
package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.util.Set;
import java.util.function.Function;

import cn.featherfly.common.db.FieldValueOperator;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.validation.Validator;
import cn.featherfly.validation.metadata.ConstraintViolation;

/**
 * 数据库操作的抽象类.
 *
 * @author zhongj
 * @param <T> the generic type
 * @since 0.1.0
 */
public abstract class AbstractExecuteOperate<T> extends AbstractOperate<T> implements ExecuteOperate<T> {

    /** The validator. */
    protected final Validator validator;

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc the jdbc
     * @param classMapping the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata the database metadata
     * @param validator the validator
     */
    protected AbstractExecuteOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping,
        SqlTypeMappingManager sqlTypeMappingManager, DatabaseMetadata databaseMetadata, Validator validator) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata);
        this.validator = validator;
    }

    /**
     * 执行操作. 操作的类型由具体子类构造的不同SQL来区分.
     *
     * @param entity the entity
     * @return 操作影响的数据行数
     */
    @Override
    public int execute(final T entity) {
        validate(entity);
        return jdbc.update(sql, getParameters(entity));
    }

    // ********************************************************************

    /**
     * Gets the parameters.
     *
     * @param entity the entity
     * @return the parameters
     */
    protected Serializable[] getParameters(T entity) {
        return getParameters(entity, paramsPropertyAndMappings);
    }

    /**
     * Gets the parameters.
     *
     * @param entity the entity
     * @param paramsPropertyAndMappings the params property and mappings
     * @return the parameters
     */
    protected Serializable[] getParameters(T entity,
        Tuple2<Function<T, Object>, JdbcPropertyMapping>[] paramsPropertyAndMappings) {
        Serializable[] operators = new Serializable[paramsPropertyAndMappings.length];
        int i = 0;
        for (Tuple2<Function<T, Object>, JdbcPropertyMapping> paramsPropertyAndMapping : paramsPropertyAndMappings) {
            operators[i] = FieldValueOperator.create(paramsPropertyAndMapping.get1(),
                paramsPropertyAndMapping.get0().apply(entity));
            i++;
        }
        return operators;
    }

    /**
     * Gets the parameters.
     *
     * @param entity the entity
     * @param mappings the mappings
     * @param useIdGenerator the use id generator
     * @return the parameters
     */
    protected Serializable[] getParameters(T entity, JdbcPropertyMapping[] mappings, boolean useIdGenerator) {
        Serializable[] operators = new Serializable[mappings.length];
        int i = 0;
        StringBuilder errorMessage = new StringBuilder();
        for (JdbcPropertyMapping mapping : mappings) {
            if (useIdGenerator && mapping.getPrimaryKey() != null) {
                Serializable propertyValue =
                    mapping.getPrimaryKey().getIdGenerator().generate(entity, mapping);
                validate(entity, mapping, errorMessage);
                operators[i] = FieldValueOperator.create(mapping, propertyValue);
            } else {
                // operators[i] = FieldValueOperator.create(mapping,propertyAccessor.getPropertyValue(entity, mapping.getPropertyIndexes()));
                Object propertyValue = mapping.getGetter().apply(entity);
                validate(entity, mapping, errorMessage);
                operators[i] = FieldValueOperator.create(mapping, propertyValue);
            }
            i++;
        }
        if (errorMessage.length() > 0) {
            errorMessage.deleteCharAt(errorMessage.length() - 1);
            throw new SqldbHammerException(errorMessage.toString());
        }
        return operators;
    }

    /**
     * Gets the parameters.
     *
     * @param entity the entity
     * @param mappings the mappings
     * @return the parameters
     */
    protected Serializable[] getParameters(T entity, JdbcPropertyMapping[] mappings) {
        return getParameters(entity, mappings, false);
    }

    protected void validate(T entity, JdbcPropertyMapping mapping, StringBuilder errorMessage) {
        if (validator == null) {
            return;
        }
        Set<ConstraintViolation<T>> cons = validator.validateProperty(entity, mapping.getPropertyName());
        for (ConstraintViolation<T> constraintViolation : cons) {
            errorMessage.append(constraintViolation.getMessage()).append(",");
        }
    }

    /**
     * Check.
     *
     * @param entity the entity
     */
    protected void validate(T entity) {
        for (JdbcPropertyMapping pkp : pkProperties) {
            if (Lang.isEmpty(pkp.getGetter().apply(entity))) {
                throw idNullOrEmptyException(entity.getClass());
            }
        }
    }
}
