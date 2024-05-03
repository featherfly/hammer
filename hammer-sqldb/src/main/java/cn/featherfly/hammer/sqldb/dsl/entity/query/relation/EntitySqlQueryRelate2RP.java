
package cn.featherfly.hammer.sqldb.dsl.entity.query.relation;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate2RP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched2RP;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class EntitySqlQueryRelate2RP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 */
public class EntitySqlQueryRelate2RP<E, R1, R2> extends AbstractEntitySqlQueryRelate2RX<E, R1, R2>
        implements EntityQueryRelate2RP<E, R1, R2> {

    /**
     * Instantiates a new entity sql query relate 2 RP.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelate2RP(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched2RP<E, R1, R2> fetch() {
        queryRelation.fetchProperty(2); // 获取第三个查询实体（index = 2），并设置为对象属性
        return new EntitySqlQueryRelatedFetched2RP<>(this, factory, sqlPageFactory, queryRelation);
    }
}
