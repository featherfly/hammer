
package cn.featherfly.hammer.sqldb.dsl.repository.execute;

import java.io.Serializable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression2;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup2;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic2;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableUpdate2;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdate3;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdateNumberValueImpl;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdateValueImpl;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.execute.UpdateNumberValueExpression;
import cn.featherfly.hammer.expression.execute.UpdateValueExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.execute.RepositoryUpdateExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlOn2;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlUpdateRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * repository sql executable update2 .
 *
 * @author zhongj
 */
public class RepositorySqlExecutableUpdate2 implements RepositorySqlUpdate2, RepositoryExecutableUpdate2 {

    protected RepositorySqlExecutableUpdate update;

    /**
     * Instantiates a new repository sql executable update 2.
     *
     * @param update the update
     */
    public RepositorySqlExecutableUpdate2(RepositorySqlExecutableUpdate update) {
        this.update = update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> RepositorySqlExecutableUpdate2 set(String name, V value) {
        update.set(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> RepositorySqlExecutableUpdate2 set(String name, V value, Predicate<V> ignoreStrategy) {
        update.set(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositorySqlExecutableUpdate2 set(SerializableFunction<T, R> name, R value) {
        update.set(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositorySqlExecutableUpdate2 set(SerializableFunction<T, R> name, R value,
        Predicate<R> ignoreStrategy) {
        update.set(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> RepositorySqlExecutableUpdate2 set(SerializableSupplier<R> property) {
        update.set(property);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> RepositorySqlExecutableUpdate2 set(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        update.set(property, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySqlExecutableUpdate2 set(Consumer<RepositoryExecutableUpdate2> consumer) {
        if (consumer != null) {
            consumer.accept(this);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate2 increase(String name, N value) {
        update.increase(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> RepositorySqlExecutableUpdate2 increase(SerializableFunction<T, N> name, N value,
        Predicate<N> ignoreStrategy) {
        update.increase(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate2 increase(String name, N value,
        Predicate<N> ignoreStrategy) {
        update.increase(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> RepositorySqlExecutableUpdate2 increase(SerializableFunction<T, R> name, R value) {
        update.increase(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate2 increase(SerializableNumberSupplier<N> property) {
        update.increase(property);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate2 increase(SerializableNumberSupplier<N> property,
        Predicate<N> ignoreStrategy) {
        update.increase(property, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateValueExpression<Serializable, RepositoryExecutableUpdate2,
        RepositoryExecutableConditionsGroup2<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic2<UpdateConditionConfig>> field(String name) {
        return new RepositoryUpdateValueImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateNumberValueExpression<Number, RepositoryExecutableUpdate2,
        RepositoryExecutableConditionsGroup2<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic2<UpdateConditionConfig>> fieldAsNumber(String name) {
        return new RepositoryUpdateNumberValueImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
        R extends Serializable> UpdateValueExpression<R, RepositoryExecutableUpdate2,
            RepositoryExecutableConditionsGroup2<UpdateConditionConfig>,
            RepositoryExecutableConditionsGroupLogic2<UpdateConditionConfig>> field(SerializableFunction<T, R> name) {
        return new RepositoryUpdateValueImpl<>(LambdaUtils.getLambdaPropertyName(name), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
        R extends Number> UpdateNumberValueExpression<R, RepositoryExecutableUpdate2,
            RepositoryExecutableConditionsGroup2<UpdateConditionConfig>,
            RepositoryExecutableConditionsGroupLogic2<UpdateConditionConfig>> fieldAsNumber(
                SerializableFunction<T, R> name) {
        return new RepositoryUpdateNumberValueImpl<>(LambdaUtils.getLambdaPropertyName(name), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroup2<UpdateConditionConfig> where() {
        return new RepositorySqlUpdateConditions2(update.updateRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroupLogic2<UpdateConditionConfig> where(
        BiFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        RepositorySqlUpdateConditions2 sqlUpdateExpression = new RepositorySqlUpdateConditions2(update.updateRelation);
        if (repositoriesCondtionFuntion != null) {
            //filterable.apply(sqlUpdateExpression);
            sqlUpdateExpression.addCondition(
                repositoriesCondtionFuntion.apply(new RepositoryFieldOnlyExpressionImpl<>(0, update.updateRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(1, update.updateRelation) //
                ));
        }
        return sqlUpdateExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryUpdateExpression<RepositoryExecutableUpdate2,
        RepositoryExecutableConditionsGroup2<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic2<UpdateConditionConfig>> configure(Consumer<UpdateConfig> configure) {
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
    public RepositoryOnExpression2<RepositoryUpdate3> join(Repository repository) {
        return new RepositorySqlOn2<RepositoryUpdate3, UpdateConditionConfig, RepositorySqlUpdateRelation,
            SqlUpdateSetBasicBuilder>(repository, new RepositorySqlExecutableUpdate3(update), update.updateRelation);
    }
}
