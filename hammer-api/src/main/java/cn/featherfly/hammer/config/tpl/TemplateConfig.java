
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-11 01:29:11
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.tpl;

import cn.featherfly.hammer.tpl.TplExecuteIdParser;

/**
 * TemplateConfig.
 *
 * @author zhongj
 */
public interface TemplateConfig {

    TemplateConfig setTplExecuteIdParser(TplExecuteIdParser tplExecuteIdParser);

    TplExecuteIdParser getTplExecuteIdParser();
}
