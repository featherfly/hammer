
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryValueConditionGroup;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryValueConditionGroupLogic;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueSortExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueSortedExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.sql.dml.AbstractEntitySqlQueryValueConditionGroupExpression;

/**
 * EntitySqlQueryValueExpression .
 *
 * @author zhongj
 * @param <E> the element type
 */
public class EntitySqlQueryValueExpression<E, V> extends
        AbstractEntitySqlQueryValueConditionGroupExpression<E, V, EntityQueryValueConditionGroup<E, V>,
                EntityQueryValueConditionGroupLogic<E, V>>
        implements EntityQueryValueConditionGroup<E, V>, EntityQueryValueConditionGroupLogic<E, V>,
        EntityQueryValueSortExpression<E, V>, EntityQueryValueSortedExpression<E, V> {

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param factory        the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation  the query relation
     */
    public EntitySqlQueryValueExpression(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation queryRelation, Class<V> valueType) {
        this(null, factory, sqlPageFactory, queryRelation, valueType);
    }

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation  the query relation
     */
    EntitySqlQueryValueExpression(EntityQueryValueConditionGroupLogic<E, V> parent, JdbcMappingFactory factory,
            SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation, Class<V> valueType) {
        super(parent, factory, sqlPageFactory, queryRelation, valueType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntitySqlQueryValueExpression<E, V> createGroup(EntityQueryValueConditionGroupLogic<E, V> parent) {
        return new EntitySqlQueryValueExpression<>(parent, factory, sqlPageFactory, entityRelation, valueType);
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
