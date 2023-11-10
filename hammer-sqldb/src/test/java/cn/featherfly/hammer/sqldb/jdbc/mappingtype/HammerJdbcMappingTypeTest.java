
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
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Content2;

/**
 * JdbcImplTest.
 *
 * @author zhongj
 */
public class HammerJdbcMappingTypeTest extends JdbcTestBase {

    Hammer hammer;

    @BeforeClass
    void be() {
        jdbc = new JdbcSpringImpl(dataSource, dialect, metadata, sqlTypeMappingManager);

        Class<Article2> type = Article2.class;

        //                manager.regist(new JavaSqlTypeMapper<Long[]>() {
        //                    private BeanProperty<Long[]> bp = BeanDescriptor.getBeanDescriptor(type).getBeanProperty("content");
        //
        //                    @Override
        //                    public boolean support(SQLType sqlType) {
        //                        return JDBCType.VARCHAR.equals(sqlType);
        //                    }
        //
        //                    @Override
        //                    public boolean support(Type<Long[]> type) {
        //                        return type.getType().equals(Long[].class);
        //                    }
        //
        //                    @Override
        //                    public Class<Long[]> getJavaType(SQLType sqlType) {
        //                        return Long[].class;
        //                    }
        //
        //                    @Override
        //                    public SQLType getSqlType(Type<Long[]> javaType) {
        //                        return JDBCType.VARCHAR;
        //                    }
        //
        //                    @Override
        //                    public void set(PreparedStatement prep, int columnIndex, Long[] value) {
        //                        System.out.println(ArrayUtils.toString(value, ','));
        //                        JdbcUtils.setParameter(prep, columnIndex, ArrayUtils.toString(value, ','));
        //                    }
        //
        //                    @Override
        //                    public Long[] get(ResultSet rs, int columnIndex) {
        //                        try {
        //                            return ArrayUtils.toNumbers(Long.class, rs.getString(columnIndex).split(","));
        //                        } catch (SQLException e) {
        //                            throw new JdbcException(e);
        //                        }
        //                    }
        //                });

        BeanDescriptor<Article2> bd = BeanDescriptor.getBeanDescriptor(type);

        BeanProperty<Article2, Content> contentProperty = bd.getBeanProperty("content");
        sqlTypeMappingManager.regist(contentProperty, new ArrayToStringSqlTypeMapper());

        BeanProperty<Article2, Content> contentProperty2 = bd.getBeanProperty("content2");
        sqlTypeMappingManager.regist(contentProperty2, new ObjectToJsonMapper<>(contentProperty2));

        BeanProperty<Article2, Content> contentProperty3 = bd.getBeanProperty("content3");
        sqlTypeMappingManager.regist(contentProperty3, new ObjectToJsonMapper<>(contentProperty3));

        BeanProperty<Article2, Content> contentProperty4 = bd.getBeanProperty("content4");
        sqlTypeMappingManager.regist(contentProperty4, new ListToStringSqlTypeMapper());
        //        sqlTypeMappingManager.regist(new ListToStringSqlTypeMapper());

        // sqlTypeMappingManager.regist(Content2.class, new ObjectToJsonMapper<>(Content2.class));
        // regist(entityClass, Mapper) 的entity类型是用于分组的
        sqlTypeMappingManager.regist(new ObjectToJsonMapper<>(Content2.class));

        hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory, hammerConfig);
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
    public void testQueryValue() {
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

        Content2 c2 = jdbc.queryValue("select content2 from cms_article2 where id = ?", Content2.class,
                article.getId());

        System.out.println(c2);
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

    @Test
    public void testUpdate() {
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

        content2.setDescp("content2_descp_update_" + Randoms.getInt(1000));
        content2.setImg("content2_img_update_" + Randoms.getInt(1000));

        hammer.update(Article2.class).set(Article2::getContent2, content2).where().eq(article::getId).execute();

        a = hammer.query(Article2.class).where().eq(article::getId).single();

        assertEquals(a.getContent2(), content2);
        assertEquals(a.getContent3(), content3);

        content3.setDescp("content3_descp_update_" + Randoms.getInt(1000));
        content3.setImg("content3_img_update_" + Randoms.getInt(1000));
        article.setContent3(content3);

        String title = "article_update_" + Randoms.getInt(1000);
        hammer.update(Article2.class).set(article::getContent3).set(Article2::getTitle, title).where()
                .eq(article::getId).execute();

        a = hammer.query(Article2.class).where().eq(article::getId).single();

        assertEquals(a.getContent2(), content2);
        assertEquals(a.getContent3(), content3);
        assertEquals(a.getTitle(), title);

    }
}
