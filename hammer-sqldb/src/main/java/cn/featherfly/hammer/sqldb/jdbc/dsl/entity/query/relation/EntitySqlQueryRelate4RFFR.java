
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelate3FF.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query
 * @Description: EntitySqlQueryRelate3FF
 * @author: zhongj
 * @date: 2023-07-14 16:01:14
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate4RFFR;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched4RFFF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class EntitySqlQueryRelate4RFFR.
 *
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 * @param <R4> query or joined type
 */
public class EntitySqlQueryRelate4RFFR<E, R1, R2, R3, R4> extends AbstractEntitySqlQueryRelate4RFFX<E, R1, R2, R3, R4>
        implements EntityQueryRelate4RFFR<E, R1, R2, R3, R4> {

    /**
     * Instantiates a new entity sql query relate 4 RFFR.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelate4RFFR(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched4RFFF<E, R1, R2, R3, R4> fetch() {
        queryRelation.fetch(4);
        return new EntitySqlQueryRelatedFetched4RFFF<>(factory, sqlPageFactory, queryRelation);
    }

}
