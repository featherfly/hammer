
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.ResultSet;

import cn.featherfly.common.lang.ClassUtils;

/**
 * ClassMapperObjectFactory.
 *
 * @author zhongj
 */
public class ClassMapperObjectFactory<T> implements MapperObjectFactory<T> {

    private Class<T> type;

    /**
     * Instantiates a new class mapper object factory.
     *
     * @param type the type
     */
    public ClassMapperObjectFactory(Class<T> type) {
        super();
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T create(ResultSet rs) {
        return ClassUtils.newInstance(type);
        //        return BeanUtils.instantiateClass(this.type);
    }

    /**
     * get type value
     *
     * @return type
     */
    public Class<T> getType() {
        return type;
    }
}
