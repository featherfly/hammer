
package cn.featherfly.hammer.sqldb.dsl.repository.execute;

import java.util.List;

import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup6;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic6;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlUpdateRelation;

/**
 * repository sql update conditions 6 .
 *
 * @author zhongj
 */
public class RepositorySqlUpdateConditions6 extends AbstractMulitiRepositorySqlExecutableConditionsGroup6<
    UpdateConditionConfig, RepositorySqlUpdateRelation, SqlUpdateSetBasicBuilder> {

    /**
     * Instantiates a new repository sql update conditions 6.
     *
     * @param updateRelation the update relation
     */
    public RepositorySqlUpdateConditions6(RepositorySqlUpdateRelation updateRelation) {
        this(null, updateRelation);
    }

    /**
     * @param parent         the parent
     * @param updateRelation the update relation
     */
    RepositorySqlUpdateConditions6(RepositoryExecutableConditionsGroupLogic6<UpdateConditionConfig> parent,
        RepositorySqlUpdateRelation updateRelation) {
        super(parent, 0, updateRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return RepositorySqlUpdateConditions.expression(super.expression(), parent, repositoryRelation,
            conditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Object> getParams() {
        return RepositorySqlUpdateConditions.getParams(parent, repositoryRelation, super.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryExecutableConditionsGroup6<UpdateConditionConfig> createGroup(
        RepositoryExecutableConditionsGroupLogic6<UpdateConditionConfig> parent) {
        return new RepositorySqlUpdateConditions6(this, repositoryRelation);
    }
}
