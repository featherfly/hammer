
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-10-16 20:39:16
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.util;

import java.util.Collections;
import java.util.Set;

import cn.featherfly.common.bean.BeanDescriptor;
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

    private ValidatorUtils() {
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

    /**
     * Validate.
     *
     * @param <T> the generic type
     * @param validator the validator
     * @param operatorType the operator type
     * @param entity the entity
     * @param propertyMapping the property mapping
     */
    public static <T> void validate(Validator validator, OperatorType operatorType, T entity,
        JdbcPropertyMapping... propertyMappings) {
        if (validator == null) {
            return;
        }
        StringBuilder errorMessage = new StringBuilder();
        for (JdbcPropertyMapping propertyMapping : propertyMappings) {
            validate(validator, operatorType, entity, propertyMapping, errorMessage);
        }
        if (errorMessage.length() > 0) {
            throw new HammerValidateException(errorMessage.toString());
        }
    }

    /**
     * Validate.
     *
     * @param <T> the generic type
     * @param validator the validator
     * @param operatorType the operator type
     * @param entity the entity
     * @param propertyMapping the property mapping
     * @param errorMessage the error message
     */
    public static <T> void validate(Validator validator, OperatorType operatorType, T entity,
        JdbcPropertyMapping propertyMapping, StringBuilder errorMessage) {
        if (validator == null) {
            return;
        }
        // TODO OperatorType.UPSERT 还未支持
        if (propertyMapping.isInsertable() && !propertyMapping.isIgnoreAtInsert()
            && operatorType == OperatorType.INSERT
            || propertyMapping.isUpdatable() && operatorType == OperatorType.UPDATE) {
            Set<ConstraintViolation<?>> cons = null;
            if (propertyMapping.getParent() != null) {
                cons = validateNestedObject(validator, entity, propertyMapping);
            } else {
                cons = validateValue(validator, entity.getClass(), propertyMapping.getPropertyName(),
                    propertyMapping.getProperty().get(entity));
            }
            for (ConstraintViolation<?> constraintViolation : cons) {
                errorMessage.append(propertyMapping.getPropertyFullName()).append(constraintViolation.getMessage())
                    .append(",");
            }
        }
    }

    private static <T> Set<ConstraintViolation<?>> validateNestedObject(Validator validator, T entity,
        JdbcPropertyMapping propertyMapping) {
        // 映射对象，先进行对象验证（例如NotNull）
        JdbcPropertyMapping parentMapping = propertyMapping.getParent();
        Set<ConstraintViolation<?>> cons =
            validateValue(validator, entity.getClass(), parentMapping.getPropertyName(),
                parentMapping.getProperty().get(entity));
        if (!cons.isEmpty()) {
            // 验证不通过，返回
            return cons;
        }

        // YUFEI_TODO 后续优化这里的逻辑，propertyMapping就应该能处理
        if (!BeanDescriptor.getBeanDescriptor(parentMapping.getProperty().getInstanceType())
            .getBeanProperty(parentMapping.getPropertyName()).hasAnnotation(validator.getValidConstraint())) {
            // 没有Valid标注，返回空Set
            return Collections.emptySet();
        }

        Object embedded = parentMapping.getProperty().get(entity);
        if (embedded != null) {
            cons = validateValue(validator, parentMapping.getPropertyType(), propertyMapping.getPropertyName(),
                propertyMapping.getProperty().get(embedded));
        } else {
            cons = validateValue(validator, parentMapping.getPropertyType(), propertyMapping.getPropertyName(),
                null);
        }
        return cons;
    }

    @SuppressWarnings({ "unchecked" })
    private static <T> Set<ConstraintViolation<?>> validateValue(Validator validator,
        Class<T> beanType, String propertyName, Object value, Class<?>... groups) {
        return (Set<ConstraintViolation<?>>) (Set<?>) validator.validateValue(beanType, propertyName, value, groups);
    }
}
