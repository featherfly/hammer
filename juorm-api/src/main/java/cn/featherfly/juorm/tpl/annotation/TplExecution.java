
package cn.featherfly.juorm.tpl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * TplExecution
 * </p>
 * <p>
 * 2019-08-14
 * </p>
 *
 * @author zhongj
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TplExecution {

    String namesapce() default "";

    String name() default "";
}
