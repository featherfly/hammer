
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-11-23 23:48:23
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import javax.validation.Validation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.ParamedExecutionExecutorEx;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.HammerValidateException;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.config.validator.ValidatorConfigImpl;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdate;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdate;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetch;
import cn.featherfly.hammer.tpl.TplExecuteId;
import cn.featherfly.hammer.tpl.TplExecuteIdBuilder;
import cn.featherfly.hammer.tpl.TplExecutor;
import cn.featherfly.validation.JavaxValidator;

/**
 * OverloadUpdateMapper2Impl.
 *
 * @author zhongj
 */
public class OverloadUpdateMapperTest {

    HammerConfigImpl hammerConfig;

    @BeforeClass
    public void before() {
        hammerConfig = new HammerConfigImpl(true);
        hammerConfig.setValidatorConfig(new ValidatorConfigImpl(
            new JavaxValidator(Validation.byDefaultProvider().configure().buildValidatorFactory().getValidator(),
                HammerValidateException::new)));
    }

    @Test(expectedExceptions = HammerValidateException.class)
    public void testUpdateEntity() {
        OverloadUpdateMapper m = new OverloadUpdateMapperImpl(hammerConfig);
        m.update((User) null);
    }

    @Test(expectedExceptions = HammerValidateException.class)
    public void testUpdateList() {
        OverloadUpdateMapper m = new OverloadUpdateMapperImpl(hammerConfig);
        m.update((List<User>) null);
    }
}

class OverloadUpdateMapperImpl extends BasedTplGenericHammer<User, Long> implements OverloadUpdateMapper {

    public OverloadUpdateMapperImpl(HammerConfig config) {
        super(getHammer(), User.class, config);
    }

    @Override
    public int update(User entity) {
        getHammerConfig().getValidatorConfig().getExecutableValidator().validateParametersThrow(this,
            ClassUtils.getMethod(OverloadUpdateMapper2.class, "update", User.class), new Object[] { entity });
        return 1;
    }

    @Override
    public int[] update(List<User> entities) {
        getHammerConfig().getValidatorConfig().getExecutableValidator().validateParametersThrow(this,
            ClassUtils.getMethod(OverloadUpdateMapper2.class, "update", List.class), new Object[] { entities });
        return new int[entities.size()];
    }

    private static Hammer getHammer() {
        return new Hammer() {

            @Override
            public <E> int save(E entity) {

                return 0;
            }

            @Override
            public <E> int[] save(List<E> entities) {

                return null;
            }

            @Override
            public <E> int[] save(List<E> entities, int batchSize) {

                return null;
            }

            @Override
            public <E> int update(E entity) {

                return 0;
            }

            @Override
            public <E> int update(E entity, IgnoreStrategy ignoreStrategy) {

                return 0;
            }

            @Override
            public <E> E updateFetch(Serializable id, Class<E> type, UnaryOperator<E> updateOperator) {

                return null;
            }

            @Override
            public <E> E updateFetch(E entity, UnaryOperator<E> updateOperator) {

                return null;
            }

            @Override
            public <E> int[] update(E... entities) {

                return null;
            }

            @Override
            public <E> int[] update(List<E> entities) {

                return null;
            }

            @Override
            public <E> int[] update(List<E> entities, int batchSize) {

                return null;
            }

            @Override
            public <E> int[] update(List<E> entities, IgnoreStrategy ignoreStrategy) {

                return null;
            }

            @Override
            public <E> int merge(E entity) {

                return 0;
            }

            @Override
            public <E> int[] merge(E... entities) {

                return null;
            }

            @Override
            public <E> int[] merge(List<E> entities) {

                return null;
            }

            @Override
            public <E> int saveOrUpdate(E entity) {

                return 0;
            }

            @Override
            public <E> int saveOrUpdate(E entity, Predicate<E> updatable) {

                return 0;
            }

            @Override
            public <E> int delete(E entity) {

                return 0;
            }

            @Override
            public <E> int delete(Serializable id, Class<E> entityType) {

                return 0;
            }

            @Override
            public <E> int[] delete(Serializable[] ids, Class<E> entityType) {

                return null;
            }

            @Override
            public <E, I extends Serializable> int[] delete(List<I> ids, Class<E> entityType) {

                return null;
            }

            @Override
            public <E> int[] delete(List<E> entities) {

                return null;
            }

            @Override
            public <E> E get(Serializable id, Class<E> type) {

                return null;
            }

            @Override
            public <E, R> E get(Serializable id, Class<E> type, SerializableFunction<E, R> fetchProperty) {

                return null;
            }

            @Override
            public <E> List<E> get(Class<E> type, Serializable... ids) {

                return null;
            }

            @Override
            public <E> List<E> get(Class<E> type, List<Serializable> ids) {

                return null;
            }

            @Override
            public <E> E get(E entity) {

                return null;
            }

            @Override
            public RepositoryQueryFetch query(String repository) {

                return null;
            }

            @Override
            public RepositoryQueryFetch query(Repository repository) {

                return null;
            }

            @Override
            public <E> EntityQueryFetch<E> query(Class<E> entityType) {

                return null;
            }

            @Override
            public RepositoryUpdate update(String repository) {

                return null;
            }

            @Override
            public RepositoryUpdate update(Repository repository) {

                return null;
            }

            @Override
            public <E> EntityUpdate<E> update(Class<E> entityType) {

                return null;
            }

            @Override
            public RepositoryDelete delete(String repository) {

                return null;
            }

            @Override
            public RepositoryDelete delete(Repository repository) {

                return null;
            }

            @Override
            public <E> EntityDelete<E> delete(Class<E> entityType) {

                return null;
            }

            @Override
            public ParamedExecutionExecutorEx dml(String execution, Map<String, Serializable> params) {

                return null;
            }

            @Override
            public ParamedExecutionExecutorEx dml(String execution, Serializable... params) {

                return null;
            }

            @Override
            public TplExecutor template() {

                return null;
            }

            @Override
            public ParamedExecutionExecutorEx template(String templateContent, Map<String, Serializable> params) {

                return null;
            }

            @Override
            public ParamedExecutionExecutorEx template(Function<TplExecuteIdBuilder, TplExecuteId> tplExecuteIdBuilder,
                Map<String, Serializable> params) {

                return null;
            }

            @Override
            public ParamedExecutionExecutorEx template(TplExecuteId tplExecuteId, Map<String, Serializable> params) {

                return null;
            }

            @Override
            public ParamedExecutionExecutorEx template(String tplExecuteId, Serializable... params) {

                return null;
            }

            @Override
            public ParamedExecutionExecutorEx template(Function<TplExecuteIdBuilder, TplExecuteId> tplExecuteIdBuilder,
                Serializable... params) {

                return null;
            }

            @Override
            public ParamedExecutionExecutorEx template(TplExecuteId tplExecuteId, Serializable... params) {

                return null;
            }

            @Override
            public <E> int[] update(E[] entities, int batchSize) {
                return null;
            }

            @Override
            public <E> int[] saveOrUpdate(List<E> entities) {
                return null;
            }

            @Override
            public <E> int[] saveOrUpdate(List<E> entities, Predicate<E> updatable) {
                return null;
            }

            @Override
            public <E> int[] saveOrUpdate(List<E> entities, int batchSize) {
                return null;
            }

            @Override
            public <E> int[] saveOrUpdate(List<E> entities, int batchSize, Predicate<E> updatable) {
                return null;
            }
        };
    }
}