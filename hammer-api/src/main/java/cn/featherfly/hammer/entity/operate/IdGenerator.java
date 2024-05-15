
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-16 00:14:16
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.entity.operate;

import java.io.Serializable;

import cn.featherfly.common.repository.mapping.ClassMapping;

/**
 * id generator.
 *
 * @author zhongj
 */
public interface IdGenerator {

    /**
     * Generate.
     *
     * @param <E>          the element type
     * @param classMapping the class mapping
     * @param entity       the entity
     * @param id           the id
     * @return the serializable
     */
    <E> Serializable generate(ClassMapping<E, ?> classMapping, E entity, Serializable id);
}
