
package cn.featherfly.hammer.tpl.mapper;

import java.util.List;
import java.util.Map;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.tpl.TplExecutor;

/**
 * <p>
 * TeMapperImpl
 * </p>
 *
 * @author zhongj
 */
public class TeMapperImpl implements TeMapper {

    private Hammer hammer;

    private TplExecutor tplExecutor;

    /**
     * @param hammer
     */
    public TeMapperImpl(Hammer hammer) {
        //        this.hammer = hammer;
        //        tplExecutor = hammer.template();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User get() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User get(String username) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User get(String username, String password) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User get(String username, String password, Integer age) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User get2() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User get2(String username, String password, Integer age) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> getMap() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> getMap(String username, String password, Integer age) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> getMap2() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> getMap2(String username, String password, Integer age) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void merge() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void merge(String name, String pass) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int merge2(String name, String pass) {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName(Long id) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName2() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName2(Long id) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getInt() {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getInt(Long id) {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getInt2() {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getInt2(Long id) {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getLong() {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getLong(Long id) {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getLong2() {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getLong2(Long id) {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getDouble() {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getDouble(Long id) {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getDouble2() {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getDouble2(Long id) {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getInteger() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getInteger(Long id) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getInteger2() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getInteger2(Long id) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> findUserList() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> findUserList(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> findUserList2() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> findUserList2(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> findMapList() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> findMapList(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> findMapList2() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> findMapList2(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> findMapPage(Page page) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> findMapPage(String name, Page page) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> findMapPage2(Page page) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> findMapPage2(String name, Page page) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<User> findUserPage(Page page) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<User> findUserPage(String name, Page page) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<User> findUserPage2(Page page) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<User> findUserPage2(String name, Page page) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> testPosition(int offset, int limit, String name, String pass) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> testPosition(String name, int limit, String pass) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<User> testPosition2(int offset, int limit, String name, String pass) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<User> testPosition2(String name, int limit, String pass) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<User> testPosition2(Page page, String name, String pass) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> testPosition(Page page, String name, String pass) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> findUserList(Page page) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> findUserList2(String name, Page page) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> findUserList(int offset, int limit) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> findUserList2(String name, int offset, int limit) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> findMapList(Page page) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> findMapList2(String name, Page page) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> findMapList(int offset, int limit) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> findMapList2(String name, int offset, int limit) {
        System.out.println(hammer);
        System.out.println(tplExecutor);
        return null;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public int count() {
    //        Map<String, Object> params = new HashMap<>();
    //        return hammer.intValue("count", params);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public User getByUsernameAndPassword(String username, String password) {
    //        Map<String, Object> params = new HashMap<>();
    //        params.put("username", username);
    //        params.put("password", password);
    //        return hammer.single("count", User.class, params);
    //    }
}
