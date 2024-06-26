//
// package cn.featherfly.hammer.sqldb.dsl.type;
//
// import java.util.Date;
//
// import cn.featherfly.hammer.dsl.query.QueryConditionsGroupExpression;
// import cn.featherfly.hammer.dsl.query.QueryConditionsGroupLogicExpression;
// import cn.featherfly.hammer.expression.condition.field.DateFieldExpression;
//
/// **
// * TypeDateExpression .
// *
// * @author zhongj
// * @param <E> the element type
// * @param <Q> the generic type
// */
// public class StaticTypeDateExpression<E, D extends Date, Q extends StaticTypeQueryConditionGroupExpression<E, Q>> {
//
// /** The expression. */
// private DateFieldExpression<D, QueryConditionsGroupExpression, QueryConditionsGroupLogicExpression> expression;
//
// /** The type expression. */
// private Q typeExpression;
//
// /**
// * Instantiates a new type date expression.
// *
// * @param expression the expression
// * @param typeExpression the type expression
// */
// public StaticTypeDateExpression(
// DateFieldExpression<D, QueryConditionsGroupExpression, QueryConditionsGroupLogicExpression> expression,
// Q typeExpression) {
// super();
// this.expression = expression;
// this.typeExpression = typeExpression;
// }
//
// /**
// * Eq.
// *
// * @param value the value
// * @return the q
// */
// public Q eq(D value) {
// expression.eq(value);
// return typeExpression;
// }
//
// /**
// * Ne.
// *
// * @param value the value
// * @return the q
// */
// public Q ne(D value) {
// expression.ne(value);
// return typeExpression;
// }
//
// /**
// * In.
// *
// * @param value the value
// * @return the q
// */
// public Q in(D value) {
// expression.in(value);
// return typeExpression;
// }
//
// /**
// * Nin.
// *
// * @param value the value
// * @return the q
// */
// public Q ni(D value) {
// expression.ni(value);
// return typeExpression;
// }
//
// /**
// * Le.
// *
// * @param value the value
// * @return the q
// */
// public Q le(D value) {
// expression.le(value);
// return typeExpression;
// }
//
// /**
// * Lt.
// *
// * @param value the value
// * @return the q
// */
// public Q lt(D value) {
// expression.lt(value);
// return typeExpression;
// }
//
// /**
// * Ge.
// *
// * @param value the value
// * @return the q
// */
// public Q ge(D value) {
// expression.ge(value);
// return typeExpression;
// }
//
// /**
// * Gt.
// *
// * @param value the value
// * @return the q
// */
// public Q gt(D value) {
// expression.gt(value);
// return typeExpression;
// }
//
// /**
// * Isn.
// *
// * @return the q
// */
// public Q isn() {
// expression.isn();
// return typeExpression;
// }
//
// /**
// * Inn.
// *
// * @return the q
// */
// public Q inn() {
// expression.inn();
// return typeExpression;
// }
// }