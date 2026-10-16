
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-10-16 20:39:16
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.util;

import java.util.Set;

import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.hammer.HammerValidateException;
import cn.featherfly.hammer.entity.operator.OperatorType;
import cn.featherfly.validation.Validator;
import cn.featherfly.validation.metadata.ConstraintViolation;

/**
 * ValidatorUtils.
 *
 * @author zhongj
 */
public final class ValidatorUtils {

    /**
     * Validate property.
     *
     * @param <T> the generic type
     * @param validator the validator
     * @param operatorType the operator type
     * @param entityType the entity type
     * @param propertyMapping the property mapping
     * @param value the value
     */
    public static <T> void validatePropertyValue(Validator validator, OperatorType operatorType, Class<T> entityType,
        JdbcPropertyMapping propertyMapping, Object value) {
        if (validator == null) {
            return;
        }
        StringBuilder errorMessage = new StringBuilder();
        validateProperty0(validator, operatorType, entityType, propertyMapping, value, errorMessage);
        if (errorMessage.length() > 0) {
            throw new HammerValidateException(errorMessage.toString());
        }
    }

    /**
     * Validate property.
     *
     * @param <T> the generic type
     * @param validator the validator
     * @param operatorType the operator type
     * @param entityType the entity type
     * @param propertyMapping the property mapping
     * @param value the value
     * @param errorMessage the error message
     */
    public static <T> void validatePropertyValue(Validator validator, OperatorType operatorType, Class<T> entityType,
        JdbcPropertyMapping propertyMapping, Object value, StringBuilder errorMessage) {
        if (validator == null) {
            return;
        }
        validateProperty0(validator, operatorType, entityType, propertyMapping, value, errorMessage);
    }

    private static <T> void validateProperty0(Validator validator, OperatorType operatorType, Class<T> entityType,
        JdbcPropertyMapping propertyMapping, Object value, StringBuilder errorMessage) {
        if (propertyMapping.isInsertable() && !propertyMapping.isIgnoreAtInsert() && operatorType == OperatorType.INSERT
            || propertyMapping.isUpdatable() && operatorType == OperatorType.UPDATE) {
            // TODO 还未测试内嵌对象 xxx.yyy
            Set<ConstraintViolation<T>> cons = validator.validateValue(entityType, propertyMapping.getPropertyName(),
                value);
            for (ConstraintViolation<T> constraintViolation : cons) {
                if (errorMessage.length() > 0) {
                    errorMessage.append(",");
                }
                errorMessage.append(propertyMapping.getPropertyFullName()).append(constraintViolation.getMessage());
            }
        }
    }
}
