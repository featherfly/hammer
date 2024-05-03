/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-27 19:17:27
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.relation;

import java.util.List;
import java.util.function.Consumer;

import cn.featherfly.common.db.Column;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.repository.AliasRepository;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.repository.RepositoryOnExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryRelateExpression;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlRelation.RepositoryRelation;

/**
 * repository sql query join on.
 *
 * @author zhongj
 * @param <Q> the generic type
 * @param <F> the generic type
 */
public class AbstractRepositorySqlQueryOn<Q extends RepositoryQueryRelateExpression<F>, F>
    implements RepositoryOnExpression<Q> {

    /** The query relate. */
    protected final Q queryRelate;

    /** The query relation. */
    protected final RepositorySqlQueryRelation queryRelation;

    /** The join repository. */
    protected final String joinRepository;

    /** The join repository alias. */
    protected final String joinRepositoryAlias;

    /** The on consumer. */
    protected final Consumer<Q> onConsumer;

    /**
     * Instantiates a new entity sql query related.
     *
     * @param queryRelate    the query relate
     * @param queryRelation  the query relation
     * @param joinRepository the repository
     */
    public AbstractRepositorySqlQueryOn(Q queryRelate, RepositorySqlQueryRelation queryRelation,
        String joinRepository) {
        this(queryRelate, queryRelation, joinRepository, null);
    }

    /**
     * Instantiates a new entity sql query related.
     *
     * @param queryRelate    the query relate
     * @param queryRelation  the query relation
     * @param joinRepository the repository
     * @param onConsumer     the on consumer
     */
    public AbstractRepositorySqlQueryOn(Q queryRelate, RepositorySqlQueryRelation queryRelation, String joinRepository,
        Consumer<Q> onConsumer) {
        this(queryRelate, queryRelation, joinRepository, null, onConsumer);
    }

    /**
     * Instantiates a new entity sql query related.
     *
     * @param queryRelate   the query relate
     * @param queryRelation the query relation
     * @param repository    the repository
     * @param onConsumer    the on consumer
     */
    public AbstractRepositorySqlQueryOn(Q queryRelate, RepositorySqlQueryRelation queryRelation, Repository repository,
        Consumer<Q> onConsumer) {
        this(queryRelate, queryRelation, repository.name(),
            repository instanceof AliasRepository ? ((AliasRepository) repository).alias() : null, onConsumer);
    }

    /**
     * Instantiates a new entity sql query related.
     *
     * @param queryRelate         the query relate
     * @param queryRelation       the query relation
     * @param joinRepository      the repository
     * @param joinRepositoryAlias the join repository alias
     * @param onConsumer          the on consumer
     */
    public AbstractRepositorySqlQueryOn(Q queryRelate, RepositorySqlQueryRelation queryRelation, String joinRepository,
        String joinRepositoryAlias, Consumer<Q> onConsumer) {
        this.queryRelation = queryRelation;
        this.queryRelate = queryRelate;
        this.joinRepository = joinRepository;
        this.joinRepositoryAlias = joinRepositoryAlias;
        if (onConsumer == null) {
            this.onConsumer = q -> {
            };
        } else {
            this.onConsumer = onConsumer;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q on(String joinRepositoryField, String sourceRepositoryField) {
        AssertIllegalArgument.isNotNull(joinRepositoryField, "joinRepositoryField");
        if (Lang.isEmpty(sourceRepositoryField)) {
            RepositoryRelation relation = queryRelation.getRepositoryRelation(0);
            List<Column> pkList = queryRelation.getMetadata().getTable(relation.getRepository()).getPrimaryColumns();
            if (pkList.size() == 1) {
                return on(joinRepositoryField, pkList.get(0).getName());
            }
            throw new SqldbHammerException(
                Strings.format("only support one primary key, but more than one primary key found {0}", pkList.size()));
        } else {
            queryRelation.join(0, sourceRepositoryField, joinRepository, joinRepositoryAlias, joinRepositoryField);
            onConsumer.accept(queryRelate);
        }
        return queryRelate;
    }
}
