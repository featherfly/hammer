
package cn.featherfly.hammer.sqldb.sql.dml;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.SortOperator;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
import cn.featherfly.hammer.expression.entity.condition.ba.BetweenEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ba.MulitiEntityBetweenExpression;
import cn.featherfly.hammer.expression.entity.condition.co.ContainsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression3;
import cn.featherfly.hammer.expression.entity.condition.co.MulitiEntityContainsExpression;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.eq.EqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.eq.MulitiEntityEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpression3;
import cn.featherfly.hammer.expression.entity.condition.ew.MulitiEntityEndWithExpression;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.ge.GreatEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ge.MulitiEntityGreatEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpression3;
import cn.featherfly.hammer.expression.entity.condition.gt.GreatThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.MulitiEntityGreatThanExpression;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpression3;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.in.MulitiEntityInExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpression3;
import cn.featherfly.hammer.expression.entity.condition.inn.IsNotNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.MulitiEntityIsNotNullExpression;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpression3;
import cn.featherfly.hammer.expression.entity.condition.isn.IsNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.isn.MulitiEntityIsNullExpression;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.le.LessEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.le.MulitiEntityLessEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpression3;
import cn.featherfly.hammer.expression.entity.condition.lk.LikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.MulitiEntityLikeExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpression3;
import cn.featherfly.hammer.expression.entity.condition.lt.LessThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.MulitiEntityLessThanExpression;
import cn.featherfly.hammer.expression.entity.condition.nba.MulitiEntityNotBetweenExpression;
import cn.featherfly.hammer.expression.entity.condition.nba.NotBetweenEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nco.MulitiEntityNotContainsExpression;
import cn.featherfly.hammer.expression.entity.condition.nco.NotContainsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.ne.MulitiEntityNotEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.NotEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.newv.MulitiEntityNotEndWithExpression;
import cn.featherfly.hammer.expression.entity.condition.newv.NotEndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpression3;
import cn.featherfly.hammer.expression.entity.condition.ni.MulitiEntityNotInExpression;
import cn.featherfly.hammer.expression.entity.condition.ni.NotInEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nl.MulitiEntityNotLikeExpression;
import cn.featherfly.hammer.expression.entity.condition.nl.NotLikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.MulitiEntityNotStartWithExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.NotStartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression3;
import cn.featherfly.hammer.expression.entity.condition.sw.MulitiEntityStartWithExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.StartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression3;
import cn.featherfly.hammer.expression.entity.query.sort.SortEntityExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.BetweenEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.ContainsEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.EndWithEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.EqualsEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.GreatEqualsEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.GreatThanEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.InEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.IsNotNullEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.IsNullEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.LessEqualsEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.LessThanEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.LikeEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityBetweenExpressionImpl;
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
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityNotBetweenExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityNotContainsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityNotEndWithExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityNotEqualsExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityNotInExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityNotLikeExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityNotStartWithExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.MulitiEntityStartWithExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.NotBetweenEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.NotContainsEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.NotEndWithEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.NotEqualsEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.NotInEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.NotLikeEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.NotStartWithEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.StartWithEntityExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.sort.SqlSortEntity;

/**
 * sql condition group expression3. 条件逻辑组构造器3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <RS> the query result type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractEntitySqlQueryConditionGroupExpression3<E, E2, E3, RS,
        C extends EntityQueryConditionGroupExpression3<E, E2, E3, C, L, EntityQuerySortExpression3<E, E2, E3, RS>, RS>,
        L extends EntityQueryConditionGroupLogicExpression3<E, E2, E3, C, L, EntityQuerySortExpression3<E, E2, E3, RS>, RS>>
        extends
        AbstractEntitySqlConditionGroupExpressionBase3<E, E2, E3, EntitySqlQueryRelation, SqlSelectBasicBuilder, C, L>
        implements EntityQueryConditionGroupExpression3<E, E2, E3, C, L, EntityQuerySortExpression3<E, E2, E3, RS>, RS>,
        EntityQueryConditionGroupLogicExpression3<E, E2, E3, C, L, EntityQuerySortExpression3<E, E2, E3, RS>, RS>,
        SqlBuilder, ParamedExpression, EntityContainsExpression3<E, E2, E3, C, L>,
        EntityEndWithExpression3<E, E2, E3, C, L>, EntityEqualsExpression3<E, E2, E3, C, L>,
        EntityGreatEqualsExpression3<E, E2, E3, C, L>, EntityGreatThanExpression3<E, E2, E3, C, L>,
        EntityInExpression3<E, E2, E3, C, L>, EntityIsNotNullExpression3<E, E2, E3, C, L>,
        EntityIsNullExpression3<E, E2, E3, C, L>, EntityLessEqualsExpression3<E, E2, E3, C, L>,
        EntityLessThanExpression3<E, E2, E3, C, L>, EntityNotEqualsExpression3<E, E2, E3, C, L>,
        EntityNotInExpression3<E, E2, E3, C, L>, EntityStartWithExpression3<E, E2, E3, C, L>,
        EntityLikeExpression3<E, E2, E3, C, L>, EntityQuerySortExpression3<E, E2, E3, RS>,
        EntityQuerySortedExpression3<E, E2, E3, RS> {

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
    protected AbstractEntitySqlQueryConditionGroupExpression3(L parent, JdbcMappingFactory factory,
            SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, queryRelation);
        sortBuilder = new SqlSortBuilder(dialect, queryRelation.getEntityRelationMapping(0).getTableAlias());
        this.sqlPageFactory = sqlPageFactory;
        entitySqlQueryConditionGroupQuery = new EntitySqlQueryConditionGroupQuery<>(this, sqlPageFactory,
                entityRelation);
    }

    // ****************************************************************************************************************

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String build() {
    //        StringBuilder result = new StringBuilder(super.build());
    //        String sort = sortBuilder.build();
    //        if (result.length() > 0) {
    //            if (Lang.isNotEmpty(sort)) {
    //                return result.append(Chars.SPACE).append(sort).toString();
    //            } else {
    //                return result.toString();
    //            }
    //        } else {
    //            return sort;
    //        }
    //    }

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
        entityRelation.getBuilder().clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR);
        return entityRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(
            Consumer<Tuple3<ContainsEntityExpression<E>, ContainsEntityExpression<E2>, ContainsEntityExpression<E3>>> containsEntityExpressions) {
        MulitiEntityContainsExpression<C, L> mulitiEntityContainsExpression = new MulitiEntityContainsExpressionImpl<>(
                this);
        containsEntityExpressions.accept(Tuples.of(
                new ContainsEntityExpressionImpl<>(0, mulitiEntityContainsExpression, ignoreStrategy, factory,
                        entityRelation),
                new ContainsEntityExpressionImpl<>(1, mulitiEntityContainsExpression, ignoreStrategy, factory,
                        entityRelation),
                new ContainsEntityExpressionImpl<>(2, mulitiEntityContainsExpression, ignoreStrategy, factory,
                        entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(
            ThreeArgusConsumer<ContainsEntityExpression<E>, ContainsEntityExpression<E2>, ContainsEntityExpression<E3>> containsEntityExpressions) {
        MulitiEntityContainsExpression<C, L> mulitiEntityContainsExpression = new MulitiEntityContainsExpressionImpl<>(
                this);
        containsEntityExpressions.accept(
                new ContainsEntityExpressionImpl<>(0, mulitiEntityContainsExpression, ignoreStrategy, factory,
                        entityRelation),
                new ContainsEntityExpressionImpl<>(1, mulitiEntityContainsExpression, ignoreStrategy, factory,
                        entityRelation),
                new ContainsEntityExpressionImpl<>(2, mulitiEntityContainsExpression, ignoreStrategy, factory,
                        entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ew(
            Consumer<Tuple3<EndWithEntityExpression<E>, EndWithEntityExpression<E2>, EndWithEntityExpression<E3>>> endWithEntityExpressions) {
        MulitiEntityEndWithExpression<C, L> mulitiExpression = new MulitiEntityEndWithExpressionImpl<>(this);
        endWithEntityExpressions.accept(Tuples.of(
                new EndWithEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new EndWithEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new EndWithEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ew(
            ThreeArgusConsumer<EndWithEntityExpression<E>, EndWithEntityExpression<E2>, EndWithEntityExpression<E3>> endWithEntityExpressions) {
        MulitiEntityEndWithExpression<C, L> mulitiExpression = new MulitiEntityEndWithExpressionImpl<>(this);
        endWithEntityExpressions.accept(
                new EndWithEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new EndWithEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new EndWithEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L eq(
            Consumer<Tuple3<EqualsEntityExpression<E>, EqualsEntityExpression<E2>, EqualsEntityExpression<E3>>> equalsEntityExpressions) {
        MulitiEntityEqualsExpression<C, L> mulitiExpression = new MulitiEntityEqualsExpressionImpl<>(this);
        equalsEntityExpressions.accept(Tuples.of(
                new EqualsEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new EqualsEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new EqualsEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L eq(
            ThreeArgusConsumer<EqualsEntityExpression<E>, EqualsEntityExpression<E2>, EqualsEntityExpression<E3>> equalsEntityExpressions) {
        MulitiEntityEqualsExpression<C, L> mulitiExpression = new MulitiEntityEqualsExpressionImpl<>(this);
        equalsEntityExpressions.accept(
                new EqualsEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new EqualsEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new EqualsEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ge(
            Consumer<Tuple3<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>, GreatEqualsEntityExpression<E3>>> greatEqualsEntityExpressions) {
        MulitiEntityGreatEqualsExpression<C, L> mulitiExpression = new MulitiEntityGreatEqualsExpressionImpl<>(this);
        greatEqualsEntityExpressions.accept(Tuples.of(
                new GreatEqualsEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new GreatEqualsEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new GreatEqualsEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ge(
            ThreeArgusConsumer<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>, GreatEqualsEntityExpression<E3>> greatEqualsEntityExpressions) {
        MulitiEntityGreatEqualsExpression<C, L> mulitiExpression = new MulitiEntityGreatEqualsExpressionImpl<>(this);
        greatEqualsEntityExpressions.accept(
                new GreatEqualsEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new GreatEqualsEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new GreatEqualsEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L gt(
            Consumer<Tuple3<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>, GreatThanEntityExpression<E3>>> greatThanEntityExpressions) {
        MulitiEntityGreatThanExpression<C, L> mulitiExpression = new MulitiEntityGreatThanExpressionImpl<>(this);
        greatThanEntityExpressions.accept(Tuples.of(
                new GreatThanEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new GreatThanEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new GreatThanEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L gt(
            ThreeArgusConsumer<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>, GreatThanEntityExpression<E3>> greatThanEntityExpressions) {
        MulitiEntityGreatThanExpression<C, L> mulitiExpression = new MulitiEntityGreatThanExpressionImpl<>(this);
        greatThanEntityExpressions.accept(
                new GreatThanEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new GreatThanEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new GreatThanEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(
            Consumer<Tuple3<InEntityExpression<E>, InEntityExpression<E2>, InEntityExpression<E3>>> inEntityExpressions) {
        MulitiEntityInExpression<C, L> mulitiExpression = new MulitiEntityInExpressionImpl<>(this);
        inEntityExpressions.accept(
                Tuples.of(new InEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                        new InEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                        new InEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(
            ThreeArgusConsumer<InEntityExpression<E>, InEntityExpression<E2>, InEntityExpression<E3>> inEntityExpressions) {
        MulitiEntityInExpression<C, L> mulitiExpression = new MulitiEntityInExpressionImpl<>(this);
        inEntityExpressions.accept(
                new InEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new InEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new InEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L inn(
            Consumer<Tuple3<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>, IsNotNullEntityExpression<E3>>> isNotNullEntityExpressions) {
        MulitiEntityIsNotNullExpression<C, L> mulitiExpression = new MulitiEntityIsNotNullExpressionImpl<>(this);
        isNotNullEntityExpressions.accept(Tuples.of(
                new IsNotNullEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new IsNotNullEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new IsNotNullEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L inn(
            ThreeArgusConsumer<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>, IsNotNullEntityExpression<E3>> isNotNullEntityExpressions) {
        MulitiEntityIsNotNullExpression<C, L> mulitiExpression = new MulitiEntityIsNotNullExpressionImpl<>(this);
        isNotNullEntityExpressions.accept(
                new IsNotNullEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new IsNotNullEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new IsNotNullEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L isn(
            Consumer<Tuple3<IsNullEntityExpression<E>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>>> isNullEntityExpressions) {
        MulitiEntityIsNullExpression<C, L> mulitiExpression = new MulitiEntityIsNullExpressionImpl<>(this);
        isNullEntityExpressions.accept(Tuples.of(
                new IsNullEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new IsNullEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new IsNullEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L isn(
            ThreeArgusConsumer<IsNullEntityExpression<E>, IsNullEntityExpression<E2>, IsNullEntityExpression<E3>> isNullEntityExpressions) {
        MulitiEntityIsNullExpression<C, L> mulitiExpression = new MulitiEntityIsNullExpressionImpl<>(this);
        isNullEntityExpressions.accept(
                new IsNullEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new IsNullEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new IsNullEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L le(
            Consumer<Tuple3<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>, LessEqualsEntityExpression<E3>>> lessEqualsEntityExpressions) {
        MulitiEntityLessEqualsExpression<C, L> mulitiExpression = new MulitiEntityLessEqualsExpressionImpl<>(this);
        lessEqualsEntityExpressions.accept(Tuples.of(
                new LessEqualsEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new LessEqualsEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new LessEqualsEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L le(
            ThreeArgusConsumer<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>, LessEqualsEntityExpression<E3>> lessEqualsEntityExpressions) {
        MulitiEntityLessEqualsExpression<C, L> mulitiExpression = new MulitiEntityLessEqualsExpressionImpl<>(this);
        lessEqualsEntityExpressions.accept(
                new LessEqualsEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new LessEqualsEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new LessEqualsEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lt(
            Consumer<Tuple3<LessThanEntityExpression<E>, LessThanEntityExpression<E2>, LessThanEntityExpression<E3>>> lessThanEntityExpressions) {
        MulitiEntityLessThanExpression<C, L> mulitiExpression = new MulitiEntityLessThanExpressionImpl<>(this);
        lessThanEntityExpressions.accept(Tuples.of(
                new LessThanEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new LessThanEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new LessThanEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lt(
            ThreeArgusConsumer<LessThanEntityExpression<E>, LessThanEntityExpression<E2>, LessThanEntityExpression<E3>> lessThanEntityExpressions) {
        MulitiEntityLessThanExpression<C, L> mulitiExpression = new MulitiEntityLessThanExpressionImpl<>(this);
        lessThanEntityExpressions.accept(
                new LessThanEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new LessThanEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new LessThanEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ne(
            Consumer<Tuple3<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>, NotEqualsEntityExpression<E3>>> notEqualsEntityExpressions) {
        MulitiEntityNotEqualsExpression<C, L> mulitiExpression = new MulitiEntityNotEqualsExpressionImpl<>(this);
        notEqualsEntityExpressions.accept(Tuples.of(
                new NotEqualsEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotEqualsEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotEqualsEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ne(
            ThreeArgusConsumer<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>, NotEqualsEntityExpression<E3>> notEqualsEntityExpressions) {
        MulitiEntityNotEqualsExpression<C, L> mulitiExpression = new MulitiEntityNotEqualsExpressionImpl<>(this);
        notEqualsEntityExpressions.accept(
                new NotEqualsEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotEqualsEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotEqualsEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(
            Consumer<Tuple3<NotInEntityExpression<E>, NotInEntityExpression<E2>, NotInEntityExpression<E3>>> notInEntityExpressions) {
        MulitiEntityNotInExpression<C, L> mulitiExpression = new MulitiEntityNotInExpressionImpl<>(this);
        notInEntityExpressions.accept(
                Tuples.of(new NotInEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                        new NotInEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                        new NotInEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(
            ThreeArgusConsumer<NotInEntityExpression<E>, NotInEntityExpression<E2>, NotInEntityExpression<E3>> notInEntityExpressions) {
        MulitiEntityNotInExpression<C, L> mulitiExpression = new MulitiEntityNotInExpressionImpl<>(this);
        notInEntityExpressions.accept(
                new NotInEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotInEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotInEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L sw(
            Consumer<Tuple3<StartWithEntityExpression<E>, StartWithEntityExpression<E2>, StartWithEntityExpression<E3>>> startWithEntityExpressions) {
        MulitiEntityStartWithExpression<C, L> expression = new MulitiEntityStartWithExpressionImpl<>(this);
        startWithEntityExpressions.accept(
                Tuples.of(new StartWithEntityExpressionImpl<>(0, expression, ignoreStrategy, factory, entityRelation),
                        new StartWithEntityExpressionImpl<>(1, expression, ignoreStrategy, factory, entityRelation),
                        new StartWithEntityExpressionImpl<>(2, expression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L sw(
            ThreeArgusConsumer<StartWithEntityExpression<E>, StartWithEntityExpression<E2>, StartWithEntityExpression<E3>> startWithEntityExpressions) {
        MulitiEntityStartWithExpression<C, L> expression = new MulitiEntityStartWithExpressionImpl<>(this);
        startWithEntityExpressions.accept(
                new StartWithEntityExpressionImpl<>(0, expression, ignoreStrategy, factory, entityRelation),
                new StartWithEntityExpressionImpl<>(1, expression, ignoreStrategy, factory, entityRelation),
                new StartWithEntityExpressionImpl<>(2, expression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lk(
            Consumer<Tuple3<LikeEntityExpression<E>, LikeEntityExpression<E2>, LikeEntityExpression<E3>>> likeEntityExpressions) {
        MulitiEntityLikeExpression<C, L> mulitiExpression = new MulitiEntityLikeExpressionImpl<>(this);
        likeEntityExpressions.accept(
                Tuples.of(new LikeEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                        new LikeEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                        new LikeEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lk(
            ThreeArgusConsumer<LikeEntityExpression<E>, LikeEntityExpression<E2>, LikeEntityExpression<E3>> likeEntityExpressions) {
        MulitiEntityLikeExpression<C, L> mulitiExpression = new MulitiEntityLikeExpressionImpl<>(this);
        likeEntityExpressions.accept(
                new LikeEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new LikeEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new LikeEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ba(
            Consumer<Tuple3<BetweenEntityExpression<E>, BetweenEntityExpression<E2>, BetweenEntityExpression<E3>>> betweenEntityExpressions) {
        MulitiEntityBetweenExpression<C, L> mulitiExpression = new MulitiEntityBetweenExpressionImpl<>(this);
        betweenEntityExpressions.accept(Tuples.of(
                new BetweenEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new BetweenEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new BetweenEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ba(
            ThreeArgusConsumer<BetweenEntityExpression<E>, BetweenEntityExpression<E2>, BetweenEntityExpression<E3>> betweenEntityExpressions) {
        MulitiEntityBetweenExpression<C, L> mulitiExpression = new MulitiEntityBetweenExpressionImpl<>(this);
        betweenEntityExpressions.accept(
                new BetweenEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new BetweenEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new BetweenEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nba(
            Consumer<Tuple3<NotBetweenEntityExpression<E>, NotBetweenEntityExpression<E2>, NotBetweenEntityExpression<E3>>> notBetweenEntityExpressions) {
        MulitiEntityNotBetweenExpression<C, L> mulitiExpression = new MulitiEntityNotBetweenExpressionImpl<>(this);
        notBetweenEntityExpressions.accept(Tuples.of(
                new NotBetweenEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotBetweenEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotBetweenEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nba(
            ThreeArgusConsumer<NotBetweenEntityExpression<E>, NotBetweenEntityExpression<E2>, NotBetweenEntityExpression<E3>> notBetweenEntityExpressions) {
        MulitiEntityNotBetweenExpression<C, L> mulitiExpression = new MulitiEntityNotBetweenExpressionImpl<>(this);
        notBetweenEntityExpressions.accept(
                new NotBetweenEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotBetweenEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotBetweenEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nco(
            Consumer<Tuple3<NotContainsEntityExpression<E>, NotContainsEntityExpression<E2>, NotContainsEntityExpression<E3>>> notContainsEntityExpressions) {
        MulitiEntityNotContainsExpression<C, L> mulitiExpression = new MulitiEntityNotContainsExpressionImpl<>(this);
        notContainsEntityExpressions.accept(Tuples.of(
                new NotContainsEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotContainsEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotContainsEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nco(
            ThreeArgusConsumer<NotContainsEntityExpression<E>, NotContainsEntityExpression<E2>, NotContainsEntityExpression<E3>> notContainsEntityExpressions) {
        MulitiEntityNotContainsExpression<C, L> mulitiExpression = new MulitiEntityNotContainsExpressionImpl<>(this);
        notContainsEntityExpressions.accept(
                new NotContainsEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotContainsEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotContainsEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L newv(
            Consumer<Tuple3<NotEndWithEntityExpression<E>, NotEndWithEntityExpression<E2>, NotEndWithEntityExpression<E3>>> notEndWithEntityExpressions) {
        MulitiEntityNotEndWithExpression<C, L> mulitiExpression = new MulitiEntityNotEndWithExpressionImpl<>(this);
        notEndWithEntityExpressions.accept(Tuples.of(
                new NotEndWithEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotEndWithEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotEndWithEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L newv(
            ThreeArgusConsumer<NotEndWithEntityExpression<E>, NotEndWithEntityExpression<E2>, NotEndWithEntityExpression<E3>> notEndWithEntityExpressions) {
        MulitiEntityNotEndWithExpression<C, L> mulitiExpression = new MulitiEntityNotEndWithExpressionImpl<>(this);
        notEndWithEntityExpressions.accept(
                new NotEndWithEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotEndWithEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotEndWithEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nsw(
            Consumer<Tuple3<NotStartWithEntityExpression<E>, NotStartWithEntityExpression<E2>, NotStartWithEntityExpression<E3>>> notStartWithEntityExpressions) {
        MulitiEntityNotStartWithExpression<C, L> mulitiExpression = new MulitiEntityNotStartWithExpressionImpl<>(this);
        notStartWithEntityExpressions.accept(Tuples.of(
                new NotStartWithEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotStartWithEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotStartWithEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nsw(
            ThreeArgusConsumer<NotStartWithEntityExpression<E>, NotStartWithEntityExpression<E2>, NotStartWithEntityExpression<E3>> notStartWithEntityExpressions) {
        MulitiEntityNotStartWithExpression<C, L> mulitiExpression = new MulitiEntityNotStartWithExpressionImpl<>(this);
        notStartWithEntityExpressions.accept(
                new NotStartWithEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotStartWithEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotStartWithEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nl(
            Consumer<Tuple3<NotLikeEntityExpression<E>, NotLikeEntityExpression<E2>, NotLikeEntityExpression<E3>>> notLikeEntityExpressions) {
        MulitiEntityNotLikeExpression<C, L> mulitiExpression = new MulitiEntityNotLikeExpressionImpl<>(this);
        notLikeEntityExpressions.accept(Tuples.of(
                new NotLikeEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotLikeEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotLikeEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nl(
            ThreeArgusConsumer<NotLikeEntityExpression<E>, NotLikeEntityExpression<E2>, NotLikeEntityExpression<E3>> notLikeEntityExpressions) {
        MulitiEntityNotLikeExpression<C, L> mulitiExpression = new MulitiEntityNotLikeExpressionImpl<>(this);
        notLikeEntityExpressions.accept(
                new NotLikeEntityExpressionImpl<>(0, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotLikeEntityExpressionImpl<>(1, mulitiExpression, ignoreStrategy, factory, entityRelation),
                new NotLikeEntityExpressionImpl<>(2, mulitiExpression, ignoreStrategy, factory, entityRelation));
        return (L) this;
    }

    // ****************************************************************************************************************
    //	sort
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression3<E, E2, E3, RS> sort() {
        return this;
    }

    // ****************************************************************************************************************

    public EntityQuerySortedExpression3<E, E2, E3, RS> asc(String... names) {
        getRootSortBuilder().asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    public EntityQuerySortedExpression3<E, E2, E3, RS> asc2(String... names) {
        for (String name : names) {
            getRootSortBuilder().asc(queryAlias2, () -> name);
        }
        return this;
    }

    public EntityQuerySortedExpression3<E, E2, E3, RS> asc3(String... names) {
        for (String name : names) {
            getRootSortBuilder().asc(queryAlias3, () -> name);
        }
        return this;
    }

    public EntityQuerySortedExpression3<E, E2, E3, RS> desc(String... names) {
        getRootSortBuilder().desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    public EntityQuerySortedExpression3<E, E2, E3, RS> desc2(String... names) {
        for (String name : names) {
            getRootSortBuilder().desc(queryAlias2, () -> name);
        }
        return this;
    }

    public EntityQuerySortedExpression3<E, E2, E3, RS> desc3(String... names) {
        for (String name : names) {
            getRootSortBuilder().desc(queryAlias3, () -> name);
        }
        return this;
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> EntityQuerySortedExpression3<E, E2, E3, RS> asc(SerializableFunction<E, P> name) {
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> asc(
            @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return asc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> EntityQuerySortedExpression3<E, E2, E3, RS> desc(SerializableFunction<E, P> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> desc(
            @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return desc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> asc(
            ThreeArgusConsumer<SortEntityExpression<E>, SortEntityExpression<E2>, SortEntityExpression<E3>> sortEntityExpressions) {
        sortEntityExpressions.accept(
                new SqlSortEntity<>(getRootSortBuilder(), queryAlias, SortOperator.ASC, classMapping),
                new SqlSortEntity<>(getRootSortBuilder(), queryAlias2, SortOperator.ASC, classMapping2),
                new SqlSortEntity<>(getRootSortBuilder(), queryAlias3, SortOperator.ASC, classMapping3));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> desc(
            ThreeArgusConsumer<SortEntityExpression<E>, SortEntityExpression<E2>, SortEntityExpression<E3>> sortEntityExpressions) {
        sortEntityExpressions.accept(
                new SqlSortEntity<>(getRootSortBuilder(), queryAlias, SortOperator.DESC, classMapping),
                new SqlSortEntity<>(getRootSortBuilder(), queryAlias2, SortOperator.DESC, classMapping2),
                new SqlSortEntity<>(getRootSortBuilder(), queryAlias3, SortOperator.DESC, classMapping3));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E, E2, E3, RS> asc3(SerializableFunction<E3, R> name) {
        return asc3(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> asc3(
            @SuppressWarnings("unchecked") SerializableFunction<E3, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return asc3(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E, E2, E3, RS> desc3(SerializableFunction<E3, R> name) {
        return desc3(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> desc3(
            @SuppressWarnings("unchecked") SerializableFunction<E3, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return desc3(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E, E2, E3, RS> asc2(SerializableFunction<E2, R> name) {
        return asc2(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> asc2(
            @SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return asc2(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression3<E, E2, E3, RS> desc2(SerializableFunction<E2, R> name) {
        return desc2(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression3<E, E2, E3, RS> desc2(
            @SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return desc2(nameArray);
    }

    // ****************************************************************************************************************
    //  private method
    // ****************************************************************************************************************

    @SuppressWarnings("unchecked")
    protected SortBuilder getRootSortBuilder() {
        return ((AbstractEntitySqlQueryConditionGroupExpression3<E, E2, E3, RS, C, L>) getRoot()).sortBuilder;
    }
}
