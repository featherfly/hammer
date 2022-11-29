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

import java.util.function.Predicate;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.hammer.dml.BuildableConditionGroupExpression;
import cn.featherfly.hammer.dml.BuildableConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 * .
 *
 * @author zhongj
 */
public class SqlConditionGroupExpressionBuilder extends
        AbstractSqlConditionGroupExpression<BuildableConditionGroupExpression, BuildableConditionGroupLogicExpression>
        implements BuildableConditionGroupExpression, BuildableConditionGroupLogicExpression {

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect        dialect
     * @param sqlPageFactory the sql page factory
     * @param ignorePolicy   the ignore policy
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, SqlPageFactory sqlPageFactory,
            Predicate<Object> ignorePolicy) {
        this(dialect, sqlPageFactory, null, ignorePolicy);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect         dialect
     * @param sqlPageFactory  the sql page factory
     * @param typeQueryEntity the type query entity
     * @param ignorePolicy    the ignore policy
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, SqlPageFactory sqlPageFactory,
            TypeQueryEntity typeQueryEntity, Predicate<Object> ignorePolicy) {
        this(dialect, sqlPageFactory, null, typeQueryEntity, ignorePolicy);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect         dialect
     * @param sqlPageFactory  the sql page factory
     * @param queryAlias      queryAlias
     * @param typeQueryEntity the type query entity
     * @param ignorePolicy    the ignore policy
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, SqlPageFactory sqlPageFactory, String queryAlias,
            TypeQueryEntity typeQueryEntity, Predicate<Object> ignorePolicy) {
        this(null, dialect, sqlPageFactory, queryAlias, typeQueryEntity, ignorePolicy);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param parent          parent group
     * @param dialect         dialect
     * @param sqlPageFactory  the sql page factory
     * @param queryAlias      queryAlias
     * @param typeQueryEntity the type query entity
     * @param ignorePolicy    the ignore policy
     */
    SqlConditionGroupExpressionBuilder(BuildableConditionGroupLogicExpression parent, Dialect dialect,
            SqlPageFactory sqlPageFactory, String queryAlias, TypeQueryEntity typeQueryEntity,
            Predicate<Object> ignorePolicy) {
        super(parent, dialect, sqlPageFactory, queryAlias, typeQueryEntity, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BuildableConditionGroupExpression createGroup(BuildableConditionGroupLogicExpression parent,
            String queryAlias, TypeQueryEntity typeQueryEntity) {
        return new SqlConditionGroupExpressionBuilder(parent, dialect, sqlPageFactory, queryAlias, typeQueryEntity,
                ignorePolicy);
    }
}
