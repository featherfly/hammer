
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
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate4FFRR;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched4FFRF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class EntitySqlQueryRelate4FFR.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R4> the generic type
 */
public class EntitySqlQueryRelate4FFRR<E, R1, R2, R3, R4>
        extends AbstractEntitySqlQueryRelate4FFRX<E, R1, R2, R3, R4, Tuple3<E, R1, R2>>
        implements EntityQueryRelate4FFRR<E, R1, R2, R3, R4> {

    /**
     * Instantiates a new entity sql query relate 4 FFF.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelate4FFRR(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched4FFRF<E, R1, R2, R3, R4> fetch() {
        queryRelation.fetch(4);
        return new EntitySqlQueryRelatedFetched4FFRF<>(factory, sqlPageFactory, queryRelation);
    }
}
