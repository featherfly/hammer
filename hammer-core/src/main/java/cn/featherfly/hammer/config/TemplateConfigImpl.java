
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
import java.util.function.Function;
import java.util.function.IntFunction;

import cn.featherfly.hammer.config.tpl.TemplateConfig;
import cn.featherfly.hammer.tpl.TplExecuteIdEmailStyleParser;
import cn.featherfly.hammer.tpl.TplExecuteIdParser;

/**
 * TemplateConfigImpl.
 *
 * @author zhongj
 */
public class TemplateConfigImpl implements TemplateConfig {

    private Function<String, String> inParamPlaceholderName = n -> "_" + n;

    private TplExecuteIdParser tplExecuteIdParser = new TplExecuteIdEmailStyleParser();

    private IntFunction<String> paramIndexToName = i -> "argu" + i;

    private boolean precompileNamedParamPlaceholder = false; // YUFEI_TODO 功能完善了再来改成默认false\

    private boolean precompileMinimize = true;

    private Charset charset = StandardCharsets.UTF_8;

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
     * @param  charset the charset
     * @return         the template config
     */
    public TemplateConfig setCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

}
