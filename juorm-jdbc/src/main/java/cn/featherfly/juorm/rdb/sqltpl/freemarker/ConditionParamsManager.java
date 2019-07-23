
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

    public void addParam(String paramName) {
        paramValuesMap.put(amount, paramName);
        amount++;
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
}
