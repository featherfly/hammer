
package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import cn.featherfly.hammer.tpl.directive.AndDirective;
import cn.featherfly.hammer.tpl.supports.ConditionParamsManager;

/**
 * AndTemplateDirectiveModel .
 *
 * @author zhongj
 */
public class AndTemplateDirectiveModel extends LogicTemplateDirectiveModel implements AndDirective {

    /**
     * Instantiates a new and template directive model.
     *
     * @param conditionParamsManager the condition params manager
     */
    public AndTemplateDirectiveModel(ConditionParamsManager conditionParamsManager) {
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
