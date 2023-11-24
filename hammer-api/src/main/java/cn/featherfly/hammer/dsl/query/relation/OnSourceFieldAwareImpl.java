
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-01-10 18:26:10
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.query.relation;

/**
 * The Class OnSourcedFieldImpl.
 *
 * @author zhongj
 */
public class OnSourceFieldAwareImpl extends AbstractOnFields implements OnSourceFieldAware {

    /**
     * Instantiates a new on source field impl.
     *
     * @param sourceField the source field
     */
    public OnSourceFieldAwareImpl(String sourceField) {
        super();
        setSourceField(sourceField);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void joinField(String name) {
        setJoinField(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String sourceField() {
        return getSourceField();
    }

}
