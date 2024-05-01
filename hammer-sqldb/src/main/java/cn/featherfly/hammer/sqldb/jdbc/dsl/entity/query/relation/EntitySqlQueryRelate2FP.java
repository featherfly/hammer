
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate2FP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched2FP;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class EntitySqlQueryRelate2FP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 */
public class EntitySqlQueryRelate2FP<E, R1, R2> extends AbstractEntitySqlQueryRelate2FX<E, R1, R2>
        implements EntityQueryRelate2FP<E, R1, R2> {

    /**
     * Instantiates a new entity sql query relate 2 FP.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelate2FP(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched2FP<E, R1, R2> fetch() {
        queryRelation.fetchProperty(2); // 获取第三个查询实体（index = 2），并设置为对象属性
        return new EntitySqlQueryRelatedFetched2FP<>(this, factory, sqlPageFactory, queryRelation);
    }

}
