
package cn.featherfly.hammer.sqldb.tpl.validation;

import javax.validation.Validation;

import org.hibernate.validator.HibernateValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.HammerValidateException;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.config.validator.ValidatorConfigImpl;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.tpl.mapper.TplDynamicExecutorFactory;
import cn.featherfly.validation.JavaxValidator;

/**
 * SqlTplDynamicExecutorTestValidationApi.
 *
 * @author zhongj
 */
public class SqlTplDynamicExecutorTestValidationApi extends JdbcTestBase {

    UserMapperValidationApi userMapper;

    @BeforeClass
    void setup() {
        TplDynamicExecutorFactory mapperFactory = TplDynamicExecutorFactory.getInstance();
        HammerConfigImpl config = new HammerConfigImpl(true);
        config.setValidatorConfig(new ValidatorConfigImpl(
            new JavaxValidator(
                Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory().getValidator(),
                HammerValidateException::new)));
        Hammer hammer =
            SqldbHammerImpl.builder(jdbc, mappingFactory, configFactory, propertyAccessorFactory, config).build();
        userMapper = mapperFactory.newInstance(UserMapperValidationApi.class, hammer, config);
    }

    @Test(expectedExceptions = HammerValidateException.class)
    void testSelectByUsername() {
        userMapper.selectByUsername(null);
    }

    @Test(expectedExceptions = HammerValidateException.class)
    void testGetByUsername() {
        userMapper.getByUsername(null);
    }
}
