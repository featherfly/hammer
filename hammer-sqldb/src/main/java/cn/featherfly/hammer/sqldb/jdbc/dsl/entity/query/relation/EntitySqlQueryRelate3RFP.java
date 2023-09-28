
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
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate3RFP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched3RFP;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class EntitySqlQueryRelate3RF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 */
public class EntitySqlQueryRelate3RFP<E, R1, R2, R3> extends AbstractEntitySqlQueryRelate3RFX<E, R1, R2, R3>
        implements EntityQueryRelate3RFP<E, R1, R2, R3> {

    /**
     * @param factory
     * @param sqlPageFactory
     * @param entitySqlQueryRelation
     */
    public EntitySqlQueryRelate3RFP(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched3RFP<E, R1, R2, R3> fetch() {
        queryRelation.fetchProperty(3);
        return new EntitySqlQueryRelatedFetched3RFP<>(this, factory, sqlPageFactory, queryRelation);
    }
}
