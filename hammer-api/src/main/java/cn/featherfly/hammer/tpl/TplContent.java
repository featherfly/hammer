
/*
 * All rights Reserved, Designed By zhongj
 * @Title: TplTemplate.java
 * @Package cn.featherfly.hammer.tpl
 * @Description: TplTemplate
 * @author: zhongj
 * @date: 2022-11-10 14:41:10
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl;

/**
 * template content.
 *
 * @author zhongj
 */
public interface TplContent extends Template {

    /**
     * get template content
     *
     * @return template content
     */
    String getContent();
}
