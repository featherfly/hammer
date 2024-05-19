
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-15 02:56:15
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl.freemarker.processor;

import java.util.Map;

import cn.featherfly.hammer.tpl.directive.IncludeDirective;

/**
 * IncludeDirectiveElement.
 *
 * @author zhongj
 */
public class IncludeDirectiveElement extends DirectiveElement {

    //    private boolean preInclude = true;

    /**
     * Instantiates a new include directive element.
     *
     * @param value the value
     * @param namedParamPlaceholder the named param placeholder
     * @param previous the previous
     * @param parser the parser
     */
    public IncludeDirectiveElement(CharSequence value, boolean namedParamPlaceholder, Element previous, Parser parser) {
        super(value, namedParamPlaceholder, previous, parser);
    }

    private String tplExecuteId;

    @Override
    public Map<String, String> getAtrtributes() {
        Map<String, String> attrs = super.getAtrtributes();
        if (attrs.get(IncludeDirective.NAME_SPACE_PARAM) != null) {
            tplExecuteId = parser.templateConfig.getTplExecuteIdParser().format(attrs.get(IncludeDirective.NAME_PARAM),
                attrs.get(IncludeDirective.NAME_SPACE_PARAM));
        } else {
            tplExecuteId = attrs.get(IncludeDirective.NAME_PARAM);
        }
        return attrs;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        //        if (preInclude) {
        if (!parser.templateConfig.isPrecompileNamedParamPlaceholder()) { // ENHANCE 先用这个凑合
            return parser.templateConfig.getPreIncludeFormmater().getStartSymbol() + tplExecuteId
                + parser.templateConfig.getPreIncludeFormmater().getEndSymbol();
            //            return "{" + tplExecuteId + "}";
        } else {
            return super.getValue();
        }
    }

}
