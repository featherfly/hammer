/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 18:27:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl;

import java.util.function.Consumer;

import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.dsl.query.relation.OnFieldBuilder;
import cn.featherfly.hammer.dsl.query.relation.OnFieldBuilderImpl;

/**
 * on expression.
 *
 * @author zhongj
 * @param <O> on result type
 */
public interface OnExpression<O> {
    // TODO 后续来加入其他方式

    /**
     * on.
     *
     * @param consumer the consumer
     * @return QueryRelate
     */
    default O on(Consumer<OnFieldBuilder> consumer) {
        OnFieldBuilderImpl onFields = new OnFieldBuilderImpl();
        consumer.accept(onFields);
        return on(onFields.getJoinField(), onFields.getSourceField());
    }

    /**
     * on.
     *
     * @param joinRepositoryField the join repository field name (use repository
     *                            name with method argu join(repository))
     * @return QueryRelate
     */
    default O on(String joinRepositoryField) {
        return on(joinRepositoryField, null);
    }

    /**
     * on.
     *
     * @param joinRepositoryField the join repository field name (use repository
     *                            name with method argu join(repository))
     * @return QueryRelate
     */
    default O on(Field joinRepositoryField) {
        return on(joinRepositoryField.name());
    }

    /**
     * on.
     *
     * @param joinRepositoryField   the join repository field name (use
     *                              repository name with method argu
     *                              join(repository))
     * @param sourceRepositoryField the join from repository field name
     * @return QueryRelate
     */
    O on(String joinRepositoryField, String sourceRepositoryField);

    /**
     * on.
     *
     * @param joinRepositoryField   the join repository field name (use
     *                              repository name with method argu
     *                              join(repository))
     * @param sourceRepositoryField the join from repository field name
     * @return QueryRelate
     */
    default O on(Field joinRepositoryField, Field sourceRepositoryField) {
        return on(joinRepositoryField.name(), sourceRepositoryField.name());
    }
}
