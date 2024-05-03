
package cn.featherfly.hammer.sqldb.dsl.repository.execute;

import java.util.List;

import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup2;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic2;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlUpdateRelation;

/**
 * repository sql update conditions 2 .
 *
 * @author zhongj
 */
public class RepositorySqlUpdateConditions2 extends AbstractMulitiRepositorySqlExecutableConditionsGroup2<
    UpdateConditionConfig, RepositorySqlUpdateRelation, SqlUpdateSetBasicBuilder> {

    /**
     * Instantiates a new repository sql update conditions 2.
     *
     * @param updateRelation the update relation
     */
    public RepositorySqlUpdateConditions2(RepositorySqlUpdateRelation updateRelation) {
        this(null, updateRelation);
    }

    /**
     * @param parent         the parent
     * @param updateRelation the update relation
     */
    RepositorySqlUpdateConditions2(RepositoryExecutableConditionsGroupLogic2<UpdateConditionConfig> parent,
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
    protected RepositoryExecutableConditionsGroup2<UpdateConditionConfig> createGroup(
        RepositoryExecutableConditionsGroupLogic2<UpdateConditionConfig> parent) {
        return new RepositorySqlUpdateConditions2(this, repositoryRelation);
    }
}
