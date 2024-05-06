
package cn.featherfly.hammer.sqldb.dsl;

import java.util.List;
import java.util.function.Function;

import org.testng.annotations.Test;

import com.speedment.common.tuple.Tuple;
import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.SimpleRepository;
import cn.featherfly.hammer.sqldb.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;

/**
 * NewDslApi.
 *
 * @author zhongj
 */
public class NewDslApi {

    //    <R> void eq(Function<Tuple2<Class<UserInfo>, Class<User>>, Class<User>> find,
    //            SerializableFunction<User, R> property, R value) {
    //        System.out.println("eq SerializableFunction<User, UserInfo> property");
    //    }

    //    <R> void eq(Function<Tuple2<Class<UserInfo>, Class<User>>, Class<UserInfo>> find,
    //            SerializableFunction1<UserInfo, R> property, R value) {
    //        System.out.println("eq SerializableFunction<User, User> property");
    //    }

    <R> void eq(
            Function<Tuple3<QueryEntityRepository<UserInfo>, QueryEntityRepository<User>, QueryEntityRepository<User>>, QueryEntityRepository<User>> find,
            SerializableFunction<User, R> property, R value) {

        System.out.println("eq SerializableFunction<User, R> property index = " + find
                .apply(Tuples.of(new QueryEntityRepository<>(0, UserInfo.class),
                        new QueryEntityRepository<>(1, User.class), new QueryEntityRepository<>(2, User.class)))
                .getIndex());
    }

    <R> void eq(
            Function<Tuple3<QueryEntityRepository<UserInfo>, QueryEntityRepository<User>, QueryEntityRepository<User>>, QueryEntityRepository<UserInfo>> find,
            SerializableFunction1<UserInfo, R> property, R value) {
        System.out.println("eq SerializableFunction1<UserInfo, R> property index = " + find
                .apply(Tuples.of(new QueryEntityRepository<>(0, UserInfo.class),
                        new QueryEntityRepository<>(1, User.class), new QueryEntityRepository<>(2, User.class)))
                .getIndex());
    }

    <R> void eq(
            Function<Tuple3<QueryEntityRepository<UserInfo>, QueryEntityRepository<User>, QueryEntityRepository<User>>, QueryEntityRepository<User>> queryEntities,
            SerializableFunction2<User, R> property, R value) {
        System.out.println("eq SerializableFunction2<User, R> property  index = " + queryEntities
                .apply(Tuples.of(new QueryEntityRepository<>(0, UserInfo.class),
                        new QueryEntityRepository<>(1, User.class), new QueryEntityRepository<>(2, User.class)))
                .getIndex());
    }

    <R> void eq2(Function<Tuple3<UserInfo, User, User>, QueryEntityRepository<User>> find,
            SerializableFunction2<User, R> property, R value) {

    }

    <R> void eq(SerializableFunction<UserInfo, R> property, R value) {
        System.out.println("eq SerializableFunction<UserInfo, R> property");
    }

    @Test
    void test() {
        eq(entities -> entities.get1(), User::getAge, 1);
        eq(entities -> entities.get1(), User::getAge, 1);
        eq(entities -> entities.get2(), User::getAge, 1);
        eq(entities -> entities.get0(), UserInfo::getName, "aaa");
        eq(entities -> entities.get0(), UserInfo::getId, 1); // 等同 eq(UserInfo::getId, 1);
        eq(UserInfo::getId, 1); // 等同 eq(querys -> querys.get0(), UserInfo::getId, 1);
    }

    public static void main(String[] args) {
        SqlQuery query = new SqlQuery(null, (DatabaseMetadata) null, null, null);

        UserInfo userInfo = new UserInfo();

        //        List<UserInfo> userInfos = query.find(UserInfo.class).join(UserInfo::getUser).where()
        //                .eq(userInfo::getUser, User::getPwd).list();
        List<UserInfo> userInfos = query.find(UserInfo.class).join(UserInfo::getUser).where()
                .property(UserInfo::getUser).property(User::getPwd).eq(userInfo.getUser().getPwd()).list();

        // 实例对象可以获取property
        query.find(UserInfo.class).where().eq(userInfos.get(0)::getDescp);
        query.find(UserInfo.class).where().eq(userInfo::getDescp);

        query.find("user").field(AggregateFunction.SUM, true, "age").intNumber();

        Function<FindAndFetchManager<Tuple2<EntityRepository<UserInfo>, EntityRepository<UserInfo>>>, Repository> f = (
                find) -> {
            find.getFindAndFetch();
            return find.getFindAndFetch().get0();
        };
        f.apply(new FindAndFetchManager<>(
                Tuples.of(new EntityRepository<>(UserInfo.class), new EntityRepository<>(UserInfo.class))));

        Function<Tuple2<EntityRepository<UserInfo>, EntityRepository<User>>, Repository> f2 = (tuple) -> {
            return tuple.get0();
        };

        f2.apply(Tuples.of(new EntityRepository<>(UserInfo.class), new EntityRepository<>(User.class)));
    }
}

class EntityRepository<T> extends SimpleRepository {

    private Class<T> type;

    /**
     * @param index
     * @param type
     */
    public EntityRepository(Class<T> type) {
        super();
        this.type = type;
    }

    /**
     * get type value
     *
     * @return type
     */
    public Class<T> getType() {
        return type;
    }
}

class QueryEntityRepository<T> extends EntityRepository<T> {

    private int index = 0;

    /**
     * @param index
     * @param type
     */
    public QueryEntityRepository(int index, Class<T> type) {
        super(type);
        this.index = index;
    }

    /**
     * get index value
     *
     * @return index
     */
    public int getIndex() {
        return index;
    }

}

class FindAndFetchManager<T extends Tuple> {

    private T tuple;

    /**
     * @param tuple
     */
    public FindAndFetchManager(T tuple) {
        super();
        this.tuple = tuple;
    }

    public T getFindAndFetch() {
        return tuple;
    }
}