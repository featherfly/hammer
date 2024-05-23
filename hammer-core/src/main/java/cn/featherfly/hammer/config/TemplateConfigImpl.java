
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-11 01:32:11
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

import cn.featherfly.common.lang.string.StringFormatter;
import cn.featherfly.hammer.config.tpl.TemplateConfig;
import cn.featherfly.hammer.tpl.TemplateDirectives;
import cn.featherfly.hammer.tpl.TplExecuteIdEmailStyleParser;
import cn.featherfly.hammer.tpl.TplExecuteIdParser;

/**
 * TemplateConfigImpl.
 *
 * @author zhongj
 */
public class TemplateConfigImpl implements TemplateConfig {

    private Function<String, String> inParamPlaceholderName = n -> "_" + n;

    private Function<String, String> countSqlConvertor;

    // ascii 165 ¥ 166 ¦
    private StringFormatter formatter = new StringFormatter((char) 165, (char) 166);

    private CountSqlConverteStrategy countSqlConverteStrategy = CountSqlConverteStrategy.INIT_WARNING;

    private TplExecuteIdParser tplExecuteIdParser = new TplExecuteIdEmailStyleParser();

    private IntFunction<String> paramIndexToName = i -> "argu" + i;

    private boolean precompileNamedParamPlaceholder = false;

    private boolean precompileMinimize = true;

    private Charset charset = StandardCharsets.UTF_8;

    private String[] includeDirectiveTagNames = new String[] { TemplateDirectives.TEMPLATE_INCLUDE_DIRECTIVE_KEY };

    //    private boolean precompileInParamPlaceholder = true;

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateConfig setTplExecuteIdParser(TplExecuteIdParser tplExecuteIdParser) {
        this.tplExecuteIdParser = tplExecuteIdParser;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TplExecuteIdParser getTplExecuteIdParser() {
        return tplExecuteIdParser;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateConfig setParamIndexToName(IntFunction<String> paramIndexToName) {
        this.paramIndexToName = paramIndexToName;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IntFunction<String> getParamIndexToName() {
        return paramIndexToName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPrecompileNamedParamPlaceholder() {
        return precompileNamedParamPlaceholder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateConfig setPrecompileNamedParamPlaceholder(boolean precompileNamedParamPlaceholder) {
        this.precompileNamedParamPlaceholder = precompileNamedParamPlaceholder;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateConfig setPrecompileMinimize(boolean precompileMinimize) {
        this.precompileMinimize = precompileMinimize;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPrecompileMinimize() {
        return precompileMinimize;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public TemplateConfig setPrecompileInParamPlaceholder(boolean precompileInParamPlaceholder) {
    //        this.precompileInParamPlaceholder = precompileInParamPlaceholder;
    //        return this;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public boolean isPrecompileInParamPlaceholder() {
    //        return precompileInParamPlaceholder;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateConfig setInParamPlaceholderName(Function<String, String> inParamPlaceholderName) {
        this.inParamPlaceholderName = inParamPlaceholderName;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Function<String, String> getInParamPlaceholderName() {
        return inParamPlaceholderName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Charset getCharset() {
        return charset;
    }

    /**
     * Sets the template charset.
     *
     * @param charset the charset
     * @return the template config
     */
    public TemplateConfig setCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getIncludeDirectiveTagNames() {
        return includeDirectiveTagNames;
    }

    /**
     * set includeDirectiveTagNames value.
     *
     * @param includeDirectiveTagNames includeDirectiveTagNames
     * @return the template config impl
     */
    public TemplateConfigImpl setIncludeDirectiveTagNames(String[] includeDirectiveTagNames) {
        this.includeDirectiveTagNames = includeDirectiveTagNames;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateConfig setCountSqlConvertor(BiFunction<String, Boolean, String> countSqlConvertor) {
        this.countSqlConvertor = (sql) -> countSqlConvertor.apply(sql, isPrecompileNamedParamPlaceholder());
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Function<String, String> getCountSqlConvertor() {
        return countSqlConvertor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateConfig setCountSqlConverteStrategy(CountSqlConverteStrategy countSqlConverteStrategy) {
        this.countSqlConverteStrategy = countSqlConverteStrategy;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountSqlConverteStrategy getCountSqlConverteStrategy() {
        return countSqlConverteStrategy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateConfig setPreIncludeFormmater(StringFormatter formatter) {
        this.formatter = formatter;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringFormatter getPreIncludeFormmater() {
        return formatter;
    }
}
