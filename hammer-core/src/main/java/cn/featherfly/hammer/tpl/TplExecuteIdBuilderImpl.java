
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-10 16:57:10
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl;

/**
 * TplExecuteIdBuilderImpl.
 *
 * @author zhongj
 */
public class TplExecuteIdBuilderImpl implements TplExecuteIdBuilder {

    private final TplExecuteIdParser parser;

    /**
     * Instantiates a new tpl execute id builder impl.
     *
     * @param parser the parser
     */
    public TplExecuteIdBuilderImpl(TplExecuteIdParser parser) {
        super();
        this.parser = parser;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NamedExecuteId name(String name) {
        return namespace -> new TplExecuteIdImpl(name, namespace, parser);
    }
}
