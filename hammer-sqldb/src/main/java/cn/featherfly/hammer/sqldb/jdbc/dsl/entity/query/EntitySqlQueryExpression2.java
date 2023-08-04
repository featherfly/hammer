
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroup2;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupLogic2;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.sql.dml.AbstractEntitySqlQueryConditionGroupExpression2;

/**
 * The Class EntitySqlQueryExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <RS> the query result type
 */
public class EntitySqlQueryExpression2<E, E2, RS> extends
        AbstractEntitySqlQueryConditionGroupExpression2<E, E2, RS, EntityQueryConditionGroup2<E, E2, RS>,
                EntityQueryConditionGroupLogic2<E, E2, RS>>
        implements EntityQueryConditionGroup2<E, E2, RS>, EntityQueryConditionGroupLogic2<E, E2, RS> {

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param factory        the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation  the query relation
     */
    public EntitySqlQueryExpression2(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
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
    EntitySqlQueryExpression2(EntityQueryConditionGroupLogic2<E, E2, RS> parent, JdbcMappingFactory factory,
            SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityQueryConditionGroup2<E, E2, RS> createGroup(EntityQueryConditionGroupLogic2<E, E2, RS> parent) {
        //      IMPLSOON 后续来实现，先让编译通过
        //        if (selectBuilder != null) {
        //            selectBuilder.setTableAlias(queryAlias);
        //        }
        return new EntitySqlQueryExpression2<>(parent, factory, sqlPageFactory, entityRelation);
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
