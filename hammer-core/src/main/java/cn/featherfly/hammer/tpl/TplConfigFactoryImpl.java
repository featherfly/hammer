
package cn.featherfly.hammer.tpl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
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
import org.springframework.core.type.classreading.MetadataReader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import cn.featherfly.common.io.ClassPathScanningProvider;
import cn.featherfly.common.io.FileUtils;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.UriUtils;
import cn.featherfly.common.lang.matcher.MethodAnnotationMatcher;
import cn.featherfly.constant.ConstantPool;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.config.HammerConstant;
import cn.featherfly.hammer.tpl.annotation.Mapper;
import cn.featherfly.hammer.tpl.annotation.Template;

/**
 * <p>
 * Config
 * </p>
 * .
 *
 * @author zhongj
 */
public class TplConfigFactoryImpl implements TplConfigFactory {

    /** The logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String MULTI_SAME_EXECUTEID = "!" + ID_SIGN + "!";

    private ObjectMapper mapper;

    private boolean devMode;

    private String suffix;

    private String prefix;

    private Map<String, TplExecuteConfigs> configs = new HashMap<>();

    private Map<String, String> executIdFileMap = new HashMap<>();

    private ResourcePatternResolver resourcePatternResolver;

    private ClassPathScanningProvider classPathScanningProvider;

    private Set<String> basePackages = new HashSet<>();

    private TemplatePreprocessor preCompiler;

    /**
     * Instantiates a new tpl config factory impl.
     */
    public TplConfigFactoryImpl() {
        this(HammerConstant.DEFAULT_PREFIX);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param basePackages basePackages
     */
    public TplConfigFactoryImpl(Set<String> basePackages) {
        this(HammerConstant.DEFAULT_PREFIX, basePackages);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix prefix
     */
    public TplConfigFactoryImpl(String prefix) {
        this(prefix, HammerConstant.DEFAULT_SUFFIX);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix       prefix
     * @param basePackages basePackages
     */
    public TplConfigFactoryImpl(String prefix, Set<String> basePackages) {
        this(prefix, HammerConstant.DEFAULT_SUFFIX, basePackages);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix prefix
     * @param suffix suffix
     */
    public TplConfigFactoryImpl(String prefix, String suffix) {
        this(prefix, suffix, null, null);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix       prefix
     * @param suffix       suffix
     * @param basePackages basePackages
     */
    public TplConfigFactoryImpl(String prefix, String suffix, Set<String> basePackages) {
        this(prefix, suffix, basePackages, null);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param preCompiler the pre compiler
     */
    public TplConfigFactoryImpl(TemplatePreprocessor preCompiler) {
        this(HammerConstant.DEFAULT_PREFIX, preCompiler);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param basePackages basePackages
     * @param preCompiler  the pre compiler
     */
    public TplConfigFactoryImpl(Set<String> basePackages, TemplatePreprocessor preCompiler) {
        this(HammerConstant.DEFAULT_PREFIX, basePackages, preCompiler);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix      prefix
     * @param preCompiler the pre compiler
     */
    public TplConfigFactoryImpl(String prefix, TemplatePreprocessor preCompiler) {
        this(prefix, HammerConstant.DEFAULT_SUFFIX, preCompiler);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix       prefix
     * @param basePackages basePackages
     * @param preCompiler  the pre compiler
     */
    public TplConfigFactoryImpl(String prefix, Set<String> basePackages, TemplatePreprocessor preCompiler) {
        this(prefix, HammerConstant.DEFAULT_SUFFIX, basePackages, preCompiler);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix      prefix
     * @param suffix      suffix
     * @param preCompiler the pre compiler
     */
    public TplConfigFactoryImpl(String prefix, String suffix, TemplatePreprocessor preCompiler) {
        this(prefix, suffix, null, preCompiler);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix       prefix
     * @param suffix       suffix
     * @param basePackages basePackages
     * @param preCompiler  the pre compiler
     */
    public TplConfigFactoryImpl(String prefix, String suffix, Set<String> basePackages,
            TemplatePreprocessor preCompiler) {
        mapper = new ObjectMapper(new YAMLFactory());
        mapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        if (preCompiler == null) {
            this.preCompiler = value -> value;
        } else {
            this.preCompiler = preCompiler;
        }

        if (Lang.isEmpty(prefix)) {
            this.prefix = HammerConstant.DEFAULT_PREFIX;
        } else {
            this.prefix = prefix;
        }
        if (Lang.isEmpty(suffix)) {
            this.suffix = HammerConstant.DEFAULT_SUFFIX;
        } else {
            this.suffix = suffix;
        }

        this.basePackages = basePackages == null ? new HashSet<>() : basePackages;

        devMode = ConstantPool.getDefault().getConstantParameter().isDevMode();

        // 读取模板文件
        initConfigsFromFile();

        // 读取mapper类
        initConfigFromMapper();
    }

    private void initConfigFromMapper() {
        if (Lang.isEmpty(basePackages)) {
            return;
        }
        if (classPathScanningProvider == null) {
            classPathScanningProvider = new ClassPathScanningProvider();
        }
        for (String basePackage : basePackages) {
            Set<MetadataReader> metadataReaders = classPathScanningProvider.findMetadata(basePackage);
            for (MetadataReader metadataReader : metadataReaders) {
                if (metadataReader.getAnnotationMetadata().hasAnnotatedMethods(Template.class.getName())) {
                    readConfig(ClassUtils.forName(metadataReader.getClassMetadata().getClassName()));
                }
            }
        }
    }

    //    private TplExecuteConfigs readConfig(TplExecuteId tplExecuteId) {
    //        if (tplExecuteId instanceof TplExecuteIdFileImpl) {
    //            return readConfig(tplExecuteId.getId());
    //        } else if (tplExecuteId instanceof TplExecuteIdMapperImpl) {
    //            return readConfig(((TplExecuteIdMapperImpl) tplExecuteId).getMapper());
    //        } else {
    //            throw new HammerException("Unsupported TplExecuteId type -> " + tplExecuteId.getClass().getName());
    //        }
    //    }

    private String getNamespace(Class<?> type) {
        Mapper mapper = type.getAnnotation(Mapper.class);
        return mapper == null || Lang.isEmpty(mapper.namespace()) ? type.getName() : mapper.namespace();
    }

    private TplExecuteConfigs readConfig(Class<?> type) {
        Collection<Method> methods = ClassUtils.findMethods(type, new MethodAnnotationMatcher(Template.class));
        String globalNamespace = getNamespace(type);
        TplExecuteConfigs newConfigs = new TplExecuteConfigs();
        newConfigs.setName(globalNamespace);
        newConfigs.setFilePath(ClassUtils.packageToDir(type.getName()));
        String fileDirectory = ClassUtils.packageToDir(type);
        Set<String> executeIds = new HashSet<>();
        for (Method method : methods) {
            Template template = method.getAnnotation(Template.class);
            if (Lang.isEmpty(template.value())) {
                continue;
            }
            String name = Lang.isEmpty(template.name()) ? method.getName() : template.name();
            String namespace = Lang.isEmpty(template.namespace()) ? globalNamespace : template.namespace();
            checkName(executeIds, name, namespace);
            TplExecuteConfig config = new TplExecuteConfig();
            config.setQuery(preCompiler.process(template.value()));
            config.setTplName(namespace + ID_SIGN + name);
            config.setExecuteId(name);
            config.setName(type.getSimpleName());
            config.setFileName(type.getSimpleName() + ".class");
            config.setFileDirectory(fileDirectory);
            logger.debug("type -> {} , namespace -> {} ,  {} -> {}", type.getName(), namespace, name, config);
            newConfigs.put(name, config);
            if (executIdFileMap.containsKey(config.getExecuteId())
                    && !executIdFileMap.get(config.getExecuteId()).equals(newConfigs.getName())) {
                executIdFileMap.put(config.getExecuteId(), MULTI_SAME_EXECUTEID);
            } else {
                executIdFileMap.put(config.getExecuteId(), newConfigs.getName());
            }
        }
        logger.debug("type -> {} , namespace -> {} ,  configs -> {}", type.getName(), globalNamespace, newConfigs);
        configs.put(newConfigs.getName(), newConfigs);
        return newConfigs;
    }

    private void checkName(Set<String> executeIds, String name, String namespace) {
        if (name.contains(ID_SIGN)) {
            throw new HammerException("invalidate character [" + ID_SIGN + "] in executeId [" + name + "]");
        }
        if (executeIds.contains(name)) {
            throw new HammerException("duplicated executeId [" + name + "] in [" + namespace + "]");
        }
    }

    private void initConfigsFromFile() {
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
                            path = org.apache.commons.lang3.StringUtils.substring(path, rootPath.length());
                            break;
                        }
                    }
                    logger.debug("init read config : {}", path);
                    readConfig(path);
                }
            }
        } catch (IOException e) {
            // TODO 使用exceptioncode
            throw new HammerException("使用路径" + packageSearchPath + "扫描tpl配置文件时I/O异常", e);
        }
    }

    private TplExecuteConfigs readConfig(final String filePath) {
        String finalFilePath = toFinalFilePath(filePath);
        final String fileName = org.apache.commons.lang3.StringUtils.substringAfterLast(finalFilePath, "/");
        final String fileDirectory = org.apache.commons.lang3.StringUtils.substringBeforeLast(finalFilePath, "/");
        final String name = org.apache.commons.lang3.StringUtils.substringBeforeLast(finalFilePath, suffix);
        try {
            InputStream in = ClassLoaderUtils.getResourceAsStream(finalFilePath, TplConfigFactoryImpl.class);
            if (in == null) {
                throw new HammerException("can not read config from " + finalFilePath + " it may be does not exist");
            }
            TplExecuteConfigs tplExecuteConfigs = mapper.readerFor(TplExecuteConfigs.class).readValue(in);
            TplExecuteConfigs newConfigs = new TplExecuteConfigs();
            newConfigs.setFilePath(finalFilePath);
            newConfigs.setName(org.apache.commons.lang3.StringUtils.removeEnd(finalFilePath, suffix));
            Set<String> executeIds = new HashSet<>();
            tplExecuteConfigs.forEach((k, v) -> {
                TplExecuteConfig config = new TplExecuteConfig();
                if (v instanceof String) {
                    config.setQuery(preCompiler.process(v.toString()));
                } else {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> map = (Map<String, Object>) v;
                    Object query = map.get("query");
                    if (Lang.isNotEmpty(query)) {
                        config.setQuery(preCompiler.process(query.toString()));
                    }
                    Object count = map.get("count");
                    if (Lang.isNotEmpty(count)) {
                        config.setCount(preCompiler.process(count.toString()));
                    }
                    if (Lang.isNotEmpty(map.get("type"))) {
                        config.setType(TplType.valueOf(map.get("type").toString()));
                    }
                }
                checkName(executeIds, k, finalFilePath);
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
            throw new HammerException("exception when read config file " + finalFilePath + " with argu " + filePath, e);
        }
    }

    private String toFinalFilePath(String filePath) {
        String result = filePath;
        // 表示传入不是文件地址字符串，不是完整的地址
        if (!result.endsWith(suffix)) {
            result = result + suffix;
            if (!result.startsWith("/")) {
                if (prefix.endsWith("/")) {
                    result = prefix + result;
                } else {
                    result = prefix + "/" + result;
                }
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

    private TplExecuteConfigs getConfigs(Class<?> type) {
        if (devMode) {
            return readConfig(type);
        } else {
            return configs.get(getNamespace(type));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TplExecuteConfig getConfig(TplExecuteId executeId) {
        if (executeId instanceof TplExecuteIdMapperImpl) {
            TplExecuteConfigs configs = getConfigs(((TplExecuteIdMapperImpl) executeId).getMapper());
            if (configs == null) {
                // TODO 使用exceptioncode
                throw new HammerException(
                        "configs with type->" + ((TplExecuteIdMapperImpl) executeId).getMapper().getName()
                                + ",namespace->" + executeId.getNamespace() + "  not find");
            }
            TplExecuteConfig config = configs.getConfig(executeId.getName());
            if (config == null) {
                // TODO 使用exceptioncode
                throw new HammerException("executeId " + executeId.getName() + " not find with type->"
                        + executeId.getNamespace() + ",namespace->" + executeId.getNamespace());
            }
            return config;
        } else if (executeId instanceof TplExecuteIdFileImpl) {
            return getConfig(executeId.getId());
        } else {
            throw new HammerException("Unsupported TplExecuteId type -> " + executeId.getClass().getName());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TplExecuteConfig getConfig(String executeId) {
        executeId = org.apache.commons.lang3.StringUtils.substringBeforeLast(executeId, COUNT_SUFFIX);
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
            throw new HammerException("file " + filePath + " not find");
        }
        TplExecuteConfig config = configs.getConfig(eId);
        if (config == null) {
            // TODO 使用exceptioncode
            throw new HammerException("executeId " + eId + " not find in " + filePath);
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
            throw new HammerException("duplicated executeId[" + executeId
                    + "], you will use full executeId like dir/file" + ID_SIGN + executeId);
        }
        return file;
    }

    /**
     * 返回devMode.
     *
     * @return devMode
     */
    public boolean isDevMode() {
        return devMode;
    }

    /**
     * 返回suffix.
     *
     * @return suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * 返回prefix.
     *
     * @return prefix
     */
    public String getPrefix() {
        return prefix;
    }
}
