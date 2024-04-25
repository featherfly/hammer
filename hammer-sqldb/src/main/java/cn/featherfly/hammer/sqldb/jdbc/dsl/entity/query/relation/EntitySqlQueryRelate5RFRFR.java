
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

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate5RFRFR;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched5RFRFF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch6;

/**
 * The Class EntitySqlQueryRelate5RFRFR.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 * @param <R4> query or joined type
 * @param <R5> query or joined type
 */
public class EntitySqlQueryRelate5RFRFR<E, R1, R2, R3, R4, R5>
        extends AbstractEntitySqlQueryFetch6<E, R1, R2, R3, R4, R5, Tuple3<E, R2, R4>>
        implements EntityQueryRelate5RFRFR<E, R1, R2, R3, R4, R5> {

    /**
     * Instantiates a new entity sql query relate 5 RFRFR.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelate5RFRFR(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched5RFRFF<E, R1, R2, R3, R4, R5> fetch() {
        queryRelation.fetch(5);
        return new EntitySqlQueryRelatedFetched5RFRFF<>(factory, sqlPageFactory, queryRelation);
    }

}
