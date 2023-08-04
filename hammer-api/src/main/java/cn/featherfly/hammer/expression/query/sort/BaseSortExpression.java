package cn.featherfly.hammer.expression.query.sort;

import java.util.List;

import cn.featherfly.hammer.expression.condition.Expression;

/**
 * 基础排序构建接口.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface BaseSortExpression<S extends BaseSortExpression<S>> extends Expression {

    /**
     * 添加升序条件 .
     *
     * @param names 名称
     * @return this
     */
    S asc(String... names);

    /**
     * 添加升序条件 .
     *
     * @param names 名称
     * @return this
     */
    S asc(List<String> names);

    /**
     * 添加降序条件 .
     *
     * @param names 名称
     * @return this
     */
    S desc(String... names);

    /**
     * 添加降序条件 .
     *
     * @param names 名称
     * @return this
     */
    S desc(List<String> names);
}