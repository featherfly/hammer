package cn.featherfly.hammer.tpl.directive;

import cn.featherfly.hammer.tpl.TplConfigFactory;

/**
 * IncludeDirective.
 *
 * @author zhongj
 */
public abstract class IncludeDirective implements TemplateDirective {

    /** The Constant TAG_NAME. */
    public static final String TAG_NAME = "include";

    /** The Constant NAME_SPACE_PARAM. */
    public static final String NAME_SPACE_PARAM = "namespace";

    /**
     * The Constant ID_PARAM.
     */
    public static final String NAME_PARAM = "name";

    /** The tpl config factory. */
    protected final TplConfigFactory tplConfigFactory;

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