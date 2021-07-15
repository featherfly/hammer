
package cn.featherfly.hammer.tpl.supports;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Lang;

/**
 * <p>
 * ConditionParamsManager
 * </p>
 * .
 *
 * @author zhongj
 */
public class ConditionParamsManager {

    /**
     * The Class Param.
     *
     * @author zhongj
     */
    public static class Param {

        /**
         * Instantiates a new param.
         */
        public Param() {
        }

        /**
         * Instantiates a new param.
         *
         * @param name        param name
         * @param transverter param transverter name
         */
        public Param(String name, String transverter) {
            this(name, transverter, false);
        }

        /**
         * Instantiates a new param.
         *
         * @param name        the name
         * @param transverter the transverter
         * @param inCondition the in condition
         */
        public Param(String name, String transverter, boolean inCondition) {
            super();
            this.name = name;
            this.transverter = transverter;
            this.inCondition = inCondition;
        }

        private String name;

        private String transverter;

        private boolean inCondition;

        /**
         * 返回name.
         *
         * @return name
         */
        public String getName() {
            return name;
        }

        /**
         * 设置name.
         *
         * @param name name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * 返回transverter.
         *
         * @return transverter
         */
        public String getTransverter() {
            return transverter;
        }

        /**
         * 设置transverter.
         *
         * @param transverter transverter
         */
        public void setTransverter(String transverter) {
            this.transverter = transverter;
        }

        /**
         * get inCondition value.
         *
         * @return inCondition
         */
        public boolean isInCondition() {
            return inCondition;
        }

        /**
         * set inCondition value.
         *
         * @param inCondition inCondition
         */
        public void setInCondition(boolean inCondition) {
            this.inCondition = inCondition;
        }

        /**
         * Convert sql for in param.
         *
         * @param sql      the sql
         * @param inParams the in params
         * @return the tuple 2
         */
        public Tuple2<String, Map<String, Object>> convertSqlForInParam(String sql, Collection<?> inParams) {
            Map<String, Object> newParams = new LinkedHashMap<>();
            final StringBuilder inParamsSql = new StringBuilder("( ");
            Lang.each(inParams, (v, i) -> {
                String newName = name + i;
                inParamsSql.append(":").append(newName);
                if (i < inParams.size() - 1) {
                    inParamsSql.append(", ");
                }
                newParams.put(newName, v);
            });
            inParamsSql.append(" )");
            return Tuples.of(sql.replaceAll(":" + name, inParamsSql.toString()), newParams);
        }

        /**
         * Convert sql for in param.
         *
         * @param sql      the sql
         * @param inParams the in params
         * @return the tuple 2
         */
        public Tuple2<String, Map<String, Object>> convertSqlForInParam(String sql, Object... inParams) {
            return convertSqlForInParam(sql, ArrayUtils.toList(inParams));
        }

    }

    private Boolean paramNamed;

    private int amount = 0;

    //    private Set<String> filterParamNames = new HashSet<>();

    private Map<String, Param> paramNames = new HashMap<>();

    private Map<Integer, String> paramValuesMap = new TreeMap<>((o1, o2) -> {
        if (o1 > o2) {
            return 1;
        } else if (o1 < o2) {
            return -1;
        } else {
            return 0;
        }
    });

    private ConditionGroup rootGroup = new ConditionGroup();

    private ConditionGroup currentGroup = rootGroup;

    /**
     * Adds the param.
     *
     * @param paramName the param name
     */
    public void addParam(String paramName) {
        addParam(new Param(paramName, null));
    }

    /**
     * Adds the param.
     *
     * @param paramNames the param names
     */
    public void addParams(Collection<String> paramNames) {
        if (Lang.isEmpty(paramNames)) {
            return;
        }

        for (String paramName : paramNames) {
            addParam(new Param(paramName, null));
        }
    }

    /**
     * Adds the param.
     *
     * @param param the param
     */
    public void addParam(Param param) {
        paramValuesMap.put(amount, param.getName());
        paramNames.put(param.getName(), param);
        amount++;
        currentGroup.addCondition();
    }

    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public int getAmount() {
        return paramValuesMap.size();
    }

    /**
     * 返回paramValues.
     *
     * @return paramValues
     */
    public List<String> getParamNames() {
        //        return paramValuesMap.values().stream().map(p -> p.name).collect(Collectors.toList());
        return new ArrayList<>(paramValuesMap.values());
    }

    /**
     * 返回paramValues.
     *
     * @return paramValues
     */
    public List<Param> getParams() {
        return new ArrayList<>(paramNames.values());
    }

    /**
     * Start group.
     */
    public void startGroup() {
        ConditionGroup group = new ConditionGroup();
        currentGroup.addChild(group);
        currentGroup = group;
    }

    /**
     * End group.
     */
    public void endGroup() {
        currentGroup = currentGroup.getParent();
    }

    /**
     * Checks if is need append logic world.
     *
     * @return true, if is need append logic world
     */
    public boolean isNeedAppendLogicWorld() {
        if (currentGroup == rootGroup) {
            return amount > 0;
        } else {
        }
        return currentGroup.getAmount() > 0 && amount > 0;
    }

    /**
     * 返回paramNamed.
     *
     * @return paramNamed
     */
    public Boolean getParamNamed() {
        return paramNamed;
    }

    /**
     * 设置paramNamed.
     *
     * @param paramNamed paramNamed
     */
    public void setParamNamed(Boolean paramNamed) {
        this.paramNamed = paramNamed;
    }

    /**
     * Contains name.
     *
     * @param paramName the param name
     * @return true, if successful
     */
    public boolean containsName(String paramName) {
        return paramValuesMap.containsValue(paramName);
    }

    /**
     * Gets the param.
     *
     * @param paramName the param name
     * @return the param
     */
    public Param getParam(String paramName) {
        return paramNames.get(paramName);
    }

    //    public void addFilterParamName(String paramName) {
    //        filterParamNames.add(paramName);
    //    }

    //    /**
    //     * Filter name.
    //     *
    //     * @param paramName the param name
    //     * @return true, if successful
    //     */
    //    public boolean filterParamName(String paramName) {
    //        return filterParamNames.contains(paramName);
    //    }

    /**
     * Checks for in param.
     *
     * @return true, if successful
     */
    public boolean hasInParam() {
        return paramNames.values().stream().anyMatch(v -> v.isInCondition());
    }

}
