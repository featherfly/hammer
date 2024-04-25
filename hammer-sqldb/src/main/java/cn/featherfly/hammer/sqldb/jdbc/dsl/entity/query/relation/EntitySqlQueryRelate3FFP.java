
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
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate3FFP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched3FFP;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class EntitySqlQueryRelate3FFP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 */
public class EntitySqlQueryRelate3FFP<E, R1, R2, R3> extends AbstractEntitySqlQueryRelate3FFX<E, R1, R2, R3>
        implements EntityQueryRelate3FFP<E, R1, R2, R3> {

    /**
     * Instantiates a new entity sql query relate 3 FFP.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelate3FFP(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched3FFP<E, R1, R2, R3> fetch() {
        queryRelation.fetchProperty(3);
        return new EntitySqlQueryRelatedFetched3FFP<>(this, factory, sqlPageFactory, queryRelation);
    }
}
