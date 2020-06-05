
package cn.featherfly.hammer.sqldb.tpl.mapper;

import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.RandomUtils;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.sqldb.tpl.UserMapper3;

/**
 * <p>
 * UserService
 * </p>
 *
 * @author zhongj
 */
@Service
public class UserService {

    @Resource
    UserMapper3 userMapper;

    @Resource
    DataSource dataSource;

    @Transactional
    public void saveBatch(User... users) {
        ArrayUtils.each(users, (a, i) -> {
            userMapper.save(a);
            insert(RandomUtils.getRandomString(10), RandomUtils.getRandomString(6), RandomUtils.getRandomInt(4));
            if (i > 1) {
                throw new RuntimeException("test transaction , i = " + i);
            }
        });
    }

    private void insert(String username, String password, int age) {
        //        DataSourceUtils.getConnection(obtainDataSource())

        String sql = "INSERT INTO `user` (`id`,`password`,`username`,`mobile_no`,`age`) VALUES (?,?,?,?,?)";
        java.sql.Connection connection = DataSourceUtils.getConnection(dataSource);
        try (PreparedStatement prep = connection.prepareStatement(sql)) {
            JdbcUtils.setParameters(prep, new Object[] { null, password, username, null, age });
            prep.execute();
        } catch (Exception e) {
            throw new JdbcException(e);
        }

        //        SqlExecutor executor = new SqlExecutor(dataSource);
    }
}
