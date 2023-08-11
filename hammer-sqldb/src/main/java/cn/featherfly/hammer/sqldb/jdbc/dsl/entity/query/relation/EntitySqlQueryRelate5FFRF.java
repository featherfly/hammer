
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

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate5FFRF;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched5FFRFF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch6;

/**
 * The Class EntitySqlQueryRelate5FFRF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R4> the generic type
 * @param <R5> the generic type
 */
public class EntitySqlQueryRelate5FFRF<E, R1, R2, R3, R4, R5>
        extends AbstractEntitySqlQueryFetch6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R2, R4>>
        implements EntityQueryRelate5FFRF<E, R1, R2, R3, R4, R5> {

    /**
     * Instantiates a new entity sql query relate 4 FFF.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelate5FFRF(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched5FFRFF<E, R1, R2, R3, R4, R5> fetch() {
        queryRelation.fetch(5);
        return new EntitySqlQueryRelatedFetched5FFRFF<>(factory, sqlPageFactory, queryRelation);
    }

}
