
package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import cn.featherfly.hammer.tpl.directive.AndDirective;

/**
 * AndDirectiveModel .
 *
 * @author zhongj
 */
public class AndDirectiveModel extends LogicDirectiveModel implements AndDirective {

    /**
     * Instantiates a new and template directive model.
     */
    public AndDirectiveModel() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getLogicWorld() {
        return "and";
    }

}
