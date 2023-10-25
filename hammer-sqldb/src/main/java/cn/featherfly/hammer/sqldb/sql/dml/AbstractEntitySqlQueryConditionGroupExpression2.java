
package cn.featherfly.hammer.sqldb.sql.dml;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.builder.dml.SqlSortBuilder;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.SortOperator;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.condition.ParamedExpression;
import cn.featherfly.hammer.expression.entity.condition.ba.BetweenEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ba.MulitiEntityBetweenExpression;
import cn.featherfly.hammer.expression.entity.condition.co.ContainsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression2;
import cn.featherfly.hammer.expression.entity.condition.co.MulitiEntityContainsExpression;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpression2;
import cn.featherfly.hammer.expression.entity.condition.eq.EqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.eq.MulitiEntityEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpression2;
import cn.featherfly.hammer.expression.entity.condition.ew.MulitiEntityEndWithExpression;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpression2;
import cn.featherfly.hammer.expression.entity.condition.ge.GreatEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ge.MulitiEntityGreatEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpression2;
import cn.featherfly.hammer.expression.entity.condition.gt.GreatThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.MulitiEntityGreatThanExpression;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpression2;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.in.MulitiEntityInExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpression2;
import cn.featherfly.hammer.expression.entity.condition.inn.IsNotNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.MulitiEntityIsNotNullExpression;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpression2;
import cn.featherfly.hammer.expression.entity.condition.isn.IsNullEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.isn.MulitiEntityIsNullExpression;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpression2;
import cn.featherfly.hammer.expression.entity.condition.le.LessEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.le.MulitiEntityLessEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpression2;
import cn.featherfly.hammer.expression.entity.condition.lk.LikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.MulitiEntityLikeExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpression2;
import cn.featherfly.hammer.expression.entity.condition.lt.LessThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.MulitiEntityLessThanExpression;
import cn.featherfly.hammer.expression.entity.condition.nba.MulitiEntityNotBetweenExpression;
import cn.featherfly.hammer.expression.entity.condition.nba.NotBetweenEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nco.MulitiEntityNotContainsExpression;
import cn.featherfly.hammer.expression.entity.condition.nco.NotContainsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression2;
import cn.featherfly.hammer.expression.entity.condition.ne.MulitiEntityNotEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.NotEqualsEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.newv.MulitiEntityNotEndWithExpression;
import cn.featherfly.hammer.expression.entity.condition.newv.NotEndWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpression2;
import cn.featherfly.hammer.expression.entity.condition.ni.MulitiEntityNotInExpression;
import cn.featherfly.hammer.expression.entity.condition.ni.NotInEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nl.MulitiEntityNotLikeExpression;
import cn.featherfly.hammer.expression.entity.condition.nl.NotLikeEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.MulitiEntityNotStartWithExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.NotStartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression2;
import cn.featherfly.hammer.expression.entity.condition.sw.MulitiEntityStartWithExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.StartWithEntityExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression2;
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
 * sql condition group expression2. 条件逻辑组构造器2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <RS> the query result type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public abstract class AbstractEntitySqlQueryConditionGroupExpression2<E, E2, RS,
        C extends EntityQueryConditionGroupExpression2<E, E2, C, L, EntityQuerySortExpression2<E, E2, RS>, RS>,
        L extends EntityQueryConditionGroupLogicExpression2<E, E2, C, L, EntityQuerySortExpression2<E, E2, RS>, RS>>
        extends
        AbstractEntitySqlConditionGroupExpressionBase2<E, E2, EntitySqlQueryRelation, SqlSelectBasicBuilder, C, L,
                QueryConditionConfig>
        implements EntityQueryConditionGroupExpression2<E, E2, C, L, EntityQuerySortExpression2<E, E2, RS>, RS>,
        EntityQueryConditionGroupLogicExpression2<E, E2, C, L, EntityQuerySortExpression2<E, E2, RS>, RS>, SqlBuilder,
        ParamedExpression, EntityContainsExpression2<E, E2, C, L>, EntityEndWithExpression2<E, E2, C, L>,
        EntityEqualsExpression2<E, E2, C, L>, EntityGreatEqualsExpression2<E, E2, C, L>,
        EntityGreatThanExpression2<E, E2, C, L>, EntityInExpression2<E, E2, C, L>,
        EntityIsNotNullExpression2<E, E2, C, L>, EntityIsNullExpression2<E, E2, C, L>,
        EntityLessEqualsExpression2<E, E2, C, L>, EntityLessThanExpression2<E, E2, C, L>,
        EntityNotEqualsExpression2<E, E2, C, L>, EntityNotInExpression2<E, E2, C, L>,
        EntityStartWithExpression2<E, E2, C, L>, EntityLikeExpression2<E, E2, C, L>,
        EntityQuerySortExpression2<E, E2, RS>, EntityQuerySortedExpression2<E, E2, RS> {

    private SqlSortBuilder sortBuilder;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    private EntitySqlQueryConditionGroupQuery<RS> entitySqlQueryConditionGroupQuery;

    /**
     * Instantiates a new abstract entity sql condition group expression 2.
     *
     * @param parent         the parent
     * @param factory        the factory
     * @param sqlPageFactory the sql page factory
     * @param queryRelation  the query relation
     */
    protected AbstractEntitySqlQueryConditionGroupExpression2(L parent, JdbcMappingFactory factory,
            SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        super(parent, factory, queryRelation);
        sortBuilder = new SqlSortBuilder(dialect, queryRelation.getEntityRelationMapping(0).getTableAlias());
        this.sqlPageFactory = sqlPageFactory;
        entitySqlQueryConditionGroupQuery = new EntitySqlQueryConditionGroupQuery<>(this, sqlPageFactory,
                entityRelation);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String build() {
    //        StringBuilder result = new StringBuilder(super.build());
    //        if (parent == null) { // 表示是根条件组，即where()开始的部分
    //            String sort = getRootSortBuilder().build();
    //            if (result.length() > 0) {
    //                if (Lang.isNotEmpty(sort)) {
    //                    return dialect.getKeywords().where() + Chars.SPACE
    //                            + result.append(Chars.SPACE).append(sort).toString();
    //                } else {
    //                    return result.toString();
    //                }
    //            } else {
    //                return sort;
    //            }
    //        } else { // 表示是子条件组，即group()方法开启内的部分
    //            return result.toString();
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

    @Override
    public long count() {
        entityRelation.getBuilder().clearColumns().addColumn(AggregateFunction.COUNT, Chars.STAR);
        return entityRelation.getJdbc().queryLong(getRoot().expression(), getRoot().getParams().toArray());
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

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(Consumer<Tuple2<ContainsEntityExpression<E>, ContainsEntityExpression<E2>>> containsEntityExpressions) {
        MulitiEntityContainsExpression<C, L> mulitiExpression = new MulitiEntityContainsExpressionImpl<>(this);
        containsEntityExpressions
                .accept(Tuples.of(new ContainsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new ContainsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L co(BiConsumer<ContainsEntityExpression<E>, ContainsEntityExpression<E2>> containsEntityExpressions) {
        MulitiEntityContainsExpression<C, L> mulitiExpression = new MulitiEntityContainsExpressionImpl<>(this);
        containsEntityExpressions.accept(
                new ContainsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new ContainsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nco(Consumer<
            Tuple2<NotContainsEntityExpression<E>, NotContainsEntityExpression<E2>>> notContainsEntityExpressions) {
        MulitiEntityNotContainsExpression<C, L> mulitiExpression = new MulitiEntityNotContainsExpressionImpl<>(this);
        notContainsEntityExpressions
                .accept(Tuples.of(new NotContainsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new NotContainsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nco(
            BiConsumer<NotContainsEntityExpression<E>, NotContainsEntityExpression<E2>> notContainsEntityExpressions) {
        MulitiEntityNotContainsExpression<C, L> mulitiExpression = new MulitiEntityNotContainsExpressionImpl<>(this);
        notContainsEntityExpressions.accept(
                new NotContainsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotContainsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ew(Consumer<Tuple2<EndWithEntityExpression<E>, EndWithEntityExpression<E2>>> endWithEntityExpressions) {
        MulitiEntityEndWithExpression<C, L> mulitiExpression = new MulitiEntityEndWithExpressionImpl<>(this);
        endWithEntityExpressions
                .accept(Tuples.of(new EndWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new EndWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ew(BiConsumer<EndWithEntityExpression<E>, EndWithEntityExpression<E2>> endWithEntityExpressions) {
        MulitiEntityEndWithExpression<C, L> mulitiExpression = new MulitiEntityEndWithExpressionImpl<>(this);
        endWithEntityExpressions.accept(new EndWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new EndWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L newv(Consumer<
            Tuple2<NotEndWithEntityExpression<E>, NotEndWithEntityExpression<E2>>> notEndWithEntityExpressions) {
        MulitiEntityNotEndWithExpression<C, L> mulitiExpression = new MulitiEntityNotEndWithExpressionImpl<>(this);
        notEndWithEntityExpressions
                .accept(Tuples.of(new NotEndWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new NotEndWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L newv(
            BiConsumer<NotEndWithEntityExpression<E>, NotEndWithEntityExpression<E2>> notEndWithEntityExpressions) {
        MulitiEntityNotEndWithExpression<C, L> mulitiExpression = new MulitiEntityNotEndWithExpressionImpl<>(this);
        notEndWithEntityExpressions.accept(
                new NotEndWithEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotEndWithEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L eq(Consumer<Tuple2<EqualsEntityExpression<E>, EqualsEntityExpression<E2>>> equalsEntityExpressions) {
        MulitiEntityEqualsExpression<C, L> mulitiExpression = new MulitiEntityEqualsExpressionImpl<>(this);
        equalsEntityExpressions
                .accept(Tuples.of(new EqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new EqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L eq(BiConsumer<EqualsEntityExpression<E>, EqualsEntityExpression<E2>> equalsEntityExpressions) {
        MulitiEntityEqualsExpression<C, L> mulitiExpression = new MulitiEntityEqualsExpressionImpl<>(this);
        equalsEntityExpressions.accept(new EqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new EqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ge(Consumer<
            Tuple2<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>>> greatEqualsEntityExpressions) {
        MulitiEntityGreatEqualsExpression<C, L> mulitiExpression = new MulitiEntityGreatEqualsExpressionImpl<>(this);
        greatEqualsEntityExpressions
                .accept(Tuples.of(new GreatEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new GreatEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ge(
            BiConsumer<GreatEqualsEntityExpression<E>, GreatEqualsEntityExpression<E2>> greatEqualsEntityExpressions) {
        MulitiEntityGreatEqualsExpression<C, L> mulitiExpression = new MulitiEntityGreatEqualsExpressionImpl<>(this);
        greatEqualsEntityExpressions.accept(
                new GreatEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new GreatEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L gt(
            Consumer<Tuple2<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>>> greatThanEntityExpressions) {
        MulitiEntityGreatThanExpression<C, L> mulitiExpression = new MulitiEntityGreatThanExpressionImpl<>(this);
        greatThanEntityExpressions
                .accept(Tuples.of(new GreatThanEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new GreatThanEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L gt(BiConsumer<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>> greatThanEntityExpressions) {
        MulitiEntityGreatThanExpression<C, L> mulitiExpression = new MulitiEntityGreatThanExpressionImpl<>(this);
        greatThanEntityExpressions.accept(
                new GreatThanEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new GreatThanEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(Consumer<Tuple2<InEntityExpression<E>, InEntityExpression<E2>>> inEntityExpressions) {
        MulitiEntityInExpression<C, L> mulitiExpression = new MulitiEntityInExpressionImpl<>(this);
        inEntityExpressions.accept(Tuples.of(new InEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new InEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L in(BiConsumer<InEntityExpression<E>, InEntityExpression<E2>> inEntityExpressions) {
        MulitiEntityInExpression<C, L> mulitiExpression = new MulitiEntityInExpressionImpl<>(this);
        inEntityExpressions.accept(new InEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new InEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L inn(
            Consumer<Tuple2<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>>> isNotNullEntityExpressions) {
        MulitiEntityIsNotNullExpression<C, L> mulitiExpression = new MulitiEntityIsNotNullExpressionImpl<>(this);
        isNotNullEntityExpressions
                .accept(Tuples.of(new IsNotNullEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new IsNotNullEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L inn(BiConsumer<IsNotNullEntityExpression<E>, IsNotNullEntityExpression<E2>> isNotNullEntityExpressions) {
        MulitiEntityIsNotNullExpression<C, L> mulitiExpression = new MulitiEntityIsNotNullExpressionImpl<>(this);
        isNotNullEntityExpressions.accept(
                new IsNotNullEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new IsNotNullEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L isn(Consumer<Tuple2<IsNullEntityExpression<E>, IsNullEntityExpression<E2>>> isNullEntityExpressions) {
        MulitiEntityIsNullExpression<C, L> mulitiExpression = new MulitiEntityIsNullExpressionImpl<>(this);
        isNullEntityExpressions
                .accept(Tuples.of(new IsNullEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new IsNullEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L isn(BiConsumer<IsNullEntityExpression<E>, IsNullEntityExpression<E2>> isNullEntityExpressions) {
        MulitiEntityIsNullExpression<C, L> mulitiExpression = new MulitiEntityIsNullExpressionImpl<>(this);
        isNullEntityExpressions.accept(new IsNullEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new IsNullEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L le(Consumer<
            Tuple2<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>>> lessEqualsEntityExpressions) {
        MulitiEntityLessEqualsExpression<C, L> mulitiExpression = new MulitiEntityLessEqualsExpressionImpl<>(this);
        lessEqualsEntityExpressions
                .accept(Tuples.of(new LessEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new LessEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L le(BiConsumer<LessEqualsEntityExpression<E>, LessEqualsEntityExpression<E2>> lessEqualsEntityExpressions) {
        MulitiEntityLessEqualsExpression<C, L> mulitiExpression = new MulitiEntityLessEqualsExpressionImpl<>(this);
        lessEqualsEntityExpressions.accept(
                new LessEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new LessEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lt(Consumer<Tuple2<LessThanEntityExpression<E>, LessThanEntityExpression<E2>>> lessThanEntityExpressions) {
        MulitiEntityLessThanExpression<C, L> mulitiExpression = new MulitiEntityLessThanExpressionImpl<>(this);
        lessThanEntityExpressions
                .accept(Tuples.of(new LessThanEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new LessThanEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lt(BiConsumer<LessThanEntityExpression<E>, LessThanEntityExpression<E2>> lessThanEntityExpressions) {
        MulitiEntityLessThanExpression<C, L> mulitiExpression = new MulitiEntityLessThanExpressionImpl<>(this);
        lessThanEntityExpressions.accept(
                new LessThanEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new LessThanEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ne(
            Consumer<Tuple2<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>>> notEqualsEntityExpressions) {
        MulitiEntityNotEqualsExpression<C, L> mulitiExpression = new MulitiEntityNotEqualsExpressionImpl<>(this);
        notEqualsEntityExpressions
                .accept(Tuples.of(new NotEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new NotEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ne(BiConsumer<NotEqualsEntityExpression<E>, NotEqualsEntityExpression<E2>> notEqualsEntityExpressions) {
        MulitiEntityNotEqualsExpression<C, L> mulitiExpression = new MulitiEntityNotEqualsExpressionImpl<>(this);
        notEqualsEntityExpressions.accept(
                new NotEqualsEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotEqualsEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(Consumer<Tuple2<NotInEntityExpression<E>, NotInEntityExpression<E2>>> notInEntityExpressions) {
        MulitiEntityNotInExpression<C, L> mulitiExpression = new MulitiEntityNotInExpressionImpl<>(this);
        notInEntityExpressions
                .accept(Tuples.of(new NotInEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new NotInEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(BiConsumer<NotInEntityExpression<E>, NotInEntityExpression<E2>> notInEntityExpressions) {
        MulitiEntityNotInExpression<C, L> mulitiExpression = new MulitiEntityNotInExpressionImpl<>(this);
        notInEntityExpressions.accept(new NotInEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotInEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L sw(
            Consumer<Tuple2<StartWithEntityExpression<E>, StartWithEntityExpression<E2>>> startWithEntityExpressions) {
        MulitiEntityStartWithExpression<C, L> expression = new MulitiEntityStartWithExpressionImpl<>(this);
        startWithEntityExpressions
                .accept(Tuples.of(new StartWithEntityExpressionImpl<>(0, expression, factory, entityRelation),
                        new StartWithEntityExpressionImpl<>(1, expression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L sw(BiConsumer<StartWithEntityExpression<E>, StartWithEntityExpression<E2>> startWithEntityExpressions) {
        MulitiEntityStartWithExpression<C, L> expression = new MulitiEntityStartWithExpressionImpl<>(this);
        startWithEntityExpressions.accept(new StartWithEntityExpressionImpl<>(0, expression, factory, entityRelation),
                new StartWithEntityExpressionImpl<>(1, expression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nsw(Consumer<
            Tuple2<NotStartWithEntityExpression<E>, NotStartWithEntityExpression<E2>>> notStartWithEntityExpressions) {
        MulitiEntityNotStartWithExpression<C, L> expression = new MulitiEntityNotStartWithExpressionImpl<>(this);
        notStartWithEntityExpressions
                .accept(Tuples.of(new NotStartWithEntityExpressionImpl<>(0, expression, factory, entityRelation),
                        new NotStartWithEntityExpressionImpl<>(1, expression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nsw(BiConsumer<NotStartWithEntityExpression<E>,
            NotStartWithEntityExpression<E2>> notStartWithEntityExpressions) {
        MulitiEntityNotStartWithExpression<C, L> expression = new MulitiEntityNotStartWithExpressionImpl<>(this);
        notStartWithEntityExpressions.accept(
                new NotStartWithEntityExpressionImpl<>(0, expression, factory, entityRelation),
                new NotStartWithEntityExpressionImpl<>(1, expression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lk(Consumer<Tuple2<LikeEntityExpression<E>, LikeEntityExpression<E2>>> likeEntityExpressions) {
        MulitiEntityLikeExpression<C, L> mulitiExpression = new MulitiEntityLikeExpressionImpl<>(this);
        likeEntityExpressions
                .accept(Tuples.of(new LikeEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new LikeEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L lk(BiConsumer<LikeEntityExpression<E>, LikeEntityExpression<E2>> likeEntityExpressions) {
        MulitiEntityLikeExpression<C, L> mulitiExpression = new MulitiEntityLikeExpressionImpl<>(this);
        likeEntityExpressions.accept(new LikeEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new LikeEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nl(Consumer<Tuple2<NotLikeEntityExpression<E>, NotLikeEntityExpression<E2>>> notLikeEntityExpressions) {
        MulitiEntityNotLikeExpression<C, L> mulitiExpression = new MulitiEntityNotLikeExpressionImpl<>(this);
        notLikeEntityExpressions
                .accept(Tuples.of(new NotLikeEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new NotLikeEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nl(BiConsumer<NotLikeEntityExpression<E>, NotLikeEntityExpression<E2>> notLikeEntityExpressions) {
        MulitiEntityNotLikeExpression<C, L> mulitiExpression = new MulitiEntityNotLikeExpressionImpl<>(this);
        notLikeEntityExpressions.accept(new NotLikeEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotLikeEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ba(Consumer<Tuple2<BetweenEntityExpression<E>, BetweenEntityExpression<E2>>> betweenEntityExpressions) {
        MulitiEntityBetweenExpression<C, L> mulitiExpression = new MulitiEntityBetweenExpressionImpl<>(this);
        betweenEntityExpressions
                .accept(Tuples.of(new BetweenEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new BetweenEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ba(BiConsumer<BetweenEntityExpression<E>, BetweenEntityExpression<E2>> betweenEntityExpressions) {
        MulitiEntityBetweenExpression<C, L> mulitiExpression = new MulitiEntityBetweenExpressionImpl<>(this);
        betweenEntityExpressions.accept(new BetweenEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new BetweenEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nba(Consumer<
            Tuple2<NotBetweenEntityExpression<E>, NotBetweenEntityExpression<E2>>> notBetweenEntityExpressions) {
        MulitiEntityNotBetweenExpression<C, L> mulitiExpression = new MulitiEntityNotBetweenExpressionImpl<>(this);
        notBetweenEntityExpressions
                .accept(Tuples.of(new NotBetweenEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                        new NotBetweenEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation)));
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L nba(
            BiConsumer<NotBetweenEntityExpression<E>, NotBetweenEntityExpression<E2>> notBetweenEntityExpressions) {
        MulitiEntityNotBetweenExpression<C, L> mulitiExpression = new MulitiEntityNotBetweenExpressionImpl<>(this);
        notBetweenEntityExpressions.accept(
                new NotBetweenEntityExpressionImpl<>(0, mulitiExpression, factory, entityRelation),
                new NotBetweenEntityExpressionImpl<>(1, mulitiExpression, factory, entityRelation));
        return (L) this;
    }

    // ****************************************************************************************************************
    //	sort
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortExpression2<E, E2, RS> sort() {
        return this;
    }

    // ****************************************************************************************************************

    public EntityQuerySortedExpression2<E, E2, RS> asc(String... names) {
        getRootSortBuilder().asc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    public EntityQuerySortedExpression2<E, E2, RS> asc2(String... names) {
        for (String name : names) {
            getRootSortBuilder().asc(queryAlias2, () -> name);
        }
        return this;
    }

    public EntityQuerySortedExpression2<E, E2, RS> desc(String... names) {
        getRootSortBuilder().desc(ClassMappingUtils.getColumnNames(classMapping, names));
        return this;
    }

    public EntityQuerySortedExpression2<E, E2, RS> desc2(String... names) {
        for (String name : names) {
            getRootSortBuilder().desc(queryAlias2, () -> name);
        }
        return this;
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> EntityQuerySortedExpression2<E, E2, RS> asc(SerializableFunction<E, P> name) {
        return asc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E, E2, RS> asc(
            @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return asc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> EntityQuerySortedExpression2<E, E2, RS> desc(SerializableFunction<E, P> name) {
        return desc(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E, E2, RS> desc(
            @SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return desc(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E, E2, RS> asc(
            BiConsumer<SortEntityExpression<E>, SortEntityExpression<E2>> sortEntityExpressions) {
        sortEntityExpressions.accept(
                new SqlSortEntity<>(getRootSortBuilder(), queryAlias, SortOperator.ASC, classMapping),
                new SqlSortEntity<>(getRootSortBuilder(), queryAlias2, SortOperator.ASC, classMapping2));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E, E2, RS> desc(
            BiConsumer<SortEntityExpression<E>, SortEntityExpression<E2>> sortEntityExpressions) {
        sortEntityExpressions.accept(
                new SqlSortEntity<>(getRootSortBuilder(), queryAlias, SortOperator.DESC, classMapping),
                new SqlSortEntity<>(getRootSortBuilder(), queryAlias2, SortOperator.DESC, classMapping2));
        return this;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> EntityQuerySortedExpression2<E, E2, RS> asc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction1<E, R> name) {
    //        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
    //                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
    //        if (index == 0) {
    //            return asc(name);
    //        }
    //        throw new SqldbHammerException("调试错误");
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQuerySortedExpression2<E, E2, RS> asc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction1<E, ?>... names) {
    //        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
    //                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
    //        if (index == 1) {
    //            return asc(names);
    //        }
    //        throw new SqldbHammerException("调试错误");
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> EntityQuerySortedExpression2<E, E2, RS> asc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name) {
    //        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
    //                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
    //        if (index == 1) {
    //            return asc2(name);
    //        }
    //        throw new SqldbHammerException("调试错误");
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQuerySortedExpression2<E, E2, RS> asc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction2<E2, ?>... names) {
    //        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
    //                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
    //        if (index == 1) {
    //            return asc2(names);
    //        }
    //        throw new SqldbHammerException("调试错误");
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> EntityQuerySortedExpression2<E, E2, RS> desc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            SerializableFunction1<E, R> name) {
    //        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
    //                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
    //        if (index == 0) {
    //            return desc(name);
    //        }
    //        throw new SqldbHammerException("调试错误");
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQuerySortedExpression2<E, E2, RS> desc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction1<E, ?>... names) {
    //        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
    //                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
    //        if (index == 0) {
    //            return desc(names);
    //        }
    //        throw new SqldbHammerException("调试错误");
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> EntityQuerySortedExpression2<E, E2, RS> desc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            SerializableFunction2<E2, R> name) {
    //        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
    //                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
    //        if (index == 1) {
    //            return desc2(name);
    //        }
    //        throw new SqldbHammerException("调试错误");
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public EntityQuerySortedExpression2<E, E2, RS> desc(
    //            Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<E2>>, QueryEntityRepository<E2>> entities,
    //            @SuppressWarnings("unchecked") SerializableFunction2<E2, ?>... names) {
    //        int index = entities.apply(Tuples.of(new QueryEntityRepository<>(0, classMapping.getType()),
    //                new QueryEntityRepository<>(1, classMapping2.getType()))).getIndex();
    //        if (index == 1) {
    //            return desc2(names);
    //        }
    //        throw new SqldbHammerException("调试错误");
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression2<E, E2, RS> asc2(SerializableFunction<E2, R> name) {
        return asc2(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E, E2, RS> asc2(
            @SuppressWarnings("unchecked") SerializableFunction<E2, ?>... names) {
        String[] nameArray = Arrays.stream(names).map(LambdaUtils::getLambdaPropertyName)
                .toArray(value -> new String[value]);
        return asc2(nameArray);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQuerySortedExpression2<E, E2, RS> desc2(SerializableFunction<E2, R> name) {
        return desc2(getPropertyName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQuerySortedExpression2<E, E2, RS> desc2(
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
        return ((AbstractEntitySqlQueryConditionGroupExpression2<E, E2, RS, C, L>) getRoot()).sortBuilder;
    }
}
