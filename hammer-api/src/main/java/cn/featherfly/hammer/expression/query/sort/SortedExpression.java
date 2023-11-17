package cn.featherfly.hammer.expression.query.sort;

/**
 * sorted expression. mean invoke asc(desc) once.
 * 已排序排序构建接口，代表已经调用过至少一次asc（desc）方法.
 *
 * @author zhongj
 * @param <S> the SortedExpression type
 */
public interface SortedExpression<S extends SortedExpression<S>> extends SortExpression<S> {

}