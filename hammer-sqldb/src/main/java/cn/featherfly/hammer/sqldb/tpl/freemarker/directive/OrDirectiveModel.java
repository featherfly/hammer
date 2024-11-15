
package cn.featherfly.hammer.sqldb.tpl.freemarker.directive;

import cn.featherfly.hammer.tpl.directive.OrDirective;

/**
 * OrDirectiveModel.
 *
 * @author zhongj
 */
public class OrDirectiveModel extends LogicDirectiveModel implements OrDirective {

    /**
     * Instantiates a new or template directive model.
     */
    public OrDirectiveModel() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getLogicWorld() {
        return "or";
    }

}
