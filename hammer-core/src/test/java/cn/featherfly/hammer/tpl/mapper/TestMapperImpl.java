
package cn.featherfly.hammer.tpl.mapper;

import java.io.Serializable;

import cn.featherfly.hammer.Hammer;

/**
 * <p>
 * TestMapperImpl
 * </p>
 *
 * @author zhongj
 */
public class TestMapperImpl extends BasedTplGenericHammer<User> implements TestMapper {

    /**
     * @param hammer
     * @param type
     */
    public TestMapperImpl(Hammer hammer) {
        super(hammer, User.class);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public User get() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public User get(String username) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public User get(String username, String password) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public User get(String username, String password, Integer age) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public User get2() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public User get2(String username, String password, Integer age) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Map<String, Object> getMap() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Map<String, Object> getMap(String username, String password, Integer age) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Map<String, Object> getMap2() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Map<String, Object> getMap2(String username, String password, Integer age) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void update1() {
    //        // YUFEI_TODO Auto-generated method stub
    //
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void merge1() {
    //        // YUFEI_TODO Auto-generated method stub
    //
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void merge(String name, String pass) {
    //        // YUFEI_TODO Auto-generated method stub
    //
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public int merge2(String name, String pass) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String getName() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String getName(Long id) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String getName2() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String getName2(Long id) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public int getInt() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public int getInt(Long id) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public int getInt2() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public int getInt2(Long id) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public long getLong() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public long getLong(Long id) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public long getLong2() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public long getLong2(Long id) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public double getDouble() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public double getDouble(Long id) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public double getDouble2() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public double getDouble2(Long id) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return 0;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Integer getInteger() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Integer getInteger(Long id) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Integer getInteger2() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Integer getInteger2(Long id) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<User> findUserList() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<User> findUserList(String name) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<User> findUserList2() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<User> findUserList2(String name) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Map<String, Object>> findMapList() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Map<String, Object>> findMapList(String name) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Map<String, Object>> findMapList2() {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Map<String, Object>> findMapList2(String name) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<Map<String, Object>> findMapPage(Page page) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<Map<String, Object>> findMapPage(String name, Page page) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<Map<String, Object>> findMapPage2(Page page) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<Map<String, Object>> findMapPage2(String name, Page page) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<User> findUserPage(Page page) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<User> findUserPage(String name, Page page) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<User> findUserPage2(Page page) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<User> findUserPage2(String name, Page page) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<Map<String, Object>> testPosition(int offset, int limit, String name, String pass) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<Map<String, Object>> testPosition(String name, int limit, String pass) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<User> testPosition2(int offset, int limit, String name, String pass) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<User> testPosition2(String name, int limit, String pass) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<User> testPosition2(Page page, String name, String pass) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<Map<String, Object>> testPosition(Page page, String name, String pass) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<User> findUserList(Page page) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<User> findUserList2(String name, Page page) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<User> findUserList(int offset, int limit) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<User> findUserList2(String name, int offset, int limit) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Map<String, Object>> findMapList(Page page) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Map<String, Object>> findMapList2(String name, Page page) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Map<String, Object>> findMapList(int offset, int limit) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Map<String, Object>> findMapList2(String name, int offset, int limit) {
    //        // YUFEI_TODO Auto-generated method stub
    //        return null;
    //    }

    @Override
    public User get(Serializable id) {
        return super.get(id);
    }

    public User2 get2(Serializable id) {
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
}
