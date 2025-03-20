
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-19 16:54:19
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import cn.featherfly.common.db.mapping.SqlTypeMappingManager;

/**
 * BeanResultSetExtractor.
 *
 * @author zhongj
 */
public class BeanListResultSetExtractor<E> extends AbstractListResultSetExtractor<E> {

    /**
     * Instantiates a new bean result set extractor.
     *
     * @param element the element
     * @param manager the manager
     */
    public BeanListResultSetExtractor(Class<E> element, SqlTypeMappingManager manager) {
        super(new NestedBeanPropertyRowMapper<>(element, manager));
    }
}
