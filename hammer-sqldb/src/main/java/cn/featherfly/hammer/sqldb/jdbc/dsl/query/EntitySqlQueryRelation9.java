
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.List;
import java.util.function.Consumer;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelation9;
import cn.featherfly.hammer.dsl.query.type.EntityQueryRelationEntity9;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;

/**
 * @author zhongj
 */
public class EntitySqlQueryRelation9<E, R1, R2, R3, R4, R5, R6, R7, R8, R9>
        implements EntitySqlQuery<E>, EntityQueryRelation9<E, R1, R2, R3, R4, R5, R6, R7, R8, R9>,
        EntityQueryRelationEntity9<E, R1, R2, R3, R4, R5, R6, R7, R8, R9> {

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupExpression<E> where() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupExpression<E> where(
            Consumer<ConditionGroupConfig<EntityQueryConditionGroupExpression<E>>> consumer) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> list() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryLimitExecutor<E> limit(Integer limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryLimitExecutor<E> limit(Integer offset, Integer limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryLimitExecutor<E> limit(Page page) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelationEntity9<E, R1, R2, R3, R4, R5, R6, R7, R8, R9> fetch() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
