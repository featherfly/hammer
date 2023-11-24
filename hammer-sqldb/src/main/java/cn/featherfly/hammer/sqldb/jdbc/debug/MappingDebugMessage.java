package cn.featherfly.hammer.sqldb.jdbc.debug;

import cn.featherfly.common.lang.debug.AbstractDebugMessage;
import cn.featherfly.common.structure.ChainMapImpl;

/**
 * The Class MappingDebugMessage.
 *
 * @author zhongj
 */
public class MappingDebugMessage extends AbstractDebugMessage<MappingDebugMessage> {

    private String columnTitle = "ColumnName";

    private String columnAsTitle = "ColumnAlias";

    private String propertyTitle = "PropertyName";

    private String propertyTypeTitle = "PropertyType";

    /**
     * Instantiates a new mapping debug message.
     *
     * @param debug the debug
     */
    public MappingDebugMessage(boolean debug) {
        super(debug);
        addColumn(columnTitle, columnAsTitle, propertyTitle, propertyTypeTitle);
    }

    /**
     * Adds the mapping.
     *
     * @param column           the column
     * @param columnAs         the column as
     * @param property         the property
     * @param propertyTypeName the property type name
     * @return the mapping debug message
     */
    public MappingDebugMessage addMapping(String column, String columnAs, String property, String propertyTypeName) {
        return (MappingDebugMessage) addRow(
                new ChainMapImpl<String, Object>().putChain(propertyTitle, property).putChain(columnTitle, column)
                        .putChain(columnAsTitle, columnAs).putChain(propertyTypeTitle, propertyTypeName));
    }
}