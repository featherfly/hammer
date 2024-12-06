
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-19 16:19:19
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.mapper.SqlResultSet;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.repository.MulitiQuery;
import cn.featherfly.common.repository.mapper.RowMapper;

/**
 * jdbc procedure muliti-query.
 *
 * @author zhongj
 */
public class JdbcProcedureMulitiQuery implements MulitiQuery {

    private int index = 0;

    private boolean forward;

    private boolean hasNext;

    private SqlTypeMappingManager manager;

    private Statement stat;

    private Function<Class<?>, RowMapper<?>> getTypeMapper;

    private Function<List<?>, ?> postHandler;

    /**
     * Instantiates a new jdbc muliti query.
     *
     * @param stat the call
     * @param manager the manager
     * @param getTypeMapper the get type mapper
     * @param postHandler the post handler
     */
    public JdbcProcedureMulitiQuery(Statement stat, SqlTypeMappingManager manager,
        Function<Class<?>, RowMapper<?>> getTypeMapper, Function<List<?>, ?> postHandler) {
        super();
        this.stat = stat;
        this.manager = manager;
        this.getTypeMapper = getTypeMapper;
        this.postHandler = postHandler;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> next() {
        return next(new MapRowMapper(manager));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> List<E> next(Class<E> elementType) {
        return next((RowMapper<E>) getTypeMapper.apply(elementType));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> List<E> next(RowMapper<E> mapper) {
        RowMapperResultSetExtractor<E> extractor = new RowMapperResultSetExtractor<>(mapper);
        ResultSet res = nextResultSet();
        List<E> list = extractor.extract(new SqlResultSet(res));
        JdbcUtils.close(res); // stat可能不是CascadedCloseStatement，所以先手动关闭 
        return (List<E>) postHandler.apply(list);
    }

    private ResultSet nextResultSet() {
        try {
            if (index == 0) {
                index++;
                return stat.getResultSet();
            }

            if (!forward) { // 表示没有调用hasNext，即没有调用call.getMoreResults()
                hasNext(); // 手动调用
            }

            if (!hasNext) { // 表示没有数据了
                throw new NoSuchElementException();
            }

            forward = false;
            index++;
            // cursor已经移动到位置了，可以直接取值
            return stat.getResultSet();
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getIndex() {
        return index;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        if (index == 0) {
            return true;
        }
        if (forward) {
            return hasNext;
        }
        try {
            hasNext = stat.getMoreResults();
            forward = true;
            return hasNext;
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws JdbcException {
        try {
            if (!stat.isClosed()) {
                stat.close();
            }
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }
}
