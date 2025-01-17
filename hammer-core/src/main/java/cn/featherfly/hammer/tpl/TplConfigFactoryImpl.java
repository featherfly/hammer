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

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
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
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.MetadataReader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.io.ClassPathScanningProvider;
import cn.featherfly.common.io.FileUtils;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.lang.UriUtils;
import cn.featherfly.common.lang.matcher.MethodAnnotationMatcher;
import cn.featherfly.hammer.annotation.Mapper;
import cn.featherfly.hammer.annotation.Template;
import cn.featherfly.hammer.config.HammerConstant;
import cn.featherfly.hammer.config.tpl.TemplateConfig;
import cn.featherfly.hammer.config.tpl.TemplateConfig.CountSqlConverteStrategy;
import cn.featherfly.hammer.tpl.TplExecuteConfig.Param;
import cn.featherfly.hammer.tpl.TplExecuteConfig.ParamsFormat;

/**
 * template config factory implement.
 *
 * @author zhongj
 */
//  YUFEI_TODO 后续把配置和TplExecute实例分开，配置就是yaml文件和类注释的内容
//  TplExecute实例就是通过配置读取并进行逻辑处理后的最终状态，即TplExecutor实现进行最终执行时，查找的是TplExecute实例
public class TplConfigFactoryImpl implements TplConfigFactory {

    /** The logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** The Constant MULTI_SAME_EXECUTEID. */
    //    private static final String MULTI_SAME_EXECUTEID = "!::!";

    public static final TplExecuteIdImpl MULTI_SAME_EXECUTEID = new TplExecuteIdImpl("!::!", null) {
        /**
         * {@inheritDoc}
         */
        @Override
        public String getId() {
            return name;
        }
    };

    private static final String NAMESPACE = "namespace";

    // ----------------------------------------------------------------------------------------------------------------

    private final boolean devMode;

    private final int commentMaxLength;

    private final Set<String> suffixes = new HashSet<>(0);

    private final Set<String> prefixes = new HashSet<>(0);

    private final Set<String> basePackages = new HashSet<>();

    private final TemplatePreprocessor templatePreprocessor;

    private final TemplateConfig templateConfig;

    // ----------------------------------------------------------------------------------------------------------------

    private final ObjectMapper mapper;

    private ResourcePatternResolver resourcePatternResolver;

    private ClassPathScanningProvider classPathScanningProvider;

    // key namespace
    private final Map<String, TplExecuteConfigs> configsMap = new HashMap<>();

    // key executeId
    private final Map<String, TplExecuteId> executeIdsMap = new HashMap<>(0);

    //    private final Map<String, String> nameNamespaceMap = new HashMap<>();

    private final Map<String, FinalPath> filePathMap = new HashMap<>();

    /**
     * Instantiates a new tpl config factory impl.
     *
     * @param prefixes the prefixes
     * @param suffixes the suffixes
     * @param basePackages basePackages
     * @param preCompiler the pre compiler
     * @param templateConfig the template config
     * @param commentMaxLength the buffer size
     * @param devMode the dev mode
     */
    public TplConfigFactoryImpl(Set<String> prefixes, Set<String> suffixes, Set<String> basePackages,
        TemplatePreprocessor preCompiler, TemplateConfig templateConfig, int commentMaxLength, boolean devMode) {
        mapper = new ObjectMapper(new YAMLFactory());
        mapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        if (preCompiler == null) {
            templatePreprocessor = (value, c) -> value;
        } else {
            templatePreprocessor = preCompiler;
        }

        AssertIllegalArgument.isNotNull(templateConfig, "templateConfig");
        this.templateConfig = templateConfig;

        if (Lang.isEmpty(prefixes)) {
            this.prefixes.add(HammerConstant.DEFAULT_PREFIX);
        } else {
            for (String prefix : prefixes) {
                this.prefixes.add(checkEndSeparator(trimBeginSeparator(prefix)));
            }
        }
        if (Lang.isEmpty(suffixes)) {
            this.suffixes.add(HammerConstant.DEFAULT_SUFFIX);
        } else {
            this.suffixes.addAll(suffixes);
        }

        CollectionUtils.addAll(this.basePackages, basePackages);
        //        this.basePackages = Lang.ifNull(basePackages, () -> new HashSet<>());

        // 这里去掉ConstantPool依赖
        //        devMode = ConstantPool.getDefault().getConstantParameter().isDevMode();
        this.devMode = devMode;

        if (commentMaxLength < 0) {
            this.commentMaxLength = 128;
        } else {
            this.commentMaxLength = commentMaxLength;
        }

        // 读取模板文件
        initConfigsFromFile();

        // 读取mapper类
        initConfigFromMapper();

        // 加载include
        if (!templateConfig.isPrecompileNamedParamPlaceholder()) { // 先用这个代替，后续看需不需要专用配置项
            preInclude();
        }

        if (logger.isDebugEnabled()) {
            debugInfo();
        }
    }

    private void preInclude() {
        if (templateConfig.isPrecompileNamedParamPlaceholder()) { // 命名参数，不需要预加载
            return;
        }

        for (Entry<String, TplExecuteConfigs> entry : configsMap.entrySet()) {
            TplExecuteConfigs configs = entry.getValue();
            for (Entry<String, Object> e : configs.entrySet()) {
                Object v = e.getValue();
                if (!(v instanceof TplExecuteConfig)) {
                    continue;
                }

                preInclude((TplExecuteConfig) v, null, new HashMap<>());
            }
        }
    }

    private TplExecuteConfig preInclude(TplExecuteConfig config, String includeId,
        Map<String, Object> templateContents) {
        if (includeId != null && config.getIncludes().isEmpty()) {
            templateContents.put(includeId, config.getContent());
            return config;
        } else {
            for (TplExecuteId includeTplId : config.getIncludes()) {
                TplExecuteConfig includeConfig = null;
                if (Lang.isEmpty(includeTplId.getNamespace())) { // namespace is null, use container namespace
                    String execId = templateConfig.getTplExecuteIdParser().format(includeTplId.getName(),
                        config.getNamespace());
                    includeConfig = preInclude(getConfig(execId), includeTplId.getId(), templateContents);
                } else {
                    includeConfig = preInclude(getConfig(includeTplId), includeTplId.getId(), templateContents);
                }
                config.setParams((Param[]) ArrayUtils.concat(config.getParams(), includeConfig.getParams()));
            }
            config.setContent(templateConfig.getPreIncludeFormmater().format(config.getContent(), templateContents));
            config.setCount(templateConfig.getPreIncludeFormmater().format(config.getCount(), templateContents));
            config.setIncluded(true);

            if (Lang.isEmpty(config.getCount()) && templateConfig.getCountSqlConvertor() != null) {
                if (CountSqlConverteStrategy.INIT_WARNING == templateConfig.getCountSqlConverteStrategy()) {
                    try {
                        config.setCount(templateConfig.getCountSqlConvertor().apply(config.getContent()));
                    } catch (Exception e) {
                        logger.warn("convert select sql to count sql error", e);
                    }
                } else if (CountSqlConverteStrategy.INIT_EXCEPTION == templateConfig.getCountSqlConverteStrategy()) {
                    config.setCount(templateConfig.getCountSqlConvertor().apply(config.getContent()));
                }
            }
            return config;
        }
    }

    private void debugInfo() {
        StringBuilder message = new StringBuilder("\n---------- template config start ----------\n");
        for (Entry<String, TplExecuteConfigs> entry : configsMap.entrySet()) {
            TplExecuteConfigs configs = entry.getValue();
            message.append(Str.format("  Config { key={0}  namespace={1}  filePath={2} types={3} }\n",
                entry.getKey(), configs.getNamespace(), configs.getFilePath(),
                configs.getTypes().stream().map((t) -> t.getName()).collect(Collectors.toList())));
            for (Entry<String, Object> e : configs.entrySet()) {
                Object v = e.getValue();
                if (!(v instanceof TplExecuteConfig)) {
                    continue;
                }
                TplExecuteConfig config = (TplExecuteConfig) v;
                message.append(Str.format(
                    "    name={0}  namespace={1}  executeId={2} tplName={3}  filePath={4}   type={5}  precompile={6}\n",
                    config.getName(), config.getNamespace(), config.getExecuteId(), config.getTplName(),
                    config.getFilePath(), config.getType(), config.getPrecompile()));
                message.append(String.format("      query:  %s\n",
                    config.getContent().trim().replaceAll("\n", "\n              ")));
                if (config.getCount() != null) {
                    message.append(String.format("      count:  %s\n",
                        config.getCount().trim().replaceAll("\n", "\n              ")));
                }
                message.append("\n");
            }
        }
        message.append("---------- template config end ----------");
        logger.debug(message.toString());
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
    //            throw new TplException("Unsupported TplExecuteId type -> " + tplExecuteId.getClass().getName());
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
        String globalNamespace = getNamespace(type);
        String fileDirectory = ClassUtils.packageToDir(type);
        //        newConfigs.setFilePath(ClassUtils.packageToDir(type.getName()));
        // 从已有读取
        final TplExecuteConfigs globalConfigs = Lang.ifNull(configsMap.get(globalNamespace),
            () -> new TplExecuteConfigs());
        globalConfigs.setNamespace(globalNamespace);
        globalConfigs.getTypes().add(type);

        BiConsumer<Template, String> setConfig = (template, templateName) -> {
            if (Lang.isEmpty(template.value())) {
                return;
            }

            String name = Lang.ifEmpty(template.name(), templateName);
            if (name == null) {
                throw new TplException("template name is not set for template content:\n" + template.value());
            }
            String namespace = Lang.ifEmpty(template.namespace(), globalNamespace);
            checkName(name, namespace);

            TplExecuteConfig config = new TplExecuteConfig();
            config.setName(name);
            config.setNamespace(namespace);
            config.setExecuteId(templateConfig.getTplExecuteIdParser().format(name, namespace));
            config.setTplName(type.getName() + FILE_SIGN + name);
            config.setFileName(type.getName() + ".class");
            config.setFileDirectory(fileDirectory);
            config.setPrecompile(template.precompile());
            if (template.precompile()) {
                config.setContent(templatePreprocessor.process(template.value(), config));
            } else {
                config.setContent(template.value());
            }
            //            logger.debug("type -> {} , namespace -> {} ,  {} -> {}", type.getName(), namespace, name, config);

            // 模板id和模板执行的关系,模板id全局唯一,重复报错
            addOrExistsError(config, () -> new TplExecuteIdMapperImpl(config.getName(), config.getNamespace(), type,
                templateConfig.getTplExecuteIdParser()));

            if (namespace.equals(globalNamespace)) {
                globalConfigs.put(name, config);
                configsMap.put(namespace, globalConfigs);
            } else {
                TplExecuteConfigs configs = Lang.ifNull(configsMap.get(namespace), () -> {
                    TplExecuteConfigs cs = new TplExecuteConfigs();
                    cs.setNamespace(namespace);
                    cs.getTypes().add(type);
                    configsMap.put(namespace, cs);
                    return cs;
                });
                configs.put(name, config);
                configsMap.put(namespace, configs);
            }
        };

        Template[] templates = type.getAnnotationsByType(Template.class);
        for (Template template : templates) {
            setConfig.accept(template, null);
        }

        Collection<Method> methods = ClassUtils.findMethods(type, new MethodAnnotationMatcher(Template.class));
        for (Method method : methods) {
            setConfig.accept(method.getAnnotation(Template.class), method.getName());
        }
        //        TplExecuteConfigs existsConfig = configsMap.get(globalConfigs.getNamespace());
        //        if (existsConfig != null) {
        //            existsConfig.putAll(globalConfigs);
        //            existsConfig.getTypes().add(type);
        //            configsMap.put(globalConfigs.getNamespace(), existsConfig);
        //            // TODO 目前逻辑先用mapper的覆盖已经从文件读取的
        //        } else {
        //            configsMap.put(globalConfigs.getNamespace(), globalConfigs);
        //        }
        return globalConfigs;
    }

    // check whether the template name is invalid or duplicate in the namespace
    private void checkName(String name, String namespace) {
        if (name.contains(templateConfig.getTplExecuteIdParser().getSeparator())) {
            // ENHANCE 使用exceptioncode
            throw new TplException("invalid character [" + templateConfig.getTplExecuteIdParser().getSeparator()
                + "] in executeId [" + name + "]");
        }
        if (Lang.ifNullOrElse(configsMap.get(namespace), () -> false, cs -> cs.containsConfig(namespace))) {
            // ENHANCE 使用exceptioncode
            throw new TplException("duplicated template name[" + name + "] in namespace[" + namespace + "]");
        }
    }

    private TplExecuteConfig assertNotExists(TplExecuteConfig newConfig) {
        if (executeIdsMap.get(newConfig.getExecuteId()) != null) {
            // ENHANCE 使用exceptioncode
            TplExecuteConfig old = getConfig(newConfig.getExecuteId());
            throw new TplException(Str.format("duplicated template executeId[{}], may take a look at {} and {}",
                newConfig.getExecuteId(), newConfig.getFilePath(), old.getFilePath()));
        }
        return newConfig;
    }

    private void addOrExistsError(TplExecuteConfig config, Supplier<TplExecuteId> supplier) {
        assertNotExists(config);

        TplExecuteId tplExecuteId = supplier.get();
        executeIdsMap.put(config.getExecuteId(), tplExecuteId);

        if (executeIdsMap.containsKey(config.getName()) && !executeIdsMap.get(config.getName()).equals(tplExecuteId)) {
            executeIdsMap.put(config.getName(), MULTI_SAME_EXECUTEID);
        } else {
            executeIdsMap.put(config.getName(), tplExecuteId);
        }
    }

    /**
     * Inits the configs from file.
     */
    private void initConfigsFromFile() {
        resourcePatternResolver = new PathMatchingResourcePatternResolver();

        for (String prefix : prefixes) {
            for (String suffix : suffixes) {
                String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                    + UriUtils.linkUri(prefix, "**/*") + suffix;
                try {
                    Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);
                    for (Resource resource : resources) {
                        if (FileUtils.isResourceInJar(resource.getURL())) {
                            readFileConfig(FileUtils.getPathInJar(resource.getURL()), prefix, suffix);
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
                            readFileConfig(path, prefix, suffix);
                        }
                    }
                } catch (IOException e) {
                    // ENHANCE 使用exceptioncode
                    throw new TplException("使用路径" + packageSearchPath + "扫描tpl配置文件时I/O异常", e);
                }
            }
        }

        if (logger.isDebugEnabled()) {
            StringBuilder message = new StringBuilder("\n---------- template file config start ----------\n");
            for (Entry<String, FinalPath> entry : filePathMap.entrySet()) {
                FinalPath finalPath = entry.getValue();
                message.append(Str.format("  namespace: {0} -> {1}\n", entry.getKey(), finalPath));
            }
            message.append("---------- template file config end ----------");
            logger.debug(message.toString());
        }
    }

    private String checkEndSeparator(final String filePath) {
        String result = filePath;
        if (!result.endsWith("/")) {
            return result + "/";
        } else {
            result = Str.trimEnd(result, "/");
            return result + "/";
        }
    }

    private String trimBeginSeparator(final String filePath) {
        String result = filePath;
        while (result.startsWith("/") && result.length() > 0) {
            result = result.substring(1);
        }
        return result;
    }

    private TplExecuteConfigs readFileConfig(final String filePath) {
        String finalFilePath = trimBeginSeparator(filePath);
        String suffix = org.apache.commons.lang3.StringUtils.substringAfterLast(finalFilePath, ".");
        for (String prefix : getPrefixes()) {
            String pre = trimBeginSeparator(prefix);
            if (filePath.startsWith(pre)) {
                return readFileConfig(finalFilePath, pre, suffix);
            }
        }
        throw new TplException(String.format("filePath[{}] is not start with prefixes[{}]", filePath, getPrefixes()));
    }

    private TplExecuteConfigs readFileConfig(final String filePath, final String prefix, final String suffix) {
        String finalFilePath = trimBeginSeparator(filePath);
        final String fileName = org.apache.commons.lang3.StringUtils.substringAfterLast(finalFilePath, "/");
        final String fileDirectory = org.apache.commons.lang3.StringUtils.substringBeforeLast(finalFilePath, "/");
        //        final String name = org.apache.commons.lang3.StringUtils.substringBeforeLast(finalFilePath, suffix);
        final Mutable<String> mutableNamespace = new MutableObject<>(org.apache.commons.lang3.StringUtils
            .substringBeforeLast(org.apache.commons.lang3.StringUtils.substringAfter(finalFilePath, prefix), suffix));
        //        String namespace = org.apache.commons.lang3.StringUtils.substringBeforeLast(
        //                org.apache.commons.lang3.StringUtils.substringAfter(finalFilePath, prefix), suffix);
        return readFileConfig(finalFilePath, mutableNamespace, fileName, fileDirectory, prefix, suffix);
    }

    private TplExecuteConfigs readFileConfig(String filePath, Mutable<String> mutableNamespace, String fileName,
        String fileDirectory, final String prefix, final String suffix) {
        try {
            InputStream is = ClassLoaderUtils.getResourceAsStream(filePath, TplConfigFactoryImpl.class);
            if (is == null) {
                throw new TplException("can not read config from " + filePath + " it may be does not exist");
            }
            BufferedInputStream bis = new BufferedInputStream(is);
            bis.mark(commentMaxLength);

            Lang.ifNotEmpty(commentContent(bis, commentMaxLength),
                (Consumer<String>) cc -> Lang.ifNotEmpty(cc, (Consumer<String>) ns -> mutableNamespace.setValue(ns)));
            bis.reset();
            final String namespace;
            if (mutableNamespace.getValue().contains("=")) {
                namespace = mutableNamespace.getValue().split("=")[1];
            } else {
                namespace = mutableNamespace.getValue();
            }
            TplExecuteConfigs tplExecuteConfigs = mapper.readerFor(TplExecuteConfigs.class).readValue(bis);
            TplExecuteConfigs newConfigs = Lang.ifNull(configsMap.get(namespace), () -> {
                TplExecuteConfigs cs = new TplExecuteConfigs();
                cs.getFilePath().add(filePath);
                cs.setNamespace(namespace);
                return cs;
            });

            for (Entry<String, Object> entrySet : tplExecuteConfigs.entrySet()) {
                String name = entrySet.getKey();
                Object value = entrySet.getValue();

                TplExecuteConfig config = new TplExecuteConfig();
                checkName(name, namespace);

                // 多prefix、suffix实现
                // 现在的executeId是之前的tplName
                // 现在的name是之前的executeId
                // 现在的tplName是之前的name
                // 现在把这里和模板那里的定义全部统一
                // name对应template name,namespace对应template namespace, executeId对应template id

                // template name
                config.setName(name);
                // template namespace
                config.setNamespace(namespace);
                // template execute id
                config.setExecuteId(templateConfig.getTplExecuteIdParser().format(name, namespace));

                //              config.setTplName(parser.format(key, namespace));
                config.setTplName(filePath + FILE_SIGN + config.getName());

                // config.setName(finalFilePath + FILE_SIGN + config.getExecuteId());
                config.setFileName(fileName);
                config.setFileDirectory(fileDirectory);

                if (value instanceof String) {
                    config.setContent(templatePreprocessor.process(value.toString(), config));
                } else {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> map = (Map<String, Object>) value;

                    boolean precompile = getPrecompile(map);
                    config.setPrecompile(precompile);
                    config.setParamNames(getParamNames(map));
                    config.setInParamNames(getInParamNames(map));
                    config.setInParamIndexs(getInParamIndexs(map));
                    config.setParamsFormat(getParamsFormat(map));
                    Object content = map.get("query"); // 历史遗留
                    if (Lang.isEmpty(content)) {
                        content = map.get("content");
                    }
                    if (Lang.isEmpty(content)) {
                        throw new TplException("template content not found with key [content | query]");
                    }
                    if (precompile) {
                        config.setContent(templatePreprocessor.process(content.toString(), config));
                    } else {
                        config.setContent(content.toString());
                    }

                    Object count = map.get("count");
                    if (Lang.isNotEmpty(count)) {
                        if (precompile) {
                            //                            config.setContent(templatePreprocessor.process(count.toString(), config));
                            // YUFEI_TODO 先不让count处理tplconfig
                            config.setContent(templatePreprocessor.process(count.toString(), new TplExecuteConfig()));
                        } else {
                            config.setCount(count.toString());
                        }
                    }
                    if (Lang.isNotEmpty(map.get("type"))) {
                        config.setType(ExecutionType.valueOf(map.get("type").toString()));
                    }
                }

                newConfigs.put(name, config);

                // 模板id和模板执行的关系,模板id全局唯一,重复报错
                addOrExistsError(config, () -> new TplExecuteIdFileImpl(config.getName(), config.getNamespace(),
                    templateConfig.getTplExecuteIdParser()));

            }
            configsMap.put(namespace, newConfigs);

            // 处理重复的namespace，因为会有多个prefix或者suffix会导致filePath重复注册为相同的namespace
            // YUFEI_TEST 后续测试，不同文件注册相同的namespace就让他注册，只要全局的template id不重复就没事以及相同namespace下name不重复
            FinalPath fp = filePathMap.get(namespace);
            if (fp != null && !filePath.equals(fp.filePath)) {
                // ENHANCE 使用exceptioncode
                throw new TplException(Str.format("duplicate regist namespace[{0}] filePath[{1} , {2}]", namespace,
                    fp.filePath, filePath));
            } else {
                filePathMap.put(namespace, new FinalPath(filePath, prefix, suffix));
            }

            return newConfigs;
        } catch (IOException e) {
            // ENHANCE 使用exceptioncode
            throw new TplException(
                "exception when read config file " + filePath + " with prefix " + prefix + " and suffix " + suffix, e);
        }
    }

    private TplExecuteConfigs readConfigNew(final String namespace) {
        // NOIMPL 还未实现
        throw new NotImplementedException();
    }

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
        if (devMode) {
            TplExecuteConfigs configs = configsMap.get(namespace);
            if (configs == null) {
                FinalPath fp = filePathMap.get(namespace);
                if (fp != null) {
                    // 已经读取过的
                    return readFileConfig(fp.filePath, fp.prefix, fp.suffix);
                } else {
                    // 重新读取，项目启动后新建文件的逻辑
                    return readConfigNew(namespace);
                }
            } else {
                for (String filePath : configs.getFilePath()) {
                    readFileConfig(filePath);
                }
                for (Class<?> mapper : configs.getTypes()) {
                    readConfig(mapper);
                }
                return configsMap.get(namespace);
            }
        } else {
            return getExistConfigs(namespace);
        }
    }

    private TplExecuteConfigs getOrReloadConfigs(TplExecuteIdMapperImpl executeIdMapper) {
        if (devMode) {
            return readConfig(executeIdMapper.getMapper());
        } else {
            return getExistConfigs(executeIdMapper);
            //            return configsMap.get(getNamespace(executeIdMapper.getMapper()));
        }
    }

    private TplExecuteConfigs getOrReloadConfigs(TplExecuteIdFileImpl executeIdFile) {
        if (devMode) {
            FinalPath fp = filePathMap.get(executeIdFile.getNamespace());
            if (fp != null) {
                return readFileConfig(fp.filePath, fp.prefix, fp.suffix);
            } else {
                return getExistConfigs(executeIdFile);
            }
        } else {
            return getExistConfigs(executeIdFile);
            //            return configsMap.get(getNamespace(executeIdMapper.getMapper()));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TplExecuteConfig getConfig(TplExecuteId executeId) {
        if (executeId instanceof TplExecuteIdMapperImpl) {
            TplExecuteConfigs configs = getOrReloadConfigs((TplExecuteIdMapperImpl) executeId);
            return getExistConfig(configs, executeId.getName());
        } else if (executeId instanceof TplExecuteIdFileImpl) {
            TplExecuteConfigs configs = getOrReloadConfigs((TplExecuteIdFileImpl) executeId);
            return getExistConfig(configs, executeId.getName());
        } else {
            return getConfig(executeId.getId());
        }
    }

    //    private TplExecuteConfig getConfig(TplExecuteIdFileImpl tplExecuteId) {
    //        if (devMode) {
    //            TplExecuteConfigs configs = getExistConfigs(tplExecuteId);
    //            TplExecuteConfig config = getExistConfig(configs, tplExecuteId.getName());
    //            return readConfig(config.getFilePath());
    //
    //            TplExecuteConfig config = configs.getConfig(executeId.getName());
    //            if (config == null) {
    //                // ENHANCE 使用exceptioncode
    //                throw new TplException("executeId " + executeId.getName() + " not find with type->"
    //                        + executeId.getNamespace() + ",namespace->" + executeId.getNamespace());
    //
    //                //            readConfig(NAMESPACE, NAMESPACE, NAMESPACE)
    //            }
    //        } else {
    //            TplExecuteConfigs configs = getExistConfigs(tplExecuteId);
    //            return getExistConfig(configs, tplExecuteId.getName());
    //        }
    //
    //        //        String executeId = tplExecuteId.getId();
    //        //        executeId = org.apache.commons.lang3.StringUtils.substringBeforeLast(executeId, COUNT_SUFFIX);
    //        //        String[] result = getFilePathAndexecuteId(executeId);
    //        //        String namespace = null;
    //        //        String eId = null;
    //        //        TplExecuteConfigs configs = null;
    //        //        if (result.length == 1) {
    //        //            configs = getConfigsByExecuteId(executeId);
    //        //            eId = executeId;
    //        //        } else {
    //        //            namespace = result[0];
    //        //            eId = result[1];
    //        //            configs = getConfigs(namespace);
    //        //        }
    //        //        if (configs == null) {
    //        //            // ENHANCE 使用exceptioncode
    //        //            throw new TplException("file " + namespace + " not find");
    //        //        }
    //        //        TplExecuteConfig config = configs.getConfig(eId);
    //        //        if (config == null) {
    //        //            // ENHANCE 使用exceptioncode
    //        //            throw new TplException("executeId " + eId + " not find in " + namespace);
    //        //        }
    //        //        return config;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TplExecuteConfig getConfig(String executeId) {
        executeId = org.apache.commons.lang3.StringUtils.substringBeforeLast(executeId, COUNT_SUFFIX);
        TplExecuteId tplExecuteId = executeIdsMap.get(executeId);
        if (tplExecuteId == null) {
            //  ENHANCE 使用exceptioncode
            throw new TplException("template executeId[" + executeId + "] not found");
        }
        return getConfig(tplExecuteId);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public TplExecuteConfig getConfig(String executeId) {
    //        executeId = org.apache.commons.lang3.StringUtils.substringBeforeLast(executeId, COUNT_SUFFIX);
    //        String[] result = getFilePathAndexecuteId(executeId);
    //        String namespace = null;
    //        String eId = null;
    //        TplExecuteConfigs configs = null;
    //        if (result.length == 1) {
    //            configs = getConfigByExecuteId(executeId);
    //            eId = executeId;
    //        } else {
    //            namespace = result[0];
    //            eId = result[1];
    //            configs = getConfigs(namespace);
    //        }
    //        if (configs == null) {
    //            // ENHANCE 使用exceptioncode
    //            throw new TplException("file " + namespace + " not find");
    //        }
    //        TplExecuteConfig config = configs.getConfig(eId);
    //        if (config == null) {
    //            // ENHANCE 使用exceptioncode
    //            throw new TplException("executeId " + eId + " not find in " + namespace);
    //        }
    //        return config;
    //    }

    private TplExecuteConfig getExistConfig(TplExecuteConfigs configs, String name) {
        TplExecuteConfig config = configs.getConfig(name);
        if (config == null) {
            // ENHANCE 使用exceptioncode
            throw new TplException(
                "template name[" + name + "] not found in namespace[" + configs.getNamespace() + "]");
        }
        return config;
    }

    private TplExecuteConfigs getExistConfigs(String namespace) {
        TplExecuteConfigs configs = configsMap.get(namespace);
        if (configs == null) {
            // ENHANCE 使用exceptioncode
            throw new TplException("namespace[" + namespace + "] template configs not found");
        }
        return configs;
    }

    private TplExecuteConfigs getExistConfigs(TplExecuteId executeId) {
        TplExecuteId tplExecuteId = executeIdsMap.get(executeId.getId());
        if (tplExecuteId == null) {
            throw new TplException("executeId[" + executeId.getId() + "] not found");
        } else if (MULTI_SAME_EXECUTEID == tplExecuteId) {
            throw new TplException("duplicated template name[" + executeId
                + "], please use full template executeId with name and namespace such as "
                + templateConfig.getTplExecuteIdParser().format("name", "namespace"));
        }
        return getExistConfigs(tplExecuteId.getNamespace());
    }

    private boolean getPrecompile(Map<String, Object> map) {
        Object precompileObj = map.get("precompile");
        boolean precompile = true; // 默认使用预编译
        if (Lang.isNotEmpty(precompileObj)) {
            if (precompileObj instanceof Boolean) {
                precompile = (Boolean) precompileObj;
            } else {
                precompile = Boolean.parseBoolean(precompileObj.toString());
            }
        }
        return precompile;
    }

    private ParamsFormat getParamsFormat(Map<String, Object> map) {
        Object pf = map.get("paramsFormat");
        if (Lang.isNotEmpty(pf)) {
            if (pf instanceof String) {
                return ParamsFormat.valueOf(pf.toString());
            } else {
                throw new TplException("paramsFormat must be a String");
            }
        }
        return ParamsFormat.AUTO;
    }

    @SuppressWarnings("unchecked")
    private String[] getStr(Map<String, Object> map, String key) {
        Set<String> strs = new HashSet<>();
        Object namesObj = map.get(key);
        if (namesObj != null) {
            if (namesObj instanceof String) {
                strs.add((String) namesObj);
            } else if (namesObj instanceof Collection) {
                for (String inParamName : (Collection<String>) namesObj) {
                    strs.add(inParamName);
                }
            } else if (namesObj instanceof String[]) {
                for (String inParamName : (String[]) namesObj) {
                    strs.add(inParamName);
                }
            } else {
                throw new TplException(key + " must be a String or String array or String list");
            }
        }
        return Lang.toArray(strs, String.class);
    }

    private String[] getParamNames(Map<String, Object> map) {
        return getStr(map, TplExecuteConfig.PARAM_NAMES);
    }

    private String[] getInParamNames(Map<String, Object> map) {
        return getStr(map, TplExecuteConfig.IN_PARAM_NAMES);
    }

    @SuppressWarnings("unchecked")
    private Set<Integer> getInParamIndexs(Map<String, Object> map) {
        Set<Integer> inParamIndexs = new HashSet<>();
        Object indexs = map.get("inParamIndexs");
        if (indexs != null) {
            if (indexs instanceof Integer || indexs.getClass() == int.class) {
                inParamIndexs.add((Integer) indexs);
            } else if (indexs instanceof Collection) {
                for (Integer index : (Collection<Integer>) indexs) {
                    inParamIndexs.add(index);
                }
            } else if (indexs instanceof Integer[]) {
                for (Integer index : (Integer[]) indexs) {
                    inParamIndexs.add(index);
                }
            } else {
                throw new TplException("inParamIndexs must be a int or int array or int list");
            }
        }
        return inParamIndexs;
        //        return CollectionUtils.toIntArray(inParamIndexs);
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
    public Set<String> getSuffixes() {
        return suffixes;
    }

    /**
     * 返回prefix.
     *
     * @return prefix
     */
    public Set<String> getPrefixes() {
        return prefixes;
    }

    /**
     * get parser value.
     *
     * @return parser
     */
    @Override
    public TemplateConfig getTemplateConfig() {
        return templateConfig;
    }

    /**
     * 返回templatePreprocessor.
     *
     * @return templatePreprocessor
     */
    public TemplatePreprocessor getTemplatePreprocessor() {
        return templatePreprocessor;
    }

    /**
     * Builder.
     *
     * @return the builder
     */
    public static Builder builder() {
        return new Builder();
    }

    private class FinalPath {

        private String suffix;

        private String prefix;

        private String filePath;

        /**
         * Instantiates a new file path.
         *
         * @param filePath the file path
         * @param prefix the prefix
         * @param suffix the suffix
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

    /**
     * The Class Builder.
     */
    public static class Builder {

        private Builder() {
        }

        private boolean devMode;
        private int commentMaxLength = 128;
        private final Set<String> suffixes = new HashSet<>();
        private final Set<String> prefixes = new HashSet<>();
        private final Set<String> basePackages = new HashSet<>();
        private TemplateConfig templateConfig;
        private TemplatePreprocessor preCompiler;

        /**
         * Dev mode.
         *
         * @param devMode the dev mode
         * @return the builder
         */
        public Builder devMode(boolean devMode) {
            this.devMode = devMode;
            return this;
        }

        /**
         * Suffixes.
         *
         * @param suffixes the suffixes
         * @return the builder
         */
        public Builder suffixes(Set<String> suffixes) {
            this.suffixes.addAll(suffixes);
            return this;
        }

        /**
         * Suffixes.
         *
         * @param suffixes the suffixes
         * @return the builder
         */
        public Builder suffixes(String... suffixes) {
            CollectionUtils.addAll(this.suffixes, suffixes);
            return this;
        }

        /**
         * Prefixs.
         *
         * @param prefixes the prefixes
         * @return the builder
         */
        public Builder prefixes(Set<String> prefixes) {
            this.prefixes.addAll(prefixes);
            return this;
        }

        /**
         * Prefixs.
         *
         * @param prefixes the prefixes
         * @return the builder
         */
        public Builder prefixes(String... prefixes) {
            CollectionUtils.addAll(this.prefixes, prefixes);
            return this;
        }

        /**
         * Base packages.
         *
         * @param basePackages the base packages
         * @return the builder
         */
        public Builder basePackages(Set<String> basePackages) {
            this.basePackages.addAll(basePackages);
            return this;
        }

        /**
         * Base packages.
         *
         * @param basePackages the base packages
         * @return the builder
         */
        public Builder basePackages(String... basePackages) {
            CollectionUtils.addAll(this.basePackages, basePackages);
            return this;
        }

        /**
         * Parser.
         *
         * @param templateConfig the template config
         * @return the builder
         */
        public Builder config(TemplateConfig templateConfig) {
            this.templateConfig = templateConfig;
            return this;
        }

        /**
         * Pre compile.
         *
         * @param preCompiler the pre compiler
         * @return the builder
         */
        public Builder preCompile(TemplatePreprocessor preCompiler) {
            this.preCompiler = preCompiler;
            return this;
        }

        /**
         * Comment max length.
         *
         * @param commentMaxLength the comment max length
         * @return the builder
         */
        public Builder commentMaxLength(int commentMaxLength) {
            this.commentMaxLength = commentMaxLength;
            return this;
        }

        /**
         * Builds the.
         *
         * @return the tpl config factory impl
         */
        public TplConfigFactoryImpl build() {
            return new TplConfigFactoryImpl(prefixes, suffixes, basePackages, preCompiler, templateConfig,
                commentMaxLength, devMode);
        }
    }

    //    private static String commentContent(byte[] bs) {
    //        int start = -1;
    //        for (int i = 0; i < bs.length; i++) {
    //            byte b = bs[i];
    //            if (b == ' ' || b == '\t') {
    //                continue;
    //            }
    //            if (b == '#') {
    //                continue;
    //            } else {
    //                // 注释结束位置
    //                start = i;
    //                break;
    //            }
    //        }
    //        if (start == -1) {
    //            return "";
    //        }
    //
    //        ByteArrayOutputStream os = new ByteArrayOutputStream(bs.length - start);
    //        for (int i = start; i < bs.length; i++) {
    //            byte b = bs[i];
    //            if (b == ' ' || b == '\t') {
    //                continue;
    //            }
    //            if (b == '\r' || b == '\n') {
    //                break;
    //            }
    //            os.write(b);
    //        }
    //        return os.toString();
    //    }

    private static String commentContent(InputStream is, int max) throws IOException {
        int start = -1;
        int read = -1;
        while (max-- > 0 && (read = is.read()) != -1) {
            if (read == '#') {
                start = read;
                continue;
            }

            if (read == ' ' || read == '\t') {
                continue;
            }
            if (read == '\r' || read == '\n') {
                start = -1;
                break;
            }

            if (start != -1 && Character.isAlphabetic(read)) {
                start = read;
                break;
            }
        }
        if (start == -1) {
            return "";
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream(max);
        os.write(start);
        while (max-- > 0 && (read = is.read()) != -1) {
            if (read == ' ' || read == '\t') {
                continue;
            }
            if (read == '\r' || read == '\n') {
                break;
            }
            os.write(read);
        }
        return os.toString();
    }

    /**
     * Gets the namespace.
     *
     * @param comment the comment
     * @return the namespace
     */
    public static String getNamespace(String comment) {
        if (comment == null) {
            return null;
        }
        String[] keyValues = comment.split(";");
        for (String keyValue : keyValues) {
            String[] kv = keyValue.split("=");
            if (kv.length == 2) {
                String k = kv[0];
                String v = kv[1];
                if (NAMESPACE.equalsIgnoreCase(k) && Lang.isNotEmpty(v)) {
                    // 从文件第一行的配置获取namespace,用于namespace冲突，又不想改文件名的情况
                    return v;
                }
            }
        }
        return null;
    }

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(String[] args) throws IOException {
        //        System.out.println(
        //                commentContent(new ByteArrayInputStream(" ###  \t   namespace=/user\nname: yufei".getBytes()), 128));
        //        System.out.println(
        //                commentContent(new ByteArrayInputStream(" ###  \r   namespace=/user\nname: yufei".getBytes()), 128));
        //        System.out.println(commentContent(
        //                new ByteArrayInputStream("select:\"select<@prop/>fromuser_infowhere1=1\"".getBytes()), 128));
        //        System.out.println(
        //                commentContent(new ByteArrayInputStream(" ###  \t   namespace=/user\nname: yufei".getBytes()), 128));
    }

}
