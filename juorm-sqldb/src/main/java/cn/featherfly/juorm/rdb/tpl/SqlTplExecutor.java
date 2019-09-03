
package cn.featherfly.juorm.rdb.tpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePaginationResults;
import cn.featherfly.juorm.rdb.Constants;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.mapping.JdbcMappingFactory;
import cn.featherfly.juorm.rdb.tpl.freemarker.JdbcFreemarkerTemplateEnv;
import cn.featherfly.juorm.tpl.TemplateEnv;
import cn.featherfly.juorm.tpl.TemplateProcessor;
import cn.featherfly.juorm.tpl.TplConfigFactory;
import cn.featherfly.juorm.tpl.TplExecuteConfig;
import cn.featherfly.juorm.tpl.TplExecuteId;
import cn.featherfly.juorm.tpl.TplExecutor;
import cn.featherfly.juorm.tpl.supports.ConditionParamsManager;

/**
 * <p>
 * Config
 * </p>
 *
 * @author zhongj
 */
public class SqlTplExecutor implements TplExecutor {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private TplConfigFactory configFactory;

    private Jdbc jdbc;

    private JdbcMappingFactory mappingFactory;

    @SuppressWarnings("rawtypes")
    private TemplateProcessor templateProcessor;

    /**
     * @param configFactory     configFactory
     * @param templateProcessor templateProcessor
     * @param jdbc              jdbc
     * @param mappingFactory    mappingFactory
     */
    public SqlTplExecutor(@Nonnull TplConfigFactory configFactory,
            @SuppressWarnings("rawtypes") @Nonnull TemplateProcessor templateProcessor, @Nonnull Jdbc jdbc,
            @Nonnull JdbcMappingFactory mappingFactory) {
        super();
        this.configFactory = configFactory;
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;
        this.templateProcessor = templateProcessor;
    }

    private Tuple3<String, TplExecuteConfig, ConditionParamsManager> getQueryExecution(String tplExecuteId,
            Map<String, Object> params, Class<?> resultType) {
        TplExecuteConfig config = configFactory.getConfig(tplExecuteId);
        Tuple2<String, ConditionParamsManager> tuple2 = getExecution(tplExecuteId, config.getQuery(), params,
                resultType);
        Constants.LOGGER.debug("tplExecuteId -> {} \nexecuteQuerySql -> {} \nqueryTemplate -> {}", tplExecuteId,
                tuple2.get0(), config.getQuery());
        return Tuples.of(tuple2.get0(), config, tuple2.get1());
    }

    private Tuple2<String, ConditionParamsManager> getCountExecution(String tplExecuteId, Map<String, Object> params,
            TplExecuteConfig config, Class<?> resultType) {
        Tuple2<String, ConditionParamsManager> result = getExecution(tplExecuteId + TplConfigFactory.COUNT_SUFFIX,
                config.getCount(), params, resultType);
        Constants.LOGGER.debug("tplExecuteId -> {}  \nexecuteCountSql -> {}  \ncountTemplate -> {}", tplExecuteId,
                result.get0(), config.getCount());
        return result;
    }

    private Tuple2<String, ConditionParamsManager> getExecution(String templateName, String sql,
            Map<String, Object> params, Class<?> resultType) {
        logger.debug("execute template name : {}", templateName);
        ConditionParamsManager manager = new ConditionParamsManager();
        Map<String, Object> root = new HashMap<>();
        root.putAll(params);

        @SuppressWarnings("rawtypes")
        TemplateEnv templateEnvFacotry = createTemplateEnvFacotry(manager, resultType);
        @SuppressWarnings("unchecked")
        String result = templateProcessor.process(templateName, sql, params, templateEnvFacotry);
        return Tuples.of(result, manager);
    }

    // TODO 此方法后续要抽出到外面来做，这样就可以配置具体的TemplateEnv
    @SuppressWarnings("rawtypes")
    private TemplateEnv createTemplateEnvFacotry(ConditionParamsManager manager, Class<?> resultType) {
        JdbcFreemarkerTemplateEnv env = new JdbcFreemarkerTemplateEnv();
        env.setConfigFactory(configFactory);
        env.setDialect(jdbc.getDialect());
        env.setManager(manager);
        env.setMappingFactory(mappingFactory);
        env.setResultType(resultType);
        return env;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single(String tplExecuteId, Map<String, Object> params) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(tplExecuteId, params, null);
        if (tuple3.get2().getParamNamed() == null || tuple3.get2().getParamNamed()) {
            return jdbc.querySingle(tuple3.get0(), getEffectiveParams(params, tuple3.get2()));
        } else {
            return jdbc.querySingle(tuple3.get0(), tuple3.get2().getParamNames().toArray());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return single(tplExecuteId.getId(), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(tplExecuteId, params,
                entityType);
        if (tuple3.get2().getParamNamed() == null || tuple3.get2().getParamNamed()) {
            return jdbc.querySingle(tuple3.get0(), getEffectiveParams(params, tuple3.get2()), entityType);
        } else {
            return jdbc.querySingle(tuple3.get0(), tuple3.get2().getParamNames().toArray(), entityType);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(tplExecuteId, params, null);
        if (tuple3.get2().getParamNamed() == null || tuple3.get2().getParamNamed()) {
            return jdbc.query(tuple3.get0(), getEffectiveParams(params, tuple3.get2()));
        } else {
            return jdbc.query(tuple3.get0(), tuple3.get2().getParamNames().toArray());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return list(tplExecuteId.getId(), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(tplExecuteId, params,
                entityType);
        if (tuple3.get2().getParamNamed() == null || tuple3.get2().getParamNamed()) {
            return jdbc.query(tuple3.get0(), getEffectiveParams(params, tuple3.get2()), entityType);
        } else {
            return jdbc.query(tuple3.get0(), tuple3.get2().getParamNames().toArray(), entityType);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, int offset, int limit) {
        return findList(tplExecuteId, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, int offset,
            int limit) {
        return list(tplExecuteId.getId(), params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return findList(tplExecuteId, entityType, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, Page page) {
        return list(tplExecuteId.getId(), params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
            int offset, int limit) {
        SimplePaginationResults<Map<String, Object>> pagination = new SimplePaginationResults<>(offset, limit);

        Tuple4<List<Map<String, Object>>, String, TplExecuteConfig, ConditionParamsManager> listTuple = findList(
                tplExecuteId, params, offset, limit);
        pagination.setPageResults(listTuple.get0());

        String countSql = null;
        ConditionParamsManager manager = null;
        TplExecuteConfig config = listTuple.get2();
        if (LangUtils.isEmpty(config.getCount())) {
            countSql = SqlUtils.convertSelectToCount(listTuple.get1());
            manager = listTuple.get3();
        } else {
            Tuple2<String, ConditionParamsManager> countTuple = getCountExecution(tplExecuteId, params, config, null);
            countSql = countTuple.get0();
            manager = countTuple.get1();
        }
        // 默认使用namedParameter
        if (manager.getParamNamed() == null || manager.getParamNamed()) {
            pagination.setTotal(jdbc.queryInt(countSql, getEffectiveParams(params, manager)));
        } else {
            pagination.setTotal(jdbc.queryInt(countSql, manager.getParamNames().toArray()));
        }
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params,
            int offset, int limit) {
        return pagination(tplExecuteId.getId(), params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
            Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params,
            Page page) {
        return pagination(tplExecuteId.getId(), params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            int offset, int limit) {
        SimplePaginationResults<E> pagination = new SimplePaginationResults<>(offset, limit);

        Tuple4<List<E>, String, TplExecuteConfig, ConditionParamsManager> listTuple = findList(tplExecuteId, entityType,
                params, offset, limit);
        pagination.setPageResults(listTuple.get0());

        String countSql = null;
        ConditionParamsManager manager = null;
        TplExecuteConfig config = listTuple.get2();
        if (LangUtils.isEmpty(config.getCount())) {
            countSql = SqlUtils.convertSelectToCount(listTuple.get1());
            manager = listTuple.get3();
        } else {
            Tuple2<String, ConditionParamsManager> countTuple = getCountExecution(tplExecuteId, params, config,
                    entityType);
            countSql = countTuple.get0();
            manager = countTuple.get1();
        }
        // 默认使用namedParameter
        if (manager.getParamNamed() == null || manager.getParamNamed()) {
            pagination.setTotal(jdbc.queryInt(countSql, getEffectiveParams(params, manager)));
        } else {
            pagination.setTotal(jdbc.queryInt(countSql, manager.getParamNames().toArray()));
        }
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType, params, limit.getOffset(), limit.getLimit());
    }

    private Tuple4<List<Map<String, Object>>, String, TplExecuteConfig, ConditionParamsManager> findList(
            String tplExecuteId, Map<String, Object> params, int offset, int limit) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(tplExecuteId, params, null);
        List<Map<String, Object>> list = null;
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();
        // 默认使用namedParameter
        if (manager.getParamNamed() == null || manager.getParamNamed()) {
            list = jdbc.query(jdbc.getDialect().getParamNamedPaginationSql(sql, offset, limit),
                    jdbc.getDialect().getPaginationSqlParameter(getEffectiveParams(params, manager), offset, limit));
        } else {
            list = jdbc.query(jdbc.getDialect().getPaginationSql(sql, offset, limit),
                    jdbc.getDialect().getPaginationSqlParameter(manager.getParamNames().toArray(), offset, limit));
        }
        return Tuples.of(list, sql, tuple3.get1(), manager);
    }

    private <E> Tuple4<List<E>, String, TplExecuteConfig, ConditionParamsManager> findList(String tplExecuteId,
            Class<E> entityType, Map<String, Object> params, int offset, int limit) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(tplExecuteId, params,
                entityType);
        List<E> list = null;
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();
        // 默认使用namedParameter
        if (manager.getParamNamed() == null || manager.getParamNamed()) {
            list = jdbc.query(jdbc.getDialect().getParamNamedPaginationSql(sql, offset, limit),
                    jdbc.getDialect().getPaginationSqlParameter(getEffectiveParams(params, manager), offset, limit),
                    entityType);
        } else {
            list = jdbc.query(jdbc.getDialect().getPaginationSql(sql, offset, limit),
                    jdbc.getDialect().getPaginationSqlParameter(manager.getParamNames().toArray(), offset, limit),
                    entityType);
        }
        return Tuples.of(list, sql, tuple3.get1(), manager);
    }

    private Map<String, Object> getEffectiveParams(Map<String, Object> params, ConditionParamsManager manager) {
        if (manager.getAmount() == 0) {
            return params;
        } else {
            return params.entrySet().stream().filter(t -> {
                return manager.containsName(t.getKey());
            }).collect(Collectors.toMap(e -> {
                return e.getKey();
            }, e -> {
                return e.getValue();
            }));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return single(tplExecuteId.getId(), entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return list(tplExecuteId.getId(), entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return list(tplExecuteId.getId(), entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {
        return list(tplExecuteId.getId(), entityType, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Object> params, int offset, int limit) {
        return pagination(tplExecuteId.getId(), entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Object> params, Page page) {
        return pagination(tplExecuteId.getId(), entityType, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E value(String tplExecuteId, Class<E> valueType, Map<String, Object> params) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(tplExecuteId, params,
                valueType);
        if (tuple3.get2().getParamNamed() == null || tuple3.get2().getParamNamed()) {
            return jdbc.queryValue(tuple3.get0(), getEffectiveParams(params, tuple3.get2()), valueType);
        } else {
            return jdbc.queryValue(tuple3.get0(), tuple3.get2().getParamNames().toArray(), valueType);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(String tplExecuteId, Class<N> numberType, Map<String, Object> params) {
        return value(tplExecuteId, numberType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer intValue(String tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, Integer.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long longValue(String tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, Long.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal bigDecimalValue(String tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, BigDecimal.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double doubleValue(String tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, Double.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String stringValue(String tplExecuteId, Map<String, Object> params) {
        return value(tplExecuteId, String.class, params);
    }
}
