
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-11 01:32:11
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config;

import cn.featherfly.hammer.config.tpl.TemplateConfig;
import cn.featherfly.hammer.tpl.TplExecuteIdEmailStyleParser;
import cn.featherfly.hammer.tpl.TplExecuteIdParser;

/**
 * TemplateConfigImpl.
 *
 * @author zhongj
 */
public class TemplateConfigImpl implements TemplateConfig {

    private TplExecuteIdParser tplExecuteIdParser = new TplExecuteIdEmailStyleParser();

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

}
