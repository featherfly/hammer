
package cn.featherfly.hammer.tpl.supports;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

import cn.featherfly.hammer.tpl.supports.WhereConditionParams.Param;

/**
 * ConditionParamsManager .
 *
 * @author zhongj
 */
public class ConditionParamsManager {

    private final List<WhereConditionParams> paramsManagers = new ArrayList<>();

    private final IntFunction<String> indexToName;

    /**
     * Instantiates a new condition params manager.
     *
     * @param indexToName the index to name
     */
    public ConditionParamsManager(IntFunction<String> indexToName) {
        this.indexToName = indexToName;
    }

    public WhereConditionParams addWhere() {
        WhereConditionParams conditionParamsManager = new WhereConditionParams(indexToName);
        paramsManagers.add(conditionParamsManager);
        return conditionParamsManager;
    }

    /**
     * Gets the param with name.
     *
     * @param paramName the param name
     * @return the param
     */
    public Param getParam(String paramName) {
        Param param = null;
        for (WhereConditionParams paramsManager : paramsManagers) {
            param = paramsManager.getParam(paramName);
            if (param != null) {
                return param;
            }
        }
        return param;
    }

    /**
     * Gets the param with index.
     *
     * @param paramIndex the param index
     * @return the param
     */
    public Param getParam(int paramIndex) {
        return getParam(paramIndex + "");
    }

    /**
     * Filter name.
     *
     * @param paramName the param name
     * @return true, if successful
     */
    public boolean filterParamName(String paramName) {
        boolean filter = false;
        for (WhereConditionParams paramsManager : paramsManagers) {
            filter = paramsManager.filterParamName(paramName);
            if (filter) {
                return filter;
            }
        }
        return filter;
    }

    /**
     * Filter name.
     *
     * @param index the index
     * @return true, if successful
     */
    public boolean filterParamIndex(int index) {
        return filterParamName(indexToName.apply(index));
    }
}
