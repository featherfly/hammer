
package cn.featherfly.hammer.tpl.mapper;

import java.util.List;
import java.util.Map;

import cn.featherfly.common.structure.HashChainMap;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.tpl.TplExecuteIdFileImpl;
import cn.featherfly.hammer.tpl.TplExecuteIdMapperImpl;

/**
 * <p>
 * TestMapper
 * </p>
 *
 * @author zhongj
 */
public class TMapperImpl extends BasedTplHammer implements TMapper {

    /**
     * @param hammer
     */
    public TMapperImpl(Hammer hammer) {
        super(hammer);
    }

    /**
     * {@inheritDoc}
     */
    public int count() {
        return hammer.intValue(new TplExecuteIdFileImpl("count", "TMapper"), new HashChainMap<String, Object>());
    }

    /**
     * {@inheritDoc}
     */
    public User getByUsernameAndPassword(String username, String password) {
        return hammer.single(new TplExecuteIdFileImpl("getByUsernameAndPassword", "TMapper"), User.class,
                new HashChainMap<String, Object>().putChain("username", username).putChain("password", password));
    }

    public User get() {
        return hammer.single(new TplExecuteIdFileImpl("get", "namesapce"), User.class,
                new HashChainMap<String, Object>());
    }

    public User get(String username) {
        return hammer.single(new TplExecuteIdFileImpl("get_1", "namesapce"), User.class,
                new HashChainMap<String, Object>().putChain("username", username));
    }

    public User get(String username, String password) {
        return hammer.single(new TplExecuteIdFileImpl("get_2", "namesapce"), User.class,
                new HashChainMap<String, Object>().putChain("username", username).putChain("password", password));
    }

    public User get(String username, String password, Integer age) {
        return hammer.single(new TplExecuteIdFileImpl("get_3", "namesapce"), User.class,
                new HashChainMap<String, Object>().putChain("username", username).putChain("password", password)
                        .putChain("age", age));
    }

    public User get2() {
        return hammer.single(new TplExecuteIdMapperImpl("get2", "TMapper", TMapper.class, true), User.class,
                new HashChainMap<String, Object>());
    }

    public User get2(String username, String password, Integer age) {
        return hammer.single(new TplExecuteIdMapperImpl("get2_", "TMapper", TMapper.class, true), User.class,
                new HashChainMap<String, Object>().putChain("username", username).putChain("password", password)
                        .putChain("age", age));
    }

    public List<User> findUsers(String name, Page page) {
        return hammer.list(new TplExecuteIdFileImpl("findUsers", "namespace"), User.class,
                new HashChainMap<String, Object>(), page);
    }

    public void update() {
        hammer.execute(new TplExecuteIdFileImpl("update", "namespace"), new HashChainMap<String, Object>());
    }

    public void merge() {
        hammer.execute(new TplExecuteIdMapperImpl("merge", "TMapper", TMapper.class, false),
                new HashChainMap<String, Object>());
    }

    public void merge(String name, String pass) {
        hammer.execute(new TplExecuteIdMapperImpl("merge", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>().putChain("name", name).putChain("pass", pass));
    }

    public int merge2(String name, String pass) {
        return hammer.execute(new TplExecuteIdMapperImpl("merge2", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>().putChain("name", name).putChain("pass", pass));
    }

    public Map<String, Object> getMap() {
        return hammer.single(new TplExecuteIdFileImpl("getMap", "namesapce"), new HashChainMap<String, Object>());
    }

    public Map<String, Object> getMap(String username, String password, Integer age) {
        return hammer.single(new TplExecuteIdFileImpl("getMap_3", "namesapce"), new HashChainMap<String, Object>()
                .putChain("username", username).putChain("password", password).putChain("age", age));
    }

    public Map<String, Object> getMap2() {
        return hammer.single(new TplExecuteIdMapperImpl("getMap2", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>());
    }

    public Map<String, Object> getMap2(String username, String password, Integer age) {
        return hammer.single(new TplExecuteIdMapperImpl("getMap2_1", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>().putChain("username", username).putChain("password", password)
                        .putChain("age", age));
    }

    public String getName() {
        return hammer.string(new TplExecuteIdFileImpl("getName", "namesapce"), new HashChainMap<String, Object>());
    }

    public String getName(Long id) {
        return hammer.string(new TplExecuteIdFileImpl("getName_1", "namesapce"),
                new HashChainMap<String, Object>().putChain("id", id));
    }

    public String getName2() {
        return hammer.string(new TplExecuteIdMapperImpl("getName2", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>());
    }

    public String getName2(Long id) {
        return hammer.string(new TplExecuteIdMapperImpl("getName2_1", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>().putChain("id", id));
    }

    public int getInt() {
        return hammer.intValue(new TplExecuteIdFileImpl("getInt", "namesapce"), new HashChainMap<String, Object>());
    }

    public int getInt(Long id) {
        return hammer.intValue(new TplExecuteIdFileImpl("getInt_1", "namesapce"),
                new HashChainMap<String, Object>().putChain("id", id));
    }

    public int getInt2() {
        return hammer.intValue(new TplExecuteIdMapperImpl("getInt2", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>());
    }

    public int getInt2(Long id) {
        return hammer.intValue(new TplExecuteIdMapperImpl("getInt2_1", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>().putChain("id", id));
    }

    public long getLong() {
        return hammer.longValue(new TplExecuteIdFileImpl("getLong", "namesapce"), new HashChainMap<String, Object>());
    }

    public long getLong(Long id) {
        return hammer.longValue(new TplExecuteIdFileImpl("getLong_1", "namesapce"),
                new HashChainMap<String, Object>().putChain("id", id));
    }

    public long getLong2() {
        return hammer.longValue(new TplExecuteIdMapperImpl("getLong2", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>());
    }

    public long getLong2(Long id) {
        return hammer.longValue(new TplExecuteIdMapperImpl("getLong2_1", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>().putChain("id", id));
    }

    public double getDouble() {
        return hammer.doubleValue(new TplExecuteIdFileImpl("getLong", "namesapce"), new HashChainMap<String, Object>());
    }

    public double getDouble(Long id) {
        return hammer.doubleValue(new TplExecuteIdFileImpl("getLong_1", "namesapce"),
                new HashChainMap<String, Object>().putChain("id", id));
    }

    public double getDouble2() {
        return hammer.doubleValue(new TplExecuteIdMapperImpl("getLong2", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>());
    }

    public double getDouble2(Long id) {
        return hammer.doubleValue(new TplExecuteIdMapperImpl("getLong2_1", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>().putChain("id", id));
    }

    public Integer getInteger() {
        return hammer.number(new TplExecuteIdFileImpl("getInteger", "namesapce"), Integer.class,
                new HashChainMap<String, Object>());
    }

    public Integer getInteger(Long id) {
        return hammer.number(new TplExecuteIdFileImpl("getInteger_1", "namesapce"), Integer.class,
                new HashChainMap<String, Object>().putChain("id", id));
    }

    public Integer getInteger2() {
        return hammer.number(new TplExecuteIdMapperImpl("getInteger2", "TMapper", TMapper.class, true), Integer.class,
                new HashChainMap<String, Object>());
    }

    public Integer getInteger2(Long id) {
        return hammer.number(new TplExecuteIdMapperImpl("getInteger2_1", "TMapper", TMapper.class, true), Integer.class,
                new HashChainMap<String, Object>().putChain("id", id));
    }

    public List<User> findUserList() {
        return hammer.list(new TplExecuteIdFileImpl("findUserList", "namesapce"), User.class,
                new HashChainMap<String, Object>());
    }

    public List<User> findUserList(String name) {
        return hammer.list(new TplExecuteIdFileImpl("findUserList_1", "TMapper"), User.class,
                new HashChainMap<String, Object>().putChain("name", name));
    }

    public List<User> findUserList2() {
        return hammer.list(new TplExecuteIdMapperImpl("findUserList2", "TMapper", TMapper.class, true), User.class,
                new HashChainMap<String, Object>());
    }

    public List<User> findUserList2(String name) {
        return hammer.list(new TplExecuteIdMapperImpl("findUserList2_1", "TMapper", TMapper.class, true), User.class,
                new HashChainMap<String, Object>().putChain("name", name));
    }

    public List<Map<String, Object>> findMapList() {
        return hammer.list(new TplExecuteIdFileImpl("findMapList", "namesapce"), new HashChainMap<String, Object>());
    }

    public List<Map<String, Object>> findMapList(String name) {
        return hammer.list(new TplExecuteIdFileImpl("findMapList_1", "TMapper"),
                new HashChainMap<String, Object>().putChain("name", name));
    }

    public List<Map<String, Object>> findMapList2() {
        return hammer.list(new TplExecuteIdMapperImpl("findMapList2", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>());
    }

    public List<Map<String, Object>> findMapList2(String name) {
        return hammer.list(new TplExecuteIdMapperImpl("findMapList2_1", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>().putChain("name", name));
    }

    public PaginationResults<User> findUserPage(Page page) {
        return hammer.pagination(new TplExecuteIdFileImpl("findUserPage", "namesapce"), User.class,
                new HashChainMap<String, Object>(), page);
    }

    public PaginationResults<User> findUserPage(String name, Page page) {
        return hammer.pagination(new TplExecuteIdFileImpl("findUserPage_1", "namesapce"), User.class,
                new HashChainMap<String, Object>().putChain("name", name), page);
    }

    public PaginationResults<User> findUserPage2(Page page) {
        return hammer.pagination(new TplExecuteIdMapperImpl("findUserPage2", "TMapper", TMapper.class, true),
                User.class, new HashChainMap<String, Object>(), page);
    }

    public PaginationResults<User> findUserPage2(String name, Page page) {
        return hammer.pagination(new TplExecuteIdMapperImpl("findUserPage2_1", "TMapper", TMapper.class, true),
                User.class, new HashChainMap<String, Object>().putChain("name", name), page);
    }

    public PaginationResults<Map<String, Object>> findMapPage(Page page) {
        return hammer.pagination(new TplExecuteIdFileImpl("findMapPage", "namesapce"),
                new HashChainMap<String, Object>(), page);
    }

    public PaginationResults<Map<String, Object>> findMapPage(String name, Page page) {
        return hammer.pagination(new TplExecuteIdFileImpl("findMapPage_1", "namesapce"),
                new HashChainMap<String, Object>().putChain("name", name), page);
    }

    public PaginationResults<Map<String, Object>> findMapPage2(Page page) {
        return hammer.pagination(new TplExecuteIdMapperImpl("findMapPage2", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>(), page);
    }

    public PaginationResults<Map<String, Object>> findMapPage2(String name, Page page) {
        return hammer.pagination(new TplExecuteIdMapperImpl("findMapPage2_1", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>().putChain("name", name), page);
    }

    public PaginationResults<User> findUserLimit(int offset, int limit) {
        return hammer.pagination(new TplExecuteIdFileImpl("findUserLimit", "namesapce"), User.class,
                new HashChainMap<String, Object>(), offset, limit);
    }

    public PaginationResults<User> findUserLimit(String name, int offset, int limit) {
        return hammer.pagination(new TplExecuteIdFileImpl("findUserLimit_1", "namesapce"), User.class,
                new HashChainMap<String, Object>().putChain("name", name), offset, limit);
    }

    public PaginationResults<User> findUserLimit2(int offset, int limit) {
        return hammer.pagination(new TplExecuteIdMapperImpl("findUserLimit2", "TMapper", TMapper.class, true),
                User.class, new HashChainMap<String, Object>(), offset, limit);
    }

    public PaginationResults<User> findUserLimit2(String name, int offset, int limit) {
        return hammer.pagination(new TplExecuteIdMapperImpl("findUserLimit2_1", "TMapper", TMapper.class, true),
                User.class, new HashChainMap<String, Object>().putChain("name", name), offset, limit);
    }

    public PaginationResults<Map<String, Object>> findMapLimit(int offset, int limit) {
        return hammer.pagination(new TplExecuteIdFileImpl("findMapLimit", "namesapce"),
                new HashChainMap<String, Object>(), offset, limit);
    }

    public PaginationResults<Map<String, Object>> findMapLimit(String name, int offset, int limit) {
        return hammer.pagination(new TplExecuteIdFileImpl("findMapLimit_1", "namesapce"),
                new HashChainMap<String, Object>().putChain("name", name), offset, limit);
    }

    public PaginationResults<Map<String, Object>> findMapLimit2(int offset, int limit) {
        return hammer.pagination(new TplExecuteIdMapperImpl("findMapLimit2", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>(), offset, limit);
    }

    public PaginationResults<Map<String, Object>> findMapLimit2(String name, int offset, int limit) {
        return hammer.pagination(new TplExecuteIdMapperImpl("findMapLimit2_1", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>().putChain("name", name), offset, limit);
    }

    public PaginationResults<Map<String, Object>> testPosition(int offset, int limit, String name, String pass) {
        return hammer.pagination(new TplExecuteIdMapperImpl("testPosition", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>().putChain("name", name).putChain("pass", pass), offset, limit);
    }

    public PaginationResults<Map<String, Object>> testPosition(String name, int limit, String pass) {
        return hammer.pagination(new TplExecuteIdMapperImpl("testPosition", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>().putChain("name", name).putChain("pass", pass), 0, limit);
    }

    public PaginationResults<User> testPosition2(int offset, int limit, String name, String pass) {
        return hammer.pagination(new TplExecuteIdMapperImpl("testPosition", "TMapper", TMapper.class, true), User.class,
                new HashChainMap<String, Object>().putChain("name", name).putChain("pass", pass), offset, limit);
    }

    public PaginationResults<User> testPosition2(String name, int limit, String pass) {
        return hammer.pagination(new TplExecuteIdMapperImpl("testPosition", "TMapper", TMapper.class, true), User.class,
                new HashChainMap<String, Object>().putChain("name", name).putChain("pass", pass), 0, limit);
    }

    public PaginationResults<Map<String, Object>> testPosition(Page page, String name, String pass) {
        return hammer.pagination(new TplExecuteIdMapperImpl("testPosition", "TMapper", TMapper.class, true),
                new HashChainMap<String, Object>().putChain("name", name).putChain("pass", pass), page);
    }

    public PaginationResults<User> testPosition2(Page page, String name, String pass) {
        return hammer.pagination(new TplExecuteIdMapperImpl("testPosition", "TMapper", TMapper.class, true), User.class,
                new HashChainMap<String, Object>().putChain("name", name).putChain("pass", pass), page);
    }

    /**
     * {@inheritDoc}
     */

    public List<User> findUserList(Page page) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */

    public List<User> findUserList2(String name, Page page) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */

    public List<User> findUserList(int offset, int limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */

    public List<User> findUserList2(String name, int offset, int limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */

    public List<Map<String, Object>> findMapList2(String name, Page page) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */

    public List<Map<String, Object>> findMapList(int offset, int limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */

    public List<Map<String, Object>> findMapList2(String name, int offset, int limit) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Map<String, Object>> findMapList(Page page) {
        return hammer.list(new TplExecuteIdMapperImpl("findMapList", "namesapce", TMapper.class, true),
                new HashChainMap<String, Object>(), page);
    }

}
