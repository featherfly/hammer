
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-14 22:12:14
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl.mapper.freemarker;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import cn.featherfly.hammer.config.TemplateConfigImpl;
import cn.featherfly.hammer.tpl.freemarker.processor.DirectiveElement;
import cn.featherfly.hammer.tpl.freemarker.processor.Parser;

/**
 * DirectiveElementTest.
 *
 * @author zhongj
 */
public class DirectiveElementTest {

    Parser parser = new Parser(new TemplateConfigImpl());

    @Test
    public void testSelfCloseTag() {
        DirectiveElement de = new DirectiveElement("<tpl name='roleFromTemplate2' namespace='role_common'>", false,
            null, parser);
        System.out.println(de.getValue());
        assertEquals(de.getValue(), "<@tpl name='roleFromTemplate2' namespace='role_common'/>");
    }

    @Test
    public void testWrapTag() {
        DirectiveElement de = new DirectiveElement("<<wrap", false, null, parser);
        System.out.println(de.getValue());
        assertEquals(de.getValue(), "<@wrap>user</@wrap>");
    }

}
