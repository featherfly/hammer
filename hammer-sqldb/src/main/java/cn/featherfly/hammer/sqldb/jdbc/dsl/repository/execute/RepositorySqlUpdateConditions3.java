
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute;

import java.util.List;

import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup3;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic3;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlUpdateRelation;

/**
 * repository sql update conditions 3 .
 *
 * @author zhongj
 */
public class RepositorySqlUpdateConditions3 extends AbstractMulitiRepositorySqlExecutableConditionsGroup3<
    UpdateConditionConfig, RepositorySqlUpdateRelation, SqlUpdateSetBasicBuilder> {

    /**
     * Instantiates a new repository sql update conditions 3.
     *
     * @param updateRelation the update relation
     */
    public RepositorySqlUpdateConditions3(RepositorySqlUpdateRelation updateRelation) {
        this(null, updateRelation);
    }

    /**
     * @param parent         the parent
     * @param updateRelation the update relation
     */
    RepositorySqlUpdateConditions3(RepositoryExecutableConditionsGroupLogic3<UpdateConditionConfig> parent,
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
    protected RepositoryExecutableConditionsGroup3<UpdateConditionConfig> createGroup(
        RepositoryExecutableConditionsGroupLogic3<UpdateConditionConfig> parent) {
        return new RepositorySqlUpdateConditions3(this, repositoryRelation);
    }
}
