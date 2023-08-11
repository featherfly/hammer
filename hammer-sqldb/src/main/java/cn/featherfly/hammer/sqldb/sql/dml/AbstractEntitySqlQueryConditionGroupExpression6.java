
package cn.featherfly.hammer.sqldb.sql.dml;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple6;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.common.function.SixArgusFunction;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.common.lang.function.SerializableFunction4;
import cn.featherfly.common.lang.function.SerializableFunction5;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.QueryEntityRepository;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression6;
import cn.featherfly.hammer.expression.entity.condition.co.ContainsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.co.ContainsEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression6;
import cn.featherfly.hammer.expression.entity.condition.co.MulitiEntityContainsExpression;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpression6;
import cn.featherfly.hammer.expression.entity.condition.eq.EqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.eq.EqualsEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.eq.MulitiEntityEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EndWithEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpression6;
import cn.featherfly.hammer.expression.entity.condition.ew.MulitiEntityEndWithExpression;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpression6;
import cn.featherfly.hammer.expression.entity.condition.ge.GreatEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ge.GreatEqualsEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.ge.MulitiEntityGreatEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpression6;
import cn.featherfly.hammer.expression.entity.condition.gt.GreatThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.GreatThanEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.gt.MulitiEntityGreatThanExpression;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpression6;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.in.MulitiEntityInExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpression6;
import cn.featherfly.hammer.expression.entity.condition.inn.IsNotNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.IsNotNullEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.inn.MulitiEntityIsNotNullExpression;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpression6;
import cn.featherfly.hammer.expression.entity.condition.isn.IsNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.isn.IsNullEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.isn.MulitiEntityIsNullExpression;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpression6;
import cn.featherfly.hammer.expression.entity.condition.le.LessEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.le.LessEqualsEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.le.MulitiEntityLessEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpression6;
import cn.featherfly.hammer.expression.entity.condition.lk.LikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.LikeEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.lk.MulitiEntityLikeExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpression6;
import cn.featherfly.hammer.expression.entity.condition.lt.LessThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.LessThanEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.lt.MulitiEntityLessThanExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression6;
import cn.featherfly.hammer.expression.entity.condition.ne.MulitiEntityNotEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.NotEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.NotEqualsEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.nin.EntityNotInExpression6;
import cn.featherfly.hammer.expression.entity.condition.nin.MulitiEntityNotInExpression;
import cn.featherfly.hammer.expression.entity.condition.nin.NotInEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nin.NotInEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyFunction;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression6;
import cn.featherfly.hammer.expression.entity.condition.sw.MulitiEntityStartWithExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.StartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.StartWithEntityExpressionImpl;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression6;
import cn.featherfly.hammer.expression.entity.query.sort.SortEntityExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityContainsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityEndWithExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityGreatEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityGreatThanExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityInExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityIsNotNullExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityIsNullExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityLessEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityLessThanExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityLikeExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityNotEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityNotInExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityStartWithExpressionImpl;

/**
 * sql condition group expression4. 条件逻辑组构造器4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <RS> the query result type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractEntitySqlQueryConditionGroupExpression6<E, E2, E3, E4, E5, E6, RS,
        C extends EntityQueryConditionGroupExpression6<E, E2, E3, E4, E5, E6, C, L,
                EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, RS>, RS>,
        L extends EntityQueryConditionGroupLogicExpression6<E, E2, E3, E4, E5, E6, C, L,
                EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, RS>, RS>>
        extends
        AbstractEntitySqlConditionGroupExpressionBase6<E, E2, E3, E4, E5, E6, EntitySqlQueryRelation,
                SqlSelectBasicBuilder, C, L>
        implements
        EntityQueryConditionGroupExpression6<E, E2, E3, E4, E5, E6, C, L,
                EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, RS>, RS>,
        EntityQueryConditionGroupLogicExpression6<E, E2, E3, E4, E5, E6, C, L,
                EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, RS>, RS>,
        SqlBuilder, ParamedExpression, EntityContainsExpression6<E, E2, E3, E4, E5, E6, C, L>,
        EntityEndWithExpression6<E, E2, E3, E4, E5, E6, C, L>, EntityEqualsExpression6<E, E2, E3, E4, E5, E6, C, L>,
        EntityGreatEqualsExpression6<E, E2, E3, E4, E5, E6, C, L>,
        EntityGreatThanExpression6<E, E2, E3, E4, E5, E6, C, L>, EntityInExpression6<E, E2, E3, E4, E5, E6, C, L>,
        EntityIsNotNullExpression6<E, E2, E3, E4, E5, E6, C, L>, EntityIsNullExpression6<E, E2, E3, E4, E5, E6, C, L>,
        EntityLessEqualsExpression6<E, E2, E3, E4, E5, E6, C, L>,
        EntityLessThanExpression6<E, E2, E3, E4, E5, E6, C, L>, EntityNotEqualsExpression6<E, E2, E3, E4, E5, E6, C, L>,
        EntityNotInExpression6<E, E2, E3, E4, E5, E6, C, L>, EntityStartWithExpression6<E, E2, E3, E4, E5, E6, C, L>,
        EntityLikeExpression6<E, E2, E3, E4, E5, E6, C, L>, EntityPropertyExpression6<E, E2, E3, E4, E5, E6, C, L>,
        EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, RS>, EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> {

    private SqlSortBuilder sortBuilder;

    private EntitySqlQueryConditionGroupQuery<RS> entitySqlQueryConditionGroupQuery;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /**
     * Instantiates a new abstract entity sql condition group expression 2.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation  the relation
     */
    protected AbstractEntitySqlQueryConditionGroupExpression6(L parent, JdbcMappingFactory factory,
            SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, queryRelation);
        sortBuilder = new SqlSortBuilder(dialect, queryRelation.getEntityRelationMapping(0).getTableAlias());
        this.sqlPageFactory = sqlPageFactory;
        entitySqlQueryConditionGroupQuery = new EntitySqlQueryConditionGroupQuery<>(this, sqlPageFactory,
                entityRelation);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        StringBuilder result = new StringBuilder(super.build());
        String sort = sortBuilder.build();
        if (result.length() > 0) {
            if (Lang.isNotEmpty(sort)) {
                return result.append(Chars.SPACE).append(sort).toString();
            } else {
                return result.toString();
            }
        } else {
            return sort;
        }
    }

    /**
     * Limit.
     *
     * @param limit the limit
     * @return the type query limit executor
     */
    @Override
    public EntityQueryLimitExecutor<RS> limit(Limit limit) {
        entitySqlQueryConditionGroupQuery.setLimit(limit);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RS> list() {
        return entitySqlQueryConditionGroupQuery.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<RS> pagination() {
        return entitySqlQueryConditionGroupQuery.pagination();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RS single() {
        return entitySqlQueryConditionGroupQuery.single();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RS unique() {
        return entitySqlQueryConditionGroupQuery.unique();
    }

    @Override
    public long count() {
        entityRelation.getBuilder().addColumn(AggregateFunction.COUNT, Chars.STAR);
        return entityRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParams().toArray());
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lk(Consumer<Tuple6<LikeEntityExpression<E>, LikeEntityExpression<E2>, LikeEntityExpression<E3>,
            LikeEntityExpression<E4>, LikeEntityExpression<E5>, LikeEntityExpression<E6>>> likeEntityExpressions) {
        MulitiEntityLikeExpression<C, L> mulitiExpression = new MulitiEntityLikeExpressionImpl<>(this);
        likeEntityExpressions.accept(Tuples.of(new LikeEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new LikeEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new LikeEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new LikeEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new LikeEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new LikeEntityExpressionImpl<E6, C, L>(5, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lk(SixArgusConsumer<LikeEntityExpression<E>, LikeEntityExpression<E2>, LikeEntityExpression<E3>,
            LikeEntityExpression<E4>, LikeEntityExpression<E5>, LikeEntityExpression<E6>> likeEntityExpressions) {
        MulitiEntityLikeExpression<C, L> mulitiExpression = new MulitiEntityLikeExpressionImpl<>(this);
        likeEntityExpressions.accept(new LikeEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new LikeEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new LikeEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new LikeEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new LikeEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new LikeEntityExpressionImpl<E6, C, L>(5, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L sw(Consumer<Tuple6<StartWithEntityExpression<E>, StartWithEntityExpression<E2>,
            StartWithEntityExpression<E3>, StartWithEntityExpression<E4>, StartWithEntityExpression<E5>,
            StartWithEntityExpression<E6>>> startWithEntityExpressions) {
        MulitiEntityStartWithExpression<C, L> expression = new MulitiEntityStartWithExpressionImpl<>(this);
        startWithEntityExpressions.accept(Tuples.of(new StartWithEntityExpressionImpl<E, C, L>(0, expression),
                new StartWithEntityExpressionImpl<E2, C, L>(1, expression),
                new StartWithEntityExpressionImpl<E3, C, L>(2, expression),
                new StartWithEntityExpressionImpl<E4, C, L>(3, expression),
                new StartWithEntityExpressionImpl<E5, C, L>(4, expression),
                new StartWithEntityExpressionImpl<E6, C, L>(5, expression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L sw(SixArgusConsumer<StartWithEntityExpression<E>, StartWithEntityExpression<E2>,
            StartWithEntityExpression<E3>, StartWithEntityExpression<E4>, StartWithEntityExpression<E5>,
            StartWithEntityExpression<E6>> startWithEntityExpressions) {
        MulitiEntityStartWithExpression<C, L> expression = new MulitiEntityStartWithExpressionImpl<>(this);
        startWithEntityExpressions.accept(new StartWithEntityExpressionImpl<E, C, L>(0, expression),
                new StartWithEntityExpressionImpl<E2, C, L>(1, expression),
                new StartWithEntityExpressionImpl<E3, C, L>(2, expression),
                new StartWithEntityExpressionImpl<E4, C, L>(3, expression),
                new StartWithEntityExpressionImpl<E5, C, L>(4, expression),
                new StartWithEntityExpressionImpl<E6, C, L>(5, expression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nin(Consumer<Tuple6<NotInEntityExpression<E>, NotInEntityExpression<E2>, NotInEntityExpression<E3>,
            NotInEntityExpression<E4>, NotInEntityExpression<E5>, NotInEntityExpression<E6>>> notInEntityExpressions) {
        MulitiEntityNotInExpression<C, L> mulitiExpression = new MulitiEntityNotInExpressionImpl<>(this);
        notInEntityExpressions.accept(Tuples.of(new NotInEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new NotInEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new NotInEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new NotInEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new NotInEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new NotInEntityExpressionImpl<E6, C, L>(5, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nin(SixArgusConsumer<NotInEntityExpression<E>, NotInEntityExpression<E2>, NotInEntityExpression<E3>,
            NotInEntityExpression<E4>, NotInEntityExpression<E5>, NotInEntityExpression<E6>> notInEntityExpressions) {
        MulitiEntityNotInExpression<C, L> mulitiExpression = new MulitiEntityNotInExpressionImpl<>(this);
        notInEntityExpressions.accept(new NotInEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new NotInEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new NotInEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new NotInEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new NotInEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new NotInEntityExpressionImpl<E6, C, L>(5, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ne(Consumer<Tuple6<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>,
            NotEqualsEntityExpression<E3>, NotEqualsEntityExpression<E4>, NotEqualsEntityExpression<E5>,
            NotEqualsEntityExpression<E6>>> notEqualsEntityExpressions) {
        MulitiEntityNotEqualsExpression<C, L> mulitiExpression = new MulitiEntityNotEqualsExpressionImpl<>(this);
        notEqualsEntityExpressions.accept(Tuples.of(new NotEqualsEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new NotEqualsEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new NotEqualsEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new NotEqualsEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new NotEqualsEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new NotEqualsEntityExpressionImpl<E6, C, L>(5, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ne(SixArgusConsumer<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>,
            NotEqualsEntityExpression<E3>, NotEqualsEntityExpression<E4>, NotEqualsEntityExpression<E5>,
            NotEqualsEntityExpression<E6>> notEqualsEntityExpressions) {
        MulitiEntityNotEqualsExpression<C, L> mulitiExpression = new MulitiEntityNotEqualsExpressionImpl<>(this);
        notEqualsEntityExpressions.accept(new NotEqualsEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new NotEqualsEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new NotEqualsEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new NotEqualsEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new NotEqualsEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new NotEqualsEntityExpressionImpl<E6, C, L>(5, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lt(Consumer<Tuple6<LessThanEntityExpression<E>, LessThanEntityExpression<E2>, LessThanEntityExpression<E3>,
            LessThanEntityExpression<E4>, LessThanEntityExpression<E5>,
            LessThanEntityExpression<E6>>> lessThanEntityExpressions) {
        MulitiEntityLessThanExpression<C, L> mulitiExpression = new MulitiEntityLessThanExpressionImpl<>(this);
        lessThanEntityExpressions.accept(Tuples.of(new LessThanEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new LessThanEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new LessThanEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new LessThanEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new LessThanEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new LessThanEntityExpressionImpl<E6, C, L>(5, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lt(SixArgusConsumer<LessThanEntityExpression<E>, LessThanEntityExpression<E2>,
            LessThanEntityExpression<E3>, LessThanEntityExpression<E4>, LessThanEntityExpression<E5>,
            LessThanEntityExpression<E6>> lessThanEntityExpressions) {
        MulitiEntityLessThanExpression<C, L> mulitiExpression = new MulitiEntityLessThanExpressionImpl<>(this);
        lessThanEntityExpressions.accept(new LessThanEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new LessThanEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new LessThanEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new LessThanEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new LessThanEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new LessThanEntityExpressionImpl<E6, C, L>(5, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L le(Consumer<Tuple6<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>,
            LessEqualsEntityExpression<E3>, LessEqualsEntityExpression<E4>, LessEqualsEntityExpression<E5>,
            LessEqualsEntityExpression<E6>>> lessEqualsEntityExpressions) {
        MulitiEntityLessEqualsExpression<C, L> mulitiExpression = new MulitiEntityLessEqualsExpressionImpl<>(this);
        lessEqualsEntityExpressions.accept(Tuples.of(new LessEqualsEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new LessEqualsEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new LessEqualsEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new LessEqualsEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new LessEqualsEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new LessEqualsEntityExpressionImpl<E6, C, L>(5, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L le(SixArgusConsumer<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>,
            LessEqualsEntityExpression<E3>, LessEqualsEntityExpression<E4>, LessEqualsEntityExpression<E5>,
            LessEqualsEntityExpression<E6>> lessEqualsEntityExpressions) {
        MulitiEntityLessEqualsExpression<C, L> mulitiExpression = new MulitiEntityLessEqualsExpressionImpl<>(this);
        lessEqualsEntityExpressions.accept(new LessEqualsEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new LessEqualsEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new LessEqualsEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new LessEqualsEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new LessEqualsEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new LessEqualsEntityExpressionImpl<E6, C, L>(5, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L isn(Consumer<Tuple6<IsNullEntityExpression<E>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>,
            IsNullEntityExpression<E4>, IsNullEntityExpression<E5>,
            IsNullEntityExpression<E6>>> isNullEntityExpressions) {
        MulitiEntityIsNullExpression<C, L> mulitiExpression = new MulitiEntityIsNullExpressionImpl<>(this);
        isNullEntityExpressions.accept(Tuples.of(new IsNullEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new IsNullEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new IsNullEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new IsNullEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new IsNullEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new IsNullEntityExpressionImpl<E6, C, L>(5, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L isn(SixArgusConsumer<IsNullEntityExpression<E>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>,
            IsNullEntityExpression<E4>, IsNullEntityExpression<E5>,
            IsNullEntityExpression<E6>> isNullEntityExpressions) {
        MulitiEntityIsNullExpression<C, L> mulitiExpression = new MulitiEntityIsNullExpressionImpl<>(this);
        isNullEntityExpressions.accept(new IsNullEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new IsNullEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new IsNullEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new IsNullEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new IsNullEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new IsNullEntityExpressionImpl<E6, C, L>(5, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L inn(Consumer<Tuple6<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>,
            IsNotNullEntityExpression<E3>, IsNotNullEntityExpression<E4>, IsNotNullEntityExpression<E5>,
            IsNotNullEntityExpression<E6>>> isNotNullEntityExpressions) {
        MulitiEntityIsNotNullExpression<C, L> mulitiExpression = new MulitiEntityIsNotNullExpressionImpl<>(this);
        isNotNullEntityExpressions.accept(Tuples.of(new IsNotNullEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new IsNotNullEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new IsNotNullEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new IsNotNullEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new IsNotNullEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new IsNotNullEntityExpressionImpl<E6, C, L>(5, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L inn(SixArgusConsumer<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>,
            IsNotNullEntityExpression<E3>, IsNotNullEntityExpression<E4>, IsNotNullEntityExpression<E5>,
            IsNotNullEntityExpression<E6>> isNotNullEntityExpressions) {
        MulitiEntityIsNotNullExpression<C, L> mulitiExpression = new MulitiEntityIsNotNullExpressionImpl<>(this);
        isNotNullEntityExpressions.accept(new IsNotNullEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new IsNotNullEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new IsNotNullEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new IsNotNullEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new IsNotNullEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new IsNotNullEntityExpressionImpl<E6, C, L>(5, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(Consumer<Tuple6<InEntityExpression<E>, InEntityExpression<E2>, InEntityExpression<E3>,
            InEntityExpression<E4>, InEntityExpression<E5>, InEntityExpression<E6>>> inEntityExpressions) {
        MulitiEntityInExpression<C, L> mulitiExpression = new MulitiEntityInExpressionImpl<>(this);
        inEntityExpressions.accept(Tuples.of(new InEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new InEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new InEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new InEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new InEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new InEntityExpressionImpl<E6, C, L>(5, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(SixArgusConsumer<InEntityExpression<E>, InEntityExpression<E2>, InEntityExpression<E3>,
            InEntityExpression<E4>, InEntityExpression<E5>, InEntityExpression<E6>> inEntityExpressions) {
        MulitiEntityInExpression<C, L> mulitiExpression = new MulitiEntityInExpressionImpl<>(this);
        inEntityExpressions.accept(new InEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new InEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new InEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new InEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new InEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new InEntityExpressionImpl<E6, C, L>(5, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L gt(Consumer<Tuple6<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>,
            GreatThanEntityExpression<E3>, GreatThanEntityExpression<E4>, GreatThanEntityExpression<E5>,
            GreatThanEntityExpression<E6>>> greatThanEntityExpressions) {
        MulitiEntityGreatThanExpression<C, L> mulitiExpression = new MulitiEntityGreatThanExpressionImpl<>(this);
        greatThanEntityExpressions.accept(Tuples.of(new GreatThanEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new GreatThanEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new GreatThanEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new GreatThanEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new GreatThanEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new GreatThanEntityExpressionImpl<E6, C, L>(5, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L gt(SixArgusConsumer<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>,
            GreatThanEntityExpression<E3>, GreatThanEntityExpression<E4>, GreatThanEntityExpression<E5>,
            GreatThanEntityExpression<E6>> greatThanEntityExpressions) {
        MulitiEntityGreatThanExpression<C, L> mulitiExpression = new MulitiEntityGreatThanExpressionImpl<>(this);
        greatThanEntityExpressions.accept(new GreatThanEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new GreatThanEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new GreatThanEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new GreatThanEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new GreatThanEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new GreatThanEntityExpressionImpl<E6, C, L>(5, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ge(Consumer<Tuple6<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>,
            GreatEqualsEntityExpression<E3>, GreatEqualsEntityExpression<E4>, GreatEqualsEntityExpression<E5>,
            GreatEqualsEntityExpression<E6>>> greatEqualsEntityExpressions) {
        MulitiEntityGreatEqualsExpression<C, L> mulitiExpression = new MulitiEntityGreatEqualsExpressionImpl<>(this);
        greatEqualsEntityExpressions.accept(Tuples.of(new GreatEqualsEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new GreatEqualsEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new GreatEqualsEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new GreatEqualsEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new GreatEqualsEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new GreatEqualsEntityExpressionImpl<E6, C, L>(5, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ge(SixArgusConsumer<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>,
            GreatEqualsEntityExpression<E3>, GreatEqualsEntityExpression<E4>, GreatEqualsEntityExpression<E5>,
            GreatEqualsEntityExpression<E6>> greatEqualsEntityExpressions) {
        MulitiEntityGreatEqualsExpression<C, L> mulitiExpression = new MulitiEntityGreatEqualsExpressionImpl<>(this);
        greatEqualsEntityExpressions.accept(new GreatEqualsEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new GreatEqualsEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new GreatEqualsEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new GreatEqualsEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new GreatEqualsEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new GreatEqualsEntityExpressionImpl<E6, C, L>(5, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L eq(Consumer<Tuple6<EqualsEntityExpression<E>, EqualsEntityExpression<E2>, EqualsEntityExpression<E3>,
            EqualsEntityExpression<E4>, EqualsEntityExpression<E5>,
            EqualsEntityExpression<E6>>> equalsEntityExpressions) {
        MulitiEntityEqualsExpression<C, L> mulitiExpression = new MulitiEntityEqualsExpressionImpl<>(this);
        equalsEntityExpressions.accept(Tuples.of(new EqualsEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new EqualsEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new EqualsEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new EqualsEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new EqualsEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new EqualsEntityExpressionImpl<E6, C, L>(5, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L eq(SixArgusConsumer<EqualsEntityExpression<E>, EqualsEntityExpression<E2>, EqualsEntityExpression<E3>,
            EqualsEntityExpression<E4>, EqualsEntityExpression<E5>,
            EqualsEntityExpression<E6>> equalsEntityExpressions) {
        MulitiEntityEqualsExpression<C, L> mulitiExpression = new MulitiEntityEqualsExpressionImpl<>(this);
        equalsEntityExpressions.accept(new EqualsEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new EqualsEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new EqualsEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new EqualsEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new EqualsEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new EqualsEntityExpressionImpl<E6, C, L>(5, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ew(Consumer<Tuple6<EndWithEntityExpression<E>, EndWithEntityExpression<E2>, EndWithEntityExpression<E3>,
            EndWithEntityExpression<E4>, EndWithEntityExpression<E5>,
            EndWithEntityExpression<E6>>> endWithEntityExpressions) {
        MulitiEntityEndWithExpression<C, L> mulitiExpression = new MulitiEntityEndWithExpressionImpl<>(this);
        endWithEntityExpressions.accept(Tuples.of(new EndWithEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new EndWithEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new EndWithEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new EndWithEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new EndWithEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new EndWithEntityExpressionImpl<E6, C, L>(5, mulitiExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ew(SixArgusConsumer<EndWithEntityExpression<E>, EndWithEntityExpression<E2>, EndWithEntityExpression<E3>,
            EndWithEntityExpression<E4>, EndWithEntityExpression<E5>,
            EndWithEntityExpression<E6>> endWithEntityExpressions) {
        MulitiEntityEndWithExpression<C, L> mulitiExpression = new MulitiEntityEndWithExpressionImpl<>(this);
        endWithEntityExpressions.accept(new EndWithEntityExpressionImpl<E, C, L>(0, mulitiExpression),
                new EndWithEntityExpressionImpl<E2, C, L>(1, mulitiExpression),
                new EndWithEntityExpressionImpl<E3, C, L>(2, mulitiExpression),
                new EndWithEntityExpressionImpl<E4, C, L>(3, mulitiExpression),
                new EndWithEntityExpressionImpl<E5, C, L>(4, mulitiExpression),
                new EndWithEntityExpressionImpl<E6, C, L>(5, mulitiExpression));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(Consumer<Tuple6<ContainsEntityExpression<E>, ContainsEntityExpression<E2>, ContainsEntityExpression<E3>,
            ContainsEntityExpression<E4>, ContainsEntityExpression<E5>,
            ContainsEntityExpression<E6>>> containsEntityExpressions) {
        MulitiEntityContainsExpression<C,
                L> mulitiEntityContainsExpression = new MulitiEntityContainsExpressionImpl<>(this);
        containsEntityExpressions
                .accept(Tuples.of(new ContainsEntityExpressionImpl<E, C, L>(0, mulitiEntityContainsExpression),
                        new ContainsEntityExpressionImpl<E2, C, L>(1, mulitiEntityContainsExpression),
                        new ContainsEntityExpressionImpl<E3, C, L>(2, mulitiEntityContainsExpression),
                        new ContainsEntityExpressionImpl<E4, C, L>(3, mulitiEntityContainsExpression),
                        new ContainsEntityExpressionImpl<E5, C, L>(4, mulitiEntityContainsExpression),
                        new ContainsEntityExpressionImpl<E6, C, L>(5, mulitiEntityContainsExpression)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(SixArgusConsumer<ContainsEntityExpression<E>, ContainsEntityExpression<E2>,
            ContainsEntityExpression<E3>, ContainsEntityExpression<E4>, ContainsEntityExpression<E5>,
            ContainsEntityExpression<E6>> containsEntityExpressions) {
        MulitiEntityContainsExpression<C,
                L> mulitiEntityContainsExpression = new MulitiEntityContainsExpressionImpl<>(this);
        containsEntityExpressions.accept(new ContainsEntityExpressionImpl<E, C, L>(0, mulitiEntityContainsExpression),
                new ContainsEntityExpressionImpl<E2, C, L>(1, mulitiEntityContainsExpression),
                new ContainsEntityExpressionImpl<E3, C, L>(2, mulitiEntityContainsExpression),
                new ContainsEntityExpressionImpl<E4, C, L>(3, mulitiEntityContainsExpression),
                new ContainsEntityExpressionImpl<E5, C, L>(4, mulitiEntityContainsExpression),
                new ContainsEntityExpressionImpl<E6, C, L>(5, mulitiEntityContainsExpression));
        return (L) this;
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public L property(SixArgusFunction<EntityPropertyFunction<E, C, L>, EntityPropertyFunction<E2, C, L>,
            EntityPropertyFunction<E3, C, L>, EntityPropertyFunction<E4, C, L>, EntityPropertyFunction<E5, C, L>,
            EntityPropertyFunction<E6, C, L>, L> entitiesPropertyFunction) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    // ****************************************************************************************************************
    //	sort
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, RS> sort() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc(SixArgusConsumer<SortEntityExpression<E>,
            SortEntityExpression<E2>, SortEntityExpression<E3>, SortEntityExpression<E4>, SortEntityExpression<E5>,
            SortEntityExpression<E6>> sortEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc(SixArgusConsumer<SortEntityExpression<E>,
            SortEntityExpression<E2>, SortEntityExpression<E3>, SortEntityExpression<E4>, SortEntityExpression<E5>,
            SortEntityExpression<E6>> sortEntityExpressions) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E>> entities, SerializableFunction<E, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E>> entities, SerializableFunction<E, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E2>> entities, SerializableFunction1<E2, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E2>> entities, SerializableFunction1<E2, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E3>> entities, SerializableFunction2<E3, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E3>> entities, SerializableFunction2<E3, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E4>> entities, SerializableFunction3<E4, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E4>> entities, SerializableFunction3<E4, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E5>> entities, SerializableFunction4<E5, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E5>> entities, SerializableFunction4<E5, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E6>> entities, SerializableFunction5<E6, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E6>> entities, SerializableFunction5<E6, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E>> entities, SerializableFunction<E, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E>> entities, SerializableFunction<E, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E2>> entities, SerializableFunction1<E2, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E2>> entities, SerializableFunction1<E2, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E3>> entities, SerializableFunction2<E3, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E3>> entities, SerializableFunction2<E3, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E4>> entities, SerializableFunction3<E4, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E4>> entities, SerializableFunction3<E4, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E5>> entities, SerializableFunction4<E5, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E5>> entities, SerializableFunction4<E5, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E6>> entities, SerializableFunction5<E6, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc(Function<
            Tuple6<QueryEntityRepository<E>, QueryEntityRepository<E2>, QueryEntityRepository<E3>,
                    QueryEntityRepository<E4>, QueryEntityRepository<E5>, QueryEntityRepository<E6>>,
            QueryEntityRepository<E6>> entities, SerializableFunction5<E6, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc6(SerializableFunction<E6, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc6(SerializableFunction<E6, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc6(SerializableFunction<E6, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc6(SerializableFunction<E6, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc5(SerializableFunction<E5, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc5(SerializableFunction<E5, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc5(SerializableFunction<E5, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc5(SerializableFunction<E5, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc4(SerializableFunction<E4, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc4(SerializableFunction<E4, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc4(SerializableFunction<E4, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc4(SerializableFunction<E4, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc3(SerializableFunction<E3, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc3(SerializableFunction<E3, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc3(SerializableFunction<E3, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc3(SerializableFunction<E3, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc2(SerializableFunction<E2, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc2(SerializableFunction<E2, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc2(SerializableFunction<E2, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc2(SerializableFunction<E2, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc(SerializableFunction<E, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> asc(SerializableFunction<E, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc(SerializableFunction<E, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression6<E, E2, E3, E4, E5, E6, RS> desc(SerializableFunction<E, ?>... names) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    // ****************************************************************************************************************
    //  private method
    // ****************************************************************************************************************

    @SuppressWarnings("unchecked")
    private SortBuilder getRootSortBuilder() {
        return ((AbstractEntitySqlQueryConditionGroupExpression6<E, E2, E3, E4, E5, E6, RS, C,
                L>) getRoot()).sortBuilder;
    }
}
