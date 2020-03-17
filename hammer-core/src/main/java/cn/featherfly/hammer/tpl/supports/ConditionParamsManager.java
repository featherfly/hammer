
package cn.featherfly.hammer.tpl.supports;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 * ConditionParamsManager
 * </p>
 *
 * @author zhongj
 */
public class ConditionParamsManager {

    private Boolean paramNamed;

    private int amount = 0;

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
        paramValuesMap.put(amount, paramName);
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
     * @param paramNamed
     *            paramNamed
     */
    public void setParamNamed(Boolean paramNamed) {
        this.paramNamed = paramNamed;
    }

    public boolean containsName(String paramName) {
        return paramValuesMap.containsValue(paramName);
    }
}
