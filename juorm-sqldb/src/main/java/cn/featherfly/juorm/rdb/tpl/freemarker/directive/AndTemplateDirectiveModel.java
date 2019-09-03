
package cn.featherfly.juorm.rdb.tpl.freemarker.directive;

import cn.featherfly.juorm.tpl.directive.AndDirective;
import cn.featherfly.juorm.tpl.supports.ConditionParamsManager;

/**
 * <p>
 * WhereTemplateDirectiveModel
 * </p>
 * 
 * @author zhongj
 */
public class AndTemplateDirectiveModel extends LogicTemplateDirectiveModel
        implements AndDirective {

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
