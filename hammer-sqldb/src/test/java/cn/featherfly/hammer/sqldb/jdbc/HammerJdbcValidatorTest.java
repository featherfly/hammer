
package cn.featherfly.hammer.sqldb.jdbc;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Nullable;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.Dates;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.HammerValidateException;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.Role2;
import freemarker.template.TemplateModelException;

/**
 * HammerJdbcTest.
 *
 * @author zhongj
 */
public class HammerJdbcValidatorTest extends JdbcTestBase {

    protected Hammer hammer;

    @Nullable
    Serializable nullObject = null;
    List<Serializable> emptyList = new ArrayList<>();
    Serializable[] emptyArray = new Serializable[0];

    Locale locale = Locale.getDefault();

    @BeforeClass
    void before() throws TemplateModelException {
        hammer = SqldbHammerImpl.builder(jdbc, mappingFactory, configFactory, propertyAccessorFactory, hammerConfig)
            .build();
        Locale.setDefault(Locale.ENGLISH);
    }

    @AfterClass
    void after() {
        Locale.setDefault(locale);
    }

    @Test
    public void save() {
        Role2 r = new Role2();
        int random = Randoms.getInt(100);
        r.setName("role_name" + random);
        r.setDescp("role_descp" + random);
        r.setCreateTime(LocalDateTime.now());
        hammer.save(r);
        assertNotNull(r.getId());

        hammer.delete(r);
    }

    @Test(expectedExceptions = HammerValidateException.class)
    public void saveValidateException() {
        Role2 r = new Role2();
        int random = Randoms.getInt(100);
        r.setName("role_name" + random);
        r.setDescp("role_descp" + random);
        // createTime is null
        hammer.save(r);

    }

    @Test(expectedExceptions = HammerValidateException.class)
    public void saveValidateException2() {
        Role2 r = new Role2();
        r.setName("role_name" + Randoms.getString(30));
        // name max size 20 
        r.setDescp("role_descp" + Randoms.getString(30));
        r.setCreateTime(LocalDateTime.now());
        hammer.save(r);

    }

    @Test
    public void update() {
        Role2 r = new Role2();
        int random = Randoms.getInt(100);
        r.setName("role_name" + random);
        r.setDescp("role_descp" + random);
        r.setCreateTime(LocalDateTime.now());
        hammer.save(r);

        Role2 r2 = hammer.get(r.getId(), Role2.class);
        LocalDateTime now = LocalDateTime.now();
        r2.setUpdateTime(now);
        hammer.update(r2);

        Role2 r3 = hammer.get(r2.getId(), Role2.class);

        assertEquals(Dates.formatTime(r3.getUpdateTime()), Dates.formatTime(r2.getUpdateTime()));

        hammer.delete(r3);
    }

    @Test(expectedExceptions = HammerValidateException.class)
    public void updateValidateException() {
        Role2 r = hammer.get(1L, Role2.class);
        // updateTime is null
        hammer.update(r);

    }

    @Test(expectedExceptions = HammerValidateException.class)
    public void updateValidateException2() {
        Role2 r = hammer.get(2L, Role2.class);
        r.setName("role_name" + Randoms.getString(30));
        // name max size 20 
        r.setUpdateTime(LocalDateTime.now());
        hammer.save(r);

    }

}
