
package cn.featherfly.hammer.sqldb.tpl.mapper;

import java.io.Serializable;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Randoms;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.tpl.UserMapper3;

/**
 * UserService.
 *
 * @author zhongj
 */
@Service
public class UserService {

    /** The user mapper. */
    @Resource
    UserMapper3 userMapper;

    /** The data source. */
    @Resource
    DataSource dataSource;

    /**
     * Save batch.
     *
     * @param users the users
     */
    @Transactional
    public void saveBatch(User... users) {
        ArrayUtils.each((a, i) -> {
            userMapper.save(a);
            System.out.println("save " + i);
            insert(Randoms.getString(10), Randoms.getString(6), Randoms.getInt(4));
            if (i > 1) {
                throw new RuntimeException("test transaction , i = " + i);
            }
        }, users);
    }

    private void insert(String username, String password, int age) {
        //        DataSourceUtils.getConnection(obtainDataSource())

        String sql = "INSERT INTO `user` (`id`,`password`,`username`,`mobile_no`,`age`) VALUES (?,?,?,?,?)";
        java.sql.Connection connection = DataSourceUtils.getConnection(dataSource);
        try (PreparedStatement prep = connection.prepareStatement(sql)) {
            JdbcUtils.setParameters(prep, new Serializable[] { null, password, username, null, age });
            prep.execute();
        } catch (Exception e) {
            throw new JdbcException(e);
        }

        //        SqlExecutor executor = new SqlExecutor(dataSource);
    }
}
