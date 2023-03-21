
/*
 * All rights Reserved, Designed By zhongj
 * @Title: PropertiesMappingManager.java
 * @Package cn.featherfly.hammer.tpl.supports
 * @Description: PropertiesMappingManager
 * @author: zhongj
 * @date: 2023-03-23 15:10:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl.supports;

import java.util.HashMap;
import java.util.Map;

/**
 * PropertiesMappingManager.
 *
 * @author zhongj
 */
public class PropertiesMappingManager {

    private Map<Integer, Value> propValues = new HashMap<>();

    /**
     * Adds the values.
     *
     * @param values the values
     * @return the index
     */
    public int addValue(Value values) {
        int index = propValues.size();
        values.index = index;
        propValues.put(index, values);
        return index;
    }

    /**
     * Gets the index.
     *
     * @return the index
     */
    public int getIndex() {
        return propValues.size();
    }

    /**
     * Gets the value.
     *
     * @param index the index
     * @return the value
     */
    public Value getValue(int index) {
        return propValues.get(index);
    }

    /**
     * The Class Values.
     *
     * @author zhongj
     */
    public static class Value {

        private int index;

        private String alias;

        private Class<?> mapping;

        private String repo;

        /**
         * Instantiates a new values.
         *
         * @param alias   the alias
         * @param mapping the mapping
         * @param repo    the repo
         */
        public Value(String alias, Class<?> mapping, String repo) {
            super();
            this.alias = alias;
            this.mapping = mapping;
            this.repo = repo;
        }

        /**
         * get mapping value.
         *
         * @return mapping
         */
        public Class<?> getMapping() {
            return mapping;
        }

        /**
         * get repo value.
         *
         * @return repo
         */
        public String getRepo() {
            return repo;
        }

        /**
         * get index value.
         *
         * @return index
         */
        public int getIndex() {
            return index;
        }

        /**
         * get alias value.
         *
         * @return alias
         */
        public String getAlias() {
            return alias;
        }
    }
}
