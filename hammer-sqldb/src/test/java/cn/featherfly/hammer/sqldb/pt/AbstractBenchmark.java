
package cn.featherfly.hammer.sqldb.pt;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.Randoms;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.lang.Timer;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.UserInfo2;

/**
 * JdbcPerformanceTest.
 *
 * @author zhongj
 */
public abstract class AbstractBenchmark extends BenchmarkTestBase implements Benchmark {

    protected abstract String getName();

    protected abstract void doInsertOne(UserInfo2 userInfo);

    //    protected abstract void doInsertOne(List<UserInfo2> userInfos);

    protected abstract void doInsertBatch(List<UserInfo2> userInfos);

    protected abstract UserInfo2 doSelectById(Serializable id);

    protected abstract List<UserInfo2> doSelectById(Serializable... ids);

    @BeforeClass
    @Parameters({ "times", "batchSize", "batchTimes" })
    public void init(@Optional("1000") int times, @Optional("1000") int batchSize, @Optional("1") int batchTimes)
            throws IOException {
        this.times = times;
        this.batchSize = batchSize;
        this.batchTimes = batchTimes;
    }

    @Test
    @Override
    public void testInsertOne() {
        UserInfo2 userInfo = new UserInfo2();
        int index = Randoms.getInt(10);
        userInfo.setId(null);
        userInfo.setUserId(1);
        userInfo.setName("yufei_one_" + index);
        userInfo.setDescp("yufei_descp_one_" + index);
        userInfo.setProvince("省_one_" + index);
        userInfo.setCity("市_one_" + index);
        userInfo.setDistrict("区_one_" + index);
        Timer timer = start();
        doInsertOne(userInfo);
        long time = timer.stop();
        System.out.println(Strings.format("{0} testInsertOne first use {1} {2}", getName(), time, unit));

        userInfo = new UserInfo2();
        index = Randoms.getInt(10);
        userInfo.setId(null);
        userInfo.setUserId(1);
        userInfo.setName("yufei_one_" + index);
        userInfo.setDescp("yufei_descp_one_" + index);
        userInfo.setProvince("省_one_" + index);
        userInfo.setCity("市_one_" + index);
        userInfo.setDistrict("区_one_" + index);
        timer = start();
        doInsertOne(userInfo);
        time = timer.stop();
        System.out.println(Strings.format("{0} testInsertOne second use {1} {2}", getName(), time, unit));
    }

    @Test(dependsOnMethods = "testInsertOne")
    @Override
    public void testInsertOneMulitiTimes() {
        List<UserInfo2> list = new ArrayList<>();
        for (int index = 0; index < times; index++) {
            UserInfo2 userInfo = new UserInfo2();
            userInfo.setId(null);
            userInfo.setUserId(1);
            userInfo.setName("yufei_" + index);
            userInfo.setDescp("yufei_descp_" + index);
            userInfo.setProvince("省_" + index);
            userInfo.setCity("市_" + index);
            userInfo.setDistrict("区_" + index);
            list.add(userInfo);
        }
        Timer timer = start();
        //        doInsertOne(list);
        for (UserInfo2 userInfo : list) {
            doInsertOne(userInfo);
        }
        long time = timer.stop();
        System.out.println(Strings.format("{0} testInsertOneMulitiTimes use {1} {2} with {3} loop times", getName(),
                time, unit, times));
    }

    @Test(dependsOnMethods = "testInsertOneMulitiTimes")
    @Override
    public void testInsertBatch() {
        List<List<UserInfo2>> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < batchTimes; i++) {
            List<UserInfo2> userInfos = new ArrayList<>();
            for (int j = 0; j < batchSize; j++) {
                UserInfo2 userInfo = new UserInfo2();
                userInfo.setId(null);
                userInfo.setUserId(1);
                userInfo.setName("yufei_" + index);
                userInfo.setDescp("yufei_descp_" + index);
                userInfo.setProvince("省_" + index);
                userInfo.setCity("市_" + index);
                userInfo.setDistrict("区_" + index);
                userInfos.add(userInfo);
                index++;
            }
            list.add(userInfos);
        }

        Timer timer = start();
        for (List<UserInfo2> userInfos : list) {
            //            System.out.println("doInsertBatch");
            doInsertBatch(userInfos);
        }
        long time = timer.stop();
        System.out.println(Strings.format("{0} testInsertBatch use {1} {2} with batchSize[{3}] {4} loop times",
                getName(), time, unit, batchSize, batchTimes));
    }

    @Test(dependsOnMethods = "testInsertBatch")
    @Override
    public void testSelectById() {
        Timer timer = start();
        doSelectById(USER_INFO_ID);
        long time = timer.stop();
        System.out.println(Strings.format("{0} testSelectById first use {1} {2}", getName(), time, unit));

        timer = start();
        doSelectById(USER_INFO_ID2);
        time = timer.stop();
        System.out.println(Strings.format("{0} testSelectById second use {1} {2}", getName(), time, unit));
    }

    @Override
    @Test(dependsOnMethods = "testSelectById")
    public void testSelectByIdMulitiTimes() {
        Timer timer = start();
        Serializable[] ids = new Serializable[times];
        for (int i = 0; i < times; i++) {
            ids[i] = i + 1;
        }
        doSelectById(ids);
        long time = timer.stop();
        System.out.println(Strings.format("{0} testSelectByIdMulitiTimes use {1} {2} with {3} loop times", getName(),
                time, unit, times));
    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************

    private static final Integer USER_INFO_ID = 1;
    private static final Integer USER_INFO_ID2 = 2;

    protected Timer start() {
        return Timer.start(unit);
    }

    private int times = 1000;

    private int batchSize = 1000;

    private int batchTimes = 1;

    private TimeUnit unit = TimeUnit.MILLISECONDS;

    /**
     * get times value
     *
     * @return times
     */
    public int getTimes() {
        return times;
    }

    /**
     * set times value
     *
     * @param times times
     */
    public void setTimes(int times) {
        this.times = times;
    }

    /**
     * get batchSize value
     *
     * @return batchSize
     */
    public int getBatchSize() {
        return batchSize;
    }

    /**
     * set batchSize value
     *
     * @param batchSize batchSize
     */
    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    /**
     * get batchTimes value
     *
     * @return batchTimes
     */
    public int getBatchTimes() {
        return batchTimes;
    }

    /**
     * set batchTimes value
     *
     * @param batchTimes batchTimes
     */
    public void setBatchTimes(int batchTimes) {
        this.batchTimes = batchTimes;
    }
}
