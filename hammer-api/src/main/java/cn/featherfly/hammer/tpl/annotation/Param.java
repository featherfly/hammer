
package cn.featherfly.hammer.tpl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * Param
 * </p>
 *
 * @author zhongj
 */
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {
    /**
     * param name alias. priority is lower than name.
     *
     * @return param name
     */
    String value() default "";

    /**
     * param name
     *
     * @return param name
     */
    String name() default "";

    /**
     * param type
     *
     * @return param type
     */
    ParamType type() default ParamType.QUERY;

}
