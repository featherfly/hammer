
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelate3FF.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query
 * @Description: EntitySqlQueryRelate3FF
 * @author: zhongj
 * @date: 2023-07-14 16:01:14
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.query.relation;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate4FRFP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched4FRFP;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class EntitySqlQueryRelate4FRFP.
 *
 * @param <E> query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 * @param <R4> query or joined type
 */
public class EntitySqlQueryRelate4FRFP<E, R1, R2, R3, R4> extends AbstractEntitySqlQueryRelate4FRFX<E, R1, R2, R3, R4>
    implements EntityQueryRelate4FRFP<E, R1, R2, R3, R4> {

    /**
     * Instantiates a new entity sql query relate 4 FRFP.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelate4FRFP(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(hammerConfig, factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched4FRFP<E, R1, R2, R3, R4> fetch() {
        queryRelation.fetchProperty(4);
        return new EntitySqlQueryRelatedFetched4FRFP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }
}
