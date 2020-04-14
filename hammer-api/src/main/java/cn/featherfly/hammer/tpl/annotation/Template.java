
package cn.featherfly.hammer.tpl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * TplExecution
 * </p>
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
     * value is template
     *
     * @return value is template
     */
    boolean isTemplate() default true;
}
