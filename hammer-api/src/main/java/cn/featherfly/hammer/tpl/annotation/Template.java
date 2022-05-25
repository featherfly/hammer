
package cn.featherfly.hammer.tpl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.featherfly.hammer.tpl.TplType;

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
     * template type
     *
     * @return template type
     */
    TplType type() default TplType.AUTO;

    /**
     * value is template
     *
     * @return value is template
     * @deprecated 会使用专门的注解处理非模板的情况，后续删除此属性
     */
    @Deprecated
    boolean isTemplate() default true;
}
