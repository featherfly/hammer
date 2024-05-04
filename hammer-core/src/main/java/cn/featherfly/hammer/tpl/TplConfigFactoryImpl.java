/*
 * All rights Reserved, Designed By zhongj
 * @Title: TplConfigFactoryImpl.java
 * @Package cn.featherfly.hammer.tpl
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2022年5月12日 下午6:19:04
 * @version V1.0
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */

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
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

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
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.lang.UriUtils;
import cn.featherfly.common.lang.matcher.MethodAnnotationMatcher;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.config.HammerConstant;
import cn.featherfly.hammer.tpl.annotation.Mapper;
import cn.featherfly.hammer.tpl.annotation.Template;

/**
 * template config factory implement.
 *
 * @author zhongj
 */
public class TplConfigFactoryImpl implements TplConfigFactory {

    private class FinalPath {

        private String suffix;

        private String prefix;

        private String filePath;

        /**
         * Instantiates a new file path.
         *
         * @param filePath the file path
         * @param prefix   the prefix
         * @param suffix   the suffix
         */
        private FinalPath(String filePath, String prefix, String suffix) {
            super();
            AssertIllegalArgument.isNotNull(suffix, "suffix");
            AssertIllegalArgument.isNotNull(prefix, "prefix");
            AssertIllegalArgument.isNotNull(filePath, "filePath");
            this.suffix = suffix;
            this.prefix = prefix;
            this.filePath = filePath;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "FinalPath [suffix=" + suffix + ", prefix=" + prefix + ", filePath=" + filePath + "]";
        }
    }

    /** The logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** The Constant MULTI_SAME_EXECUTEID. */
    private static final String MULTI_SAME_EXECUTEID = "!" + ID_SIGN + "!";

    /** The mapper. */
    private ObjectMapper mapper;

    /** The dev mode. */
    private boolean devMode;

    /** The suffix. */
    private Set<String> suffixs = new HashSet<>(0);

    /** The prefix. */
    private Set<String> prefixs = new HashSet<>(0);

    /** The configs. */
    private Map<String, TplExecuteConfigs> configsMap = new HashMap<>();

    /** The execut id namespace map. */
    private Map<String, String> executIdNamespaceMap = new HashMap<>();

    private Map<String, FinalPath> filePathMap = new HashMap<>();

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
     */
    public TplConfigFactoryImpl(String prefix, String suffix, Set<String> basePackages,
            TemplatePreprocessor preCompiler) {
        this(prefix, suffix, basePackages, preCompiler, false);
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
        Set<String> prefixs = new HashSet<>();
        prefixs.add(prefix);
        Set<String> suffixs = new HashSet<>();
        suffixs.add(suffix);
        init(prefixs, suffixs, basePackages, preCompiler, devMode);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefixs      the prefixs
     * @param suffixs      the suffixs
     * @param basePackages basePackages
     */
    public TplConfigFactoryImpl(Set<String> prefixs, Set<String> suffixs, Set<String> basePackages) {
        this(prefixs, suffixs, basePackages, null);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefixs      the prefixs
     * @param suffixs      the suffixs
     * @param basePackages basePackages
     * @param preCompiler  the pre compiler
     */
    public TplConfigFactoryImpl(Set<String> prefixs, Set<String> suffixs, Set<String> basePackages,
            TemplatePreprocessor preCompiler) {
        this(prefixs, suffixs, basePackages, preCompiler, false);
    }

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefixs      the prefixs
     * @param suffixs      the suffixs
     * @param basePackages basePackages
     * @param preCompiler  the pre compiler
     * @param devMode      the dev mode
     */
    public TplConfigFactoryImpl(Set<String> prefixs, Set<String> suffixs, Set<String> basePackages,
            TemplatePreprocessor preCompiler, boolean devMode) {
        init(prefixs, suffixs, basePackages, preCompiler, devMode);
    }

    private void init(Set<String> prefixs, Set<String> suffixs, Set<String> basePackages,
            TemplatePreprocessor preCompiler, boolean devMode) {
        mapper = new ObjectMapper(new YAMLFactory());
        mapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        if (preCompiler == null) {
            templatePreprocessor = value -> value;
        } else {
            templatePreprocessor = preCompiler;
        }

        if (Lang.isEmpty(prefixs)) {
            this.prefixs.add(HammerConstant.DEFAULT_PREFIX);
        } else {
            this.prefixs.addAll(prefixs);
        }
        if (Lang.isEmpty(suffixs)) {
            this.suffixs.add(HammerConstant.DEFAULT_SUFFIX);
        } else {
            this.suffixs.addAll(suffixs);
        }

        this.basePackages = basePackages == null ? new HashSet<>() : basePackages;

        // 这里去掉ConstantPool依赖
        //        devMode = ConstantPool.getDefault().getConstantParameter().isDevMode();
        this.devMode = devMode;

        // 读取模板文件
        initConfigsFromFile();

        // 读取mapper类
        initConfigFromMapper();

        if (logger.isDebugEnabled()) {
            StringBuilder message = new StringBuilder("\n---------- template config start ----------\n");
            for (Entry<String, TplExecuteConfigs> entry : configsMap.entrySet()) {
                TplExecuteConfigs configs = entry.getValue();
                message.append(Strings.format("  Config { key={0}  namespace={1}  filePath={2} types={3} }\n",
                        entry.getKey(), configs.getNamespace(), configs.getFilePath(),
                        configs.getTypes().stream().map((t) -> t.getName()).collect(Collectors.toList())));
                for (Entry<String, Object> e : configs.entrySet()) {
                    Object v = e.getValue();
                    if (v instanceof TplExecuteConfig) {
                        TplExecuteConfig config = (TplExecuteConfig) v;
                        message.append(Strings.format(
                                "    name={0}  tplName={1}  filePath={2}  namespace={3}  executeId={4}  type={5}  precompile={6}\n",
                                config.getName(), config.getTplName(), config.getFilePath(), config.getNamespace(),
                                config.getExecuteId(), config.getType(), config.getPrecompile()));
                        message.append(String.format("      query:  %s\n",
                                config.getContent().trim().replaceAll("\n", "\n              ")));
                        if (config.getCount() != null) {
                            message.append(String.format("      count:  %s\n",
                                    config.getCount().trim().replaceAll("\n", "\n              ")));
                        }
                        message.append("\n");
                    }
                }
            }
            message.append("---------- template config end ----------");
            logger.debug(message.toString());
        }
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
        //        newConfigs.setFilePath(ClassUtils.packageToDir(type.getName()));
        TplExecuteConfigs newConfigs = new TplExecuteConfigs();
        newConfigs.setNamespace(globalNamespace);
        newConfigs.getTypes().add(type);

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
            config.setPrecompile(template.precompile());
            if (template.precompile()) {
                config.setContent(templatePreprocessor.process(template.value()));
            } else {
                config.setContent(template.value());
            }
            config.setTplName(namespace + ID_SIGN + name);
            config.setNamespace(namespace);
            config.setExecuteId(name);
            config.setName(type.getName() + FILE_SIGN + name);
            config.setFileName(type.getName() + ".class");
            config.setFileDirectory(fileDirectory);
            //            logger.debug("type -> {} , namespace -> {} ,  {} -> {}", type.getName(), namespace, name, config);

            if (namespace.equals(globalNamespace)) {
                newConfigs.put(name, config);
            } else {
                TplExecuteConfigs configs = configsMap.get(namespace);
                if (configs == null) {
                    configs = new TplExecuteConfigs();
                    configs.setNamespace(namespace);
                    configsMap.put(namespace, configs);
                }
                configs.getTypes().add(type);
                configs.put(name, config);
            }

            if (executIdNamespaceMap.containsKey(config.getExecuteId())
                    && !executIdNamespaceMap.get(config.getExecuteId()).equals(newConfigs.getNamespace())) {
                executIdNamespaceMap.put(config.getExecuteId(), MULTI_SAME_EXECUTEID);
            } else {
                executIdNamespaceMap.put(config.getExecuteId(), namespace);
            }
        }
        //        logger.debug("type -> {} , namespace -> {} ,  configs -> {}", type.getName(), globalNamespace, newConfigs);

        TplExecuteConfigs existsConfig = configsMap.get(newConfigs.getNamespace());
        if (existsConfig != null) {
            existsConfig.putAll(newConfigs);
            existsConfig.getTypes().add(type);
            configsMap.put(newConfigs.getNamespace(), existsConfig);
            // TODO 目前逻辑先用mapper的覆盖已经从文件读取的
        } else {
            configsMap.put(newConfigs.getNamespace(), newConfigs);
        }
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

        for (String prefix : prefixs) {
            for (String suffix : suffixs) {
                String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                        + UriUtils.linkUri(prefix, "**/*") + suffix;
                try {
                    Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);
                    for (Resource resource : resources) {
                        if (FileUtils.isResourceInJar(resource.getURL())) {
                            readConfig(FileUtils.getPathInJar(resource.getURL()), prefix, suffix);
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
                            readConfig(path, prefix, suffix);
                        }
                    }
                } catch (IOException e) {
                    // TODO 使用exceptioncode
                    throw new HammerException("使用路径" + packageSearchPath + "扫描tpl配置文件时I/O异常", e);
                }
            }
        }

        if (logger.isDebugEnabled()) {
            StringBuilder message = new StringBuilder("\n---------- template file config start ----------\n");
            for (Entry<String, FinalPath> entry : filePathMap.entrySet()) {
                FinalPath finalPath = entry.getValue();
                message.append(Strings.format("  namespace: {0} -> {1}\n", entry.getKey(), finalPath));
            }
            message.append("---------- template file config end ----------");
            logger.debug(message.toString());
        }
    }

    private String toFinalFilePath(final String filePath) {
        String result = filePath;
        if (result.startsWith("/")) {
            result = result.substring(1);
        }
        return result;
    }

    /**
     * Read config.
     *
     * @param filePath the file path
     * @return the tpl execute configs
     */
    private TplExecuteConfigs readConfig(final String filePath, final String prefix, final String suffix) {
        String finalFilePath = toFinalFilePath(filePath);
        final String fileName = org.apache.commons.lang3.StringUtils.substringAfterLast(finalFilePath, "/");
        final String fileDirectory = org.apache.commons.lang3.StringUtils.substringBeforeLast(finalFilePath, "/");
        //        final String name = org.apache.commons.lang3.StringUtils.substringBeforeLast(finalFilePath, suffix);
        final String namespace = org.apache.commons.lang3.StringUtils.substringBeforeLast(
                org.apache.commons.lang3.StringUtils.substringAfter(finalFilePath, prefix), suffix);
        try {
            InputStream in = ClassLoaderUtils.getResourceAsStream(finalFilePath, TplConfigFactoryImpl.class);
            if (in == null) {
                throw new HammerException("can not read config from " + finalFilePath + " it may be does not exist");
            }
            TplExecuteConfigs tplExecuteConfigs = mapper.readerFor(TplExecuteConfigs.class).readValue(in);
            TplExecuteConfigs newConfigs = new TplExecuteConfigs();
            newConfigs.setFilePath(finalFilePath);
            newConfigs.setNamespace(namespace);
            Set<String> executeIds = new HashSet<>();

            //            StringBuilder debugMessage = new StringBuilder();
            //            if (logger.isDebugEnabled()) {
            //                debugMessage.append("\n---------- read config from filePath -> " + filePath + " start ----------\n");
            //            }
            tplExecuteConfigs.forEach((k, v) -> {
                TplExecuteConfig config = new TplExecuteConfig();
                if (v instanceof String) {
                    config.setContent(templatePreprocessor.process(v.toString()));
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

                    Object content = map.get("query"); // 历史遗留
                    if (Lang.isEmpty(content)) {
                        content = map.get("content");
                    }
                    if (Lang.isEmpty(content)) {
                        throw new TplException("template content not found with key [content | query]");
                    }
                    if (precompile) {
                        config.setContent(templatePreprocessor.process(content.toString()));
                    } else {
                        config.setContent(content.toString());
                    }

                    Object count = map.get("count");
                    if (Lang.isNotEmpty(count)) {
                        if (precompile) {
                            config.setCount(templatePreprocessor.process(count.toString()));
                        } else {
                            config.setCount(count.toString());
                        }
                    }
                    if (Lang.isNotEmpty(map.get("type"))) {
                        config.setType(TplType.valueOf(map.get("type").toString()));
                    }
                }
                checkName(executeIds, k, finalFilePath);
                executeIds.add(k);

                //                config.setTplName(newConfigs.getName() + ID_SIGN + k);
                // 多prefix、suffix实现
                config.setTplName(namespace + ID_SIGN + k);
                config.setNamespace(namespace);
                config.setExecuteId(k);
                config.setName(finalFilePath + FILE_SIGN + config.getExecuteId());
                config.setFileName(fileName);
                config.setFileDirectory(fileDirectory);
                //                if (logger.isDebugEnabled()) {
                //                    debugMessage.append(Strings.format("  {0} -> {1}\n\n", k, config));
                //                }
                newConfigs.put(k, config);
                if (executIdNamespaceMap.containsKey(config.getExecuteId())
                        && !executIdNamespaceMap.get(config.getExecuteId()).equals(finalFilePath)) {
                    executIdNamespaceMap.put(config.getExecuteId(), MULTI_SAME_EXECUTEID);
                } else {
                    executIdNamespaceMap.put(config.getExecuteId(), namespace);
                }
            });
            //            if (logger.isDebugEnabled()) {
            //                debugMessage.append("---------- read config from filePath -> " + filePath + " end ----------\n");
            //                logger.debug(debugMessage.toString());
            //            }
            configsMap.put(namespace, newConfigs);

            // 处理重复的namespace，因为会有多个prefix或者suffix会导致filePath重复注册为相同的namespace
            FinalPath fp = filePathMap.get(namespace);
            if (fp != null && !finalFilePath.equals(fp.filePath)) {
                // TODO 使用exceptioncode
                throw new HammerException(Strings.format("duplicate regist namespace[{0}] filePath[{1} , {2}]",
                        namespace, fp.filePath, finalFilePath));
            } else {
                filePathMap.put(namespace, new FinalPath(finalFilePath, prefix, suffix));
            }

            return newConfigs;
        } catch (IOException e) {
            // TODO 使用exceptioncode
            throw new HammerException("exception when read config file " + finalFilePath + " with prefix " + prefix
                    + " and suffix " + suffix, e);
        }
    }

    //    /**
    //     * To final file path.
    //     *
    //     * @param filePath the file path
    //     * @return the string
    //     */
    //    private String toFinalFilePath(final String filePath, final String prefix, final String suffix) {
    //        String result = filePath;
    //        // 表示传入不是文件地址字符串，不是完整的地址
    //        if (!result.endsWith(suffix)) {
    //            result = result + suffix;
    //            if (!result.startsWith("/")) {
    //                if (prefix.endsWith("/")) {
    //                    result = prefix + result;
    //                } else {
    //                    result = prefix + "/" + result;
    //                }
    //            }
    //        }
    //        if (result.startsWith("/")) {
    //            result = result.substring(1);
    //        }
    //        return result;
    //    }

    //    private FinalPath getExistsFinalPath(final String namespace) {
    //        FinalPath fp = filePathMap.get(namespace);
    //        if (fp == null) {
    //            throw new HammerException("no FinalPath found for " + namespace);
    //        }
    //        return fp;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<TplExecuteConfigs> getAllConfigs() {
        return new ArrayList<>(configsMap.values());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TplExecuteConfigs getConfigs(String namespace) {
        // filePath即namespace
        TplExecuteConfigs configs = configsMap.get(namespace);
        if (configs != null) {
            if (devMode) {
                FinalPath fp = filePathMap.get(configs.getNamespace());
                if (fp != null) {
                    return readConfig(fp.filePath, fp.prefix, fp.suffix);
                } else {
                    return configs;
                }
            }
        }
        return configs;
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
            return configsMap.get(getNamespace(type));
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
        String namespace = null;
        String eId = null;
        TplExecuteConfigs configs = null;
        if (result.length == 1) {
            configs = getConfigByExecuteId(executeId);
            eId = executeId;
        } else {
            namespace = result[0];
            eId = result[1];
            configs = getConfigs(namespace);
        }
        if (configs == null) {
            // TODO 使用exceptioncode
            throw new HammerException("file " + namespace + " not find");
        }
        TplExecuteConfig config = configs.getConfig(eId);
        if (config == null) {
            // TODO 使用exceptioncode
            throw new HammerException("executeId " + eId + " not find in " + namespace);
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

    private TplExecuteConfigs getConfigByExecuteId(String executeId) {
        String configName = executIdNamespaceMap.get(executeId);
        if (MULTI_SAME_EXECUTEID.equals(configName)) {
            throw new HammerException("duplicated executeId[" + executeId
                    + "], you will use full executeId like dir/file" + ID_SIGN + executeId);
        }
        return configsMap.get(configName);
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
    public Set<String> getSuffixs() {
        return suffixs;
    }

    /**
     * 返回prefix.
     *
     * @return prefix
     */
    public Set<String> getPrefixs() {
        return prefixs;
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
