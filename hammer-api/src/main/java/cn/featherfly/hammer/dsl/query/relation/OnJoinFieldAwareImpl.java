
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-01-10 18:26:10
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.query.relation;

/**
 * The Class OnJoinedFieldImpl.
 *
 * @author zhongj
 */
public class OnJoinFieldAwareImpl extends AbstractOnFields implements OnJoinFieldAware {

    /**
     * Instantiates a new on source field impl.
     *
     * @param joinField the join field
     */
    public OnJoinFieldAwareImpl(String joinField) {
        super();
        setJoinField(joinField);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sourceField(String name) {
        setSourceField(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String joinField() {
        return getJoinField();
    }

}
