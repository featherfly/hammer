
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-02-08 16:05:08
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl;

/**
 * template engine built in directive.
 *
 * @author zhongj
 */
public class TemplateEngineBuiltInDirective {

    private String name;

    private boolean needEndPair;

    /**
     * Instantiates a new directive.
     *
     * @param name the name
     */
    public TemplateEngineBuiltInDirective(String name) {
        this(name, true);
    }

    /**
     * Instantiates a new directive.
     *
     * @param name the name
     * @param needEndPair the need end pair
     */
    public TemplateEngineBuiltInDirective(String name, boolean needEndPair) {
        super();
        this.name = name;
        this.needEndPair = needEndPair;
    }

    /**
     * get name value.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if is need end pair.
     *
     * @return true, if is need end pair
     */
    public boolean isNeedEndPair() {
        return needEndPair;
    }
}
