
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-01-10 17:43:10
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.query.relation;

/**
 * The Class OnFieldsImpl.
 *
 * @author zhongj
 */
public class OnFieldBuilderImpl implements OnFieldBuilder {

    private AbstractOnFields onFields;

    /**
     * {@inheritDoc}
     */
    @Override
    public OnJoinFieldAware joinField(String name) {
        OnJoinFieldAwareImpl onFields = new OnJoinFieldAwareImpl(name);
        this.onFields = onFields;
        return onFields;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OnSourceFieldAware sourceField(String name) {
        OnSourceFieldAwareImpl onFields = new OnSourceFieldAwareImpl(name);
        this.onFields = onFields;
        return onFields;
    }

    /**
     * Gets the source field.
     *
     * @return the source field
     */
    public String getSourceField() {
        return onFields.getSourceField();
    }

    /**
     * Gets the join field.
     *
     * @return the join field
     */
    public String getJoinField() {
        return onFields.getJoinField();
    }

}
