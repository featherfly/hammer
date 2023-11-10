package cn.featherfly.hammer.expression.query.sort;

/**
 * sorted expression3. mean invoke asc(desc) once.
 * 已排序排序构建接口，代表已经调用过至少一次asc（desc）方法.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortedExpression3<S extends SortedExpression3<S>> extends SortedExpression<S>, SortExpression3<S> {

}