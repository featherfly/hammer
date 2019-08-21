
package cn.featherfly.juorm.rdb.tpl.freemarker.directive;

import cn.featherfly.juorm.tpl.directive.OrTemplateDirective;
import cn.featherfly.juorm.tpl.supports.ConditionParamsManager;

/**
 * <p>
 * WhereTemplateDirectiveModel
 * </p>
 * 
 * @author zhongj
 */
public class OrTemplateDirectiveModel extends LogicTemplateDirectiveModel
        implements OrTemplateDirective {

    /**
     * @param conditionParamsManager
     */
    public OrTemplateDirectiveModel(
            ConditionParamsManager conditionParamsManager) {
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
