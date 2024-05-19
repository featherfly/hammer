
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MapRowIterable.java
 * @Description: MapRowIterable
 * @author: zhongj
 * @date: 2023-09-18 14:14:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.annotation.Nonnull;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.mapping.SqlResultSet;
import cn.featherfly.common.lang.AutoCloseableIterable;
import cn.featherfly.common.repository.mapping.RowMapper;

/**
 * MapRowIterable.
 *
 * @author zhongj
 * @param <T> the generic type
 */
public class RowIterable<T> implements AutoCloseableIterable<T> {

    private @Nonnull SqlResultSet res;

    private @Nonnull RowMapper<T> mapper;

    /**
     * Instantiates a new map row iterable.
     *
     * @param res the res
     * @param mapper the mapper
     */
    public RowIterable(SqlResultSet res, RowMapper<T> mapper) {
        super();
        this.res = res;
        this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return new MapRowLazyIterator<>(res, mapper);
    }

    private static class MapRowLazyIterator<T> implements Iterator<T> {

        private @Nonnull SqlResultSet res;

        private @Nonnull RowMapper<T> mapper;

        private int index;

        private boolean forward;

        private boolean hasNext;

        /**
         * Instantiates a new map row lazy iterator.
         *
         * @param res the res
         * @param mapper the mapper
         */
        private MapRowLazyIterator(SqlResultSet res, RowMapper<T> mapper) {
            super();
            this.res = res;
            this.mapper = mapper;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            if (res == null) {
                return false;
            }
            if (forward) {
                return hasNext;
            }
            try {
                forward = true;
                hasNext = res.getResultSet().next();
                return hasNext;
            } catch (SQLException e) {
                throw new JdbcException(e);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public T next() {
            if (res == null) {
                throw new NoSuchElementException();
            }
            if (!forward) { // 表示没有调用hasNext，即没有调用res.next()
                hasNext(); // 手动调用，
            }

            if (!hasNext) { // 表示没有数据了
                throw new NoSuchElementException();
            }
            forward = false;
            // cursor已经移动到位置了，可以直接取值
            return mapper.mapRow(res, index++);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        if (!res.getResultSet().isClosed() && !res.getResultSet().getStatement().isClosed()
            && !res.getResultSet().getStatement().getConnection().isClosed()) {
            // AutoCloseConnection, auto close it create object
            res.getResultSet().getStatement().getConnection().close();
        }
    }
}
