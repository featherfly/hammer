
package cn.featherfly.hammer.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.featherfly.hammer.tpl.ExecutionType;

/**
 * template.
 *
 * @author zhongj
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Template {
    /**
     * template file name path
     *
     * @return template file name path
     */
    String namespace() default "";

    /**
     * template name
     *
     * @return template name
     */
    String name() default "";

    /**
     * template string value
     *
     * @return template string value
     */
    String value() default "";

    /**
     * pre compile template.
     *
     * @return true, if need pre compile
     */
    boolean precompile() default true;

    /**
     * template type
     *
     * @return template type
     */
    ExecutionType type() default ExecutionType.AUTO;
}
