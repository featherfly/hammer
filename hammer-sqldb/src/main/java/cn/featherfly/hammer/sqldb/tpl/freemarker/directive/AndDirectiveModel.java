
package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import cn.featherfly.hammer.tpl.directive.AndDirective;
import cn.featherfly.hammer.tpl.supports.ConditionParamsManager;

/**
 * AndDirectiveModel .
 *
 * @author zhongj
 */
public class AndDirectiveModel extends LogicDirectiveModel implements AndDirective {

    /**
     * Instantiates a new and template directive model.
     *
     * @param conditionParamsManager the condition params manager
     */
    public AndDirectiveModel(ConditionParamsManager conditionParamsManager) {
        super(conditionParamsManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getLogicWorld() {
        return "and";
    }

}
