
package cn.featherfly.juorm.rdb.sqltpl.freemarker;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * ConditionParamsManager
 * </p>
 * 
 * @author zhongj
 */
public class ConditionParamsManager {

    private int amount = 0;

    private Map<Integer, String> paramValuesMap = new HashMap<>();

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
     * 返回paramValuesMap
     * 
     * @return paramValuesMap
     */
    public Map<Integer, String> getParamValuesMap() {
        return paramValuesMap;
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

}
