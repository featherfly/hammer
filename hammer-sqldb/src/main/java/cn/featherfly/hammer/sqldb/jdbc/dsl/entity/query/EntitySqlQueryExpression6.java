
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup6;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic6;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.sql.dml.AbstractEntitySqlQueryConditionGroupExpression6;

/**
 * The Class EntitySqlQueryExpression4.
 *
 * @author zhongj
 * @param <T1> the element type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <T4> the generic type
 * @param <T5> the generic type
 * @param <T6> the generic type
 * @param <RS> the query result type
 */
public class EntitySqlQueryExpression6<T1, T2, T3, T4, T5, T6, RS> extends
        AbstractEntitySqlQueryConditionGroupExpression6<T1, T2, T3, T4, T5, T6, RS,
                EntityQueryConditionGroup6<T1, T2, T3, T4, T5, T6, RS>,
                EntityQueryConditionGroupLogic6<T1, T2, T3, T4, T5, T6, RS>>
        implements EntityQueryConditionGroup6<T1, T2, T3, T4, T5, T6, RS>,
        EntityQueryConditionGroupLogic6<T1, T2, T3, T4, T5, T6, RS> {

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param factory        the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation  the query relation
     */
    public EntitySqlQueryExpression6(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation queryRelation) {
        this(null, factory, sqlPageFactory, queryRelation);
    }

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation  the query relation
     */
    EntitySqlQueryExpression6(EntityQueryConditionGroupLogic6<T1, T2, T3, T4, T5, T6, RS> parent,
            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityQueryConditionGroup6<T1, T2, T3, T4, T5, T6, RS> createGroup(
            EntityQueryConditionGroupLogic6<T1, T2, T3, T4, T5, T6, RS> parent) {
        return new EntitySqlQueryExpression6<>(parent, factory, sqlPageFactory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        String condition = super.build();
        if (parent == null) {
            String result = entityRelation.buildSelectSql();
            String sort = getRootSortBuilder().build();
            if (Lang.isEmpty(condition)) {
                return result + Chars.SPACE + sort;
            } else {
                return result + Chars.SPACE + dialect.getKeywords().where() + Chars.SPACE + condition + Chars.SPACE
                        + sort;
            }
        } else {
            return condition;
        }
    }
}
