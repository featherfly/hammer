
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.dsl.query.type.EntityQueryValueConditionGroup;
import cn.featherfly.hammer.dsl.query.type.EntityQueryValueConditionGroupLogic;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.sql.dml.AbstractEntitySqlQueryValueConditionGroupExpression;

/**
 * EntitySqlQueryExpression .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class EntitySqlQueryValueExpression<E> extends
        AbstractEntitySqlQueryValueConditionGroupExpression<E, EntityQueryValueConditionGroup<E>,
                EntityQueryValueConditionGroupLogic<E>>
        implements EntityQueryValueConditionGroup<E>, EntityQueryValueConditionGroupLogic<E>,
        EntityQuerySortExpression<E>, EntityQuerySortedExpression<E> {

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param factory        the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation  the query relation
     */
    public EntitySqlQueryValueExpression(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
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
    EntitySqlQueryValueExpression(EntityQueryValueConditionGroupLogic<E> parent, JdbcMappingFactory factory,
            SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntitySqlQueryValueExpression<E> createGroup(EntityQueryValueConditionGroupLogic<E> parent) {
        //      IMPLSOON 后续来实现，先让编译通过
        //        if (selectBuilder != null) {
        //            selectBuilder.setTableAlias(queryAlias);
        //        }
        return new EntitySqlQueryValueExpression<>(parent, factory, sqlPageFactory, entityRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        //        String result = entityRelation.buildSelectSql();
        //        String condition = super.build();
        //        if (Lang.isNotEmpty(condition)) {
        //            result = result + Chars.SPACE + dialect.getKeywords().where() + Chars.SPACE + condition;
        //        }
        //        return result;
        String result = entityRelation.buildSelectSql();
        String condition = super.build();
        if (parent == null) {
            if (Lang.isEmpty(condition)) {
                return result;
            } else {
                return result + Chars.SPACE + dialect.getKeywords().where() + Chars.SPACE + condition;
            }
        } else {
            return condition;
        }
    }
}
