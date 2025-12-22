
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-27 01:30:27
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.util.Locale;

import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.hammer.entity.EntityUtils;

/**
 * AbstractBeanRowMapper.
 *
 * @author zhongj
 * @param <T> the generic type
 */
public abstract class AbstractBeanRowMapper<T> implements RowMapper<T> {

    /**
     * Convert the given name to lower case. By default, conversions will happen
     * within the US locale.
     *
     * @param name the original name
     * @return the converted name
     * @since 0.7.4
     */
    protected String lowerCaseName(String name) {
        return name.toLowerCase(Locale.US);
    }

    /**
     * Checks if is entity.
     *
     * @param type the type
     * @return true, if is entity
     * @since 0.7.4
     */
    protected boolean isEntity(Class<?> type) {
        return EntityUtils.isEntity(type);
    }
}
