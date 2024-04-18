
package cn.featherfly.hammer.sqldb.tpl.mapper;

import static org.testng.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.DelegatingSmartContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePagination;
import cn.featherfly.hammer.sqldb.TestConstants;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;

/**
 * TplDynamicExecutorSpringRegistorTest.
 *
 * @author zhongj
 */
@ContextConfiguration(loader = DelegatingSmartContextLoader.class, locations = "classpath:app.xml")
public class TplDynamicExecutorSpringRegistorTest2 extends AbstractTestNGSpringContextTests {

    @Resource
    UserInfoTupleMapper tupleMapper;

    @BeforeClass
    public void setUp() {

    }

    @Test
    void testSingleTuple2() {
        Integer userId = 1;
        Tuple2<UserInfo, User> tuple2 = tupleMapper.selectUserInfoByUserId(userId);
        System.out.println(tuple2.get0());
        System.out.println(tuple2.get1());

        assertEquals(userId, tuple2.get0().getUser().getId());
        assertEquals(userId, tuple2.get1().getId());
    }

    @Test
    void testListTuple2() {
        List<Tuple2<UserInfo, User>> list = tupleMapper.selectUserInfoAndUserList();
        assertEquals(list.size(), TestConstants.USER_INFO_INIT_ROWS);

        for (Tuple2<UserInfo, User> tuple2 : list) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }
    }

    @Test
    void testListPageTuple2() {
        List<Tuple2<UserInfo, User>> list = tupleMapper.selectUserInfoAndUserList(new SimplePagination(0, 1));
        assertEquals(list.size(), 1);

        for (Tuple2<UserInfo, User> tuple2 : list) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }

        list = tupleMapper.selectUserInfoAndUserList(0, 1);
        assertEquals(list.size(), 1);

        for (Tuple2<UserInfo, User> tuple2 : list) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }
    }

    @Test
    void testPaginationTuple2() {
        PaginationResults<
            Tuple2<UserInfo, User>> page = tupleMapper.selectUserInfoAndUserPage(new SimplePagination(0, 10));
        assertEquals(page.getTotal(), Integer.valueOf(TestConstants.USER_INFO_INIT_ROWS));
        assertEquals(page.getPageResults().size(), TestConstants.USER_INFO_INIT_ROWS);

        for (Tuple2<UserInfo, User> tuple2 : page.getPageResults()) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }

        page = tupleMapper.selectUserInfoAndUserPage(new SimplePagination(0, 1));
        assertEquals(page.getTotal(), Integer.valueOf(TestConstants.USER_INFO_INIT_ROWS));
        assertEquals(page.getPageResults().size(), 1);

        for (Tuple2<UserInfo, User> tuple2 : page.getPageResults()) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }
    }

    @Test
    void testPaginationLimitTuple2() {
        PaginationResults<Tuple2<UserInfo, User>> page = tupleMapper.selectUserInfoAndUserPage(0, 10);
        assertEquals(page.getTotal(), Integer.valueOf(TestConstants.USER_INFO_INIT_ROWS));
        assertEquals(page.getPageResults().size(), TestConstants.USER_INFO_INIT_ROWS);

        for (Tuple2<UserInfo, User> tuple2 : page.getPageResults()) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }

        page = tupleMapper.selectUserInfoAndUserPage(0, 1);
        assertEquals(page.getTotal(), Integer.valueOf(TestConstants.USER_INFO_INIT_ROWS));
        assertEquals(page.getPageResults().size(), 1);

        for (Tuple2<UserInfo, User> tuple2 : page.getPageResults()) {
            System.out.println(tuple2.get0());
            System.out.println(tuple2.get1());

            assertEquals(tuple2.get0().getUser().getId(), tuple2.get1().getId());
        }
    }
}
