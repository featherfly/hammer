
package cn.featherfly.hammer.sqldb.dsl.entity.query.relation;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate1P;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched1P;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class EntitySqlQueryRelation1P.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <R1> query or joined type
 */
public class EntitySqlQueryRelate1P<E, R1> extends AbstractEntitySqlQueryRelate1X<E, R1>
    implements EntityQueryRelate1P<E, R1> {

    /**
     * Instantiates a new entity sql query relate 1 P.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelate1P(HammerConfig hammerConfig, JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
        EntitySqlQueryRelation entitySqlQueryRelation) {
        super(hammerConfig, factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched1P<E, R1> fetch() {
        queryRelation.fetchProperty(1); // 获取第二个查询实体（index = 1），并设置为对象属性
        return new EntitySqlQueryRelatedFetched1P<>(this, hammerConfig, factory, sqlPageFactory, queryRelation);
    }
}
