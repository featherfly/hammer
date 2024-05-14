
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-11 01:29:11
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.tpl;

import java.nio.charset.Charset;
import java.util.function.Function;
import java.util.function.IntFunction;

import cn.featherfly.hammer.tpl.TplExecuteIdParser;

/**
 * TemplateConfig.
 *
 * @author zhongj
 */
public interface TemplateConfig {

    /**
     * Gets the template charset.
     *
     * @return the charset
     */
    Charset getCharset();

    /**
     * Sets the tpl execute id parser.
     *
     * @param  tplExecuteIdParser the tpl execute id parser
     * @return                    the template config
     */
    TemplateConfig setTplExecuteIdParser(TplExecuteIdParser tplExecuteIdParser);

    /**
     * Gets the tpl execute id parser.
     *
     * @return the tpl execute id parser
     */
    TplExecuteIdParser getTplExecuteIdParser();

    /**
     * Sets the param index to name.
     *
     * @param  paramIndexToName the param index to name
     * @return                  the template config
     */
    TemplateConfig setParamIndexToName(IntFunction<String> paramIndexToName);

    /**
     * Gets the param index to name.
     *
     * @return the param index to name
     */
    IntFunction<String> getParamIndexToName();

    /**
     * Sets the in param placeholder name.
     *
     * @param  inParamPlaceholderName the in param placeholder name
     * @return                        the template config
     */
    TemplateConfig setInParamPlaceholderName(Function<String, String> inParamPlaceholderName);

    /**
     * Gets the in param placeholder name.
     *
     * @return the in param placeholder name
     */
    Function<String, String> getInParamPlaceholderName();

    /**
     * Sets the precompile named param placeholder.
     *
     * @param  precompileNamedParamPlaceholder the precompile named param placeholder
     * @return                                 the template config
     */
    TemplateConfig setPrecompileNamedParamPlaceholder(boolean precompileNamedParamPlaceholder);

    /**
     * Checks if is precompile named param placeholder.
     *
     * @return true, if is precompile named param placeholder
     */
    boolean isPrecompileNamedParamPlaceholder();

    /**
     * Sets the precompile minimize.
     *
     * @param  precompileMinimize the precompile minimize
     * @return                    the template config
     */
    TemplateConfig setPrecompileMinimize(boolean precompileMinimize);

    /**
     * Checks if is precompile minimize.
     *
     * @return true, if is precompile minimize
     */
    boolean isPrecompileMinimize();

    //    TemplateConfig setPrecompileInParamPlaceholder(boolean precompileInParamPlaceholder);
    //
    //    boolean isPrecompileInParamPlaceholder();

}
