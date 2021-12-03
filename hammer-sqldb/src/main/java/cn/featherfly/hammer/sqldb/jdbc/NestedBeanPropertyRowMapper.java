
package cn.featherfly.hammer.sqldb.jdbc;

import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.NotWritablePropertyException;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.bean.NoSuchPropertyException;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.mapping.JdbcMappingException;
import cn.featherfly.common.db.mapping.SqlResultSet;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.lang.AssertIllegalArgument;

/**
 * {@link RowMapper} implementation that converts a row into a new instance of
 * the specified mapped target class. The mapped target class must be a
 * top-level class and it must have a default or no-arg constructor.
 * <p>
 * Column values are mapped based on matching the column name as obtained from
 * result set meta-data to public setters for the corresponding properties. The
 * names are matched either directly or by transforming a name separating the
 * parts with underscores to the same name using "camel" case.
 * <p>
 * Mapping is provided for fields in the target class for many common types,
 * e.g.: String, boolean, Boolean, byte, Byte, short, Short, int, Integer, long,
 * Long, float, Float, double, Double, BigDecimal, {@code java.util.Date}, etc.
 * <p>
 * To facilitate mapping between columns and fields that don't have matching
 * names, try using column aliases in the SQL statement like "select fname as
 * first_name from customer".
 * <p>
 * For 'null' values read from the database, we will attempt to call the setter,
 * but in the case of Java primitives, this causes a TypeMismatchException. This
 * class can be configured (using the primitivesDefaultedForNullValue property)
 * to trap this exception and use the primitives default value. Be aware that if
 * you use the values from the generated bean to update the database the
 * primitive value will have been set to the primitive's default value instead
 * of null.
 * <p>
 * Please note that this class is designed to provide convenience rather than
 * high performance. For best performance, consider using a custom
 * {@link RowMapper} implementation.
 *
 * @author Thomas Risberg
 * @author Juergen Hoeller
 * @author zhongj
 * @param <T> the result type
 * @since 0.1.0
 */
public class NestedBeanPropertyRowMapper<T>
        implements RowMapper<T>, cn.featherfly.common.repository.mapping.RowMapper<T> {

    /** Logger available to subclasses. */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /** The class we are mapping to. */
    @Nullable
    private Class<T> mappedClass;

    /** Whether we're strictly validating. */
    private boolean checkFullyPopulated = false;

    /** Whether we're defaulting primitives when mapping a null value. */
    private boolean primitivesDefaultedForNullValue = false;

    /** ConversionService for binding JDBC values to bean properties. */
    @Nullable
    private ConversionService conversionService = DefaultConversionService.getSharedInstance();

    /** Map of the fields we provide mapping for. */
    @Nullable
    private Map<String, PropertyDescriptor> mappedFields;

    /** Set of bean properties we provide mapping for. */
    @Nullable
    private Set<String> mappedProperties;

    @Nullable
    private SqlTypeMappingManager manager;

    /**
     * Create a new {@code BeanPropertyRowMapper}, accepting unpopulated
     * properties in the target bean.
     * <p>
     *
     * @param mappedClass the class that each row should be mapped to
     * @param manager     the manager
     */
    public NestedBeanPropertyRowMapper(Class<T> mappedClass, SqlTypeMappingManager manager) {
        initialize(mappedClass);
        this.manager = manager;
    }

    /**
     * Create a new {@code BeanPropertyRowMapper}.
     *
     * @param mappedClass         the class that each row should be mapped to
     * @param manager             the manager
     * @param checkFullyPopulated whether we're strictly validating that all
     *                            bean properties have been mapped from
     *                            corresponding database fields
     */
    public NestedBeanPropertyRowMapper(Class<T> mappedClass, SqlTypeMappingManager manager,
            boolean checkFullyPopulated) {
        initialize(mappedClass);
        this.manager = manager;
        this.checkFullyPopulated = checkFullyPopulated;
    }

    /**
     * Set the class that each row should be mapped to.
     *
     * @param mappedClass the new mapped class
     */
    public void setMappedClass(Class<T> mappedClass) {
        if (this.mappedClass == null) {
            initialize(mappedClass);
        } else {
            if (this.mappedClass != mappedClass) {
                throw new InvalidDataAccessApiUsageException("The mapped class can not be reassigned to map to "
                        + mappedClass + " since it is already providing mapping for " + this.mappedClass);
            }
        }
    }

    /**
     * Get the class that we are mapping to.
     *
     * @return the mapped class
     */
    @Nullable
    public final Class<T> getMappedClass() {
        return this.mappedClass;
    }

    /**
     * Set whether we're strictly validating that all bean properties have been
     * mapped from corresponding database fields.
     * <p>
     * Default is {@code false}, accepting unpopulated properties in the target
     * bean.
     *
     * @param checkFullyPopulated the new check fully populated
     */
    public void setCheckFullyPopulated(boolean checkFullyPopulated) {
        this.checkFullyPopulated = checkFullyPopulated;
    }

    /**
     * Return whether we're strictly validating that all bean properties have
     * been mapped from corresponding database fields.
     *
     * @return true, if is check fully populated
     */
    public boolean isCheckFullyPopulated() {
        return this.checkFullyPopulated;
    }

    /**
     * Set whether we're defaulting Java primitives in the case of mapping a
     * null value from corresponding database fields.
     * <p>
     * Default is {@code false}, throwing an exception when nulls are mapped to
     * Java primitives.
     *
     * @param primitivesDefaultedForNullValue the new primitives defaulted for
     *                                        null value
     */
    public void setPrimitivesDefaultedForNullValue(boolean primitivesDefaultedForNullValue) {
        this.primitivesDefaultedForNullValue = primitivesDefaultedForNullValue;
    }

    /**
     * Return whether we're defaulting Java primitives in the case of mapping a
     * null value from corresponding database fields.
     *
     * @return true, if is primitives defaulted for null value
     */
    public boolean isPrimitivesDefaultedForNullValue() {
        return this.primitivesDefaultedForNullValue;
    }

    /**
     * Set a {@link ConversionService} for binding JDBC values to bean
     * properties, or {@code null} for none.
     * <p>
     * Default is a {@link DefaultConversionService}, as of Spring 4.3. This
     * provides support for {@code java.time} conversion and other special
     * types.
     *
     * @param conversionService the new conversion service
     * @see #initBeanWrapper(BeanWrapper)
     * @since 4.3
     */
    public void setConversionService(@Nullable ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * Return a {@link ConversionService} for binding JDBC values to bean
     * properties, or {@code null} if none.
     *
     * @return the conversion service
     * @since 4.3
     */
    @Nullable
    public ConversionService getConversionService() {
        return this.conversionService;
    }

    /**
     * Initialize the mapping meta-data for the given class.
     *
     * @param mappedClass the mapped class
     */
    protected void initialize(Class<T> mappedClass) {
        AssertIllegalArgument.isNotNull(mappedClass, "mappedClass");
        this.mappedClass = mappedClass;
        this.mappedFields = new HashMap<>();
        this.mappedProperties = new HashSet<>();
        PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(mappedClass);
        for (PropertyDescriptor pd : pds) {
            if (pd.getWriteMethod() != null) {
                this.mappedFields.put(lowerCaseName(pd.getName()), pd);
                String underscoredName = underscoreName(pd.getName());
                if (!lowerCaseName(pd.getName()).equals(underscoredName)) {
                    this.mappedFields.put(underscoredName, pd);
                }
                this.mappedProperties.add(pd.getName());
            }
        }
    }

    /**
     * Convert a name in camelCase to an underscored name in lower case. Any
     * upper case letters are converted to lower case with a preceding
     * underscore.
     *
     * @param name the original name
     * @return the converted name
     * @see #lowerCaseName
     * @since 4.2
     */
    protected String underscoreName(String name) {
        if (!StringUtils.hasLength(name)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        result.append(lowerCaseName(name.substring(0, 1)));
        for (int i = 1; i < name.length(); i++) {
            String s = name.substring(i, i + 1);
            String slc = lowerCaseName(s);
            if (!s.equals(slc)) {
                result.append("_").append(slc);
            } else {
                result.append(s);
            }
        }
        return result.toString();
    }

    /**
     * Convert the given name to lower case. By default, conversions will happen
     * within the US locale.
     *
     * @param name the original name
     * @return the converted name
     * @since 4.2
     */
    protected String lowerCaseName(String name) {
        return name.toLowerCase(Locale.US);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T mapRow(cn.featherfly.common.repository.mapping.ResultSet res, int rowNum) {
        ResultSet rs = null;
        if (res instanceof SqlResultSet) {
            SqlResultSet sqlrs = (SqlResultSet) res;
            rs = sqlrs.getResultSet();
            AssertIllegalArgument.isNotNull(rs, "java.sql.ResultSet");
        } else {
            throw new JdbcMappingException("ResultSet is not type of SqlResultSet");
        }

        try {
            return mapRow(rs, rowNum);
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    private List<Mapping> mappings;

    /**
     * Extract the values for all columns in the current row.
     * <p>
     * Utilizes public setters and result set meta-data.
     *
     * @param rs        the rs
     * @param rowNumber the row number
     * @return the t
     * @throws SQLException the SQL exception
     * @see java.sql.ResultSetMetaData
     */
    @Override
    public T mapRow(ResultSet rs, int rowNumber) throws SQLException {
        Assert.state(this.mappedClass != null, "Mapped class was not specified");
        T mappedObject = BeanUtils.instantiateClass(this.mappedClass);
        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(mappedObject);
        initBeanWrapper(bw);

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        Set<String> populatedProperties = isCheckFullyPopulated() ? new HashSet<>() : null;

        MappingDebugMessage mappingDebugMessage = new MappingDebugMessage();
        BeanDescriptor<T> beanDescriptor = BeanDescriptor.getBeanDescriptor(mappedClass);
        if (rowNumber == 0) {
            mappings = new ArrayList<>();

            for (int index = 1; index <= columnCount; index++) {
                Mapping mapping = new Mapping();
                mappings.add(mapping);

                String column = JdbcUtils.lookupColumnName(rsmd, index);
                String field = lowerCaseName(org.springframework.util.StringUtils.delete(column, " "));
                boolean nestedProperty = false;
                if (field.contains(".")) {
                    nestedProperty = true;
                    field = org.apache.commons.lang3.StringUtils.substringBefore(field, ".");
                }
                mapping.column = rsmd.getColumnName(index);
                mapping.columnAs = column;

                PropertyDescriptor pd = this.mappedFields != null ? this.mappedFields.get(field) : null;
                mapping.propertyDescriptor = pd;
                if (pd != null) {
                    BeanProperty<?> bp;
                    if (nestedProperty) {
                        // 嵌套设值，所以直接使用SQL查询出来列的别名
                        bp = beanDescriptor.getChildBeanProperty(column);
                        // bp == null will throw NoSuchPropertyException
                        mapping.property = column;
                        mapping.propertyTypeName = bp.getType().getName();
                        mapping.beanProperty = bp;
                    } else {
                        try {
                            bp = beanDescriptor.getChildBeanProperty(pd.getName());

                            mapping.property = pd.getName();
                            mapping.propertyTypeName = bp.getType().getName();
                            mapping.beanProperty = bp;

                        } catch (NoSuchPropertyException e) {
                            logger.debug(e.getMessage());

                            mapping.property = pd.getName();
                            mapping.propertyTypeName = ClassUtils.getQualifiedName(pd.getPropertyType());
                        }
                    }

                    if (logger.isDebugEnabled()) {
                        mappingDebugMessage.addMapping(mapping.column, mapping.columnAs, mapping.property,
                                mapping.propertyTypeName);
                    }

                    if (populatedProperties != null) {
                        populatedProperties.add(mapping.propertyDescriptor.getName());
                    }
                } else {
                    logger.debug("No property found for column '" + column + "' mapped to field '" + field + "'");
                }
            }

            if (logger.isDebugEnabled()) {
                StringBuilder debugMessage = new StringBuilder();
                debugMessage.append("\n---------- Map " + mappedClass.getName() + " Start ----------\n")
                        .append(mappingDebugMessage.toString())
                        .append("---------- Map " + mappedClass.getName() + " End ----------");
                logger.debug(debugMessage.toString());
            }
        }

        for (int index = 1; index <= mappings.size(); index++) {
            Mapping mapping = mappings.get(index - 1);
            if (mapping.propertyDescriptor != null) {
                try {
                    Object value = null;
                    if (mapping.beanProperty != null) {
                        value = manager.get(rs, index, mapping.beanProperty);
                        beanDescriptor.setProperty(mappedObject, mapping.property, value);
                    } else {
                        value = getColumnValue(rs, index, mapping.propertyDescriptor);
                        try {
                            bw.setPropertyValue(mapping.propertyDescriptor.getName(), value);
                        } catch (TypeMismatchException ex) {
                            if (value == null && this.primitivesDefaultedForNullValue) {
                                if (logger.isDebugEnabled()) {
                                    logger.debug("Intercepted TypeMismatchException for row " + rowNumber
                                            + " and column '" + mapping.columnAs
                                            + "' with null value when setting property '"
                                            + mapping.propertyDescriptor.getName() + "' of type '"
                                            + ClassUtils.getQualifiedName(mapping.propertyDescriptor.getPropertyType())
                                            + "' on object: " + mappedObject, ex);
                                }
                            } else {
                                throw ex;
                            }
                        }
                    }
                } catch (NotWritablePropertyException ex) {
                    throw new DataRetrievalFailureException(
                            "Unable to map column '" + mapping.columnAs + "' to property '" + mapping.property + "'",
                            ex);
                }
            }
        }

        //        for (int index = 1; index <= columnCount; index++) {
        //            PropertyDescriptor pd = this.mappedFields != null ? this.mappedFields.get(field) : null;
        //            if (pd != null) {
        //                try {
        //                    BeanDescriptor<T> bd = BeanDescriptor.getBeanDescriptor(mappedClass);
        //                    Object value = null;
        //                    if (nestedProperty) {
        //                        // 嵌套设值，所以直接使用SQL查询出来列的别名
        //                        bp = bd.getChildBeanProperty(column);
        //                        // bp == null will throw NoSuchPropertyException
        //                        if (rowNumber == 0 && logger.isDebugEnabled()) {
        //                            mappingDebugMessage.addMapping(rsmd.getColumnName(index), column, column,
        //                                    bp.getType().getName());
        //                        }
        //                        value = manager.get(rs, index, bp);
        //                        bd.setProperty(mappedObject, column, value);
        //                    } else {
        //                        bp = bd.getChildBeanProperty(pd.getName());
        //                        if (bp != null) {
        //                            value = manager.get(rs, index, bp);
        //                        } else {
        //                            value = getColumnValue(rs, index, pd);
        //                        }
        //                        if (rowNumber == 0 && logger.isDebugEnabled()) {
        //                            mappingDebugMessage.addMapping(rsmd.getColumnName(index), pd.getName(),
        //                                    ClassUtils.getQualifiedName(pd.getPropertyType()));
        //                        }
        //                        try {
        //                            bw.setPropertyValue(pd.getName(), value);
        //                        } catch (TypeMismatchException ex) {
        //                            if (value == null && this.primitivesDefaultedForNullValue) {
        //                                if (logger.isDebugEnabled()) {
        //                                    logger.debug("Intercepted TypeMismatchException for row " + rowNumber
        //                                            + " and column '" + column + "' with null value when setting property '"
        //                                            + pd.getName() + "' of type '"
        //                                            + ClassUtils.getQualifiedName(pd.getPropertyType()) + "' on object: "
        //                                            + mappedObject, ex);
        //                                }
        //                            } else {
        //                                throw ex;
        //                            }
        //                        }
        //                        if (populatedProperties != null) {
        //                            populatedProperties.add(pd.getName());
        //                        }
        //                    }
        //                } catch (NotWritablePropertyException ex) {
        //                    throw new DataRetrievalFailureException(
        //                            "Unable to map column '" + column + "' to property '" + pd.getName() + "'", ex);
        //                }
        //            } else {
        //                // No PropertyDescriptor found
        //                if (rowNumber == 0 && logger.isDebugEnabled()) {
        //                    logger.debug("No property found for column '" + column + "' mapped to field '" + field + "'");
        //                }
        //            }
        //        }

        //        if (rowNumber == 0 && logger.isDebugEnabled()) {
        //            StringBuilder debugMessage = new StringBuilder();
        //            debugMessage.append("\n---------- Map " + mappedClass.getName() + " Start ----------\n")
        //                    .append(mappingDebugMessage.toString())
        //                    .append("---------- Map " + mappedClass.getName() + " End ----------");
        //            logger.debug(debugMessage.toString());
        //        }

        if (populatedProperties != null && !populatedProperties.equals(this.mappedProperties)) {
            throw new InvalidDataAccessApiUsageException(
                    "Given ResultSet does not contain all fields " + "necessary to populate object of class ["
                            + this.mappedClass.getName() + "]: " + this.mappedProperties);
        }

        return mappedObject;
    }

    /**
     * Initialize the given BeanWrapper to be used for row mapping. To be called
     * for each row.
     * <p>
     * The default implementation applies the configured
     * {@link ConversionService}, if any. Can be overridden in subclasses.
     *
     * @param bw the BeanWrapper to initialize
     * @see #getConversionService()
     * @see BeanWrapper#setConversionService
     */
    protected void initBeanWrapper(BeanWrapper bw) {
        ConversionService cs = getConversionService();
        if (cs != null) {
            bw.setConversionService(cs);
        }
    }

    /**
     * Retrieve a JDBC object value for the specified column.
     * <p>
     * The default implementation calls
     * {@link JdbcUtils#getResultSetValue(java.sql.ResultSet, int, Class)}.
     * Subclasses may override this to check specific value types upfront, or to
     * post-process values return from {@code getResultSetValue}.
     *
     * @param rs    is the ResultSet holding the data
     * @param index is the column index
     * @param pd    the bean property that each result object is expected to
     *              match
     * @return the Object value
     * @throws SQLException in case of extraction failure
     * @see org.springframework.jdbc.support.JdbcUtils#getResultSetValue(java.sql.ResultSet,
     *      int, Class)
     */
    @Nullable
    protected Object getColumnValue(ResultSet rs, int index, PropertyDescriptor pd) throws SQLException {
        return JdbcUtils.getResultSetValue(rs, index, pd.getPropertyType());
    }

    public static class Mapping {

        String column;

        String columnAs;

        String property;

        String propertyTypeName;

        BeanProperty<?> beanProperty;

        private PropertyDescriptor propertyDescriptor;

        //        /**
        //         * {@inheritDoc}
        //         */
        //        @Override
        //        public String toString() {
        //            String format = Strings.format("  Mapping column %-{0}s as %-{1}s to property %-{2}s of type {3}\n",
        //                    columnMaxLength, columnAsMaxLength, propertyMaxLength, propertyTypeName);
        //            return String.format(format, column, columnAs, property);
        //        }
    }
}
