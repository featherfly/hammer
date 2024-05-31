
package cn.featherfly.hammer.sqldb.dsl.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.model.ParamedColumnElement;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.sql.dml.SqlConditionExpressionBuilder;
import cn.featherfly.hammer.sqldb.sql.dml.SqlLogicOperatorExpressionBuilder;

/**
 * sql condition group expression . sql条件逻辑组表达式.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <C2> condition config
 * @param <ER> entity sql relation
 * @param <B> sql builder
 */
@SuppressWarnings("unchecked")
public abstract class AbstractMulitiEntitySqlConditionsGroupExpressionBase<E1, C extends GroupExpression<C, L>,
    L extends GroupEndExpression<C, L>, C2 extends ConditionConfig<C2>, ER extends EntitySqlRelation<ER, B>,
    B extends SqlBuilder> extends AbstractMulitiEntitySqlConditionsExpressionBase<E1, C, L, C2, ER, B>
    implements LogicExpression<C, L>, GroupExpression<C, L>, GroupEndExpression<C, L> {

    /**
     * Instantiates a new abstract sql condition group expression.
     *
     * @param parent parent group
     * @param factory the factory
     * @param entitySqlRelation the entity sql relation
     */
    protected AbstractMulitiEntitySqlConditionsGroupExpressionBase(L parent, JdbcMappingFactory factory,
        ER entitySqlRelation) {
        super(parent, factory, entitySqlRelation);
    }

    /**
     * Gets the root.
     *
     * @return the root
     */
    protected AbstractMulitiEntitySqlConditionsGroupExpressionBase<E1, C, L, C2, ER, B> getRoot() {
        L p = endGroup();
        while (p != p.endGroup()) {
            p = p.endGroup();
        }
        return (AbstractMulitiEntitySqlConditionsGroupExpressionBase<E1, C, L, C2, ER, B>) p;
    }

    /**
     * Creates the group.
     *
     * @param parent the parent
     * @return the c
     */
    protected abstract C createGroup(L parent);

    /**
     * {@inheritDoc}
     */
    @Override
    public C group() {
        C group = createGroup((L) this);
        addCondition(group);
        return group;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L group(Function<C, L> group) {
        C g = group();
        return ((GroupEndExpression<C, L>) group.apply(g)).endGroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L endGroup() {
        if (parent != null) {
            return parent;
        } else {
            return (L) this;
        }
    }

    //    @Override
    //    public C logic(LogicOperator operator) {
    //        AssertIllegalArgument.isNotNull(operator, "operator");
    //        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(operator));
    //    }
    //
    //    @Override
    //    public L logic(LogicOperator operator, LogicExpression<?, ?> logicExpression) {
    //        logic(operator);
    //        return (L) addCondition(logicExpression);
    //    }
    //
    //    @Override
    //    public L logic(LogicOperator operator, Function<C, L> group) {
    //        return logic(operator).group(group);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C and() {
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.AND));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L and(LogicExpression<?, ?> logicExpression) {
        and();
        return (L) addCondition(logicExpression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L and(Function<C, L> group) {
        return and().group(group);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C or() {
        return (C) addCondition(new SqlLogicOperatorExpressionBuilder(LogicOperator.OR));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L or(LogicExpression<?, ?> logicExpression) {
        or();
        return (L) addCondition(logicExpression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L or(Function<C, L> group) {
        return or().group(group);
    }

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
    public <R> L eqOrNe(AtomicInteger index, ComparisonOperator comparisonOperator, PropertyMapping<?> pm, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return eqOrNe(comparisonOperator, pm, null, value, getAlias(index), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eqOrNe(AtomicInteger index, ComparisonOperator comparisonOperator, PropertyMapping<?> pm,
        ParamedColumnElement name, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return eqOrNe(comparisonOperator, pm, name, value, getAlias(index), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eqOrNe(AtomicInteger index, ComparisonOperator comparisonOperator, ParamedColumnElement field, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        // IMPLSOON 未实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eqOrNe(AtomicInteger index, ComparisonOperator comparisonOperator, String name, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        // IMPLSOON 未实现
        throw new NotImplementedException();
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    protected <R> L eq_ne(AtomicInteger index, ComparisonOperator comparisonOperator, List<PropertyMapping<?>> pms, R value,
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

    private <V> L eqOrNeEmbedded(ComparisonOperator comparisonOperator, JdbcPropertyMapping propertyMapping,
        ParamedColumnElement name, V value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        List<JdbcPropertyMapping> propertyMappings = propertyMapping.getPropertyMappings();
        L logic = null;
        C condition = (C) this;
        boolean groupable = propertyMappings.size() > 1;
        if (groupable) {
            condition = group();
        }
        //        BeanDescriptor<?> bd = BeanDescriptor.getBeanDescriptor(value.getClass());
        for (PropertyMapping<?> pm : propertyMappings) {
            Serializable ov = pm.getProperty().get(value);
            //            Object ov = bd.getBeanProperty(pm.getPropertyName()).getValue(value);
            if (logic != null) {
                // ENHANCE 后续配置，使用configure可以进行动态设置使用and还是or连接
                condition = logic.and();
            }
            logic = ((AbstractMulitiEntitySqlConditionsExpressionBase<E1, C, L, C2, ER, B>) condition)
                .eqOrNe(comparisonOperator, pm, name, ov, queryAlias, matchStrategy, ignoreStrategy);
        }
        if (groupable && logic != null) {
            logic = logic.endGroup();
        }
        return logic;
    }

    private <V> L eqOrNeToOne(ComparisonOperator comparisonOperator, PropertyMapping<?> joinFromPropertyMapping,
        ParamedColumnElement name, V value, String queryAlias, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        JdbcClassMapping<?> joinClassMapping = factory.getClassMapping(joinFromPropertyMapping.getPropertyType());
        Collection<JdbcPropertyMapping> propertyMappings = joinClassMapping.getPropertyMappingLeafNodes();
        L logic = null;
        C condition = (C) this;
        //        BeanDescriptor<?> bd = BeanDescriptor.getBeanDescriptor(value.getClass());
        List<Tuple2<PropertyMapping<?>, Serializable>> values = new ArrayList<>();
        boolean groupable = false;
        boolean fetch = false;
        for (PropertyMapping<?> pm : propertyMappings) {
            Serializable ov = pm.getGetter().apply(value);
            //Serializable ov = () bd.getBeanProperty(pm.getPropertyName()).getValue(value);
            if (Lang.isNotEmpty(ov)) {
                values.add(Tuples.of(pm, ov));
                if (!pm.isPrimaryKey() && !fetch) {
                    fetch = true;
                    entityRelation.join(getIndex(), joinFromPropertyMapping.getPropertyName(), joinClassMapping);
                    queryAlias = getAlias(getIndex() + 1);
                }
            }
        }
        if (fetch) {
            groupable = fetch;
            condition = group();
            for (Tuple2<PropertyMapping<?>, Serializable> tv : values) {
                if (logic != null) {
                    // ENHANCE 后续配置，使用configure可以进行动态设置使用and还是or连接
                    condition = logic.and();
                }
                logic = ((AbstractMulitiEntitySqlConditionsExpressionBase<E1, C, L, C2, ER, B>) condition)
                    .eqOrNe(comparisonOperator, tv.get0(), name, tv.get1(), queryAlias, matchStrategy, ignoreStrategy);
            }
        } else {
            groupable = joinFromPropertyMapping.getPropertyMappings().size() > 1;
            if (groupable) {
                condition = group();
            }
            for (PropertyMapping<?> pm : joinFromPropertyMapping.getPropertyMappings()) {
                Serializable ov = pm.getProperty().get(value);
                //                Object ov = bd.getBeanProperty(pm.getPropertyName()).getValue(value);
                if (logic != null) {
                    // ENHANCE 后续配置，使用configure可以进行动态设置使用and还是or连接
                    condition = logic.and();
                }
                logic = ((AbstractMulitiEntitySqlConditionsExpressionBase<E1, C, L, C2, ER, B>) condition)
                    .eqOrNe(comparisonOperator, pm, name, ov, queryAlias, matchStrategy, ignoreStrategy);
            }
        }
        if (groupable && logic != null) {
            logic = logic.endGroup();
        }
        return logic;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected <R> L eqOrNe(ComparisonOperator comparisonOperator, PropertyMapping<?> pm, ParamedColumnElement field,
        R value, String queryAlias, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        AssertIllegalArgument.isNotNull(ignoreStrategy, "ignoreStrategy");
        if (value == null) {
            return eqOrNe0(comparisonOperator, pm, field, value, queryAlias, matchStrategy, ignoreStrategy);
        }
        if (ClassUtils.isParent(pm.getPropertyType(), value.getClass())) {
            switch (pm.getMode()) {
                //                case ONE_TO_ONE: TODO ONE_TO_ONE 支持
                case MANY_TO_ONE:
                    return eqOrNeToOne(comparisonOperator, pm, field, value, queryAlias, matchStrategy, ignoreStrategy);
                case EMBEDDED:
                    return eqOrNeEmbedded(comparisonOperator, (JdbcPropertyMapping) pm, field, value, queryAlias,
                        matchStrategy, ignoreStrategy);
                case ONE_TO_MANY:
                    throw new SqldbHammerException("unsupport ONE_TO_MANY for eq");
                case SINGLE:
                    return eqOrNe0(comparisonOperator, pm, field, value, queryAlias, matchStrategy, ignoreStrategy);
                default:
                    throw new SqldbHammerException("unsupport default Mapping Mode for eq");
            }
        } else {
            for (PropertyMapping<?> spm : pm.getPropertyMappings()) {
                if (ClassUtils.isParent(spm.getPropertyType(), value.getClass())) {
                    return eqOrNe(comparisonOperator, spm, field, value, queryAlias, matchStrategy, ignoreStrategy);
                }
            }
        }
        // YUFEI_TEST 需要分支测试
        return eqOrNe0(comparisonOperator, pm, field, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    private <R> L eqOrNe0(ComparisonOperator comparisonOperator, PropertyMapping<?> pm, ParamedColumnElement field,
        R value, String queryAlias, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        SqlConditionExpressionBuilder.Builder builder = null;
        if (field == null) {
            builder = SqlConditionExpressionBuilder.field(pm.getRepositoryFieldName());
        } else {
            builder = SqlConditionExpressionBuilder.field(field);
        }
        return (L) addCondition(builder.dialect(getDialect()) //
            .comparisonOperator(comparisonOperator) //
            .value(value instanceof Expression ? value : getFieldValueOperator(pm, value)) //
            .tableAlias(queryAlias) //
            .matchStrategy(matchStrategy) //
            .ignoreStrategy(ignoreStrategy) //
            .build());
        //        if (value instanceof Expression) {
        //            return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(), value,
        //                comparisonOperator, matchStrategy, queryAlias, ignoreStrategy));
        //        } else {
        //            return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                getFieldValueOperator(pm, value), comparisonOperator, matchStrategy, queryAlias, ignoreStrategy));
        //        }
    }

    // ********************************************************************
    // protected method
    // ********************************************************************

    /**
     * Gets the index.
     *
     * @return the index
     */
    protected int getIndex() {
        return 0;
    }

    // ********************************************************************
    // property
    // ********************************************************************
}
