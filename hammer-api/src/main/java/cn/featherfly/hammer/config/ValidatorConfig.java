
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-04-25 23:31:25
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import cn.featherfly.validation.Validator;
import cn.featherfly.validation.executable.ExecutableValidator;

/**
 * ValidatorConfig.
 *
 * @author zhongj
 */
public interface ValidatorConfig {

    /**
     * Gets the validator.
     *
     * @return the validator
     */
    Validator getValidator();

    /**
     * Gets the executable validator.
     *
     * @return the executable validator
     */
    ExecutableValidator getExecutableValidator();

    /**
     * Validate.
     *
     * @param <T> the generic type
     * @param object the object
     * @param method the method
     * @param parameterValues the parameter values
     * @param groups the groups
     */
    default <T> void validateParameters(T object, Method method, Object[] parameterValues, Class<?>... groups) {
        ExecutableValidator validator = getExecutableValidator();
        if (validator == null) {
            return;
        }
        validator.validateParametersThrow(object, method, parameterValues, groups);
    }

    /**
     * Checks if is constraint.
     *
     * @param <A> the generic type
     * @param constraintType the constraint type
     * @return true, if is constraint
     */
    default <A extends Annotation> boolean isConstraint(Class<A> constraintType) {
        Validator validator = getValidator();
        if (validator == null) {
            return false;
        }
        return validator.isConstraint(constraintType);
    }
}
