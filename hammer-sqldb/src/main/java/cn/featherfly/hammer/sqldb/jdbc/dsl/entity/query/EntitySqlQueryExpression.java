
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.AbstractMulitiEntitySqlQueryConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * EntitySqlQueryExpression .
 *
 * @author zhongj
 * @param <T> the element type
 */
public class EntitySqlQueryExpression<T> extends
        AbstractMulitiEntitySqlQueryConditionsGroupExpression<T, EntityQueryConditionGroup<T>,
                EntityQueryConditionGroupLogic<T>>
        implements EntityQueryConditionGroup<T>, EntityQueryConditionGroupLogic<T> {

    /**
     * Instantiates a new entity sql query expression.
     *
     * @param factory        the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation  the query relation
     */
    public EntitySqlQueryExpression(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
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
    EntitySqlQueryExpression(EntityQueryConditionGroupLogic<T> parent, JdbcMappingFactory factory,
            SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntitySqlQueryExpression<T> createGroup(EntityQueryConditionGroupLogic<T> parent) {
        return new EntitySqlQueryExpression<>(parent, factory, sqlPageFactory, entityRelation);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public long count() {
    //        queryRelation.getSelectBuilder().addColumn(AggregateFunction.COUNT, Chars.STAR);
    //        return queryRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParams().toArray());
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        //        String result = entityRelation.buildSelectSql();
        //        String condition = super.build();
        //        if (Lang.isNotEmpty(condition)) {
        //            result = result + Chars.SPACE + dialect.getKeywords().where() + Chars.SPACE + condition;
        //        }
        //        return result;

        //        String result = entityRelation.buildSelectSql();
        //        String condition = super.build();
        //        if (parent == null) {
        //            if (Lang.isEmpty(condition)) {
        //                return result;
        //            } else {
        //                return result + Chars.SPACE + dialect.getKeywords().where() + Chars.SPACE + condition;
        //            }
        //        } else {
        //            return condition;
        //        }

        String condition = super.expression();
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
