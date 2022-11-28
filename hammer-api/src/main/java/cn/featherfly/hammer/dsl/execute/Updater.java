
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.execute.UpdaterExpression;

/**
 * Updater.
 *
 * @author zhongj
 */
public interface Updater extends
        UpdaterExpression<Update, ExecutableUpdate, ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression, UpdateValue, UpdateNumberValue> {

}
