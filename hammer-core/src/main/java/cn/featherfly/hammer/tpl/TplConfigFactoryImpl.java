
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

    /** The Constant MULTI_SAME_EXECUTEID. */
    private static final String MULTI_SAME_EXECUTEID = "!" + ID_SIGN + "!";

    /** The mapper. */
    private ObjectMapper mapper;

    /** The dev mode. */
    private boolean devMode;

    /** The suffix. */
    private String suffix;

    /** The prefix. */
    private String prefix;

    /** The configs. */
    private Map<String, TplExecuteConfigs> configs = new HashMap<>();

    /** The execut id file map. */
    private Map<String, String> executIdFileMap = new HashMap<>();

    /** The resource pattern resolver. */
    private ResourcePatternResolver resourcePatternResolver;

    /** The class path scanning provider. */
    private ClassPathScanningProvider classPathScanningProvider;

    /** The base packages. */
    private Set<String> basePackages = new HashSet<>();

    /** The template preprocessor. */
    private TemplatePreprocessor templatePreprocessor;

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
        this(basePackages, false);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param basePackages the base packages
     * @param devMode      the dev mode
     */
    public TplConfigFactoryImpl(Set<String> basePackages, boolean devMode) {
        this(HammerConstant.DEFAULT_PREFIX, basePackages, devMode);
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
     * @param prefix  the prefix
     * @param devMode the dev mode
     */
    public TplConfigFactoryImpl(String prefix, boolean devMode) {
        this(prefix, HammerConstant.DEFAULT_SUFFIX, devMode);
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
     * @param prefix       the prefix
     * @param basePackages the base packages
     * @param devMode      the dev mode
     */
    public TplConfigFactoryImpl(String prefix, Set<String> basePackages, boolean devMode) {
        this(prefix, HammerConstant.DEFAULT_SUFFIX, basePackages, devMode);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix prefix
     * @param suffix suffix
     */
    public TplConfigFactoryImpl(String prefix, String suffix) {
        this(prefix, suffix, false);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix  the prefix
     * @param suffix  the suffix
     * @param devMode the dev mode
     */
    public TplConfigFactoryImpl(String prefix, String suffix, boolean devMode) {
        this(prefix, suffix, null, null, devMode);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix       prefix
     * @param suffix       suffix
     * @param basePackages basePackages
     */
    public TplConfigFactoryImpl(String prefix, String suffix, Set<String> basePackages) {
        this(prefix, suffix, basePackages, null, false);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix       the prefix
     * @param suffix       the suffix
     * @param basePackages the base packages
     * @param devMode      the dev mode
     */
    public TplConfigFactoryImpl(String prefix, String suffix, Set<String> basePackages, boolean devMode) {
        this(prefix, suffix, basePackages, null, devMode);
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
     * @param preCompiler the pre compiler
     * @param devMode     the dev mode
     */
    public TplConfigFactoryImpl(TemplatePreprocessor preCompiler, boolean devMode) {
        this(HammerConstant.DEFAULT_PREFIX, preCompiler, devMode);
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
     * @param basePackages the base packages
     * @param preCompiler  the pre compiler
     * @param devMode      the dev mode
     */
    public TplConfigFactoryImpl(Set<String> basePackages, TemplatePreprocessor preCompiler, boolean devMode) {
        this(HammerConstant.DEFAULT_PREFIX, basePackages, preCompiler, devMode);
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
     * @param prefix      the prefix
     * @param preCompiler the pre compiler
     * @param devMode     the dev mode
     */
    public TplConfigFactoryImpl(String prefix, TemplatePreprocessor preCompiler, boolean devMode) {
        this(prefix, HammerConstant.DEFAULT_SUFFIX, preCompiler, devMode);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix       prefix
     * @param basePackages basePackages
     * @param preCompiler  the pre compiler
     */
    public TplConfigFactoryImpl(String prefix, Set<String> basePackages, TemplatePreprocessor preCompiler) {
        this(prefix, basePackages, preCompiler, false);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix       the prefix
     * @param basePackages the base packages
     * @param preCompiler  the pre compiler
     * @param devMode      the dev mode
     */
    public TplConfigFactoryImpl(String prefix, Set<String> basePackages, TemplatePreprocessor preCompiler,
            boolean devMode) {
        this(prefix, HammerConstant.DEFAULT_SUFFIX, basePackages, preCompiler, devMode);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix      prefix
     * @param suffix      suffix
     * @param preCompiler the pre compiler
     */
    public TplConfigFactoryImpl(String prefix, String suffix, TemplatePreprocessor preCompiler) {
        this(prefix, suffix, preCompiler, false);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix      the prefix
     * @param suffix      the suffix
     * @param preCompiler the pre compiler
     * @param devMode     the dev mode
     */
    public TplConfigFactoryImpl(String prefix, String suffix, TemplatePreprocessor preCompiler, boolean devMode) {
        this(prefix, suffix, null, preCompiler, devMode);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefix       prefix
     * @param suffix       suffix
     * @param basePackages basePackages
     * @param preCompiler  the pre compiler
     * @param devMode      the dev mode
     */
    public TplConfigFactoryImpl(String prefix, String suffix, Set<String> basePackages,
            TemplatePreprocessor preCompiler, boolean devMode) {
        mapper = new ObjectMapper(new YAMLFactory());
        mapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        if (preCompiler == null) {
            templatePreprocessor = value -> value;
        } else {
            templatePreprocessor = preCompiler;
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

        // 这里去掉ConstantPool依赖
        //        devMode = ConstantPool.getDefault().getConstantParameter().isDevMode();
        this.devMode = devMode;

        // 读取模板文件
        initConfigsFromFile();

        // 读取mapper类
        initConfigFromMapper();
    }

    /**
     * Inits the config from mapper.
     */
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

    /**
     * Gets the namespace.
     *
     * @param type the type
     * @return the namespace
     */
    private String getNamespace(Class<?> type) {
        Mapper mapper = type.getAnnotation(Mapper.class);
        return mapper == null || Lang.isEmpty(mapper.namespace()) ? type.getName() : mapper.namespace();
    }

    /**
     * Read config.
     *
     * @param type the type
     * @return the tpl execute configs
     */
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
            config.setQuery(templatePreprocessor.process(template.value()));
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

    /**
     * Check name.
     *
     * @param executeIds the execute ids
     * @param name       the name
     * @param namespace  the namespace
     */
    private void checkName(Set<String> executeIds, String name, String namespace) {
        if (name.contains(ID_SIGN)) {
            throw new HammerException("invalidate character [" + ID_SIGN + "] in executeId [" + name + "]");
        }
        if (executeIds.contains(name)) {
            throw new HammerException("duplicated executeId [" + name + "] in [" + namespace + "]");
        }
    }

    /**
     * Inits the configs from file.
     */
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

    /**
     * Read config.
     *
     * @param filePath the file path
     * @return the tpl execute configs
     */
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
                    config.setQuery(templatePreprocessor.process(v.toString()));
                } else {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> map = (Map<String, Object>) v;

                    Object precompileObj = map.get("precompile");
                    boolean precompile = true; // 默认使用预编译
                    if (Lang.isNotEmpty(precompileObj)) {
                        if (precompileObj instanceof Boolean) {
                            precompile = (Boolean) precompileObj;
                        } else {
                            precompile = Boolean.parseBoolean(precompileObj.toString());
                        }
                    }
                    config.setPrecompile(precompile);

                    Object query = map.get("query");
                    if (Lang.isNotEmpty(query)) {
                        if (precompile) {
                            config.setQuery(templatePreprocessor.process(query.toString()));
                        } else {
                            config.setQuery(query.toString());
                        }
                    }
                    Object count = map.get("count");
                    if (Lang.isNotEmpty(count)) {
                        if (precompile) {
                            config.setCount(templatePreprocessor.process(count.toString()));
                        } else {
                            config.setQuery(query.toString());
                        }
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

    /**
     * To final file path.
     *
     * @param filePath the file path
     * @return the string
     */
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

    /**
     * Gets the configs.
     *
     * @param type the type
     * @return the configs
     */
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

    /**
     * Gets the file path andexecute id.
     *
     * @param executeId the execute id
     * @return the file path andexecute id
     */
    private String[] getFilePathAndexecuteId(String executeId) {
        String[] result = executeId.split(ID_SIGN);
        return result;
    }

    /**
     * Gets the file path.
     *
     * @param executeId the execute id
     * @return the file path
     */
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

    /**
     * 返回templatePreprocessor.
     *
     * @return templatePreprocessor
     */
    public TemplatePreprocessor getTemplatePreprocessor() {
        return templatePreprocessor;
    }
}
