
package cn.featherfly.hammer.sqldb.dsl.repository.execute;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.dml.basic.SqlUpdateSetBasicBuilder;
import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression3;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroup3;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableConditionsGroupLogic3;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryExecutableUpdate3;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdate4;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdateNumberValueImpl;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdateValueImpl;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.execute.UpdateNumberValueExpression;
import cn.featherfly.hammer.expression.execute.UpdateValueExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryFieldOnlyExpression;
import cn.featherfly.hammer.expression.repository.execute.RepositoryUpdateExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlOn3;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlUpdateRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.condition.field.RepositoryFieldOnlyExpressionImpl;

/**
 * repository sql executable update3 .
 *
 * @author zhongj
 */
public class RepositorySqlExecutableUpdate3 implements RepositorySqlUpdate3, RepositoryExecutableUpdate3 {

    protected RepositorySqlExecutableUpdate update;

    /**
     * Instantiates a new repository sql executable update 3.
     *
     * @param update the update
     */
    public RepositorySqlExecutableUpdate3(RepositorySqlExecutableUpdate update) {
        this.update = update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> RepositorySqlExecutableUpdate3 set(String name, V value) {
        update.set(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> RepositorySqlExecutableUpdate3 set(String name, V value, Predicate<V> ignoreStrategy) {
        update.set(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositorySqlExecutableUpdate3 set(SerializableFunction<T, R> name, R value) {
        update.set(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> RepositorySqlExecutableUpdate3 set(SerializableFunction<T, R> name, R value,
        Predicate<R> ignoreStrategy) {
        update.set(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> RepositorySqlExecutableUpdate3 set(SerializableSupplier<R> property) {
        update.set(property);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> RepositorySqlExecutableUpdate3 set(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        update.set(property, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySqlExecutableUpdate3 set(Consumer<RepositoryExecutableUpdate3> consumer) {
        if (consumer != null) {
            consumer.accept(this);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate3 increase(String name, N value) {
        update.increase(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> RepositorySqlExecutableUpdate3 increase(SerializableFunction<T, N> name, N value,
        Predicate<N> ignoreStrategy) {
        update.increase(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate3 increase(String name, N value,
        Predicate<N> ignoreStrategy) {
        update.increase(name, value, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> RepositorySqlExecutableUpdate3 increase(SerializableFunction<T, R> name, R value) {
        update.increase(name, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate3 increase(SerializableNumberSupplier<N> property) {
        update.increase(property);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositorySqlExecutableUpdate3 increase(SerializableNumberSupplier<N> property,
        Predicate<N> ignoreStrategy) {
        update.increase(property, ignoreStrategy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateValueExpression<Serializable, RepositoryExecutableUpdate3,
        RepositoryExecutableConditionsGroup3<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic3<UpdateConditionConfig>> field(String name) {
        return new RepositoryUpdateValueImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateNumberValueExpression<Number, RepositoryExecutableUpdate3,
        RepositoryExecutableConditionsGroup3<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic3<UpdateConditionConfig>> fieldAsNumber(String name) {
        return new RepositoryUpdateNumberValueImpl<>(name, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
        R extends Serializable> UpdateValueExpression<R, RepositoryExecutableUpdate3,
            RepositoryExecutableConditionsGroup3<UpdateConditionConfig>,
            RepositoryExecutableConditionsGroupLogic3<UpdateConditionConfig>> field(SerializableFunction<T, R> name) {
        return new RepositoryUpdateValueImpl<>(LambdaUtils.getLambdaPropertyName(name), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
        R extends Number> UpdateNumberValueExpression<R, RepositoryExecutableUpdate3,
            RepositoryExecutableConditionsGroup3<UpdateConditionConfig>,
            RepositoryExecutableConditionsGroupLogic3<UpdateConditionConfig>> fieldAsNumber(
                SerializableFunction<T, R> name) {
        return new RepositoryUpdateNumberValueImpl<>(LambdaUtils.getLambdaPropertyName(name), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroup3<UpdateConditionConfig> where() {
        return new RepositorySqlUpdateConditions3(update.updateRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryExecutableConditionsGroupLogic3<UpdateConditionConfig> where(
        ThreeArgusFunction<RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression, RepositoryFieldOnlyExpression,
            LogicExpression<?, ?>> repositoriesCondtionFuntion) {
        RepositorySqlUpdateConditions3 sqlUpdateExpression = new RepositorySqlUpdateConditions3(update.updateRelation);
        if (repositoriesCondtionFuntion != null) {
            //filterable.apply(sqlUpdateExpression);
            sqlUpdateExpression.addCondition(
                repositoriesCondtionFuntion.apply(new RepositoryFieldOnlyExpressionImpl<>(0, update.updateRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(1, update.updateRelation) //
                    , new RepositoryFieldOnlyExpressionImpl<>(2, update.updateRelation) //
                ));
        }
        return sqlUpdateExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryUpdateExpression<RepositoryExecutableUpdate3,
        RepositoryExecutableConditionsGroup3<UpdateConditionConfig>,
        RepositoryExecutableConditionsGroupLogic3<UpdateConditionConfig>> configure(Consumer<UpdateConfig> configure) {
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
    public RepositoryOnExpression3<RepositoryUpdate4> join(Repository repository) {
        return new RepositorySqlOn3<RepositoryUpdate4, UpdateConditionConfig, RepositorySqlUpdateRelation,
            SqlUpdateSetBasicBuilder>(repository, new RepositorySqlExecutableUpdate4(update), update.updateRelation);
    }
}
