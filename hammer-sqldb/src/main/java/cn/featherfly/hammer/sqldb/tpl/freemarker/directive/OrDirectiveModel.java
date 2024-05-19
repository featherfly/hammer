
package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import cn.featherfly.hammer.tpl.directive.OrDirective;
import cn.featherfly.hammer.tpl.supports.ConditionParamsManager;

/**
 * OrDirectiveModel.
 *
 * @author zhongj
 */
public class OrDirectiveModel extends LogicDirectiveModel implements OrDirective {

    /**
     * Instantiates a new or template directive model.
     *
     * @param conditionParamsManager conditionParamsManager
     */
    public OrDirectiveModel(ConditionParamsManager conditionParamsManager) {
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
