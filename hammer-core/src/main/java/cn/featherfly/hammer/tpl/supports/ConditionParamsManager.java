
package cn.featherfly.hammer.tpl.supports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * <p>
 * ConditionParamsManager
 * </p>
 *
 * @author zhongj
 */
public class ConditionParamsManager {

    public static class Param {

        public Param() {
        }

        /**
         * @param name        param name
         * @param transverter param transverter name
         */
        public Param(String name, String transverter) {
            super();
            this.name = name;
            this.transverter = transverter;
        }

        private String name;

        private String transverter;

        /**
         * 返回name
         *
         * @return name
         */
        public String getName() {
            return name;
        }

        /**
         * 设置name
         *
         * @param name name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * 返回transverter
         *
         * @return transverter
         */
        public String getTransverter() {
            return transverter;
        }

        /**
         * 设置transverter
         *
         * @param transverter transverter
         */
        public void setTransverter(String transverter) {
            this.transverter = transverter;
        }
    }

    private Boolean paramNamed;

    private int amount = 0;

    private Set<String> filterParamNames = new HashSet<>();

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

    public void addParam(String paramName) {
        addParam(new Param(paramName, null));
    }

    public void addParam(Param param) {
        paramValuesMap.put(amount, param.getName());
        paramNames.put(param.getName(), param);
        amount++;
        currentGroup.addCondition();
    }

    public int getAmount() {
        return paramValuesMap.size();
    }

    /**
     * 返回paramValues
     *
     * @return paramValues
     */
    public List<String> getParamNames() {
        //        return paramValuesMap.values().stream().map(p -> p.name).collect(Collectors.toList());
        return new ArrayList<>(paramValuesMap.values());
    }

    public void startGroup() {
        ConditionGroup group = new ConditionGroup();
        currentGroup.addChild(group);
        currentGroup = group;
    }

    public void endGroup() {
        currentGroup = currentGroup.getParent();
    }

    public boolean isNeedAppendLogicWorld() {
        if (currentGroup == rootGroup) {
            return amount > 0;
        } else {
        }
        return currentGroup.getAmount() > 0 && amount > 0;
    }

    /**
     * 返回paramNamed
     *
     * @return paramNamed
     */
    public Boolean getParamNamed() {
        return paramNamed;
    }

    /**
     * 设置paramNamed
     *
     * @param paramNamed paramNamed
     */
    public void setParamNamed(Boolean paramNamed) {
        this.paramNamed = paramNamed;
    }

    public boolean containsName(String paramName) {
        return paramValuesMap.containsValue(paramName);
    }

    public Param getParam(String paramName) {
        return paramNames.get(paramName);
    }

    public boolean filterName(String paramName) {
        return filterParamNames.contains(paramName);
    }
}
