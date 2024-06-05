
package cn.featherfly.hammer.sqldb.jdbc.mappingtype;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.db.mapping.mappers.ObjectToJsonMapper;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.JdbcSpringImpl;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.mappingtype.sqltype.ArrayToStringSqlTypeMapper;
import cn.featherfly.hammer.sqldb.jdbc.mappingtype.sqltype.ListToStringSqlTypeMapper;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Article2;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Content;

/**
 * JdbcImplTest.
 *
 * @author zhongj
 */
public class HammerJdbcMappingTypeTest2 extends JdbcTestBase {

    Hammer hammer;

    @BeforeClass
    void be() {
        jdbc = new JdbcSpringImpl(dataSource, dialect, metadata, sqlTypeMappingManager, propertyAccessorFactory);

        Class<Article2> type = Article2.class;

        BeanDescriptor<Article2> bd = BeanDescriptor.getBeanDescriptor(type);

        BeanProperty<Article2, Content> contentProperty = bd.getBeanProperty("content2");
        sqlTypeMappingManager.regist(type, new ObjectToJsonMapper<>(contentProperty));

        contentProperty = bd.getBeanProperty("content3");
        sqlTypeMappingManager.regist(type, new ObjectToJsonMapper<>(Content.class));

        contentProperty = bd.getBeanProperty("content4");
        sqlTypeMappingManager.regist(type, new ListToStringSqlTypeMapper());

        contentProperty = bd.getBeanProperty("content");
        sqlTypeMappingManager.regist(type, new ArrayToStringSqlTypeMapper());

        hammer = SqldbHammerImpl.builder(jdbc, mappingFactory, configFactory, propertyAccessorFactory, hammerConfig)
            .build();
    }

    @Test
    public void testSaveAndGet() {
        Article2 article = new Article2();
        article.setTitle("article_" + Randoms.getInt(1000));
        Content content2 = new Content();
        content2.setDescp("content2_descp_" + Randoms.getInt(1000));
        content2.setImg("content2_img_" + Randoms.getInt(1000));
        article.setContent2(content2);
        Content content3 = new Content();
        content3.setDescp("content3_descp_" + Randoms.getInt(1000));
        content3.setImg("content3_img_" + Randoms.getInt(1000));
        article.setContent3(content3);

        Long[] content = new Long[] { 1L, 2L };
        article.setContent(content);

        List<Long> content4 = ArrayUtils.toList(1L, 2L, 3L);
        article.setContent4(content4);

        hammer.save(article);

        Article2 a = hammer.get(article.getId(), article.getClass());

        assertEquals(a.getContent2(), content2);
        assertEquals(a.getContent3(), content3);
        assertEquals(a.getContent(), content);
        assertEquals(a.getContent4(), content4);

        a = hammer.query(Article2.class).where().eq(article::getId).single();

        assertEquals(a.getContent2(), content2);
        assertEquals(a.getContent3(), content3);
        assertEquals(a.getContent(), content);
        assertEquals(a.getContent4(), content4);
    }

    @Test
    public void testQuery() {
        Article2 article = new Article2();
        article.setTitle("article_" + Randoms.getInt(1000));
        Content content2 = new Content();
        content2.setDescp("content2_descp_" + Randoms.getInt(1000));
        content2.setImg("content2_img_" + Randoms.getInt(1000));
        article.setContent2(content2);
        Content content3 = new Content();
        content3.setDescp("content3_descp_" + Randoms.getInt(1000));
        content3.setImg("content3_img_" + Randoms.getInt(1000));
        article.setContent3(content3);

        hammer.save(article);

        Article2 a = hammer.query(Article2.class).where().eq(article::getId).single();

        assertEquals(a.getContent2(), content2);
        assertEquals(a.getContent3(), content3);
    }
}
