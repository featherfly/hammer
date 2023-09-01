
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate1R;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched1F;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * The Class EntitySqlQueryRelation.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 */
public class EntitySqlQueryRelate1R<E, R1> extends AbstractEntitySqlQueryRelate1X<E, R1>
        implements EntityQueryRelate1R<E, R1> {
    //    extends AbstractEntitySqlQueryFetch2<E, R1>

    /**
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     * @param classMapping           the class mapping
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
