
package cn.featherfly.hammer.sqldb.dsl.repository.execute;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.function.FourArgusFunction;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression4;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup4;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic4;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableUpdate4;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdate5;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdateNumberValueImpl;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdateValueImpl;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.execute.UpdateNumberValueExpression;
import cn.featherfly.hammer.expression.execute.UpdateValueExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.execute.RepositoryUpdateExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlOn4;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlUpdateRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * repository sql executable update4 .
 *
 * @author zhongj
 */
public class RepositorySqlExecutableUpdate4 implements RepositorySqlUpdate4, RepositoryExecutableUpdate4 {

    protected RepositorySqlExecutableUpdate update;

    /**
     * Instantiates a new repository sql executable update 4.
     *
     * @param update the update
     */
    public RepositorySqlExecutableUpdate4(RepositorySqlExecutableUpdate update) {
        this.update = update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> RepositorySqlExecutableUpdate4 set(String name, V value) {
        update.set(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> RepositorySqlExecutableUpdate4 set(String name, V value, Predicate<V> ignoreStrategy) {
        update.set(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositorySqlExecutableUpdate4 set(SerializableFunction<T, R> name, R value) {
        update.set(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositorySqlExecutableUpdate4 set(SerializableFunction<T, R> name, R value,
        Predicate<R> ignoreStrategy) {
        update.set(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> RepositorySqlExecutableUpdate4 set(SerializableSupplier<R> property) {
        update.set(property);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> RepositorySqlExecutableUpdate4 set(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        update.set(property, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySqlExecutableUpdate4 set(Consumer<RepositoryExecutableUpdate4> consumer) {
        if (consumer != null) {
            consumer.accept(this);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate4 increase(String name, N value) {
        update.increase(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> RepositorySqlExecutableUpdate4 increase(SerializableFunction<T, N> name, N value,
        Predicate<N> ignoreStrategy) {
        update.increase(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate4 increase(String name, N value,
        Predicate<N> ignoreStrategy) {
        update.increase(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> RepositorySqlExecutableUpdate4 increase(SerializableFunction<T, R> name, R value) {
        update.increase(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate4 increase(SerializableNumberSupplier<N> property) {
        update.increase(property);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate4 increase(SerializableNumberSupplier<N> property,
        Predicate<N> ignoreStrategy) {
        update.increase(property, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateValueExpression<Serializable, RepositoryExecutableUpdate4,
        RepositoryExecutableConditionsGroup4<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic4<UpdateConditionConfig>> field(String name) {
        return new RepositoryUpdateValueImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateNumberValueExpression<Number, RepositoryExecutableUpdate4,
        RepositoryExecutableConditionsGroup4<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic4<UpdateConditionConfig>> fieldAsNumber(String name) {
        return new RepositoryUpdateNumberValueImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
        R extends Serializable> UpdateValueExpression<R, RepositoryExecutableUpdate4,
            RepositoryExecutableConditionsGroup4<UpdateConditionConfig>,
            RepositoryExecutableConditionsGroupLogic4<UpdateConditionConfig>> field(SerializableFunction<T, R> name) {
        return new RepositoryUpdateValueImpl<>(LambdaUtils.getLambdaPropertyName(name), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
        R extends Number> UpdateNumberValueExpression<R, RepositoryExecutableUpdate4,
            RepositoryExecutableConditionsGroup4<UpdateConditionConfig>,
            RepositoryExecutableConditionsGroupLogic4<UpdateConditionConfig>> fieldAsNumber(
                SerializableFunction<T, R> name) {
        return new RepositoryUpdateNumberValueImpl<>(LambdaUtils.getLambdaPropertyName(name), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroup4<UpdateConditionConfig> where() {
        return new RepositorySqlUpdateConditions4(update.updateRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroupLogic4<UpdateConditionConfig> where(
        FourArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            RepositoryFieldOnlyExpression, LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        RepositorySqlUpdateConditions4 sqlUpdateExpression = new RepositorySqlUpdateConditions4(update.updateRelation);
        if (repositoriesCondtionFuntion != null) {
            //filterable.apply(sqlUpdateExpression);
            sqlUpdateExpression.addCondition(
                repositoriesCondtionFuntion.apply(new RepositoryFieldOnlyExpressionImpl<>(0, update.updateRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(1, update.updateRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(2, update.updateRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(3, update.updateRelation) //
                ));
        }
        return sqlUpdateExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryUpdateExpression<RepositoryExecutableUpdate4,
        RepositoryExecutableConditionsGroup4<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic4<UpdateConditionConfig>> configure(Consumer<UpdateConfig> configure) {
        if (configure != null) {
            configure.accept(update.updateRelation.getConfig());
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        return update.execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryOnExpression4<RepositoryUpdate5> join(Repository repository) {
        return new RepositorySqlOn4<RepositoryUpdate5, UpdateConditionConfig, RepositorySqlUpdateRelation,
            SqlUpdateSetBasicBuilder>(repository, new RepositorySqlExecutableUpdate5(update), update.updateRelation);
    }
}
