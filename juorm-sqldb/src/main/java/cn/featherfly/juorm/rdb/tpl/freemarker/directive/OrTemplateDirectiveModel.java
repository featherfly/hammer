
package cn.featherfly.juorm.rdb.tpl.freemarker.directive;

import cn.featherfly.juorm.tpl.directive.OrDirective;
import cn.featherfly.juorm.tpl.supports.ConditionParamsManager;

/**
 * <p>
 * WhereTemplateDirectiveModel
 * </p>
 * 
 * @author zhongj
 */
public class OrTemplateDirectiveModel extends LogicTemplateDirectiveModel
        implements OrDirective {

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
