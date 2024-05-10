
package cn.featherfly.hammer.tpl.mapper;

import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.config.HammerConfig;

/**
 * <p>
 * TestMapperImpl
 * </p>
 *
 * @author zhongj
 */
public class TestMapperImpl extends BasedTplGenericHammer<User, Long> implements TestMapper {
    /**
     * @param hammer
     * @param type
     */
    public TestMapperImpl(Hammer hammer, HammerConfig hammerConfig) {
        super(hammer, User.class, hammerConfig);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public User get() {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public User get(String username) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public User get(String username, String password) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public User get(String username, String password, Integer age) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public User get2() {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public User get2(String username, String password, Integer age) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Map<String, Object> getMap() {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Map<String, Object> getMap(String username, String password, Integer age) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Map<String, Object> getMap2() {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Map<String, Object> getMap2(String username, String password, Integer age) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void update1() {
    //
    //
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void merge1() {
    //
    //
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void merge(String name, String pass) {
    //
    //
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public int merge2(String name, String pass) {
    //
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String getName() {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String getName(Long id) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String getName2() {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String getName2(Long id) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public int getInt() {
    //
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public int getInt(Long id) {
    //
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public int getInt2() {
    //
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public int getInt2(Long id) {
    //
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public long getLong() {
    //
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public long getLong(Long id) {
    //
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public long getLong2() {
    //
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public long getLong2(Long id) {
    //
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public double getDouble() {
    //
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public double getDouble(Long id) {
    //
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public double getDouble2() {
    //
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public double getDouble2(Long id) {
    //
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Integer getInteger() {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Integer getInteger(Long id) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Integer getInteger2() {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Integer getInteger2(Long id) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<User> findUserList() {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<User> findUserList(String name) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<User> findUserList2() {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<User> findUserList2(String name) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Map<String, Object>> findMapList() {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Map<String, Object>> findMapList(String name) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Map<String, Object>> findMapList2() {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Map<String, Object>> findMapList2(String name) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<Map<String, Object>> findMapPage(Page page) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<Map<String, Object>> findMapPage(String name, Page page) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<Map<String, Object>> findMapPage2(Page page) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<Map<String, Object>> findMapPage2(String name, Page page) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<User> findUserPage(Page page) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<User> findUserPage(String name, Page page) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<User> findUserPage2(Page page) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<User> findUserPage2(String name, Page page) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<Map<String, Object>> testPosition(int offset, int limit, String name, String pass) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<Map<String, Object>> testPosition(String name, int limit, String pass) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<User> testPosition2(int offset, int limit, String name, String pass) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<User> testPosition2(String name, int limit, String pass) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<User> testPosition2(Page page, String name, String pass) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<Map<String, Object>> testPosition(Page page, String name, String pass) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<User> findUserList(Page page) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<User> findUserList2(String name, Page page) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<User> findUserList(int offset, int limit) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<User> findUserList2(String name, int offset, int limit) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Map<String, Object>> findMapList(Page page) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Map<String, Object>> findMapList2(String name, Page page) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Map<String, Object>> findMapList(int offset, int limit) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Map<String, Object>> findMapList2(String name, int offset, int limit) {
    //
    //        return null;
    //    }

    @Override
    public User get(Long id) {
        return super.get(id);
    }

    public User2 get2(Long id) {
        return (User2) super.get(id);
    }

    public int i() {
        return 1;
    }

    public long l() {
        return 1l;
    }

    public double d() {
        return 1.0;
    }

    public float f() {
        return 1.0f;
    }

    public boolean b() {
        return true;
    }

    public byte by() {
        return 1;
    }

    public short s() {
        return 1;
    }

    public char c() {
        return 'c';
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getByUsername(String username) {
        return null;
    }
}
