
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
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlUpdateRelation;

/**
 * SqlDeleteExpression .
 *
 * @author zhongj
 */
public class SqlUpdateExpression extends SqlExecutableConditionGroupExpression<UpdateConditionConfig,
        RepositorySqlUpdateRelation, SqlUpdateSetBasicBuilder> {

    private SqlUpdateSetBasicBuilder builder;

    /**
     * Instantiates a new sql update expression.
     *
     * @param jdbc                  the jdbc
     * @param builder               the builder
     * @param updateRelation        the update relation
     * @param updateConditionConfig the update condition config
     */
    public SqlUpdateExpression(Jdbc jdbc, SqlUpdateSetBasicBuilder builder, RepositorySqlUpdateRelation updateRelation,
            UpdateConditionConfig updateConditionConfig) {
        this(null, jdbc, builder, builder.getAlias(), updateRelation, updateConditionConfig);
    }

    /**
     * Instantiates a new sql update expression.
     *
     * @param parent                the parent
     * @param jdbc                  the jdbc
     * @param builder               the builder
     * @param tableAlias            the table alias
     * @param updateRelation        the update relation
     * @param updateConditionConfig the update condition config
     */
    SqlUpdateExpression(RepositoryExecutableConditionsGroupLogic<UpdateConditionConfig> parent, Jdbc jdbc,
            SqlUpdateSetBasicBuilder builder, String tableAlias, RepositorySqlUpdateRelation updateRelation,
            UpdateConditionConfig updateConditionConfig) {
        super(parent, jdbc, tableAlias, updateRelation, updateConditionConfig);
        this.builder = builder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected RepositoryExecutableConditionsGroup<UpdateConditionConfig> createGroup(
            RepositoryExecutableConditionsGroupLogic<UpdateConditionConfig> parent) {
        return new SqlUpdateExpression(this, jdbc, builder, getRepositoryAlias(), repositoryRelation, conditionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        String condition = super.expression();
        if (parent == null) {
            if (Lang.isEmpty(condition)) {
                switch (conditionConfig.getEmptyConditionStrategy()) {
                    case EXCEPTION:
                        throw new SqldbHammerException("empty condition for update");
                    case NON_EXECUTION:
                        return null;
                    case EXECUTION:
                        return builder.build();
                    default:
                        return builder.build();
                }
            } else {
                try {
                    return builder.build() + Chars.SPACE + jdbc.getDialect().getKeywords().where() + Chars.SPACE
                            + condition;
                } catch (JdbcException e) {
                    // no value to set, use NON_EXECUTION strategy
                    return null;
                }
            }
        } else {
            return condition;
        }

        //        String condition = super.build();
        //        if (Strings.isEmpty(condition)) {
        //            return builder.build();
        //        } else {
        //            return builder.build() + Chars.SPACE + jdbc.getDialect().getKeywords().where() + Chars.SPACE + condition;
        //        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Object> getParams() {
        List<Object> params = new ArrayList<>();
        if (parent == null) {
            params.addAll(builder.getParams());
        }
        params.addAll(super.getParams());
        return params;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public ObjectFieldExpression<ExecutableConditionGroup<UpdateConditionConfig>,
    //            ExecutableConditionGroupLogic<UpdateConditionConfig>> field(String name) {
    //        return new ObjectFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public StringFieldExpression<ExecutableConditionGroup<UpdateConditionConfig>,
    //            ExecutableConditionGroupLogic<UpdateConditionConfig>> fieldAsString(String name) {
    //        return new StringFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> NumberFieldExpression<N, ExecutableConditionGroup<UpdateConditionConfig>,
    //            ExecutableConditionGroupLogic<UpdateConditionConfig>> fieldAsNumber(String name) {
    //        return new NumberFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R extends Enum<R>> EnumFieldExpression<R, ExecutableConditionGroup<UpdateConditionConfig>,
    //            ExecutableConditionGroupLogic<UpdateConditionConfig>> fieldAsEnum(String name) {
    //        return new EnumFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> DateFieldExpression<D, ExecutableConditionGroup<UpdateConditionConfig>,
    //            ExecutableConditionGroupLogic<UpdateConditionConfig>> fieldAsDate(String name) {
    //        return new DateFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public LocalDateFieldExpression<ExecutableConditionGroup<UpdateConditionConfig>,
    //            ExecutableConditionGroupLogic<UpdateConditionConfig>> fieldAsLocalDate(String name) {
    //        return new LocalDateFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public LocalDateTimeFieldExpression<ExecutableConditionGroup<UpdateConditionConfig>,
    //            ExecutableConditionGroupLogic<UpdateConditionConfig>> fieldAsLocalDateTime(String name) {
    //        return new LocalDateTimeFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public LocalTimeFieldExpression<ExecutableConditionGroup<UpdateConditionConfig>,
    //            ExecutableConditionGroupLogic<UpdateConditionConfig>> fieldAsLocalTime(String name) {
    //        return new LocalTimeFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    //    }
}
