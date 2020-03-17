
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.execute.UpdaterExpression;

/**
 * <p>
 * Updater
 * </p>
 *
 * @author zhongj
 */
public interface Updater extends
        UpdaterExpression<Update, ExecutableUpdate, ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression, UpdateValue, UpdateNumberValue> {

}
