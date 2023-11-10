
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 15:57:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta.user;

import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.SimpleAliasRepository;
import cn.featherfly.hammer.dml.builder.sql.meta.IntField;
import cn.featherfly.hammer.dml.builder.sql.meta.IntFieldImpl;
import cn.featherfly.hammer.dml.builder.sql.meta.QueryableRepository;
import cn.featherfly.hammer.dml.builder.sql.meta.QueryableStringField;
import cn.featherfly.hammer.dml.builder.sql.meta.QueryableStringFieldImpl;

/**
 * UserTable.
 *
 * @author zhongj
 */
public class UserTableQueryable implements QueryableRepository {

    public final QueryableStringField<UserTableFilterable,
            UserTableLogic> name = new QueryableStringFieldImpl<>("name");
    public final QueryableStringField<UserTableFilterable,
            UserTableLogic> password = new QueryableStringFieldImpl<>("password");
    public final IntField age = new IntFieldImpl("age");

    //    private QueryCondition queryCondition;

    /**
     */
    public UserTableQueryable() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return "user";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AliasRepository alias(String alias) {
        return new SimpleAliasRepository(name(), alias);
    }
}
