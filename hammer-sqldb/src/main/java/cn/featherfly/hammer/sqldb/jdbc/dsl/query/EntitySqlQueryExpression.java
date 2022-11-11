
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.function.Predicate;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.MappingFactory;
import cn.featherfly.hammer.dsl.query.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.EntityQueryEntity;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * EntitySqlQueryExpression .
 *
 * @author zhongj
 */
public class EntitySqlQueryExpression<E> extends EntitySqlQueryConditionGroupExpression<E> {

    /** The select builder. */
    private SqlSelectBasicBuilder selectBuilder;

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc              the jdbc
     * @param classMapping      the class mapping
     * @param entityQueryEntity the entity query entity
     * @param factory           the factory
     * @param sqlPageFactory    the sql page factory
     * @param aliasManager      the alias manager
     * @param selectBuilder     the select builder
     * @param ignorePolicy      the ignore policy
     */
    public EntitySqlQueryExpression(Jdbc jdbc, ClassMapping<?> classMapping, EntityQueryEntity<E> entityQueryEntity,
            MappingFactory factory, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
            SqlSelectBasicBuilder selectBuilder, Predicate<Object> ignorePolicy) {
        //        super(jdbc, selectBuilder.getTableAlias(), classMapping, factory, sqlPageFactory, aliasManager,
        //                entityQueryEntity, ignorePolicy);
        //      IMPLSOON 后续来实现，先让编译通过
        super(jdbc, "", classMapping, factory, sqlPageFactory, aliasManager, entityQueryEntity, ignorePolicy);
        this.selectBuilder = selectBuilder;
    }

    /**
     * Instantiates a new type sql query expression.
     *
     * @param parent            the parent
     * @param jdbc              the jdbc
     * @param queryAlias        the query alias
     * @param classMapping      the class mapping
     * @param factory           the factory
     * @param sqlPageFactory    the sql page factory
     * @param aliasManager      the alias manager
     * @param entityQueryEntity the entity query entity
     * @param ignorePolicy      the ignore policy
     */
    EntitySqlQueryExpression(EntityQueryConditionGroupLogicExpression<E> parent, Jdbc jdbc, String queryAlias,
            ClassMapping<?> classMapping, MappingFactory factory, SqlPageFactory sqlPageFactory,
            AliasManager aliasManager, EntityQueryEntity<E> entityQueryEntity, Predicate<Object> ignorePolicy) {
        super(parent, jdbc, queryAlias, classMapping, factory, sqlPageFactory, aliasManager, entityQueryEntity,
                ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntitySqlQueryConditionGroupExpression<E> createGroup(EntityQueryConditionGroupLogicExpression<E> parent,
            String queryAlias, EntityQueryEntity<E> entityQueryEntity) {
        if (selectBuilder != null) {
            //      IMPLSOON 后续来实现，先让编译通过
            //            selectBuilder.setTableAlias(queryAlias);
        }
        return new EntitySqlQueryExpression<>(parent, jdbc, queryAlias, classMapping, factory, sqlPageFactory,
                aliasManager, entityQueryEntity, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        selectBuilder.addColumn(AggregateFunction.COUNT, Chars.STAR);
        return jdbc.queryLong(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        String result = "";
        if (selectBuilder != null) {
            result = selectBuilder.build();
        }
        String condition = super.build();
        if (Lang.isNotEmpty(condition)) {
            result = result + Chars.SPACE + condition;
        }
        return result;
    }
}
