
package cn.featherfly.juorm.tpl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import cn.featherfly.common.io.FileUtils;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.common.lang.UriUtils;
import cn.featherfly.constant.ConstantPool;
import cn.featherfly.juorm.JuormException;
import cn.featherfly.juorm.tpl.TplExecuteConfig.Type;

/**
 * <p>
 * Config
 * </p>
 *
 * @author zhongj
 */
public class TplConfigFactoryImpl implements TplConfigFactory {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String DEFAULT_SUFFIX = ".yaml.tpl";

    public static final String DEFAULT_PREFIX = "";

    private static final String MULTI_SAME_EXECUTEID = "!" + ID_SIGN + "!";

    private ObjectMapper mapper;

    private boolean devMode;

    private String suffix = DEFAULT_SUFFIX;

    private String prefix = DEFAULT_PREFIX;

    private Map<String, TplExecuteConfigs> configs = new HashMap<>();

    private Map<String, String> executIdFileMap = new HashMap<>();

    private ResourcePatternResolver resourcePatternResolver;

    public TplConfigFactoryImpl() {
        this(DEFAULT_PREFIX);
    }

    public TplConfigFactoryImpl(String prefix) {
        this(prefix, DEFAULT_SUFFIX);
    }

    public TplConfigFactoryImpl(String prefix, String suffix) {
        mapper = new ObjectMapper(new YAMLFactory());
        mapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        this.prefix = prefix;
        this.suffix = suffix;

        devMode = ConstantPool.getDefault().getConstantParameter().isDevMode();

        initConfigs();
    }

    private void initConfigs() {
        resourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + UriUtils.linkUri(prefix, "**/*")
                + suffix;
        try {
            Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);
            for (Resource resource : resources) {
                if (FileUtils.isResourceInJar(resource.getURL())) {
                    readConfig(FileUtils.getPathInJar(resource.getURL()));
                } else {
                    String path = resource.getURL().getPath();
                    Enumeration<URL> enums = ClassLoader.getSystemResources("");
                    while (enums.hasMoreElements()) {
                        String rootPath = enums.nextElement().getPath();
                        if (path.startsWith(rootPath)) {
                            path = StringUtils.substring(path, rootPath.length());
                            break;
                        }
                    }
                    logger.debug("init read config : {}", path);
                    readConfig(path);
                }
            }
        } catch (IOException e) {
            // TODO 使用exceptioncode
            throw new JuormException("使用路径" + packageSearchPath + "扫描tpl配置文件时I/O异常", e);
        }
    }

    /**
     * 返回devMode
     *
     * @return devMode
     */
    public boolean isDevMode() {
        return devMode;
    }

    /**
     * 返回suffix
     *
     * @return suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * 返回prefix
     *
     * @return prefix
     */
    public String getPrefix() {
        return prefix;
    }

    private TplExecuteConfigs readConfig(final String filePath) {
        String finalFilePath = toFinalFilePath(filePath);
        final String fileName = StringUtils.substringAfterLast(finalFilePath, "/");
        final String fileDirectory = StringUtils.substringBeforeLast(finalFilePath, "/");
        final String name = StringUtils.substringBeforeLast(finalFilePath, suffix);
        try {
            TplExecuteConfigs tplExecuteConfigs = mapper.readerFor(TplExecuteConfigs.class)
                    .readValue(ClassLoaderUtils.getResourceAsStream(finalFilePath, TplConfigFactoryImpl.class));
            TplExecuteConfigs newConfigs = new TplExecuteConfigs();
            newConfigs.setFilePath(finalFilePath);
            newConfigs.setName(org.apache.commons.lang3.StringUtils.removeEnd(finalFilePath, suffix));
            Set<String> executeIds = new HashSet<>();
            tplExecuteConfigs.forEach((k, v) -> {
                TplExecuteConfig config = new TplExecuteConfig();
                if (v instanceof String) {
                    config.setQuery(v.toString());
                } else {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> map = (Map<String, Object>) v;
                    if (LangUtils.isNotEmpty(map.get("query"))) {
                        config.setQuery(map.get("query").toString());
                    }
                    if (LangUtils.isNotEmpty(map.get("count"))) {
                        config.setCount(map.get("count").toString());
                    }
                    if (LangUtils.isNotEmpty(map.get("type"))) {
                        config.setType(Type.valueOf(map.get("type").toString()));
                    }
                }
                if (k.contains(ID_SIGN)) {
                    throw new JuormException("invalidate character [" + ID_SIGN + "] in executeId [" + k + "]");
                }
                if (executeIds.contains(k)) {
                    throw new JuormException("duplicated executeId [" + k + "] in [" + finalFilePath + "]");
                }
                executeIds.add(k);

                config.setTplName(newConfigs.getName() + ID_SIGN + k);
                config.setExecuteId(k);
                config.setName(name);
                config.setFileName(fileName);
                config.setFileDirectory(fileDirectory);
                logger.debug("filePath -> {} , finalFilePath -> {} ,  {} -> {}", filePath, finalFilePath, k, config);
                //                System.out.println(config);
                newConfigs.put(k, config);
                if (executIdFileMap.containsKey(config.getExecuteId())
                        && !executIdFileMap.get(config.getExecuteId()).equals(finalFilePath)) {
                    executIdFileMap.put(config.getExecuteId(), MULTI_SAME_EXECUTEID);
                } else {
                    executIdFileMap.put(config.getExecuteId(), finalFilePath);
                }
            });
            logger.debug("filePath -> {} , finalFilePath -> {} ,  configs -> {}", filePath, finalFilePath, newConfigs);
            configs.put(finalFilePath, newConfigs);
            return newConfigs;
        } catch (IOException e) {
            // TODO 使用exceptioncode
            throw new JuormException("exception when read config file " + finalFilePath + " with argu " + filePath, e);
        }

    }

    private String toFinalFilePath(String filePath) {
        String result = filePath;
        // 表示传入不是文件地址字符串，不是完整的地址
        if (!result.endsWith(suffix)) {
            result = result + suffix;
            if (!result.startsWith("/")) {
                result = prefix + result;
            }
        }
        if (result.startsWith("/")) {
            result = result.substring(1);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<TplExecuteConfigs> getAllConfigs() {
        return new ArrayList<>(configs.values());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TplExecuteConfigs getConfigs(String filePath) {
        if (devMode) {
            return readConfig(filePath);
        } else {
            return configs.get(toFinalFilePath(filePath));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TplExecuteConfig getConfig(String executeId) {
        executeId = StringUtils.substringBeforeLast(executeId, COUNT_SUFFIX);
        String[] result = getFilePathAndexecuteId(executeId);
        String filePath = null;
        String eId = null;
        if (result.length == 1) {
            filePath = getFilePath(executeId);
            eId = executeId;
        } else {
            filePath = result[0];
            eId = result[1];
        }
        TplExecuteConfigs configs = getConfigs(filePath);
        if (configs == null) {
            // TODO 使用exceptioncode
            throw new JuormException("file " + filePath + " not find");
        }
        TplExecuteConfig config = configs.getConfig(eId);
        if (config == null) {
            // TODO 使用exceptioncode
            throw new JuormException("executeId " + eId + " not find in " + filePath);
        }
        return config;
    }

    private String[] getFilePathAndexecuteId(String executeId) {
        String[] result = executeId.split(ID_SIGN);
        return result;
    }

    private String getFilePath(String executeId) {
        String file = executIdFileMap.get(executeId);
        if (MULTI_SAME_EXECUTEID.equals(file)) {
            // TODO 使用exceptioncode
            throw new JuormException("duplicated executeId[" + executeId
                    + "], you will use full executeId like dir/file" + ID_SIGN + executeId);
        }
        return file;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TplExecuteConfig getConfig(TplExecuteId executeId) {
        return getConfig(executeId.getId());
    }
}
