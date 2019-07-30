
package cn.featherfly.juorm.rdb.tpl.freemarker;

/**
 * <p>
 * WhereTemplateDirectiveModel
 * </p>
 * 
 * @author zhongj
 */
public class OrTemplateDirectiveModel
        extends LogicTemplateDirectiveModel {

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
