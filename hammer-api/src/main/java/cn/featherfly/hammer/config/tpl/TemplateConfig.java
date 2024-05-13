
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

    TemplateConfig setCharset(Charset charset);

    Charset getCharset();

    TemplateConfig setTplExecuteIdParser(TplExecuteIdParser tplExecuteIdParser);

    TplExecuteIdParser getTplExecuteIdParser();

    TemplateConfig setParamIndexToName(IntFunction<String> paramIndexToName);

    IntFunction<String> getParamIndexToName();

    TemplateConfig setInParamPlaceholderName(Function<String, String> inParamPlaceholderName);

    Function<String, String> getInParamPlaceholderName();

    TemplateConfig setPrecompileNamedParamPlaceholder(boolean precompileNamedParamPlaceholder);

    boolean isPrecompileNamedParamPlaceholder();

    TemplateConfig setPrecompileMinimize(boolean precompileMinimize);

    boolean isPrecompileMinimize();

    //    TemplateConfig setPrecompileInParamPlaceholder(boolean precompileInParamPlaceholder);
    //
    //    boolean isPrecompileInParamPlaceholder();

}
