
package cn.featherfly.hammer.sqldb.jdbc;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.db.mapping.mappers.ObjectToJsonMapper;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.common.lang.reflect.GenericClass;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.vo.Article2;
import cn.featherfly.hammer.sqldb.jdbc.vo.Content;
import cn.featherfly.hammer.sqldb.jdbc.vo.Content2;

/**
 * JdbcImplTest.
 *
 * @author zhongj
 */
public class HammerJdbcMappingTypeTest extends JdbcTestBase {

    Hammer hammer;

    @BeforeClass
    void be() {
        jdbc = new JdbcImpl(dataSource, dialect, sqlTypeMappingManager);

        Class<Article2> type = Article2.class;

        //        manager.regist(new JavaSqlTypeMapper<Long[]>() {
        //            private BeanProperty<Long[]> bp = BeanDescriptor.getBeanDescriptor(type).getBeanProperty("content");
        //
        //            @Override
        //            public boolean support(SQLType sqlType) {
        //                return JDBCType.VARCHAR.equals(sqlType);
        //            }
        //
        //            @Override
        //            public boolean support(GenericType<Long[]> type) {
        //                return type.getType().equals(Long[].class);
        //            }
        //
        //            @Override
        //            public Class<Long[]> getJavaType(SQLType sqlType) {
        //                return Long[].class;
        //            }
        //
        //            @Override
        //            public SQLType getSqlType(GenericType<Long[]> javaType) {
        //                return JDBCType.VARCHAR;
        //            }
        //
        //            @Override
        //            public void set(PreparedStatement prep, int columnIndex, Long[] value) {
        //                System.out.println(ArrayUtils.toString(value, ','));
        //                JdbcUtils.setParameter(prep, columnIndex, ArrayUtils.toString(value, ','));
        //            }
        //
        //            @Override
        //            public Long[] get(ResultSet rs, int columnIndex) {
        //                try {
        //                    return ArrayUtils.toNumbers(Long.class, rs.getString(columnIndex).split(","));
        //                } catch (SQLException e) {
        //                    throw new JdbcException(e);
        //                }
        //            }
        //        });

        BeanDescriptor<Article2> bd = BeanDescriptor.getBeanDescriptor(type);

        BeanProperty<Content> contentProperty = bd.getBeanProperty("content2");
        sqlTypeMappingManager.regist(contentProperty, new ObjectToJsonMapper<>(contentProperty));

        contentProperty = bd.getBeanProperty("content3");
        sqlTypeMappingManager.regist(contentProperty, new ObjectToJsonMapper<>(contentProperty));

        sqlTypeMappingManager.regist(new GenericClass<>(Content2.class), new ObjectToJsonMapper<>(Content2.class));

        hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory);
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

        hammer.save(article);

        Article2 a = hammer.get(article.getId(), article.getClass());

        assertEquals(a.getContent2(), content2);
        assertEquals(a.getContent3(), content3);
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
}
