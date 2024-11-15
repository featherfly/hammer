
package cn.featherfly.hammer.sqldb.dsl.entity.condition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

import cn.featherfly.common.db.builder.model.ArithmeticColumnElement;
import cn.featherfly.common.db.builder.model.ColumnElement;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping.Mode;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.FieldExpression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;

/**
 * The Class AbstractMulitiEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiEntityPropertyExpression<E, C extends ConditionExpression,
    L extends LogicExpression<C, L>> implements Expression {

    /** The index. */
    protected AtomicInteger index;

    /** The expression. */
    protected InternalMulitiEntityCondition<L> expression;

    /** The factory. */
    protected JdbcMappingFactory factory;

    /** The property list. */
    protected List<Serializable> propertyList = new ArrayList<>();

    /** The query relation. */
    protected EntitySqlRelation<?, ?> queryRelation;

    /** The params. */
    protected Supplier<ArithmeticColumnElement> arithmeticColumnElement = () -> null;

    /**
     * Instantiates a new entity property type expression impl.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    protected AbstractMulitiEntityPropertyExpression(AtomicInteger index, Serializable name,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        this(index, Lang.list(name), expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity property type expression impl.
     *
     * @param index the index
     * @param propertyList the property list
     * @param expression the expression
     * @param factory the factory
     * @param queryRelation the query relation
     */
    protected AbstractMulitiEntityPropertyExpression(AtomicInteger index, List<Serializable> propertyList,
        InternalMulitiEntityCondition<L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super();
        this.index = index;
        this.expression = expression;
        this.propertyList.addAll(propertyList);
        this.factory = factory;
        this.queryRelation = queryRelation;
    }

    public L eq(Field field) {
        return expression.eq(index, getPropertyMapping(field), arithmeticColumnElement.get(), field,
            expression.getIgnoreStrategy());
    }

    public L eq(FieldExpression expr) {
        return expression.eq(index, getPropertyMapping(expr), arithmeticColumnElement.get(), expr,
            expression.getIgnoreStrategy());
    }

    //    public L eq(SerializableFunction<?, P> expr) {
    //        return expression.eq(index, getPropertyMapping(expr), arithmeticColumnElement.get(), expr,
    //            expression.getIgnoreStrategy());
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return new ColumnElement(expression.getJdbc().getDialect(), getPropertyMapping(this).getRepositoryFieldName(),
            expression.getAlias(index.intValue())).toSql();
        //        String expr = expression.expression();
        //        if (Lang.isEmpty(expr) && !propertyList.isEmpty()) {
        //            return new ColumnElement(expression.getJdbc().getDialect(),
        //                getPropertyMapping(this).getRepositoryFieldName(), expression.getAlias(index.intValue())).toSql();
        //        }
        //        return expr;
    }

    /**
     * Gets the property mapping.
     *
     * @param value the value
     * @return the property mapping
     */
    protected PropertyMapping<?> getPropertyMapping(Object value) {
        int index = this.index.get();
        if (propertyList.size() == 1) {
            ClassMapping<?, JdbcPropertyMapping> classMapping = expression.getClassMapping(index);
            return classMapping.getPropertyMapping(LambdaUtils.getLambdaPropertyName(propertyList.get(0)));
        } else if (propertyList.size() == 2) {
            ClassMapping<?, JdbcPropertyMapping> classMapping = expression.getClassMapping(index);
            JdbcPropertyMapping pm = classMapping
                .getPropertyMapping(LambdaUtils.getLambdaPropertyName(propertyList.get(0)));
            if (value == null) {
                // ENHANCE 这个查询值为null则直接返回对象映射的逻辑后续考虑是否合理
                return pm;
            }

            SerializedLambdaInfo propertyInfo = LambdaUtils.getLambdaInfo(propertyList.get(1));
            String pn = propertyInfo.getPropertyName();
            if (pm.getMode() == Mode.EMBEDDED) {
                JdbcPropertyMapping spm = pm.getPropertyMapping(pn);
                if (spm == null) {
                    throw new SqldbHammerException(Strings.format("no property mapping found for {0}.{1}.{2}",
                        classMapping.getType().getSimpleName(), pm.getPropertyFullName(), pn));
                }
                return spm;
            } else if (Mode.MANY_TO_ONE == pm.getMode() || Mode.MANY_TO_ONE == pm.getMode()) {
                // YUFEI_TEST 需要测试ONE_TO_ONE
                JdbcPropertyMapping spm = pm.getPropertyMapping(pn);
                if (spm != null) {
                    return spm;
                } else {
                    @SuppressWarnings("unchecked")
                    JdbcClassMapping<E> cm = factory.getClassMapping((Class<E>) pm.getPropertyType());
                    // 这里需要join，在条件设置中需要判断对象是否已经join，如果没有join，则需要在设置查询参数时，先join
                    // 所以需要在条件中记录已经join的对象关系来判断是否需要join
                    spm = cm.getPropertyMapping(pn);
                    if (spm != null) {
                        queryRelation.join(index, pm.getPropertyName(), cm);
                        this.index.incrementAndGet();
                        return spm;
                    } else {
                        throw new SqldbHammerException(
                            Strings.format("no property mapping found for {0}.{1}", cm.getType().getSimpleName(), pn));
                    }
                }
            } else if (pm.getMode() == Mode.ONE_TO_MANY) {
                // IMPLSOON 未实现一对多
                // 在条件设置中需要判断对象是否已经join，如果没有join，则需要在设置查询参数时，先join
                // 所以需要在条件中记录已经join的对象关系来判断是否需要join
                throw new NotImplementedException();
            } else if (pm.getMode() == Mode.SINGLE) {
                // YUFEI_TEST 待测试，propertyList.size() > 1 时 propertyList.get(0)就不应该是Mode.SINGLE，所以应该永远进不了这个逻辑
                throw new NotImplementedException();
            }
            throw new UnsupportedException();
        } else {
            // IMPLSOON 未实现，出现多次对象嵌套，只可能出现在关联对象的情况即，即多次获取ManyToOne(OneToOne)的属性
            // 例如： order.getOwner().getUserInfo().getAddress().getNo()  -  order > user > user_info > address.no
            throw new NotImplementedException();
        }
    }

    public String name() {
        // YUFEI_TEST 需要测试该方法
        return getPropertyMapping(null).getRepositoryFieldName();
    }
}
