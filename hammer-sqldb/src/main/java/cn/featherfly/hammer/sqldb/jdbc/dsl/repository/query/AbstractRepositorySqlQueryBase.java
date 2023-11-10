
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query;

import cn.featherfly.common.db.Table;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.WhereExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlRelation.RepositoryRelation;

/**
 * AbstractRepositorySqlQueryBase.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <Q> the generic type
 */
public abstract class AbstractRepositorySqlQueryBase<C extends ConditionExpression, Q>
        implements QueryCountExecutor, QueryConditionLimit<Q>, WhereExpression<C> {

    /** The query relation. */
    protected final RepositorySqlQueryRelation queryRelation;

    /** The index. */
    protected final int index;

    /** The sql page factory. */
    protected final SqlPageFactory sqlPageFactory;

    /** The id name. */
    protected String idName;

    /** The limit. */
    protected Limit limit;

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param index          the index
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQueryBase(int index, RepositorySqlQueryRelation queryRelation,
            SqlPageFactory sqlPageFactory) {
        this.index = index;
        this.queryRelation = queryRelation;
        this.sqlPageFactory = sqlPageFactory;
        setIdName();
    }

    public void setIdName() {
        RepositoryRelation relation = queryRelation.getRepositoryRelation(index);
        if (relation != null) {
            Table tableMetadata = queryRelation.getMetadata().getTable(relation.getRepository());
            if (tableMetadata.getPrimaryColumns().size() == 1) {
                // FIXME 这里处理不了复合主键的问题
                idName = tableMetadata.getPrimaryColumns().get(0).getName();
            }
        }
    }

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    protected AbstractRepositorySqlQueryBase(AbstractRepositorySqlQueryBase<?, ?> repositorySqlQueryFetch) {
        queryRelation = repositorySqlQueryFetch.queryRelation;
        index = repositorySqlQueryFetch.index;
        sqlPageFactory = repositorySqlQueryFetch.sqlPageFactory;
        idName = repositorySqlQueryFetch.idName;
        limit = repositorySqlQueryFetch.limit;
    }

    /**
     * Gets the id name.
     *
     * @return the id name
     */
    protected String getIdName() {
        if (Lang.isEmpty(idName)) {
            throw new HammerException("primary key column name is null");
        }
        return idName;
    }

    /**
     * Count.
     *
     * @return the e
     */
    @Override
    public long count() {
        return new RepositorySqlQueryValueExpression(queryRelation, sqlPageFactory).count();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public Q limit(Limit limit) {
        this.limit = limit;
        return (Q) this;
    }

    //    public C where(Consumer<C> consumer) {
    //        C c = where();
    //        if (consumer != null) {
    //            consumer.accept(c);
    //        }
    //        return c;
    //    }
}
