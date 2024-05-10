
package cn.featherfly.hammer.tpl.mapper;

import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.tpl.TplExecuteId;
import cn.featherfly.hammer.tpl.TplExecuteIdFileImpl;
import cn.featherfly.hammer.tpl.TplExecuteIdMapperImpl;
import cn.featherfly.hammer.tpl.TplExecuteIdParser;
import cn.featherfly.hammer.tpl.TplExecutor;

/**
 * BasedTplHammer.
 *
 * @author zhongj
 */
public class AbstractBasedHammer {

    /** The hammer config. */
    protected final HammerConfig hammerConfig;

    /** The tpl executor. */
    protected final TplExecutor tplExecutor;

    protected final TplExecuteIdParser parser;

    /**
     * Instantiates a new based hammer tpl executor.
     *
     * @param tplExecutor  the tpl executor
     * @param hammerConfig the hammer config
     */
    public AbstractBasedHammer(TplExecutor tplExecutor, HammerConfig hammerConfig) {
        this.hammerConfig = hammerConfig;
        this.tplExecutor = tplExecutor;
        parser = hammerConfig.getTemplateConfig().getTplExecuteIdParser();
    }

    /**
     * File execute id.
     *
     * @param name      the name
     * @param namespace the namespace
     * @return the tpl execute id
     */
    protected final TplExecuteId fileExecuteId(String name, String namespace) {
        return new TplExecuteIdFileImpl(name, namespace, hammerConfig.getTemplateConfig().getTplExecuteIdParser());
    }

    /**
     * Mapper execute id.
     *
     * @param name      the name
     * @param namespace the namespace
     * @return the tpl execute id
     */
    protected final TplExecuteId mapperExecuteId(String name, String namespace) {
        return new TplExecuteIdMapperImpl(name, namespace, this.getClass(),
                hammerConfig.getTemplateConfig().getTplExecuteIdParser());
    }

    /**
     * get hammerConfig value
     *
     * @return hammerConfig
     */
    public HammerConfig getHammerConfig() {
        return hammerConfig;
    }
}
