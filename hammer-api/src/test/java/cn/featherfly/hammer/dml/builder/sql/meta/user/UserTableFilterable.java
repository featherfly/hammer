
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 15:57:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta.user;

import java.util.function.Function;

import cn.featherfly.hammer.dml.builder.sql.meta.FilterableRepository;
import cn.featherfly.hammer.dml.builder.sql.meta.FilterableStringField;
import cn.featherfly.hammer.dml.builder.sql.meta.FilterableStringFieldImpl;
import cn.featherfly.hammer.dml.builder.sql.meta.IntField;
import cn.featherfly.hammer.dml.builder.sql.meta.IntFieldImpl;
import cn.featherfly.hammer.dml.builder.sql.meta.Where;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup;
import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * UserTable.
 *
 * @author zhongj
 */
public class UserTableFilterable
    implements FilterableRepository, Where<UserTableFilterable, UserTableFilterable, UserTableLogic>,
    GroupExpression<UserTableFilterable, UserTableLogic> {

    public static void main(String[] args) {
        UserTableFilterable user = null;
        user.name.eq("zj").and().password.eq("123").single();
        user.name.eq("zj").and().password.eq("123").limit(1).single();

        user.name.eq("zj").and().password.eq("123").unique();
        user.name.eq("zj").and().password.eq("123").limit(1).unique();

        user.name.eq("zj").and().password.eq("123").list();
        user.name.eq("zj").and().password.eq("123").limit(10).list();

        user.name.eq("zj").and().password.eq("123").limit(10).pagination();
    }

    private String alias;

    public final FilterableStringField<UserTableFilterable, UserTableLogic> name;

    public final FilterableStringField<UserTableFilterable, UserTableLogic> password;

    public final IntField age;

    private RepositoryQueryConditionsGroup queryCondition;

    /**
     * @param alias
     * @param queryCondition
     */
    UserTableFilterable(String alias, RepositoryQueryConditionsGroup queryCondition) {
        super();
        this.alias = alias;
        name = new FilterableStringFieldImpl<>("name", queryCondition);
        password = new FilterableStringFieldImpl<>("password", queryCondition);
        age = new IntFieldImpl("age");
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
    public String alias() {
        return alias;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FilterableStringField<UserTableFilterable, UserTableLogic> alias(String alias) {
        return new FilterableStringFieldImpl<>(alias, queryCondition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserTableFilterable group() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserTableLogic group(Function<UserTableFilterable, UserTableLogic> group) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserTableLogic ignore(boolean ignorable,
        Function<UserTableFilterable, UserTableLogic> conditionExpressions) {
        return null;
    }

}
