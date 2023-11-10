
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Queryable.java
 * @Package cn.featherfly.hammer.expression.api.entity
 * @Description: Queryable
 * @author: zhongj
 * @date: 2023-05-31 17:45:31
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

/**
 * Queryable.
 *
 * @author zhongj
 */
//TODO 后续group by 的表达式也是在这里定义 extends Sortable, Groupbyable
public interface Queryable<S> extends Sortable<S> {

}
