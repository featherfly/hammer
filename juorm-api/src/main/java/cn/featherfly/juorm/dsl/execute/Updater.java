
package cn.featherfly.juorm.dsl.execute;

import cn.featherfly.juorm.expression.execute.UpdaterExpression;

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
