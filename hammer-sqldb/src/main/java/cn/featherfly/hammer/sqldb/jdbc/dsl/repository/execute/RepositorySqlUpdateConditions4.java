
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute;

import java.util.List;

import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup4;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic4;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlUpdateRelation;

/**
 * repository sql update conditions 4 .
 *
 * @author zhongj
 */
public class RepositorySqlUpdateConditions4 extends AbstractMulitiRepositorySqlExecutableConditionsGroup4<
    UpdateConditionConfig, RepositorySqlUpdateRelation, SqlUpdateSetBasicBuilder> {

    /**
     * Instantiates a new repository sql update conditions 4.
     *
     * @param updateRelation the update relation
     */
    public RepositorySqlUpdateConditions4(RepositorySqlUpdateRelation updateRelation) {
        this(null, updateRelation);
    }

    /**
     * @param parent         the parent
     * @param updateRelation the update relation
     */
    RepositorySqlUpdateConditions4(RepositoryExecutableConditionsGroupLogic4<UpdateConditionConfig> parent,
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
    protected RepositoryExecutableConditionsGroup4<UpdateConditionConfig> createGroup(
        RepositoryExecutableConditionsGroupLogic4<UpdateConditionConfig> parent) {
        return new RepositorySqlUpdateConditions4(this, repositoryRelation);
    }
}
