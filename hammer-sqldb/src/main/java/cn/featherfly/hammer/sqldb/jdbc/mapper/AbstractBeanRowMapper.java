
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-27 01:30:27
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.featherfly.common.repository.mapper.RowMapper;

/**
 * AbstractBeanRowMapper.
 *
 * @author zhongj
 */
public abstract class AbstractBeanRowMapper<T> implements RowMapper<T> {

    /**
     * Convert the given name to lower case. By default, conversions will happen
     * within the US locale.
     *
     * @param name the original name
     * @return the converted name
     * @since 4.2
     */
    protected String lowerCaseName(String name) {
        return name.toLowerCase(Locale.US);
    }

    protected boolean isEntity(Class<?> type) {
        return type.getAnnotation(Table.class) != null || type.getAnnotation(Entity.class) != null;
    }
}
