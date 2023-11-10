
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 16:00:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta;

import cn.featherfly.common.repository.AliasField;

/**
 * FieldImpl.
 *
 * @author zhongj
 */
public class FieldImpl implements AliasField {

    private final String name;

    private final String alias;

    /**
     * Instantiates a new field impl.
     *
     * @param name the name
     */
    public FieldImpl(String name) {
        this(name, null);
    }

    /**
     * Instantiates a new field impl.
     *
     * @param name the name
     */
    public FieldImpl(String name, String alias) {
        super();
        this.name = name;
        this.alias = alias;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String alias() {
        return alias;
    }

}
