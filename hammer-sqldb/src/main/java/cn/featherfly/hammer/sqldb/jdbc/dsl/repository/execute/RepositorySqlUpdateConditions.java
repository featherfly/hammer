
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute;

import java.util.ArrayList;
import java.util.List;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlUpdateRelation;

/**
 * repository sql update conditions .
 *
 * @author zhongj
 */
public class RepositorySqlUpdateConditions extends AbstractMulitiRepositorySqlExecutableConditionsGroup<
    UpdateConditionConfig, RepositorySqlUpdateRelation, SqlUpdateSetBasicBuilder> {

    /**
     * Instantiates a new repository sql update conditions.
     *
     * @param updateRelation the update relation
     */
    public RepositorySqlUpdateConditions(RepositorySqlUpdateRelation updateRelation) {
        this(null, updateRelation);
    }

    /**
     * Instantiates a new repository sql update conditions.
     *
     * @param parent         the parent
     * @param updateRelation the update relation
     */
    RepositorySqlUpdateConditions(RepositoryExecutableConditionsGroupLogic<UpdateConditionConfig> parent,
        RepositorySqlUpdateRelation updateRelation) {
        super(parent, 0, updateRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryExecutableConditionsGroup<UpdateConditionConfig> createGroup(
        RepositoryExecutableConditionsGroupLogic<UpdateConditionConfig> parent) {
        return new RepositorySqlUpdateConditions(this, repositoryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return expression(super.expression(), parent, repositoryRelation, conditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Object> getParams() {
        return getParams(parent, repositoryRelation, super.getParams());
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
    static String expression(String condition, LogicExpression<?, ?> parent, RepositorySqlUpdateRelation relation,
        UpdateConditionConfig conditionConfig) {
        if (parent == null) {
            if (Lang.isEmpty(condition)) {
                switch (conditionConfig.getEmptyConditionStrategy()) {
                    case EXCEPTION:
                        throw new SqldbHammerException("empty condition for update");
                    case NON_EXECUTION:
                        return null;
                    case EXECUTION:
                        return relation.getBuilder().build();
                    default:
                        return relation.getBuilder().build();
                }
            } else {
                try {
                    return relation.getBuilder().build() + Chars.SPACE
                        + relation.getJdbc().getDialect().getKeywords().where() + Chars.SPACE + condition;
                } catch (JdbcException e) {
                    // no value to set, use NON_EXECUTION strategy
                    return null;
                }
            }
        } else {
            return condition;
        }
    }

    /**
     * Gets the params.
     *
     * @param parent      the parent
     * @param relation    the relation
     * @param superParams the super params
     * @return the params
     */
    static List<Object> getParams(LogicExpression<?, ?> parent, RepositorySqlUpdateRelation relation,
        List<Object> superParams) {
        List<Object> params = new ArrayList<>();
        if (parent == null) {
            params.addAll(relation.getBuilder().getParams());
        }
        params.addAll(superParams);
        return params;
    }
}
