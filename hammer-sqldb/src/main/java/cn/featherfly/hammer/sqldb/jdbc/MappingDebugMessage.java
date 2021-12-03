package cn.featherfly.hammer.sqldb.jdbc;

import java.util.ArrayList;
import java.util.List;

import cn.featherfly.common.lang.Strings;

/**
 * The Class MappingDebugMessage.
 *
 * @author zhongj
 */
public class MappingDebugMessage {

    private int columnMaxLength;

    private int columnAsMaxLength;

    private int propertyMaxLength;

    private final List<Mapping> mappings = new ArrayList<>(0);

    /**
     * Adds the mapping.
     *
     * @param column           the column
     * @param property         the property
     * @param propertyTypeName the property type name
     */
    public void addMapping(String column, String property, String propertyTypeName) {
        addMapping(column, column, property, propertyTypeName);
    }

    /**
     * Adds the mapping.
     *
     * @param column           the column
     * @param columnAs         the column as
     * @param property         the property
     * @param propertyTypeName the property type name
     */
    public void addMapping(String column, String columnAs, String property, String propertyTypeName) {
        Mapping mapping = new Mapping();
        mapping.column = column;
        if (columnMaxLength < column.length()) {
            columnMaxLength = column.length();
        }
        mapping.property = property;
        if (propertyMaxLength < property.length()) {
            propertyMaxLength = property.length();
        }

        mapping.propertyTypeName = propertyTypeName;

        if (columnAs != null) {
            mapping.columnAs = columnAs;
            if (columnAsMaxLength < columnAs.length()) {
                columnAsMaxLength = columnAs.length();
            }
        }

        mappings.add(mapping);
    }

    private class Mapping {

        private String column;

        private String columnAs;

        private String property;

        private String propertyTypeName;

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            String format = Strings.format("  Mapping column %-{0}s as %-{1}s to property %-{2}s of type {3}\n",
                    columnMaxLength, columnAsMaxLength, propertyMaxLength, propertyTypeName);
            return String.format(format, column, columnAs, property);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder dm = new StringBuilder();
        for (Mapping mapping : mappings) {
            dm.append(mapping.toString());
        }
        return dm.toString();
    }
}