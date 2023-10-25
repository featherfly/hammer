
package cn.featherfly.hammer.sqldb.sql.dml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
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

    protected void join() {

    }

    private <V> L eqOrNeEmbedded(ComparisonOperator comparisonOperator, JdbcPropertyMapping propertyMapping, V value,
            String queryAlias, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        List<JdbcPropertyMapping> propertyMappings = propertyMapping.getPropertyMappings();
        L logic = null;
        C condition = (C) this;
        boolean groupable = propertyMappings.size() > 1;
        if (groupable) {
            condition = group();
        }
        BeanDescriptor<?> bd = BeanDescriptor.getBeanDescriptor(value.getClass());
        for (PropertyMapping<?> pm : propertyMappings) {
            Object ov = bd.getBeanProperty(pm.getPropertyName()).getValue(value);
            if (logic != null) {
                // ENHANCE 后续配置，使用configure可以进行动态设置使用and还是or连接
                condition = logic.and();
            }
            logic = ((AbstractEntitySqlConditionExpressionBase<E, ER, B, C, L, C2>) condition).eq_ne(comparisonOperator,
                    pm, ov, queryAlias, matchStrategy, ignoreStrategy);
        }
        if (groupable) {
            logic = logic.endGroup();
        }
        return logic;
    }

    private <V> L eqOrNeToOne(ComparisonOperator comparisonOperator, PropertyMapping<?> joinFromPropertyMapping,
            V value, String queryAlias, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        JdbcClassMapping<?> joinClassMapping = factory.getClassMapping(joinFromPropertyMapping.getPropertyType());
        Collection<JdbcPropertyMapping> propertyMappings = joinClassMapping.getPropertyMappings();
        L logic = null;
        C condition = (C) this;
        BeanDescriptor<?> bd = BeanDescriptor.getBeanDescriptor(value.getClass());
        List<Tuple2<PropertyMapping<?>, Object>> values = new ArrayList<>();
        boolean groupable = false;
        boolean fetch = false;
        for (PropertyMapping<?> pm : propertyMappings) {
            Object ov = bd.getBeanProperty(pm.getPropertyName()).getValue(value);
            if (Lang.isNotEmpty(ov)) {
                values.add(Tuples.of(pm, ov));
                if (!pm.isPrimaryKey() && !fetch) {
                    fetch = true;
                    entityRelation.join(getIndex(), joinFromPropertyMapping.getPropertyName(), joinClassMapping, true);
                    queryAlias = getAlias(getIndex() + 1);
                }
            }
        }
        if (fetch) {
            groupable = fetch;
            condition = group();
            for (Tuple2<PropertyMapping<?>, Object> tv : values) {
                if (logic != null) {
                    // ENHANCE 后续配置，使用configure可以进行动态设置使用and还是or连接
                    condition = logic.and();
                }
                logic = ((AbstractEntitySqlConditionExpressionBase<E, ER, B, C, L, C2>) condition)
                        .eq_ne(comparisonOperator, tv.get0(), tv.get1(), queryAlias, matchStrategy, ignoreStrategy);
            }
        } else {
            groupable = joinFromPropertyMapping.getPropertyMappings().size() > 1;
            if (groupable) {
                condition = group();
            }
            for (PropertyMapping<?> pm : joinFromPropertyMapping.getPropertyMappings()) {
                Object ov = bd.getBeanProperty(pm.getPropertyName()).getValue(value);
                if (logic != null) {
                    // ENHANCE 后续配置，使用configure可以进行动态设置使用and还是or连接
                    condition = logic.and();
                }
                logic = ((AbstractEntitySqlConditionExpressionBase<E, ER, B, C, L, C2>) condition)
                        .eq_ne(comparisonOperator, pm, ov, queryAlias, matchStrategy, ignoreStrategy);
            }
        }
        if (groupable) {
            logic = logic.endGroup();
        }
        return logic;
    }

    @Override
    protected <R> L eq_ne(ComparisonOperator comparisonOperator, PropertyMapping<?> pm, R value, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        AssertIllegalArgument.isNotNull(ignoreStrategy, "ignoreStrategy");
        if (value == null) {
            return eq_ne0(comparisonOperator, pm, value, queryAlias, matchStrategy, ignoreStrategy);
        }
        if (ClassUtils.isParent(pm.getPropertyType(), value.getClass())) {
            switch (pm.getMode()) {
                //                case ONE_TO_ONE: TODO ONE_TO_ONE 支持
                case MANY_TO_ONE:
                    return eqOrNeToOne(comparisonOperator, pm, value, queryAlias, matchStrategy, ignoreStrategy);
                case EMBEDDED:
                    return eqOrNeEmbedded(comparisonOperator, (JdbcPropertyMapping) pm, value, queryAlias,
                            matchStrategy, ignoreStrategy);
                case ONE_TO_MANY:
                    throw new SqldbHammerException("unsupport ONE_TO_MANY for eq");
                case SINGLE:
                    return eq_ne0(comparisonOperator, pm, value, queryAlias, matchStrategy, ignoreStrategy);
                default:
                    throw new SqldbHammerException("unsupport default Mapping Mode for eq");
            }
        } else {
            for (PropertyMapping<?> spm : pm.getPropertyMappings()) {
                if (ClassUtils.isParent(spm.getPropertyType(), value.getClass())) {
                    return eq_ne(comparisonOperator, spm, value, queryAlias, matchStrategy, ignoreStrategy);
                }
            }
        }
        // YUFEI_TEST 需要分支测试
        return eq_ne0(comparisonOperator, pm, value, queryAlias, matchStrategy, ignoreStrategy);
    }

    private <R> L eq_ne0(ComparisonOperator comparisonOperator, PropertyMapping<?> pm, R value, String queryAlias,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        //        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, pm.getRepositoryFieldName(),
        //                getFieldValueOperator(pm, value), comparisonOperator, matchStrategy, queryAlias, ignoreStrategy));
        return eq_ne0(comparisonOperator, pm.getRepositoryFieldName(), getFieldValueOperator(pm, value), queryAlias,
                matchStrategy, ignoreStrategy);
    }

    private <R> L eq_ne0(ComparisonOperator comparisonOperator, String fieldName,
            FieldValueOperator<R> fieldValueOperator, String queryAlias, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy) {
        return (L) addCondition(new SqlConditionExpressionBuilder(dialect, fieldName, fieldValueOperator,
                comparisonOperator, matchStrategy, queryAlias, ignoreStrategy));
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
