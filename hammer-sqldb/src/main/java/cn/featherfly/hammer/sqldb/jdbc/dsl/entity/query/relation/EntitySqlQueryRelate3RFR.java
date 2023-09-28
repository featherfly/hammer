
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
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate3RFR;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched3RFF;
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
public class EntitySqlQueryRelate3RFR<E, R1, R2, R3> extends AbstractEntitySqlQueryRelate3RFX<E, R1, R2, R3>
        implements EntityQueryRelate3RFR<E, R1, R2, R3> {

    /**
     * @param factory
     * @param sqlPageFactory
     * @param entitySqlQueryRelation
     */
    public EntitySqlQueryRelate3RFR(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched3RFF<E, R1, R2, R3> fetch() {
        queryRelation.fetch(3);
        return new EntitySqlQueryRelatedFetched3RFF<>(factory, sqlPageFactory, queryRelation);
    }
}
