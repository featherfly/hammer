
package cn.featherfly.juorm.dml.builder.sql.query;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.expression.query.QueryEntityPropertiesExpression;
import cn.featherfly.juorm.expression.query.QueryExecutor;
import cn.featherfly.juorm.mapping.RowMapper;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class AbstractUserQueryEntity<Q extends AbstractUserQueryEntity<Q>> implements
        QueryEntityPropertiesExpression<Q, UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Q property(String propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q property(String... propertyNames) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q property(Collection<String> propertyNames) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression where() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Integer limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Integer offset, Integer limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Page page) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer integer() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long longInt() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal decimal() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(Class<N> type) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
