
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping.Mode;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * The Class AbstractMulitiEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <P> the element type
 * @param <F> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiEntityPropertyExpression<E, C extends ConditionExpression,
        L extends LogicExpression<C, L>> {

    /** The index. */
    protected AtomicInteger index;

    /** The expression. */
    protected AbstractMulitiEntityConditionExpression<C, L> expression;

    protected JdbcMappingFactory factory;

    protected List<Serializable> propertyList = new ArrayList<>();

    protected EntitySqlRelation<?, ?> queryRelation;

    /**
     * Instantiates a new entity property type expression impl.
     *
     * @param index      the index
     * @param name       the name
     * @param expression the expression
     * @param factory    the factory
     */
    protected AbstractMulitiEntityPropertyExpression(AtomicInteger index, Serializable name,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?, ?> queryRelation) {
        this(index, Lang.list(name), expression, factory, queryRelation);
    }

    /**
     * Instantiates a new entity property type expression impl.
     *
     * @param index        the index
     * @param propertyList the property list
     * @param expression   the expression
     * @param factory      the factory
     */
    protected AbstractMulitiEntityPropertyExpression(AtomicInteger index, List<Serializable> propertyList,
            AbstractMulitiEntityConditionExpression<C, L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?, ?> queryRelation) {
        super();
        this.index = index;
        this.expression = expression;
        this.propertyList.addAll(propertyList);
        this.factory = factory;
        this.queryRelation = queryRelation;
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
                    // IMPLSOON 这里需要join，在条件设置中需要判断对象是否已经join，如果没有join，则需要在设置查询参数时，先join
                    // 所以需要在条件中记录已经join的对象关系来判断是否需要join
                    spm = cm.getPropertyMapping(pn);
                    if (spm != null) {
                        queryRelation.join(index, pm.getPropertyName(), cm);
                        this.index.incrementAndGet();
                        //                        index++;
                        return spm;
                    } else {
                        throw new SqldbHammerException(Strings.format("no property mapping found for {0}.{1}",
                                cm.getType().getSimpleName(), pn));
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

    //    /**
    //     * Gets the property mapping.
    //     *
    //     * @param value the value
    //     * @return the property mapping
    //     */
    //    protected List<PropertyMapping<?>> getPropertyMappings(Object value) {
    //        if (value == null) {
    //            ClassMapping<?, JdbcPropertyMapping> classMapping = expression.getClassMapping(index);
    //            // ENHANCE 这个查询值为null则直接返回对象映射的逻辑后续考虑是否合理
    //            return CollectionUtils
    //                    .list(classMapping.getPropertyMapping(LambdaUtils.getLambdaPropertyName(propertyList.get(0))));
    //        }
    //
    //        List<PropertyMapping<?>> pms = new ArrayList<>(propertyList.size());
    //        if (propertyList.size() == 1) {
    //            ClassMapping<?, JdbcPropertyMapping> classMapping = expression.getClassMapping(index);
    //            pms.add(classMapping.getPropertyMapping(LambdaUtils.getLambdaPropertyName(propertyList.get(0))));
    //            return pms;
    //        } else if (propertyList.size() == 2) {
    //            ClassMapping<?, JdbcPropertyMapping> classMapping = expression.getClassMapping(index);
    //            JdbcPropertyMapping pm = classMapping
    //                    .getPropertyMapping(LambdaUtils.getLambdaPropertyName(propertyList.get(0)));
    //
    //            SerializedLambdaInfo propertyInfo = LambdaUtils.getLambdaInfo(propertyList.get(1));
    //            String pn = propertyInfo.getPropertyName();
    //            if (pm.getMode() == Mode.EMBEDDED) {
    //                JdbcPropertyMapping spm = pm.getPropertyMapping(pn);
    //                if (spm == null) {
    //                    throw new SqldbHammerException(Strings.format("no property mapping found for {0}.{1}.{2}",
    //                            classMapping.getType().getSimpleName(), pm.getPropertyFullName(), pn));
    //                }
    //                pms.add(spm);
    //                return pms;
    //            } else if (pm.getMode() == Mode.MANY_TO_ONE) { // YUFEI_TODO 后续把ONE_TO_ONE的逻辑也加入
    //                pms.add(pm);
    //                JdbcPropertyMapping spm = pm.getPropertyMapping(pn);
    //                if (spm != null) {
    //                    return pms;
    //                } else {
    //                    @SuppressWarnings("unchecked")
    //                    JdbcClassMapping<E> cm = factory.getClassMapping((Class<E>) pm.getPropertyType());
    //                    // IMPLSOON 这里需要join，在条件设置中需要判断对象是否已经join，如果没有join，则需要在设置查询参数时，先join
    //                    // 所以需要在条件中记录已经join的对象关系来判断是否需要join
    //                    spm = cm.getPropertyMapping(pn);
    //                    if (spm != null) {
    //                        pms.add(spm);
    //                        // TODO join的逻辑在这里添加
    //                        queryRelation.join(index, pm.getPropertyName(), cm);
    //                        index++;
    //                        return pms;
    //                    } else {
    //                        throw new SqldbHammerException(Strings.format("no property mapping found for {0}.{1}",
    //                                cm.getType().getSimpleName(), pn));
    //                    }
    //                }
    //            } else if (pm.getMode() == Mode.ONE_TO_MANY) {
    //                // IMPLSOON 未实现一对多
    //                // 在条件设置中需要判断对象是否已经join，如果没有join，则需要在设置查询参数时，先join
    //                // 所以需要在条件中记录已经join的对象关系来判断是否需要join
    //                throw new NotImplementedException();
    //            } else if (pm.getMode() == Mode.SINGLE) {
    //                // YUFEI_TEST 待测试，propertyList.size() > 1 时 propertyList.get(0)就不应该是Mode.SINGLE，所以应该永远进不了这个逻辑
    //                throw new NotImplementedException();
    //            }
    //            throw new UnsupportedException();
    //        } else {
    //            // IMPLSOON 未实现，出现多次对象嵌套，只可能出现在关联对象的情况即，即多次获取ManyToOne(OneToOne)的属性
    //            // 例如： order.getOwner().getUserInfo().getAddress().getNo()  -  order > user > user_info > address.no
    //            throw new NotImplementedException();
    //        }
    //    }
}
