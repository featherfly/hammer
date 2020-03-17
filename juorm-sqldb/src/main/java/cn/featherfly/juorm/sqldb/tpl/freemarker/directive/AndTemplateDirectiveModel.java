
package cn.featherfly.juorm.sqldb.tpl.freemarker.directive;

import cn.featherfly.juorm.tpl.directive.AndDirective;
import cn.featherfly.juorm.tpl.supports.ConditionParamsManager;

/**
 * <p>
 * AndTemplateDirectiveModel
 * </p>
 * .
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
