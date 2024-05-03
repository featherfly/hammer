
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityPropertyFunctionImpl.java
 * @Description: EntityPropertyFunctionImpl
 * @author: zhongj
 * @date: 2023-08-21 18:00:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.condition.field;

import java.util.Date;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryDateFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryEnumFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalDateFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalDateTimeFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalTimeFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryNumberFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositorySerializableFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryStringFieldExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.condition.InternalMulitiRepositoryFieldOnlyConditionImpl;

/**
 * RepositoryFieldExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
@SuppressWarnings("unchecked")
public class RepositoryFieldExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>,
    C2 extends ConditionConfig<C2>, S extends RepositorySqlRelation<S, B>, B extends SqlBuilder>
    implements RepositoryFieldExpression<C, L> {

    protected final InternalMulitiRepositoryFieldOnlyConditionImpl<C2, S, B> expression;

    /**
     * Instantiates a new entity property function impl.
     *
     * @param index              the index
     * @param repositoryRelation the repository relation
     */
    public RepositoryFieldExpressionImpl(int index, S repositoryRelation) {
        expression = new InternalMulitiRepositoryFieldOnlyConditionImpl<>(index, repositoryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return expression.expression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySerializableFieldExpression<C, L> field(String name) {
        return new SerializableFieldExpressionMulitiRepositoryImpl<>(expression.getIndex(), name,
            (InternalMulitiCondition<L>) expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryStringFieldExpression<C, L> fieldAsString(String name) {
        return new StringFieldExpressionMulitiRepositoryImpl<>(expression.getIndex(), name,
            (InternalMulitiCondition<L>) expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositoryNumberFieldExpression<N, C, L> fieldAsNumber(String name) {
        return new NumberFieldExpressionMulitiRepositoryImpl<>(expression.getIndex(), name,
            (InternalMulitiCondition<L>) expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> RepositoryDateFieldExpression<D, C, L> fieldAsDate(String name) {
        return new DateFieldExpressionMulitiRepositoryImpl<>(expression.getIndex(), name,
            (InternalMulitiCondition<L>) expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> RepositoryEnumFieldExpression<E, C, L> fieldAsEnum(String name) {
        return new EnumFieldExpressionMulitiRepositoryImpl<>(expression.getIndex(), name,
            (InternalMulitiCondition<L>) expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalDateFieldExpression<C, L> fieldAsLocalDate(String name) {
        return new LocalDateFieldExpressionMulitiRepositoryImpl<>(expression.getIndex(), name,
            (InternalMulitiCondition<L>) expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalDateTimeFieldExpression<C, L> fieldAsLocalDateTime(String name) {
        return new LocalDateTimeFieldExpressionMulitiRepositoryImpl<>(expression.getIndex(), name,
            (InternalMulitiCondition<L>) expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalTimeFieldExpression<C, L> fieldAsLocalTime(String name) {
        return new LocalTimeFieldExpressionMulitiRepositoryImpl<>(expression.getIndex(), name,
            (InternalMulitiCondition<L>) expression);
    }
}
