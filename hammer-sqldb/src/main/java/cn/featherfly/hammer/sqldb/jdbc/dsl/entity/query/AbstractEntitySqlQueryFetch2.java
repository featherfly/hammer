
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.dsl.QueryEntityRepository;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup2;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic2;
import cn.featherfly.hammer.expression.api.Sortable;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation.EntityRelationMapping;

/**
 * The Class AbstractEntitySqlQueryFetch2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <RS> the generic type
 */
public abstract class AbstractEntitySqlQueryFetch2<E, E2, RS> extends AbstractEntitySqlQuery<RS>
        implements EntityWhereExpression2<E, E2, EntityQueryConditionGroup2<E, E2, RS>,
                EntityQueryConditionGroupLogic2<E, E2, RS>>,
        Sortable<EntityQuerySortExpression2<E, E2, RS>> {

    /**
     * Instantiates a new abstract entity sql query fetched.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryFetch2(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup2<E, E2, RS> where() {
        return new EntitySqlQueryExpression2<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroup2<E, E2, RS> where(Consumer<EntityQueryConditionGroup2<E, E2, RS>> consumer) {
        EntitySqlQueryExpression2<E, E2,
                RS> exp = new EntitySqlQueryExpression2<>(factory, sqlPageFactory, queryRelation);
        if (consumer != null) {
            consumer.accept(exp);
        }
        return exp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression2<E, E2, RS> sort() {
        return new EntitySqlQueryExpression2<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	protected method
    // ****************************************************************************************************************

    protected <RES> void prepareJoin(int index,
            BiFunction<QueryEntityRepository<E>, QueryEntityRepository<E2>, ?> entities) {
        @SuppressWarnings("unchecked")
        EntityRelationMapping<E> erm = (EntityRelationMapping<E>) queryRelation.getEntityRelationMapping(0);
        @SuppressWarnings("unchecked")
        EntityRelationMapping<E2> erm2 = (EntityRelationMapping<E2>) queryRelation.getEntityRelationMapping(1);

        QueryEntityRepository<?> qer = (QueryEntityRepository<?>) entities.apply(
                new QueryEntityRepository<>(0, erm.getClassMapping().getType()),
                new QueryEntityRepository<>(1, erm2.getClassMapping().getType()));

        if (qer.getType() != queryRelation.getEntityRelationMapping(index).getClassMapping().getType()) {
            throw new SqldbHammerException("编译出错");
        }
    }

    protected <RES> void prepareJoin(int index,
            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, ?> entities) {
        @SuppressWarnings("unchecked")
        EntityRelationMapping<E> erm = (EntityRelationMapping<E>) queryRelation.getEntityRelationMapping(0);
        @SuppressWarnings("unchecked")
        EntityRelationMapping<E2> erm2 = (EntityRelationMapping<E2>) queryRelation.getEntityRelationMapping(1);

        QueryEntityRepository<?> qer = (QueryEntityRepository<?>) entities
                .apply(Tuples.of(new QueryEntityRepository<>(0, erm.getClassMapping().getType()),
                        new QueryEntityRepository<>(1, erm2.getClassMapping().getType())));

        if (qer.getType() != queryRelation.getEntityRelationMapping(index).getClassMapping().getType()) {
            throw new SqldbHammerException("编译出错");
        }
    }
}
