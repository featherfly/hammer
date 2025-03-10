//
//package cn.featherfly.hammer.sqldb.dsl.type;
//
//import cn.featherfly.hammer.dsl.query.QueryConditionsGroupExpression;
//import cn.featherfly.hammer.dsl.query.QueryConditionsGroupLogicExpression;
//import cn.featherfly.hammer.expression.condition.field.ObjectFieldExpression;
//
///**
// * TypeObjectExpression .
// *
// * @author zhongj
// * @param <E> the element type
// * @param <Q> the generic type
// */
//public class StaticTypeObjectExpression<E, Q extends StaticTypeQueryConditionGroupExpression<E, Q>> {
//
//    /** The expression. */
//    private ObjectFieldExpression<QueryConditionsGroupExpression, QueryConditionsGroupLogicExpression> expression;
//
//    /** The type expression. */
//    private Q typeExpression;
//
//    /**
//     * Instantiates a new type object expression.
//     *
//     * @param expression     the expression
//     * @param typeExpression the type expression
//     */
//    public StaticTypeObjectExpression(
//            ObjectFieldExpression<QueryConditionsGroupExpression, QueryConditionsGroupLogicExpression> expression,
//            Q typeExpression) {
//        super();
//        this.expression = expression;
//        this.typeExpression = typeExpression;
//    }
//
//    /**
//     * Eq.
//     *
//     * @param value the value
//     * @return the q
//     */
//    public Q eq(Object value) {
//        expression.eq(value);
//        return typeExpression;
//    }
//
//    /**
//     * Ne.
//     *
//     * @param value the value
//     * @return the q
//     */
//    public Q ne(Object value) {
//        expression.ne(value);
//        return typeExpression;
//    }
//
//    /**
//     * In.
//     *
//     * @param value the value
//     * @return the q
//     */
//    public Q in(Object value) {
//        expression.in(value);
//        return typeExpression;
//    }
//
//    /**
//     * Nin.
//     *
//     * @param value the value
//     * @return the q
//     */
//    public Q ni(Object value) {
//        expression.ni(value);
//        return typeExpression;
//    }
//
//    /**
//     * Le.
//     *
//     * @param value the value
//     * @return the q
//     */
//    public Q le(Object value) {
//        expression.le(value);
//        return typeExpression;
//    }
//
//    /**
//     * Lt.
//     *
//     * @param value the value
//     * @return the q
//     */
//    public Q lt(Object value) {
//        expression.lt(value);
//        return typeExpression;
//    }
//
//    /**
//     * Ge.
//     *
//     * @param value the value
//     * @return the q
//     */
//    public Q ge(Object value) {
//        expression.ge(value);
//        return typeExpression;
//    }
//
//    /**
//     * Gt.
//     *
//     * @param value the value
//     * @return the q
//     */
//    public Q gt(Object value) {
//        expression.gt(value);
//        return typeExpression;
//    }
//
//    /**
//     * Sw.
//     *
//     * @param value the value
//     * @return the q
//     */
//    public Q sw(String value) {
//        expression.sw(value);
//        return typeExpression;
//    }
//
//    /**
//     * Co.
//     *
//     * @param value the value
//     * @return the q
//     */
//    public Q co(String value) {
//        expression.co(value);
//        return typeExpression;
//    }
//
//    /**
//     * Ew.
//     *
//     * @param value the value
//     * @return the q
//     */
//    public Q ew(String value) {
//        expression.ew(value);
//        return typeExpression;
//    }
//
//    /**
//     * Isn.
//     *
//     * @return the q
//     */
//    public Q isn() {
//        expression.isn();
//        return typeExpression;
//    }
//
//    /**
//     * Inn.
//     *
//     * @return the q
//     */
//    public Q inn() {
//        expression.inn();
//        return typeExpression;
//    }
//
//}