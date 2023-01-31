
package cn.featherfly.hammer.tpl.mapper;

import java.io.Serializable;

import cn.featherfly.common.lang.ClassUtils;

/**
 * <p>
 * Superclass
 * </p>
 *
 * @author zhongj
 */
public class Superclass<T> {

    private String name;

    /**
     */
    public Superclass() {
    }

    /**
     */
    public Superclass(String name) {
        this.name = name;
    }

    public T get(Serializable id) {
        System.out.println(name);
        System.out.print(ClassUtils.getSuperClassGenericType(this.getClass()));
        return null;
    }
}
