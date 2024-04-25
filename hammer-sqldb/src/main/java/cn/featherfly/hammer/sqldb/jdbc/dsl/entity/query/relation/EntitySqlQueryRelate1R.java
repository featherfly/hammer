/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelate1R.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2023年9月26日 下午5:51:29
 * @version V1.0
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */

package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate1R;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched1F;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class EntitySqlQueryRelate1R.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> query or joined type
 */
public class EntitySqlQueryRelate1R<E, R1> extends AbstractEntitySqlQueryRelate1X<E, R1>
        implements EntityQueryRelate1R<E, R1> {

    /**
     * Instantiates a new entity sql query relate 1 R.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelate1R(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelatedFetched1F<E, R1> fetch() {
        queryRelation.fetch(1); // 获取第二个查询实体（index = 1）
        return new EntitySqlQueryRelatedFetched1F<>(factory, sqlPageFactory, queryRelation);
    }
}
