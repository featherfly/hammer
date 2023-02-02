
package cn.featherfly.hammer.sqldb.jdbc.dsl;

import java.util.List;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple;
import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.repository.SimpleRepository;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserInfo;

/**
 * NewDslApi.
 *
 * @author zhongj
 */
public class NewDslApi {

    public static void main(String[] args) {

        SqlQuery query = null;

        UserInfo userInfo = new UserInfo();

        List<UserInfo> userInfos = query.find(UserInfo.class).join(UserInfo::getUser).where()
                .eq(userInfo::getUser, User::getPwd).list();

        // 实例对象可以获取property
        query.find(UserInfo.class).where().eq(userInfos.get(0)::getDescp);
        query.find(UserInfo.class).where().eq(userInfo::getDescp);

        query.find("user").property(AggregateFunction.SUM, true, "age").integer();

        Function<FindAndFetchManager<Tuple2<EntityRepository<UserInfo>, EntityRepository<UserInfo>>>,
                Repository> f = (find) -> {
                    return find.getFindAndFetch().get0();
                };

        Function<Tuple2<EntityRepository<UserInfo>, EntityRepository<User>>, Repository> f2 = (tuple) -> {
            return tuple.get0();
        };

        f2.apply(Tuples.of(new EntityRepository<UserInfo>(), new EntityRepository<User>()));
    }
}

class EntityRepository<T> extends SimpleRepository {
    public Class<T> type() {
        return null;
    }
}

class FindAndFetchManager<T extends Tuple> {

    private T tuple;

    public T getFindAndFetch() {
        return tuple;
    }
}