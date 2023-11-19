/*
 * All rights Reserved, Designed By zhongj
 * @Title: SqlConditionGroupExpressionBuilder.java
 * @Package cn.featherfly.hammer.sqldb.sql.dml
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2022年11月29日 下午5:03:42
 * @version V1.0
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */

package cn.featherfly.hammer.sqldb.sql.dml;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.dml.BuildableConditionGroupExpression;
import cn.featherfly.hammer.dml.BuildableConditionGroupLogicExpression;

/**
 * sql condition group builder. sql条件逻辑组构造器.
 *
 * @author zhongj
 */
public class SqlConditionGroupExpressionBuilder extends
        AbstractSqlConditionGroupExpression<BuildableConditionGroupExpression, BuildableConditionGroupLogicExpression, QueryConditionConfig>
        implements BuildableConditionGroupExpression, BuildableConditionGroupLogicExpression {

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect              dialect
     * @param queryConditionConfig the query condition config
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, QueryConditionConfig queryConditionConfig) {
        this(dialect, null, queryConditionConfig);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect              dialect
     * @param queryAlias           queryAlias
     * @param queryConditionConfig the query condition config
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, String queryAlias,
            QueryConditionConfig queryConditionConfig) {
        this(null, dialect, queryAlias, queryConditionConfig);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param parent               parent group
     * @param dialect              dialect
     * @param queryAlias           queryAlias
     * @param queryConditionConfig the query condition config
     */
    SqlConditionGroupExpressionBuilder(BuildableConditionGroupLogicExpression parent, Dialect dialect,
            String queryAlias, QueryConditionConfig queryConditionConfig) {
        super(parent, dialect, queryAlias, queryConditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BuildableConditionGroupExpression createGroup(BuildableConditionGroupLogicExpression parent,
            String queryAlias) {
        return new SqlConditionGroupExpressionBuilder(parent, dialect, queryAlias,
                (QueryConditionConfig) conditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAlias(int index) {
        // IMPLSOON 未实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <M extends ClassMapping<T, P>, T, P extends PropertyMapping<P>> M getClassMapping(int index) {
        // IMPLSOON 未实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> BuildableConditionGroupLogicExpression eqOrNe(AtomicInteger index, ComparisonOperator comparisonOperator,
            PropertyMapping<?> pm, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        // IMPLSOON 未实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> BuildableConditionGroupLogicExpression eqOrNe(AtomicInteger index, ComparisonOperator comparisonOperator,
            String name, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        // IMPLSOON 未实现
        throw new NotImplementedException();
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    protected <R> BuildableConditionGroupLogicExpression eq_ne(int index, ComparisonOperator comparisonOperator,
    //            List<PropertyMapping<?>> pms, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
    //        // IMPLSOON 未实现
    //        throw new NotImplementedException();
    //    }
}
