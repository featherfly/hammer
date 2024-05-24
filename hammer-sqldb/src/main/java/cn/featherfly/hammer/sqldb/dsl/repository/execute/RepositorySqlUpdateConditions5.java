
package cn.featherfly.hammer.sqldb.dsl.repository.execute;

import java.io.Serializable;
import java.util.List;

import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup5;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic5;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlUpdateRelation;

/**
 * repository sql update conditions 5 .
 *
 * @author zhongj
 */
public class RepositorySqlUpdateConditions5 extends AbstractMulitiRepositorySqlExecutableConditionsGroup5<
    UpdateConditionConfig, RepositorySqlUpdateRelation, SqlUpdateSetBasicBuilder> {

    /**
     * Instantiates a new repository sql update conditions 5.
     *
     * @param updateRelation the update relation
     */
    public RepositorySqlUpdateConditions5(RepositorySqlUpdateRelation updateRelation) {
        this(null, updateRelation);
    }

    /**
     * @param parent the parent
     * @param updateRelation the update relation
     */
    RepositorySqlUpdateConditions5(RepositoryExecutableConditionsGroupLogic5<UpdateConditionConfig> parent,
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
    public List<Serializable> getParams() {
        return RepositorySqlUpdateConditions.getParams(parent, repositoryRelation, super.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryExecutableConditionsGroup5<UpdateConditionConfig> createGroup(
        RepositoryExecutableConditionsGroupLogic5<UpdateConditionConfig> parent) {
        return new RepositorySqlUpdateConditions5(this, repositoryRelation);
    }
}
