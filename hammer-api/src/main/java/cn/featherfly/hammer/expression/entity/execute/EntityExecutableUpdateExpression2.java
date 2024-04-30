
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * EntityExecutableUpdateExpression2.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 * @param <U>  update expressoin
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityExecutableUpdateExpression2<E, J1, U extends EntityExecutableUpdateExpression2<E, J1, U, C, L>,
    C extends EntityExecutableConditionGroupExpression2<E, J1, C, L, UpdateConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression2<E, J1, C, L, UpdateConditionConfig>>
    extends EntityUpdateExpression<E, U, C, L>, EntityPropertyExecutableUpdateExpression2<E, J1, U, C, L>,
    EntityExecutableUpdateSetExpression2<E, J1, U, C, L> {
    // YUFEI_TODO 后续来加入多实体更新
    //    /**
    //     * Sets the.
    //     *
    //     * @param consumer the consumer
    //     * @return the u
    //     */
    //    U set(BiConsumer<RepositoryExecutableUpdateExpression<?, ?, ?>,
    //        RepositoryExecutableUpdateExpression<?, ?, ?>> consumer);
    //    default void a() {
    //        RepositoryExecutableUpdateExpression2<?, ?, ?> a = null;
    //        a.set((r1, r2) -> {
    //            r1.set("name", "yufei").increase("age", 1);
    //            r2.set("username", "yufei").increase("acount", 1);
    //        });
    //    }
}
