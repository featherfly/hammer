
package cn.featherfly.juorm.tpl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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

    private ObjectMapper mapper;

    private boolean devMode;

    private String suffix = DEFAULT_SUFFIX;

    private String prefix = DEFAULT_PREFIX;

    private Map<String, TplExecuteConfigs> configs = new HashMap<>();

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
     * 设置suffix
     *
     * @param suffix suffix
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * 返回prefix
     *
     * @return prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * 设置prefix
     *
     * @param prefix prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    private TplExecuteConfigs readConfig(final String filePath) {
        String finalFilePath = toFinalFilePath(filePath);
        final String name = StringUtils.substringAfterLast(finalFilePath, "/");
        final String directory = StringUtils.substringBeforeLast(finalFilePath, "/");
        try {
            TplExecuteConfigs tplExecuteConfigs = mapper.readerFor(TplExecuteConfigs.class)
                    .readValue(ClassLoaderUtils.getResourceAsStream(finalFilePath, TplConfigFactoryImpl.class));
            TplExecuteConfigs newConfigs = new TplExecuteConfigs();
            newConfigs.setFilePath(finalFilePath);
            newConfigs.setName(org.apache.commons.lang3.StringUtils.removeEnd(finalFilePath, suffix));
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
                config.setTplPath(newConfigs.getName() + IdSign + k);
                config.setExecuteId(k);
                config.setName(name);
                config.setDirectory(directory);
                logger.debug("filePath -> {} , finalFilePath -> {} ,  config -> {}", filePath, finalFilePath, config);
                //                System.out.println(config);
                newConfigs.put(k, config);
            });
            configs.put(finalFilePath, newConfigs);
            return newConfigs;
        } catch (IOException e) {
            // TODO 使用exceptioncode
            throw new JuormException("exception when read config file " + filePath, e);
        }

    }

    private String toFinalFilePath(String filePath) {
        String result = filePath;
        if (!result.startsWith("/")) {
            result = prefix + result;
        }
        if (!result.endsWith(suffix)) {
            result = result + suffix;
        }
        if (result.startsWith("/")) {
            result = result.substring(1);
        }
        return result;
    }

    private String[] getFilePathAndSqlId(String sqlId) {
        String[] result = sqlId.split(IdSign);
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
    public TplExecuteConfig getConfig(String sqlId) {
        String[] result = getFilePathAndSqlId(sqlId);
        String filePath = result[0];
        String sId = result[1];
        TplExecuteConfigs configs = getConfigs(filePath);
        if (configs == null) {
            // TODO 使用exceptioncode
            throw new JuormException("file " + filePath + " not find");
        }
        TplExecuteConfig config = configs.getConfig(sId);
        if (config == null) {
            // TODO 使用exceptioncode
            throw new JuormException("sqlId " + sId + " not find in " + filePath);
        }
        return config;
    }
}
