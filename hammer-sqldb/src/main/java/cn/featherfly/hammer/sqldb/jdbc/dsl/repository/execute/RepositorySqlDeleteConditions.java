
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlDeleteRelation;

/**
 * The Class RepositorySqlDeleteExpression.
 *
 * @author zhongj
 */
public class RepositorySqlDeleteConditions extends AbstractMulitiRepositorySqlExecutableConditionsGroup<
    DeleteConditionConfig, RepositorySqlDeleteRelation, SqlDeleteFromBasicBuilder> {

    /**
     * Instantiates a new repository sql delete expression.
     *
     * @param deleteRelation the delete relation
     */
    public RepositorySqlDeleteConditions(RepositorySqlDeleteRelation deleteRelation) {
        this(null, deleteRelation);
    }

    /**
     * Instantiates a new repository sql delete expression.
     *
     * @param parent         the parent
     * @param deleteRelatoin the delete relatoin
     */
    RepositorySqlDeleteConditions(RepositoryExecutableConditionsGroupLogic<DeleteConditionConfig> parent,
        RepositorySqlDeleteRelation deleteRelatoin) {
        super(parent, 0, deleteRelatoin);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryExecutableConditionsGroup<DeleteConditionConfig> createGroup(
        RepositoryExecutableConditionsGroupLogic<DeleteConditionConfig> parent) {
        return new RepositorySqlDeleteConditions(parent, repositoryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return RepositorySqlDeleteConditions.expression(super.expression(), parent, repositoryRelation,
            conditionConfig);
    }

    /**
     * Expression.
     *
     * @param condition       the condition
     * @param parent          the parent
     * @param relation        the relation
     * @param conditionConfig the condition config
     * @return the string
     */
    static String expression(String condition, LogicExpression<?, ?> parent, RepositorySqlDeleteRelation relation,
        DeleteConditionConfig conditionConfig) {
        // TODO 后续加入设置参数，是否允许无条件筛选参数的删除操作（因为无条件帅选参数删除是危险操作），默认为不允许
        // 当前没有参数返回的0
        if (parent == null) {
            if (Lang.isEmpty(condition)) {
                switch (conditionConfig.getEmptyConditionStrategy()) {
                    case EXCEPTION:
                        throw new SqldbHammerException("empty condition");
                    case NON_EXECUTION:
                        return null;
                    case EXECUTION:
                        return relation.getBuilder().build();
                    default:
                        return relation.getBuilder().build();
                }
            } else {
                return relation.getBuilder().build() + Chars.SPACE
                    + relation.getJdbc().getDialect().getKeywords().where() + Chars.SPACE + condition;
            }
        } else {
            return condition;
        }
    }
}
