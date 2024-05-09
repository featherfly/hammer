package cn.featherfly.hammer.tpl.directive;

/**
 * LogicDirective.
 *
 * @author zhongj
 */
public interface LogicDirective extends TemplateDirective {

    String PARAM_NAME_IF = "if";

    String PARAM_NAME_NAME = "name";

    String PARAM_NAME_FORCE = "force";

    String PARAM_NAME_TRANSVERTER = "transverter";

}