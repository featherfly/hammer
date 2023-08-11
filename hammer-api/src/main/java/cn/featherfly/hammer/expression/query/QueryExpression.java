
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.expression.ConditionGroupExpression;
import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.condition.RepositoryConditionsGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryFetchExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryFetchedPropertyExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueConditionGroupLogicExpression;

/**
 * dsl for query.
 *
 * @author zhongj
 * @param <Q>   the generic type
 * @param <QP>  the generic type
 * @param <QW>  the generic type
 * @param <QWO> the generic type
 * @param <QWE> the generic type
 * @param <C>   the generic type
 * @param <L>   the generic type
 * @param <RC>  the generic type
 * @param <RL>  the generic type
 * @param <RTC> the generic type
 * @param <RTL> the generic type
 */
public interface QueryExpression<Q extends QueryEntityExpression<QP, QW, QWO, QWE, C, L, RC, RL>,
        QP extends QueryEntityPropertiesExpression<QP, QW, QWO, QWE, C, L, RC, RL>,
        QW extends QueryRelateExpression<QW, QWO, QWE, RC, RL>,
        QWO extends QueryRelateOnExpression<QW, QWO, QWE, RC, RL>,
        QWE extends QueryRelateEntityExpression<QW, QWO, QWE, RC, RL>, C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>, RC extends RepositoryConditionsGroupExpression<RC, RL>,
        RL extends RepositoryConditionGroupLogicExpression<RC, RL>
//,
//        TQ extends TypeQueryEntityExpression<TQP, TQW, TQWE, TC, TL, RTC, RTL>,
//        TQP extends TypeQueryEntityPropertiesExpression<TQP, TQW, TQWE, TC, TL, RTC, RTL>,
//        TQW extends TypeQueryWithExpression<TQW, TQWE, RTC, RTL>,
//        TQWE extends TypeQueryWithEntityExpression<TQW, TQWE, RTC, RTL>,
//        TC extends TypeConditionGroupExpression<TC, TL>, TL extends TypeConditionGroupLogicExpression<TC, TL>,
//        RTC extends RepositoryConditionsGroupExpression<RTC, RTL>,
//        RTL extends RepositoryConditionGroupLogicExpression<RTC, RTL>
//        ,
//        EQ extends EntityQueryEntityExpression<?, EQP, EQW, EQWE, EC, EL>,
//        EQP extends EntityQueryEntityPropertiesExpression<?, EQP, EQW, EQWE, EC, EL>,
//        EQW extends EntityQueryWithExpression<?, EQW, EQWE, EC, EL>,
//        EQWE extends EntityQueryWithEntityExpression<?, EQW, EQWE, EC, EL>,
//        EC extends EntityConditionGroupExpression<EC, EL>, EL extends EntityConditionGroupLogicExpression<EC, EL>
> {

    /**
     * start query dsl for repository.
     *
     * @param repository repository
     * @return generic type of QueryEntityExpression
     */
    Q find(Repository repository);

    /**
     * start query dsl for repository.
     *
     * @param repository repository
     * @return generic type of QueryEntityExpression
     */
    Q find(String repository);

    /**
     * start query dsl for repository.
     *
     * @param <EQF>      the generic type
     * @param <E>        the element type
     * @param <EQC>      the generic type
     * @param <EQL>      the generic type
     * @param <EQFP>     the generic type
     * @param <EQVC>     the generic type
     * @param <EQVL>     the generic type
     * @param <RS>       the generic type
     * @param entityType the entity type
     * @return generic type of EntityQueryFetchExpression
     */
    <EQF extends EntityQueryFetchExpression<E, EQC, EQL, EQFP, EQVC, EQVL, RS>, E,
            EQC extends EntityQueryConditionGroupExpression<E, EQC, EQL, RS>,
            EQL extends EntityQueryConditionGroupLogicExpression<E, EQC, EQL, RS>,
            EQFP extends EntityQueryFetchedPropertyExpression<E, EQVC, EQVL, EQFP, RS>,
            EQVC extends EntityQueryValueConditionGroupExpression<E, EQVC, EQVL, RS>,
            EQVL extends EntityQueryValueConditionGroupLogicExpression<E, EQVC, EQVL, RS>,
            RS extends EntityQuerySortExpression<E>> EQF find(Class<E> entityType);

    //    /**
    //     * find repository type.
    //     *
    //     * @param repositoryType repository type
    //     * @return QueryEntity
    //     */
    //    TQ find(Class<?> repositoryType);
    //    <E> EQ<E> find(Class<E> repositoryType);

    //    <E, EQ extends EntityQueryEntityExpression<E, EQP, EQW, EQWE, EC, EL>,
    //            EQP extends EntityQueryEntityPropertiesExpression<E, EQP, EQW, EQWE, EC, EL>,
    //            EQW extends EntityQueryWithExpression<E, EQW, EQWE, EC, EL>,
    //            EQWE extends EntityQueryWithEntityExpression<E, EQW, EQWE, EC, EL>,
    //            EC extends EntityConditionGroupExpression<EC, EL>,
    //            EL extends EntityConditionGroupLogicExpression<EC, EL>> EQ find(Class<E> repositoryType);

    //    <TQ1 extends TypeQueryEntityExpression<TQP1, TQW1, TQWE1, TC1, TL1, RTC1, RTL1>,
    //            TQP1 extends TypeQueryEntityPropertiesExpression<TQP1, TQW1, TQWE1, TC1, TL1, RTC1, RTL1>,
    //            TQW1 extends TypeQueryWithExpression<TQW1, TQWE1, RTC1, RTL1>,
    //            TQWE1 extends TypeQueryWithEntityExpression<TQW1, TQWE1, RTC1, RTL1>,
    //            TC1 extends TypeConditionGroupExpression<TC1, TL1>, TL1 extends TypeConditionGroupLogicExpression<TC1, TL1>,
    //            RTC1 extends RepositoryConditionsGroupExpression<RTC1, RTL1>,
    //            RTL1 extends RepositoryConditionGroupLogicExpression<RTC1, RTL1>> TQ find(Class<?> repositoryType);
}
