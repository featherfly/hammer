
package cn.featherfly.juorm.expression.query;

import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.Repository;

/**
 * <p>
 * dsl for query
 * </p>
 *
 * @author zhongj
 */
public interface QueryExpression<Q extends QueryEntityExpression<QP, QW, QWO, QWE, C, L>,
        QP extends QueryEntityPropertiesExpression<QP, QW, QWO, QWE, C, L>,
        QW extends QueryWithExpression<QW, QWO, QWE, C, L>, QWO extends QueryWithOnExpression<QW, QWO, QWE, C, L>,
        QWE extends QueryWithEntityExpression<QW, QWO, QWE, C, L>, C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>,
        TQ extends TypeQueryEntityExpression<TQP, TQW, TQWO, TQWE, TC, TL>,
        TQP extends TypeQueryEntityPropertiesExpression<TQP, TQW, TQWO, TQWE, TC, TL>,
        TQW extends TypeQueryWithExpression<TQW, TQWO, TQWE, TC, TL>,
        TQWO extends TypeQueryWithOnExpression<TQW, TQWO, TQWE, TC, TL>,
        TQWE extends TypeQueryWithEntityExpression<TQW, TQWO, TQWE, TC, TL>,
        TC extends ConditionGroupExpression<TC, TL>, TL extends ConditionGroupLogicExpression<TC, TL>> {
    /**
     * find repository
     *
     * @param repository repository
     * @return QueryEntity
     */
    Q find(Repository repository);

    //    /**
    //     * find repository
    //     *
    //     * @param repository repository
    //     * @return QueryEntity
    //     */
    //    <T, R> Q find(SerializableFunction<T, R> repository);

    /**
     * find repository
     *
     * @param repository repository
     * @return QueryEntity
     */
    Q find(String repository);

    /**
     * find reposit type
     *
     * @param repositType repositType
     * @return QueryEntity
     */
    TQ find(Class<?> repositType);
}
