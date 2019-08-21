
package cn.featherfly.juorm.rdb.tpl.freemarker.directive;

import cn.featherfly.juorm.tpl.directive.AndTemplateDirective;
import cn.featherfly.juorm.tpl.supports.ConditionParamsManager;

/**
 * <p>
 * WhereTemplateDirectiveModel
 * </p>
 * 
 * @author zhongj
 */
public class AndTemplateDirectiveModel extends LogicTemplateDirectiveModel
        implements AndTemplateDirective {

    /**
     * @param conditionParamsManager
     */
    public AndTemplateDirectiveModel(
            ConditionParamsManager conditionParamsManager) {
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
