
package cn.featherfly.hammer.tpl.mapper;

import java.util.List;

import cn.featherfly.common.repository.Params;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.tpl.TplExecuteIdFileImpl;

/**
 * <p>
 * TestMapper
 * </p>
 *
 * @author zhongj
 */
public class TMapperImpl extends BasedTplHammer implements TMapper {

    //    protected final TplExecuteIdParser parser = new TplExecuteIdEmailStyleParser();

    /**
     * @param hammer
     */
    public TMapperImpl(Hammer hammer, HammerConfig hammerConfig) {
        super(hammer, hammerConfig);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    public int count() {
    //        return hammer.template().intValue(fileExecuteId("count", "TMapper"), new ChainMapImpl<>());
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    public User getByUsernameAndPassword(String username, String password) {
    //        return tplExecutor.single(fileExecuteId("getByUsernameAndPassword", "TMapper"), User.class,
    //                new ChainMapImpl<String, Object>().putChain("username", username).putChain("password", password));
    //    }

    //    public User get() {
    //        return hammer.template().single(new TplExecuteIdFileImpl("get", "namesapce", parser), User.class,
    //                new ChainMapImpl<>());
    //    }
    //
    //    public User get(String username) {
    //        return hammer.template().single(new TplExecuteIdFileImpl("get_1", "namesapce", parser), User.class,
    //                new ChainMapImpl<String, Object>().putChain("username", username));
    //    }
    //
    //    public User get(String username, String password) {
    //        return hammer.template().single(new TplExecuteIdFileImpl("get_2", "namesapce", parser), User.class,
    //                new ChainMapImpl<String, Object>().putChain("username", username).putChain("password", password));
    //    }
    //
    //    public User get(String username, String password, Integer age) {
    //        return hammer.template().single(new TplExecuteIdFileImpl("get_3", "namesapce", parser), User.class,
    //                new ChainMapImpl<String, Object>().putChain("username", username).putChain("password", password)
    //                        .putChain("age", age));
    //    }
    //
    //    public User get2() {
    //        return hammer.template().single(new TplExecuteIdMapperImpl("get2", "TMapper", TMapper.class, parser),
    //                User.class, new ChainMapImpl<>());
    //    }
    //
    //    public User get2(String username, String password, Integer age) {
    //        return hammer.template().single(new TplExecuteIdMapperImpl("get2_", "TMapper", TMapper.class, parser),
    //                User.class, new ChainMapImpl<String, Object>().putChain("username", username)
    //                        .putChain("password", password).putChain("age", age));
    //    }
    //
    //    public List<User> findUsers(String name, Page page) {
    //        return hammer.template().list(new TplExecuteIdFileImpl("findUsers", "namespace", parser), User.class,
    //                new ChainMapImpl<>(), page);
    //    }
    //
    //    public void update() {
    //        hammer.template().execute(new TplExecuteIdFileImpl("update", "namespace", parser), new ChainMapImpl<>());
    //    }
    //
    //    public void merge() {
    //        hammer.template().execute(new TplExecuteIdMapperImpl("merge", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<>());
    //    }
    //
    //    public void merge(String name, String pass) {
    //        hammer.template().execute(new TplExecuteIdMapperImpl("merge", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<String, Object>().putChain("name", name).putChain("pass", pass));
    //    }
    //
    //    public int merge2(String name, String pass) {
    //        return hammer.template().execute(new TplExecuteIdMapperImpl("merge2", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<String, Object>().putChain("name", name).putChain("pass", pass));
    //    }
    //
    //    public Map<String, Object> getMap() {
    //        return hammer.template().single(new TplExecuteIdFileImpl("getMap", "namesapce", parser), new ChainMapImpl<>());
    //    }
    //
    //    public Map<String, Object> getMap(String username, String password, Integer age) {
    //        return hammer.template().single(new TplExecuteIdFileImpl("getMap_3", "namesapce", parser),
    //                new ChainMapImpl<String, Object>().putChain("username", username).putChain("password", password)
    //                        .putChain("age", age));
    //    }
    //
    //    public Map<String, Object> getMap2() {
    //        return hammer.template().single(new TplExecuteIdMapperImpl("getMap2", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<>());
    //    }
    //
    //    public Map<String, Object> getMap2(String username, String password, Integer age) {
    //        return hammer.template().single(new TplExecuteIdMapperImpl("getMap2_1", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<String, Object>().putChain("username", username).putChain("password", password)
    //                        .putChain("age", age));
    //    }
    //
    //    public String getName() {
    //        return hammer.template().string(new TplExecuteIdFileImpl("getName", "namesapce", parser), new ChainMapImpl<>());
    //    }
    //
    //    public String getName(Long id) {
    //        return hammer.template().string(new TplExecuteIdFileImpl("getName_1", "namesapce", parser),
    //                new ChainMapImpl<String, Object>().putChain("id", id));
    //    }
    //
    //    public String getName2() {
    //        return hammer.template().string(new TplExecuteIdMapperImpl("getName2", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<>());
    //    }
    //
    //    public String getName2(Long id) {
    //        return hammer.template().string(new TplExecuteIdMapperImpl("getName2_1", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<String, Object>().putChain("id", id));
    //    }
    //
    //    public int getInt() {
    //        return hammer.template().intValue(new TplExecuteIdFileImpl("getInt", "namesapce", parser),
    //                new ChainMapImpl<>());
    //    }
    //
    //    public int getInt(Long id) {
    //        return hammer.template().intValue(new TplExecuteIdFileImpl("getInt_1", "namesapce", parser),
    //                new ChainMapImpl<String, Object>().putChain("id", id));
    //    }
    //
    //    public int getInt2() {
    //        return hammer.template().intValue(new TplExecuteIdMapperImpl("getInt2", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<>());
    //    }
    //
    //    public int getInt2(Long id) {
    //        return hammer.template().intValue(new TplExecuteIdMapperImpl("getInt2_1", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<String, Object>().putChain("id", id));
    //    }
    //
    //    public long getLong() {
    //        return hammer.template().longValue(new TplExecuteIdFileImpl("getLong", "namesapce", parser),
    //                new ChainMapImpl<>());
    //    }
    //
    //    public long getLong(Long id) {
    //        return hammer.template().longValue(new TplExecuteIdFileImpl("getLong_1", "namesapce", parser),
    //                new ChainMapImpl<String, Object>().putChain("id", id));
    //    }
    //
    //    public long getLong2() {
    //        return hammer.template().longValue(new TplExecuteIdMapperImpl("getLong2", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<>());
    //    }
    //
    //    public long getLong2(Long id) {
    //        return hammer.template().longValue(new TplExecuteIdMapperImpl("getLong2_1", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<String, Object>().putChain("id", id));
    //    }
    //
    //    public double getDouble() {
    //        return hammer.template().doubleValue(new TplExecuteIdFileImpl("getLong", "namesapce", parser),
    //                new ChainMapImpl<>());
    //    }
    //
    //    public double getDouble(Long id) {
    //        return hammer.template().doubleValue(new TplExecuteIdFileImpl("getLong_1", "namesapce", parser),
    //                new ChainMapImpl<String, Object>().putChain("id", id));
    //    }
    //
    //    public double getDouble2() {
    //        return hammer.template().doubleValue(new TplExecuteIdMapperImpl("getLong2", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<>());
    //    }
    //
    //    public double getDouble2(Long id) {
    //        return hammer.template().doubleValue(new TplExecuteIdMapperImpl("getLong2_1", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<String, Object>().putChain("id", id));
    //    }
    //
    //    public Integer getInteger() {
    //        return hammer.template().number(new TplExecuteIdFileImpl("getInteger", "namesapce", parser), Integer.class,
    //                new ChainMapImpl<>());
    //    }
    //
    //    public Integer getInteger(Long id) {
    //        return hammer.template().number(new TplExecuteIdFileImpl("getInteger_1", "namesapce", parser), Integer.class,
    //                new ChainMapImpl<String, Object>().putChain("id", id));
    //    }
    //
    //    public Integer getInteger2() {
    //        return hammer.template().number(new TplExecuteIdMapperImpl("getInteger2", "TMapper", TMapper.class, parser),
    //                Integer.class, new ChainMapImpl<>());
    //    }
    //
    //    public Integer getInteger2(Long id) {
    //        return hammer.template().number(new TplExecuteIdMapperImpl("getInteger2_1", "TMapper", TMapper.class, parser),
    //                Integer.class, new ChainMapImpl<String, Object>().putChain("id", id));
    //    }
    //
    //    public List<User> findUserList() {
    //        return hammer.template().list(new TplExecuteIdFileImpl("findUserList", "namesapce", parser), User.class,
    //                new ChainMapImpl<>());
    //    }
    //
    //    public List<User> findUserList(String name) {
    //        return hammer.template().list(new TplExecuteIdFileImpl("findUserList_1", "TMapper", parser), User.class,
    //                new ChainMapImpl<String, Object>().putChain("name", name));
    //    }
    //
    //    public List<User> findUserList2() {
    //        return hammer.template().list(new TplExecuteIdMapperImpl("findUserList2", "TMapper", TMapper.class, parser),
    //                User.class, new ChainMapImpl<>());
    //    }
    //
    //    public List<User> findUserList2(String name) {
    //        return hammer.template().list(new TplExecuteIdMapperImpl("findUserList2_1", "TMapper", TMapper.class, parser),
    //                User.class, new ChainMapImpl<String, Object>().putChain("name", name));
    //    }
    //
    //    public List<Map<String, Object>> findMapList() {
    //        return hammer.template().list(new TplExecuteIdFileImpl("findMapList", "namesapce", parser),
    //                new ChainMapImpl<>());
    //    }
    //
    //    public List<Map<String, Object>> findMapList(String name) {
    //        return hammer.template().list(new TplExecuteIdFileImpl("findMapList_1", "TMapper", parser),
    //                new ChainMapImpl<String, Object>().putChain("name", name));
    //    }
    //
    //    public List<Map<String, Object>> findMapList2() {
    //        return hammer.template().list(new TplExecuteIdMapperImpl("findMapList2", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<>());
    //    }
    //
    //    public List<Map<String, Object>> findMapList2(String name) {
    //        return hammer.template().list(new TplExecuteIdMapperImpl("findMapList2_1", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<String, Object>().putChain("name", name));
    //    }
    //
    //    public PaginationResults<User> findUserPage(Page page) {
    //        return hammer.template().pagination(new TplExecuteIdFileImpl("findUserPage", "namesapce", parser), User.class,
    //                new ChainMapImpl<>(), page);
    //    }
    //
    //    public PaginationResults<User> findUserPage(String name, Page page) {
    //        return hammer.template().pagination(new TplExecuteIdFileImpl("findUserPage_1", "namesapce", parser), User.class,
    //                new ChainMapImpl<String, Object>().putChain("name", name), page);
    //    }
    //
    //    public PaginationResults<User> findUserPage2(Page page) {
    //        return hammer.template().pagination(
    //                new TplExecuteIdMapperImpl("findUserPage2", "TMapper", TMapper.class, parser), User.class,
    //                new ChainMapImpl<>(), page);
    //    }
    //
    //    public PaginationResults<User> findUserPage2(String name, Page page) {
    //        return hammer.template().pagination(
    //                new TplExecuteIdMapperImpl("findUserPage2_1", "TMapper", TMapper.class, parser), User.class,
    //                new ChainMapImpl<String, Object>().putChain("name", name), page);
    //    }
    //
    //    public PaginationResults<Map<String, Object>> findMapPage(Page page) {
    //        return hammer.template().pagination(new TplExecuteIdFileImpl("findMapPage", "namesapce", parser),
    //                new ChainMapImpl<>(), page);
    //    }
    //
    //    public PaginationResults<Map<String, Object>> findMapPage(String name, Page page) {
    //        return hammer.template().pagination(new TplExecuteIdFileImpl("findMapPage_1", "namesapce", parser),
    //                new ChainMapImpl<String, Object>().putChain("name", name), page);
    //    }
    //
    //    public PaginationResults<Map<String, Object>> findMapPage2(Page page) {
    //        return hammer.template().pagination(
    //                new TplExecuteIdMapperImpl("findMapPage2", "TMapper", TMapper.class, parser), new ChainMapImpl<>(),
    //                page);
    //    }
    //
    //    public PaginationResults<Map<String, Object>> findMapPage2(String name, Page page) {
    //        return hammer.template().pagination(
    //                new TplExecuteIdMapperImpl("findMapPage2_1", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<String, Object>().putChain("name", name), page);
    //    }
    //
    //    public PaginationResults<User> findUserLimit(int offset, int limit) {
    //        return hammer.template().pagination(new TplExecuteIdFileImpl("findUserLimit", "namesapce", parser), User.class,
    //                new ChainMapImpl<>(), offset, limit);
    //    }
    //
    //    public PaginationResults<User> findUserLimit(String name, int offset, int limit) {
    //        return hammer.template().pagination(new TplExecuteIdFileImpl("findUserLimit_1", "namesapce", parser),
    //                User.class, new ChainMapImpl<String, Object>().putChain("name", name), offset, limit);
    //    }
    //
    //    public PaginationResults<User> findUserLimit2(int offset, int limit) {
    //        return hammer.template().pagination(
    //                new TplExecuteIdMapperImpl("findUserLimit2", "TMapper", TMapper.class, parser), User.class,
    //                new ChainMapImpl<>(), offset, limit);
    //    }
    //
    //    public PaginationResults<User> findUserLimit2(String name, int offset, int limit) {
    //        return hammer.template().pagination(
    //                new TplExecuteIdMapperImpl("findUserLimit2_1", "TMapper", TMapper.class, parser), User.class,
    //                new ChainMapImpl<String, Object>().putChain("name", name), offset, limit);
    //    }
    //
    //    public PaginationResults<Map<String, Object>> findMapLimit(int offset, int limit) {
    //        return hammer.template().pagination(new TplExecuteIdFileImpl("findMapLimit", "namesapce", parser),
    //                new ChainMapImpl<>(), offset, limit);
    //    }
    //
    //    public PaginationResults<Map<String, Object>> findMapLimit(String name, int offset, int limit) {
    //        return hammer.template().pagination(new TplExecuteIdFileImpl("findMapLimit_1", "namesapce", parser),
    //                new ChainMapImpl<String, Object>().putChain("name", name), offset, limit);
    //    }
    //
    //    public PaginationResults<Map<String, Object>> findMapLimit2(int offset, int limit) {
    //        return hammer.template().pagination(
    //                new TplExecuteIdMapperImpl("findMapLimit2", "TMapper", TMapper.class, parser), new ChainMapImpl<>(),
    //                offset, limit);
    //    }
    //
    //    public PaginationResults<Map<String, Object>> findMapLimit2(String name, int offset, int limit) {
    //        return hammer.template().pagination(
    //                new TplExecuteIdMapperImpl("findMapLimit2_1", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<String, Object>().putChain("name", name), offset, limit);
    //    }
    //
    //    public PaginationResults<Map<String, Object>> testPosition(int offset, int limit, String name, String pass) {
    //        return hammer.template().pagination(
    //                new TplExecuteIdMapperImpl("testPosition", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<String, Object>().putChain("name", name).putChain("pass", pass), offset, limit);
    //    }
    //
    //    public PaginationResults<Map<String, Object>> testPosition(String name, int limit, String pass) {
    //        return hammer.template().pagination(
    //                new TplExecuteIdMapperImpl("testPosition", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<String, Object>().putChain("name", name).putChain("pass", pass), 0, limit);
    //    }
    //
    //    public PaginationResults<User> testPosition2(int offset, int limit, String name, String pass) {
    //        return hammer.template().pagination(
    //                new TplExecuteIdMapperImpl("testPosition", "TMapper", TMapper.class, parser), User.class,
    //                new ChainMapImpl<String, Object>().putChain("name", name).putChain("pass", pass), offset, limit);
    //    }
    //
    //    public PaginationResults<User> testPosition2(String name, int limit, String pass) {
    //        return hammer.template().pagination(
    //                new TplExecuteIdMapperImpl("testPosition", "TMapper", TMapper.class, parser), User.class,
    //                new ChainMapImpl<String, Object>().putChain("name", name).putChain("pass", pass), 0, limit);
    //    }
    //
    //    public PaginationResults<Map<String, Object>> testPosition(Page page, String name, String pass) {
    //        return hammer.template().pagination(
    //                new TplExecuteIdMapperImpl("testPosition", "TMapper", TMapper.class, parser),
    //                new ChainMapImpl<String, Object>().putChain("name", name).putChain("pass", pass), page);
    //    }
    //
    //    public PaginationResults<User> testPosition2(Page page, String name, String pass) {
    //        return hammer.template().pagination(
    //                new TplExecuteIdMapperImpl("testPosition", "TMapper", TMapper.class, parser), User.class,
    //                new ChainMapImpl<String, Object>().putChain("name", name).putChain("pass", pass), page);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public List<User> findUserList(Page page) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public List<User> findUserList2(String name, Page page) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public List<User> findUserList(int offset, int limit) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public List<User> findUserList2(String name, int offset, int limit) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public List<Map<String, Object>> findMapList2(String name, Page page) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public List<Map<String, Object>> findMapList(int offset, int limit) {
    //
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //
    //    public List<Map<String, Object>> findMapList2(String name, int offset, int limit) {
    //
    //        return null;
    //    }
    //
    //    public List<Map<String, Object>> findMapList(Page page) {
    //        return hammer.template().list(new TplExecuteIdMapperImpl("findMapList", "namesapce", TMapper.class, parser),
    //                new ChainMapImpl<>(), page);
    //    }
    //
    //    public List<User> getGtAge(Integer age) {
    //        return hammer.template().list(new TplExecuteIdMapperImpl("getGtAge", "namesapce", TMapper.class, parser),
    //                User.class, new ChainMapImpl<String, Object>().putChain("age", age));
    //    }

    @Override
    public List<User> getGtAge(int age) {
        return tplExecutor.list(new TplExecuteIdFileImpl("getGtAge", "TMapper", parser), User.class,
            new Params().set("age", age));
    }

}
