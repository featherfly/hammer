
package cn.featherfly.hammer.sqldb.tpl;

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
import com.speedment.common.tuple.Tuple5;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.operate.QueryOperator;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePaginationResults;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplExecuteConfig;
import cn.featherfly.hammer.tpl.TplExecuteId;
import cn.featherfly.hammer.tpl.TplExecuteIdFileImpl;
import cn.featherfly.hammer.tpl.TplExecutor;
import cn.featherfly.hammer.tpl.directive.TemplateDirective;
import cn.featherfly.hammer.tpl.method.TemplateMethod;
import cn.featherfly.hammer.tpl.supports.ConditionParamsManager;
import cn.featherfly.hammer.tpl.supports.ConditionParamsManager.Param;

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

    private SqlDbTemplateEngine<TemplateDirective, TemplateMethod> templateEngine;

    /**
     * @param configFactory  configFactory
     * @param templateEngine templateEngine
     * @param jdbc           jdbc
     * @param mappingFactory mappingFactory
     */
    @SuppressWarnings("unchecked")
    public SqlTplExecutor(@Nonnull TplConfigFactory configFactory,
            @SuppressWarnings("rawtypes") @Nonnull SqlDbTemplateEngine templateEngine, @Nonnull Jdbc jdbc,
            @Nonnull JdbcMappingFactory mappingFactory) {
        super();
        this.configFactory = configFactory;
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;
        this.templateEngine = templateEngine;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute(String tplExecuteId, Map<String, Object> params) {
        return execute(new TplExecuteIdFileImpl(tplExecuteId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute(TplExecuteId tplExecuteId, Map<String, Object> params) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> queryExecution = getQueryExecution(tplExecuteId,
                params, Integer.class);
        String sql = queryExecution.get0();
        ConditionParamsManager manager = queryExecution.get2();

        if (queryExecution.get2().getParamNamed() == null || queryExecution.get2().getParamNamed()) {
            return jdbc.update(sql, getEffectiveParamMap(params, manager));
        } else {
            return jdbc.update(sql, getEffectiveParamArray(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single(String tplExecuteId, Map<String, Object> params) {
        return single(new TplExecuteIdFileImpl(tplExecuteId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single(TplExecuteId tplExecuteId, Map<String, Object> params) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(tplExecuteId, params, null);
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();

        if (tuple3.get2().getParamNamed() == null || tuple3.get2().getParamNamed()) {
            return jdbc.querySingle(sql, getEffectiveParamMap(params, manager));
        } else {
            return jdbc.querySingle(sql, getEffectiveParamArray(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return single(new TplExecuteIdFileImpl(tplExecuteId), entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(tplExecuteId, params,
                entityType);
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();

        if (tuple3.get2().getParamNamed() == null || tuple3.get2().getParamNamed()) {
            return jdbc.querySingle(sql, entityType, getEffectiveParamMap(params, manager));
        } else {
            return jdbc.querySingle(sql, entityType, getEffectiveParamArray(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(tplExecuteId, params, null);
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();

        if (tuple3.get2().getParamNamed() == null || tuple3.get2().getParamNamed()) {
            return jdbc.query(sql, getEffectiveParamMap(params, manager));
        } else {
            return jdbc.query(sql, getEffectiveParamArray(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(tplExecuteId, params,
                entityType);
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();

        if (tuple3.get2().getParamNamed() == null || tuple3.get2().getParamNamed()) {
            return jdbc.query(sql, entityType, getEffectiveParamMap(params, manager));
        } else {
            return jdbc.query(sql, entityType, getEffectiveParamArray(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, int offset, int limit) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, int offset,
            int limit) {
        return findList(tplExecuteId, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return findList(tplExecuteId, entityType, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, Page page) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
            int offset, int limit) {
        return pagination(new TplExecuteIdFileImpl(tplExecuteId), params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params,
            int offset, int limit) {
        SimplePaginationResults<Map<String, Object>> pagination = new SimplePaginationResults<>(offset, limit);
        Tuple5<List<Map<String, Object>>, String, TplExecuteConfig, ConditionParamsManager, Map<String, Object>> listTuple = findList(
                tplExecuteId, params, offset, limit);
        pagination.setPageResults(listTuple.get0());

        String countSql = null;
        ConditionParamsManager manager = null;
        TplExecuteConfig config = listTuple.get2();
        if (Lang.isEmpty(config.getCount())) {
            countSql = SqlUtils.convertSelectToCount(listTuple.get1());
            manager = listTuple.get3();
        } else {
            Tuple2<String, ConditionParamsManager> countTuple = getCountExecution(tplExecuteId, params, config, null);
            countSql = countTuple.get0();
            manager = countTuple.get1();
        }
        // 默认使用namedParameter
        if (manager.getParamNamed() == null || manager.getParamNamed()) {
            pagination.setTotal(jdbc.queryInt(countSql, getEffectiveParamMap(listTuple.get4(), manager)));
        } else {
            pagination.setTotal(jdbc.queryInt(countSql, getEffectiveParamArray(listTuple.get4(), manager)));
        }
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
            Page page) {
        return pagination(new TplExecuteIdFileImpl(tplExecuteId), params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params,
            Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            int offset, int limit) {
        return pagination(new TplExecuteIdFileImpl(tplExecuteId), entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Object> params, int offset, int limit) {
        SimplePaginationResults<E> pagination = new SimplePaginationResults<>(offset, limit);

        Tuple5<List<E>, String, TplExecuteConfig, ConditionParamsManager, Map<String, Object>> listTuple = findList(
                tplExecuteId, entityType, params, offset, limit);
        pagination.setPageResults(listTuple.get0());

        String countSql = null;
        ConditionParamsManager manager = null;
        TplExecuteConfig config = listTuple.get2();
        if (Lang.isEmpty(config.getCount())) {
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
            pagination.setTotal(jdbc.queryInt(countSql, getEffectiveParamMap(listTuple.get4(), manager)));
        } else {
            pagination.setTotal(jdbc.queryInt(countSql, getEffectiveParamArray(listTuple.get4(), manager)));
        }
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            Page page) {
        return pagination(new TplExecuteIdFileImpl(tplExecuteId), entityType, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E value(String tplExecuteId, Class<E> valueType, Map<String, Object> params) {
        return value(new TplExecuteIdFileImpl(tplExecuteId), valueType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E value(TplExecuteId tplExecuteId, Class<E> valueType, Map<String, Object> params) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(tplExecuteId, params,
                valueType);
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();

        if (tuple3.get2().getParamNamed() == null || tuple3.get2().getParamNamed()) {
            return jdbc.queryValue(sql, valueType, getEffectiveParamMap(params, manager));
        } else {
            return jdbc.queryValue(sql, valueType, getEffectiveParamArray(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue(String tplExecuteId, Map<String, Object> params) {
        return numberInt(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return numberInt(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue(String tplExecuteId, Map<String, Object> params) {
        return numberLong(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return numberLong(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue(String tplExecuteId, Map<String, Object> params) {
        return numberDouble(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return numberDouble(tplExecuteId, params);
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
    public <N extends Number> N number(TplExecuteId tplExecuteId, Class<N> numberType, Map<String, Object> params) {
        return value(tplExecuteId, numberType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer numberInt(String tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, Integer.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer numberInt(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, Integer.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long numberLong(String tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, Long.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long numberLong(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, Long.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double numberDouble(String tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, Double.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double numberDouble(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, Double.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal numberBigDecimal(String tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, BigDecimal.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal numberBigDecimal(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, BigDecimal.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string(String tplExecuteId, Map<String, Object> params) {
        return value(tplExecuteId, String.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return value(tplExecuteId, String.class, params);
    }

    private Tuple3<String, TplExecuteConfig, ConditionParamsManager> getQueryExecution(TplExecuteId tplExecuteId,
            Map<String, Object> params, Class<?> resultType) {
        TplExecuteConfig config = configFactory.getConfig(tplExecuteId);
        Tuple2<String, ConditionParamsManager> tuple2 = getExecution(tplExecuteId.getId(), config.getQuery(), params,
                resultType);
        logger.debug("tplExecuteId -> {} \nexecuteQuerySql -> {} \nqueryTemplate -> {}", tplExecuteId, tuple2.get0(),
                config.getQuery());
        return Tuples.of(tuple2.get0(), config, tuple2.get1());
    }

    //    private Tuple3<String, TplExecuteConfig, ConditionParamsManager> getQueryExecution(String tplExecuteId,
    //            Map<String, Object> params, Class<?> resultType) {
    //        TplExecuteConfig config = configFactory.getConfig(tplExecuteId);
    //        Tuple2<String, ConditionParamsManager> tuple2 = getExecution(tplExecuteId, config.getQuery(), params,
    //                resultType);
    //        Constants.LOGGER.debug("tplExecuteId -> {} \nexecuteQuerySql -> {} \nqueryTemplate -> {}", tplExecuteId,
    //                tuple2.get0(), config.getQuery());
    //        return Tuples.of(tuple2.get0(), config, tuple2.get1());
    //    }

    private Tuple2<String, ConditionParamsManager> getCountExecution(TplExecuteId tplExecuteId,
            Map<String, Object> params, TplExecuteConfig config, Class<?> resultType) {
        String templateName = tplExecuteId.getId() + TplConfigFactory.COUNT_SUFFIX;
        Tuple2<String, ConditionParamsManager> result = getExecution(templateName, config.getCount(), params,
                resultType);
        logger.debug("tplExecuteId -> {}  \nexecuteCountSql -> {}  \ncountTemplate -> {}", tplExecuteId, result.get0(),
                config.getCount());
        return result;
    }

    //    private Tuple2<String, ConditionParamsManager> getCountExecution(String tplExecuteId, Map<String, Object> params,
    //            TplExecuteConfig config, Class<?> resultType) {
    //        Tuple2<String, ConditionParamsManager> result = getExecution(tplExecuteId + TplConfigFactory.COUNT_SUFFIX,
    //                config.getCount(), params, resultType);
    //        Constants.LOGGER.debug("tplExecuteId -> {}  \nexecuteCountSql -> {}  \ncountTemplate -> {}", tplExecuteId,
    //                result.get0(), config.getCount());
    //        return result;
    //    }

    //    private Tuple2<String, ConditionParamsManager> getExecution(TplExecuteId tplExecuteId, String sql,
    //            Map<String, Object> params, Class<?> resultType) {
    //        String templateName = tplExecuteId.getId() + TplConfigFactory.COUNT_SUFFIX;
    //        logger.debug("execute template name : {}", templateName);
    //        ConditionParamsManager manager = new ConditionParamsManager();
    //        Map<String, Object> root = new HashMap<>();
    //        root.putAll(params);
    //
    //        SqlDbTemplateProcessEnv<TemplateDirective, TemplateMethod> templateProcessEnv = createTemplateProcessEnv(
    //                manager, resultType);
    //        String result = templateEngine.process(templateName, sql, params, templateProcessEnv);
    //        return Tuples.of(result, manager);
    //    }

    private Tuple2<String, ConditionParamsManager> getExecution(String templateName, String sql,
            Map<String, Object> params, Class<?> resultType) {
        logger.debug("execute template name : {}", templateName);
        ConditionParamsManager manager = new ConditionParamsManager();
        Map<String, Object> root = new HashMap<>();
        root.putAll(params);

        SqlDbTemplateProcessEnv<TemplateDirective, TemplateMethod> templateProcessEnv = createTemplateProcessEnv(
                manager, resultType);
        String result = templateEngine.process(templateName, sql, params, templateProcessEnv);
        return Tuples.of(result, manager);
    }

    private SqlDbTemplateProcessEnv<TemplateDirective, TemplateMethod> createTemplateProcessEnv(
            ConditionParamsManager manager, Class<?> resultType) {
        SqlDbTemplateProcessEnv<TemplateDirective, TemplateMethod> env = templateEngine.createTemplateProcessEnv();
        env.setConfigFactory(configFactory);
        env.setDialect(jdbc.getDialect());
        env.setManager(manager);
        env.setMappingFactory(mappingFactory);
        env.setResultType(resultType);
        return env;
    }

    private Tuple5<List<Map<String, Object>>, String, TplExecuteConfig, ConditionParamsManager, Map<String, Object>> findList(
            TplExecuteId tplExecuteId, Map<String, Object> params, int offset, int limit) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(tplExecuteId, params, null);
        List<Map<String, Object>> list = null;
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();
        // 默认使用namedParameter
        if (manager.getParamNamed() == null || manager.getParamNamed()) {
            list = jdbc.query(jdbc.getDialect().getParamNamedPaginationSql(sql, offset, limit),
                    jdbc.getDialect().getPaginationSqlParameter(getEffectiveParamMap(params, manager), offset, limit));
        } else {
            list = jdbc.query(jdbc.getDialect().getPaginationSql(sql, offset, limit), jdbc.getDialect()
                    .getPaginationSqlParameter(getEffectiveParamArray(params, tuple3.get2()), offset, limit));
        }
        return Tuples.of(list, sql, tuple3.get1(), manager, params);
    }

    private <E> Tuple5<List<E>, String, TplExecuteConfig, ConditionParamsManager, Map<String, Object>> findList(
            TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset, int limit) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(tplExecuteId, params,
                entityType);
        List<E> list = null;
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();

        // 默认使用namedParameter
        if (manager.getParamNamed() == null || manager.getParamNamed()) {
            list = jdbc.query(jdbc.getDialect().getParamNamedPaginationSql(sql, offset, limit), entityType,
                    jdbc.getDialect().getPaginationSqlParameter(getEffectiveParamMap(params, manager), offset, limit));
        } else {
            list = jdbc.query(jdbc.getDialect().getPaginationSql(sql, offset, limit), entityType, jdbc.getDialect()
                    .getPaginationSqlParameter(getEffectiveParamArray(params, manager), offset, limit));
        }
        return Tuples.of(list, sql, tuple3.get1(), manager, params);
    }

    // 如果sql中有参数没有使用条件判断，则参数会被过滤掉，（即过滤掉username参数）
    // select * from user <@where>  username = :username <@and if=password> password = :password</@and></@where>
    // 上面这种情况应该是不存在的，因为这样用本身会带来bug，如果一个查询条件不会空，也使用<@and> <@or>连接起来
    private Object[] getEffectiveParamArray(Map<String, Object> params, ConditionParamsManager manager) {
        //        return params.entrySet().stream().filter(t -> {
        //            return !manager.filterParamName(t.getKey());
        //        }).collect(Collectors.toMap(e -> {
        //            return e.getKey();
        //        }, e -> {
        //            return transvert(e.getKey(), e.getValue(), manager);
        //        })).values().toArray();

        return manager.getParamNames().stream().filter(n -> params.containsKey(n)).map(n -> {
            return transvert(n, params.get(n), manager);
            //            return params.get(n);
        }).collect(Collectors.toList()).toArray();
    }

    private Map<String, Object> getEffectiveParamMap(Map<String, Object> params, ConditionParamsManager manager) {
        //        return params.entrySet().stream().filter(t -> {
        //            return !manager.filterParamName(t.getKey());
        //        }).collect(Collectors.toMap(e -> {
        //            return e.getKey();
        //        }, e -> {
        //            return transvert(e.getKey(), e.getValue(), manager);
        //        }));

        if (manager.getAmount() == 0) {
            return params;
        } else {
            return params.entrySet().stream().filter(t -> {
                return manager.containsName(t.getKey());
            }).collect(Collectors.toMap(e -> {
                return e.getKey();
            }, e -> {
                return transvert(e.getKey(), e.getValue(), manager);
            }));
        }
    }

    private Object transvert(String name, Object value, ConditionParamsManager manager) {
        if (value == null) {
            return value;
        }
        Param p = manager.getParam(name);
        if (p != null && Lang.isNotEmpty(p.getTransverter())) {
            // TODO 这里后续需要使用TransverterManager来处理，这样就可以用户自定义处理器了
            if (QueryOperator.CO.name().equals(p.getTransverter())) {
                return "%" + value + "%";
            } else if (QueryOperator.SW.name().equals(p.getTransverter())) {
                return value + "%";
            } else if (QueryOperator.EW.name().equals(p.getTransverter())) {
                return "%" + value;
            } else {
                throw new SqldbHammerException("no implemention for " + p.getTransverter());
            }
        }
        return value;
    }
}
