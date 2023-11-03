//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.type;
//
//import cn.featherfly.hammer.dsl.query.QueryConditionsGroupExpression;
//import cn.featherfly.hammer.dsl.query.QueryConditionsGroupLogicExpression;
//import cn.featherfly.hammer.expression.condition.field.NumberFieldExpression;
//
///**
// * TypeNumberExpression .
// *
// * @author zhongj
// * @param <E> the element type
// * @param <Q> the generic type
// */
//public class StaticTypeNumberExpression<N extends Number, E, Q extends StaticTypeQueryConditionGroupExpression<E, Q>> {
//
//    /** The expression. */
//    private NumberFieldExpression<N, QueryConditionsGroupExpression, QueryConditionsGroupLogicExpression> expression;
//
//    /** The type expression. */
//    private Q typeExpression;
//
//    /**
//     * Instantiates a new type number expression.
//     *
//     * @param expression     the expression
//     * @param typeExpression the type expression
//     */
//    public StaticTypeNumberExpression(
//            NumberFieldExpression<N, QueryConditionsGroupExpression, QueryConditionsGroupLogicExpression> expression,
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
//    public Q eq(N value) {
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
//    public Q ne(N value) {
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
//    public Q in(N value) {
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
//    public Q ni(N value) {
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
//    public Q le(N value) {
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
//    public Q lt(N value) {
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
//    public Q ge(N value) {
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
//    public Q gt(N value) {
//        expression.gt(value);
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
//}
