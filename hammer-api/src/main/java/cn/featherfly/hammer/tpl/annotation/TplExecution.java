
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
public @interface TplExecution {

    String namespace() default "";

    String name() default "";
}
