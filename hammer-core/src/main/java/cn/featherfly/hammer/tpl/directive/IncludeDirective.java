package cn.featherfly.hammer.tpl.directive;

import cn.featherfly.hammer.tpl.TplConfigFactory;

/**
 * IncludeDirective.
 *
 * @author zhongj
 */
public abstract class IncludeDirective implements TemplateDirective {

    public static final String NAME_SPACE_PARAM = "namespace";

    public static final String ID_PARAM = "id";

    protected TplConfigFactory tplConfigFactory;

    /**
     * Instantiates a new include directive.
     *
     * @param tplConfigFactory tplConfigFactory
     */
    protected IncludeDirective(TplConfigFactory tplConfigFactory) {
        super();
        this.tplConfigFactory = tplConfigFactory;
    }

}