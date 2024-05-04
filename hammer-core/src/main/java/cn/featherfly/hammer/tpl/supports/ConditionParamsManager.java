
package cn.featherfly.hammer.tpl.supports;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.featherfly.common.lang.Lang;

/**
 * ConditionParamsManager .
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
         * @param name        the name
         * @param transverter the transverter
         */
        public Param(String name, String transverter) {
            super();
            this.name = name;
            this.transverter = transverter;
        }

        private String name;

        private String transverter;

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

    }

    private Boolean paramNamed;

    private final Set<String> filterParamNames = new HashSet<>();

    private final Map<String, Param> nameParamMap = new LinkedHashMap<>();

    private final List<Param> paramList = new ArrayList<>();

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
        paramList.add(param);
        nameParamMap.putIfAbsent(param.getName(), param);
        currentGroup.addCondition();
    }

    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public int getAmount() {
        return paramList.size();
    }

    /**
     * 返回paramValues.
     *
     * @return paramValues
     */
    public List<String> getParamNames() {
        return new ArrayList<>(nameParamMap.keySet());
    }

    /**
     * 返回paramValues.
     *
     * @return paramValues
     */
    public List<Param> getParams() {
        return new ArrayList<>(paramList);
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
            return getAmount() > 0;
        } else {
            return currentGroup.getAmount() > 0 && getAmount() > 0;
        }
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
        return nameParamMap.containsKey(paramName);
    }

    /**
     * Gets the param.
     *
     * @param paramName the param name
     * @return the param
     */
    public Param getParam(String paramName) {
        return nameParamMap.get(paramName);
    }

    public void addFilterParamName(String paramName) {
        filterParamNames.add(paramName);
    }

    public void addFilterParamNames(String... paramNames) {
        if (paramNames != null) {
            for (String pn : paramNames) {
                addFilterParamName(pn);
            }
        }
    }

    /**
     * Filter name.
     *
     * @param paramName the param name
     * @return true, if successful
     */
    public boolean filterParamName(String paramName) {
        return filterParamNames.contains(paramName);
    }
}
