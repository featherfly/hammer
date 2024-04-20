
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.execute;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlDeleteFromBasicBuilder;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.repository.execute.ExecutableConditionGroup;
import cn.featherfly.hammer.dsl.repository.execute.ExecutableConditionGroupLogic;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlDeleteRelation;

/**
 * SqlDeleteExpression .
 *
 * @author zhongj
 */
public class SqlDeleteExpression extends SqlExecutableConditionGroupExpression<DeleteConditionConfig,
        RepositorySqlDeleteRelation, SqlDeleteFromBasicBuilder> {

    private SqlDeleteFromBasicBuilder builder;

    /**
     * Instantiates a new sql delete expression.
     *
     * @param jdbc                  the jdbc
     * @param builder               the builder
     * @param deleteRelation        the delete relation
     * @param deleteConditionConfig the delete condition config
     */
    public SqlDeleteExpression(Jdbc jdbc, SqlDeleteFromBasicBuilder builder, RepositorySqlDeleteRelation deleteRelation,
            DeleteConditionConfig deleteConditionConfig) {
        this(null, jdbc, builder, builder.getTableAlias(), deleteRelation, deleteConditionConfig);
    }

    /**
     * Instantiates a new sql delete expression.
     *
     * @param parent                the parent
     * @param jdbc                  the jdbc
     * @param builder               the builder
     * @param tableAlias            the table alias
     * @param deleteRelation        the delete relation
     * @param deleteConditionConfig the delete condition config
     */
    SqlDeleteExpression(ExecutableConditionGroupLogic<DeleteConditionConfig> parent, Jdbc jdbc,
            SqlDeleteFromBasicBuilder builder, String tableAlias, RepositorySqlDeleteRelation deleteRelation,
            DeleteConditionConfig deleteConditionConfig) {
        super(parent, jdbc, tableAlias, deleteRelation, deleteConditionConfig);
        this.builder = builder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ExecutableConditionGroup<DeleteConditionConfig> createGroup(
            ExecutableConditionGroupLogic<DeleteConditionConfig> parent) {
        return new SqlDeleteExpression(this, jdbc, builder, getRepositoryAlias(), repositoryRelation, conditionConfig);
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
                        throw new SqldbHammerException("empty condition for delete");
                    case NON_EXECUTION:
                        return null;
                    case EXECUTION:
                        return builder.build();
                    default:
                        return builder.build();
                }
            } else {
                return builder.build() + Chars.SPACE + jdbc.getDialect().getKeywords().where() + Chars.SPACE
                        + condition;
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

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public ObjectFieldExpression<ExecutableConditionGroup<DeleteConditionConfig>,
    //            ExecutableConditionGroupLogic<DeleteConditionConfig>> field(String name) {
    //        return new ObjectFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public StringFieldExpression<ExecutableConditionGroup<DeleteConditionConfig>,
    //            ExecutableConditionGroupLogic<DeleteConditionConfig>> fieldAsString(String name) {
    //        return new StringFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> NumberFieldExpression<N, ExecutableConditionGroup<DeleteConditionConfig>,
    //            ExecutableConditionGroupLogic<DeleteConditionConfig>> fieldAsNumber(String name) {
    //        return new NumberFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> DateFieldExpression<D, ExecutableConditionGroup<DeleteConditionConfig>,
    //            ExecutableConditionGroupLogic<DeleteConditionConfig>> fieldAsDate(String name) {
    //        return new DateFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R extends Enum<R>> EnumFieldExpression<R, ExecutableConditionGroup<DeleteConditionConfig>,
    //            ExecutableConditionGroupLogic<DeleteConditionConfig>> fieldAsEnum(String name) {
    //        return new EnumFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public LocalDateFieldExpression<ExecutableConditionGroup<DeleteConditionConfig>,
    //            ExecutableConditionGroupLogic<DeleteConditionConfig>> fieldAsLocalDate(String name) {
    //        return new LocalDateFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public LocalDateTimeFieldExpression<ExecutableConditionGroup<DeleteConditionConfig>,
    //            ExecutableConditionGroupLogic<DeleteConditionConfig>> fieldAsLocalDateTime(String name) {
    //        return new LocalDateTimeFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public LocalTimeFieldExpression<ExecutableConditionGroup<DeleteConditionConfig>,
    //            ExecutableConditionGroupLogic<DeleteConditionConfig>> fieldAsLocalTime(String name) {
    //        return new LocalTimeFieldExpressionMulitiRepositoryImpl<>(0, name, this);
    //    }
}
