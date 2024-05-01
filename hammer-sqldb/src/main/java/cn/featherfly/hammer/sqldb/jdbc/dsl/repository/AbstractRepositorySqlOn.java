
/*
 * All rights Reserved, Designed By zhongj
 * @Title: AbstractRepositorySqlOn.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.repository
 * @author: zhongj
 * @date: 2024-04-29 19:02:29
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression;

/**
 * AbstractRepositorySqlOn.
 *
 * @author zhongj
 * @param <O> on result type
 * @param <R> repository sql relation
 * @param <B> sql builder
 */
public class AbstractRepositorySqlOn<O, R extends RepositorySqlRelation<R, B>, B extends SqlBuilder>
        implements RepositoryOnExpression<O> {

    /** The on result. */
    protected final O onResult;

    /** The index. */
    //    protected final int index;

    /** The sql relation. */
    protected final R sqlRelation;

    /** The join table. */
    protected final String joinTable;

    /** The join table alias. */
    protected final String joinTableAlias;

    /**
     * Instantiates a new abstract repository sql on.
     *
     * @param joinTable   the join table
     * @param onResult    the query relate
     * @param sqlRelation the query relation
     */
    public AbstractRepositorySqlOn(String joinTable, O onResult, R sqlRelation) {
        this.joinTable = joinTable;
        this.sqlRelation = sqlRelation;
        this.onResult = onResult;
        joinTableAlias = null;
    }

    /**
     * Instantiates a new abstract repository sql on.
     *
     * @param repository  the repository
     * @param onResult    the query relate
     * @param sqlRelation the query relation
     */
    public AbstractRepositorySqlOn(Repository repository, O onResult, R sqlRelation) {
        joinTable = repository.name();
        if (repository instanceof AliasRepository) {
            joinTableAlias = ((AliasRepository) repository).alias();
        } else {
            joinTableAlias = null;
        }
        this.sqlRelation = sqlRelation;
        this.onResult = onResult;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public O on(String joinRepositoryField, String sourceRepositoryField) {
        sqlRelation.join(0, sourceRepositoryField, joinTable, joinTableAlias, joinRepositoryField);
        return onResult;
    }
}
