
package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import cn.featherfly.hammer.tpl.directive.OrDirective;
import cn.featherfly.hammer.tpl.supports.ConditionParamsManager;

/**
 * OrTemplateDirectiveModel.
 *
 * @author zhongj
 */
public class OrTemplateDirectiveModel extends LogicTemplateDirectiveModel implements OrDirective {

    /**
     * Instantiates a new or template directive model.
     *
     * @param conditionParamsManager conditionParamsManager
     */
    public OrTemplateDirectiveModel(ConditionParamsManager conditionParamsManager) {
        super(conditionParamsManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getLogicWorld() {
        return "or";
    }

}
