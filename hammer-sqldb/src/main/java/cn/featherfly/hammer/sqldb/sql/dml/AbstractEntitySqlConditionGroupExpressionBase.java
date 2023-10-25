
package cn.featherfly.hammer.sqldb.sql.dml;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping.Mode;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * sql condition group builder sql条件逻辑组构造器 .
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
@SuppressWarnings("unchecked")
public abstract class AbstractEntitySqlConditionGroupExpressionBase<E, ER extends EntitySqlRelation<ER, B>,
        B extends SqlBuilder, C extends GroupExpression<C, L>, L extends GroupEndExpression<C, L>,
        C2 extends ConditionConfig<C2>> extends AbstractEntitySqlConditionExpressionBase<E, ER, B, C, L, C2> implements
        LogicExpression<C, L>, GroupExpression<C, L>, GroupEndExpression<C, L>, EntityPropertyExpression<E, C, L> {

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param parent            parent group
     * @param factory           the factory
     * @param entitySqlRelation the entity sql relation
     */
    protected AbstractEntitySqlConditionGroupExpressionBase(L parent, JdbcMappingFactory factory,
            ER entitySqlRelation) {
        super(parent, factory, entitySqlRelation);
    }

    /**
     * Gets the root.
     *
     * @return the root
     */
    protected AbstractEntitySqlConditionExpressionBase<E, ER, B, C, L, C2> getRoot() {
        L p = endGroup();
        while (p != p.endGroup()) {
            p = p.endGroup();
        }
        return (AbstractEntitySqlConditionExpressionBase<E, ER, B, C, L, C2>) p;
    }

    /**
     * Creates the group.
     *
     * @param parent     the parent
     * @param queryAlias the query alias
     * @return the c
     */
    protected abstract C createGroup(L parent);

    @Override
    public C group() {
        C group = createGroup((L) this);
        addCondition(group);
        return group;
    }

    @Override
    public L group(Function<C, L> group) {
        C g = group();
        return ((GroupEndExpression<C, L>) group.apply(g)).endGroup();
    }

    @Override
    public L endGroup() {
        if (parent != null) {
            return parent;
        } else {
            return (L) this;
        }
    }

    @Override
    public C logic(LogicOperator operator) {
        AssertIllegalArgument.isNotNull(operator, "operator");
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(operator));
    }

    @Override
    public C and() {
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.AND));
    }

    @Override
    public L and(Function<C, L> group) {
        return and().group(group);
    }

    @Override
    public C or() {
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.OR));
    }

    @Override
    public L or(Function<C, L> group) {
        return or().group(group);
    }

    //    @Override
    //    public long count() {
    //        queryRelation.getSelectBuilder().addColumn(AggregateFunction.COUNT, Chars.STAR);
    //        return queryRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParams().toArray());
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String build() {
    //        return super.build();
    //        //        String condition = super.build();
    //        //        if (parent == null) {
    //        //            if (Lang.isNotEmpty(condition)) {
    //        //                //                return dialect.getKeywords().where() + Chars.SPACE + super.build() + Chars.SPACE + sortBuilder.build();
    //        //                return dialect.getKeywords().where() + Chars.SPACE + condition;
    //        //            } else {
    //        //                //                return super.build() + Chars.SPACE + sortBuilder.build();
    //        //                return condition;
    //        //            }
    //        //        } else {
    //        //            return ((AbstractEntitySqlConditionExpressionBase<E, ER, B, C, L>) parent).build();
    //        //        }
    //    }

    // ********************************************************************
    // private method
    // ********************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    protected <R> L eq_ne(AtomicInteger index, ComparisonOperator comparisonOperator, PropertyMapping<?> pm, R value,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return eq_ne(comparisonOperator, pm, value, getAlias(index), matchStrategy, ignoreStrategy);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    protected <R> L eq_ne(int index, ComparisonOperator comparisonOperator, List<PropertyMapping<?>> pms, R value,
    //            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
    //        if (Lang.isEmpty(pms)) {
    //            throw new SqldbHammerException("propertyMappingList can not be empty"); // ENHANCE 异常消息
    //        }
    //        if (pms.size() == 1) {
    //            return eq_ne(index, comparisonOperator, pms.get(0), value, matchStrategy, ignoreStrategy);
    //        } else {
    //            PropertyMapping<?> pm = pms.get(pms.size() - 1);
    //            return eq_ne0(comparisonOperator, pm.getRepositoryFieldName(), getFieldValueOperator(pm, value),
    //                    getAlias(index), matchStrategy, ignoreStrategy);
    //            //            return eq_ne(comparisonOperator, pms, value, getAlias(index), matchStrategy, ignoreStrategy);
    //        }
    //    }

    @Override
    protected <R> L eq_ne(ComparisonOperator comparisonOperator, PropertyMapping<?> pm, R value, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        AssertIllegalArgument.isNotNull(ignoreStrategy, "ignoreStrategy");
        if (value != null) {
            if (pm.getMode() == Mode.MANY_TO_ONE || pm.getMode() == Mode.EMBEDDED) {
                L logic = null;
                C condition = (C) this;
                boolean groupable = pm.getPropertyMappings().size() > 1;
                if (groupable) {
                    condition = group();
                }
                if (ClassUtils.isParent(pm.getPropertyType(), value.getClass())) {
                    BeanDescriptor<?> bd = BeanDescriptor.getBeanDescriptor(value.getClass());
                    // IMPLSOON pm.getPropertyMappings() 只能获取EMBEDDED的映射
                    // 如果是MANY_TO_ONE或者ONE_TO_ONE， pm.getPropertyMappings()只会返回映射对应的外键column,比如user_id
                    // TODO 考虑是否进行关系映射查询
                    // 即 userInfo.user[name=yi, age= 18], 自动join,并查询所有非空的值，和现在的逻辑一致，只是需要自动join
                    for (PropertyMapping<?> spm : pm.getPropertyMappings()) {
                        Object ov = bd.getBeanProperty(spm.getPropertyName()).getValue(value);
                        if (logic != null) {
                            condition = logic.and();
                        }
                        logic = ((AbstractEntitySqlConditionExpressionBase<E, ER, B, C, L, C2>) condition)
                                .eq_ne(comparisonOperator, spm, ov, queryAlias, matchStrategy, ignoreStrategy);
                    }

                    //                    if (pm.getMode() == Mode.EMBEDDED) {
                    //                        for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
                    //                            Object ov = bd.getBeanProperty(spm.getPropertyName()).getValue(value);
                    //                            if (logic != null) {
                    //                                condition = logic.and();
                    //                            }
                    //                            logic = ((AbstractEntitySqlConditionGroupExpression<E, C, L>) condition)
                    //                                    .eq_ne0(comparisonOperator, spm, ov, matchStrategy);
                    //                        }
                    //                    } else if (pm.getMode() == Mode.MANY_TO_ONE) {
                    //                        JdbcClassMapping<?> cm = factory.getClassMapping(pm.getPropertyType());
                    //                        for (JdbcPropertyMapping cpm : cm.getPropertyMappings()) {
                    //                            // IMPLSOON 后续来实现关联对象的联表查询
                    //                            Object ov = bd.getBeanProperty(cpm.getPropertyName()).getValue(value);
                    //                            if (logic != null) {
                    //                                condition = logic.and();
                    //                            }
                    //                            logic = ((AbstractEntitySqlConditionGroupExpression<E, C, L>) condition)
                    //                                    .eq_ne0(comparisonOperator, "", cpm, ov, matchStrategy);
                    //                        }
                    //                    } else {
                    //                        // FIXME 后续来实现
                    //                        throw new SqldbHammerException("not support");
                    //                    }
                    if (groupable) {
                        logic = logic.endGroup();
                    }
                    return logic;
                } else {
                    for (PropertyMapping<?> spm : pm.getPropertyMappings()) {
                        if (ClassUtils.isParent(spm.getPropertyType(), value.getClass())) {
                            return eq_ne(comparisonOperator, spm, value, queryAlias, matchStrategy, ignoreStrategy);
                        }
                    }
                }
            }
        }

        return eq_ne0(comparisonOperator, pm, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    private <T, R> L eq_ne0(ComparisonOperator comparisonOperator, PropertyMapping<?> pm, R value, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                getFieldValueOperator(pm, value), comparisonOperator, matchStrategy, queryAlias, ignoreStrategy));
        return eq_ne0(comparisonOperator, pm.getRepositoryFieldName(), getFieldValueOperator(pm, value), queryAlias,
                matchStrategy, ignoreStrategy);
    }

    private <T, R> L eq_ne0(ComparisonOperator comparisonOperator, String fieldName,
            FieldValueOperator<R> fieldValueOperator, String queryAlias, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, fieldName, fieldValueOperator,
                comparisonOperator, matchStrategy, queryAlias, ignoreStrategy));
    }

    // ********************************************************************
    // protected method
    // ********************************************************************

    // ********************************************************************
    // property
    // ********************************************************************
}
