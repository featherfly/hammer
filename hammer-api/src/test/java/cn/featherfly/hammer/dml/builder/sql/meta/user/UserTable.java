
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 15:57:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta.user;

import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.SimpleAliasRepository;
import cn.featherfly.hammer.dml.builder.sql.meta.FieldImpl;
import cn.featherfly.hammer.dml.builder.sql.meta.QueryableRepository;

/**
 * UserTable.
 *
 * @author zhongj
 */
public class UserTable implements QueryableRepository {

    public final Field name = new FieldImpl("name");
    public final Field password = new FieldImpl("password");
    public final Field age = new FieldImpl("age");

    //    private QueryCondition queryCondition;

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return "user";
    }

    @Override
    public AliasRepository alias(String alias) {
        return new SimpleAliasRepository(name(), alias);
    }
}
