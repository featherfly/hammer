
package cn.featherfly.juorm.rdb.sqltpl.freemarker;

/**
 * <p>
 * WhereTemplateDirectiveModel
 * </p>
 * 
 * @author zhongj
 */
public class AndTemplateDirectiveModel
        extends LogicTemplateDirectiveModel {

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