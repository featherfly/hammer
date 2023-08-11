
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup5;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic5;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.sql.dml.AbstractEntitySqlQueryConditionGroupExpression5;

/**
 * The Class EntitySqlQueryExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <RS> the query result type
 */
public class EntitySqlQueryExpression5<E, E2, E3, E4, E5, RS> extends
        AbstractEntitySqlQueryConditionGroupExpression5<E, E2, E3, E4, E5, RS,
                EntityQueryConditionGroup5<E, E2, E3, E4, E5, RS>,
                EntityQueryConditionGroupLogic5<E, E2, E3, E4, E5, RS>>
        implements EntityQueryConditionGroup5<E, E2, E3, E4, E5, RS>,
        EntityQueryConditionGroupLogic5<E, E2, E3, E4, E5, RS> {

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param factory        the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation  the query relation
     */
    public EntitySqlQueryExpression5(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
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
    EntitySqlQueryExpression5(EntityQueryConditionGroupLogic5<E, E2, E3, E4, E5, RS> parent, JdbcMappingFactory factory,
            SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityQueryConditionGroup5<E, E2, E3, E4, E5, RS> createGroup(
            EntityQueryConditionGroupLogic5<E, E2, E3, E4, E5, RS> parent) {
        //      IMPLSOON 后续来实现，先让编译通过
        //        if (selectBuilder != null) {
        //            selectBuilder.setTableAlias(queryAlias);
        //        }
        return new EntitySqlQueryExpression5<>(parent, factory, sqlPageFactory, entityRelation);
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
