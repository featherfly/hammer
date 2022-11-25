
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.EntityWhereExpression;

/**
 * type query relation entity expression.
 *
 * @author zhongj
 */
public interface EntityQueryRelationEntityExpression<E, R1, Q extends EntityQueryEntityPropertiesExpression<E, Q, C, L>,
        QR extends EntityQueryRelationExpression<E, R1, Q, C, L>, C extends EntityConditionGroupExpression<E, C, L>,
        L extends EntityConditionGroupLogicExpression<E, C, L>>
        extends EntityWhereExpression<E, C, L>, EntityQueryRelationExpression<E, R1, Q, C, L>
/*, EntityQueryRelationEntitySimpleExpression<E, R1, T, QW, QWE>*/ {

    /**
     * 添加查询出来的所有属性
     *
     * @return QueryWithExpression
     */
    QR fetch();

    //    /**
    //     * relate to.
    //     *
    //     * @param the          generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default QWE relate(SerializableFunction<E, R1> propertyName) {
    //        return join(propertyName);
    //    }
    //
    //    /**
    //     * join on.
    //     *
    //     * @param the          generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    QWE join(SerializableFunction<E, R1> propertyName);
    //
    //    /**
    //     * relate to.
    //     *
    //     * @param the          generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default QWE relate(SerializableFunction2<R1, E> propertyName) {
    //        return join(propertyName);
    //    }
    //
    //    /**
    //     * join on.
    //     *
    //     * @param the          generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    QWE join(SerializableFunction2<R1, E> propertyName);
    //
    //    /**
    //     * relate to.
    //     *
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default QWE relate(SerializableFunction3<E, E> propertyName) {
    //        return join(propertyName);
    //    }
    //
    //    /**
    //     * join on.
    //     *
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    QWE join(SerializableFunction3<E, E> propertyName);
    //
    //    /**
    //     * relate to.
    //     *
    //     * @param the          generic type
    //     * @param propertyName with type object property name
    //     * @param index        with index
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default QWE relate(SerializableFunction<E, R1> propertyName, int index) {
    //        return join(propertyName, index);
    //    }
    //
    //    /**
    //     * join on.
    //     *
    //     * @param the          generic type
    //     * @param propertyName with type object property name
    //     * @param index        with index
    //     * @return TypeQueryWithOnExpression
    //     */
    //    QWE join(SerializableFunction<E, R1> propertyName, int index);
}
