
package cn.featherfly.juorm.rdb.tpl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePagination;
import cn.featherfly.juorm.rdb.Constants;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.JuormJdbcException;
import cn.featherfly.juorm.rdb.jdbc.mapping.MappingFactory;
import cn.featherfly.juorm.rdb.tpl.freemarker.AndTemplateDirectiveModel;
import cn.featherfly.juorm.rdb.tpl.freemarker.ConditionParamsManager;
import cn.featherfly.juorm.rdb.tpl.freemarker.OrTemplateDirectiveModel;
import cn.featherfly.juorm.rdb.tpl.freemarker.PropertiesMappingDirectiveModel;
import cn.featherfly.juorm.rdb.tpl.freemarker.WhereTemplateDirectiveModel;
import cn.featherfly.juorm.tpl.TplConfigFactory;
import cn.featherfly.juorm.tpl.TplExecuteConfig;
import cn.featherfly.juorm.tpl.TplExecutor;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * <p>
 * Config
 * </p>
 *
 * @author zhongj
 */
public class SqlTplExecutor implements TplExecutor {

    private TplConfigFactory configFactory;

    private Configuration cfg;

    private Jdbc jdbc;

    private MappingFactory mappingFactory;

    /**
     * @param configFactory
     */
    public SqlTplExecutor(@Nonnull TplConfigFactory configFactory, @Nonnull Jdbc jdbc,
            @Nonnull MappingFactory mappingFactory) {
        super();
        this.configFactory = configFactory;
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;

        cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setTemplateLoader(new StringTemplateLoader());
        cfg.setDefaultEncoding("UTF-8");

        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    private Tuple3<String, TplExecuteConfig, ConditionParamsManager> getQueryExecution(String sqlFullId,
            Map<String, Object> params, Class<?> resultType) {
        TplExecuteConfig config = configFactory.getConfig(sqlFullId);
        Tuple2<String, ConditionParamsManager> tuple2 = getExecution(sqlFullId, config.getQuery(), params, resultType);
        Constants.LOGGER.debug("sqlFullId -> {} \nexecuteQuerySql -> {} \nqueryTemplate -> {}", sqlFullId,
                tuple2.get0(), config.getQuery());
        return Tuples.of(tuple2.get0(), config, tuple2.get1());
    }

    private Tuple2<String, ConditionParamsManager> getCountExecution(String sqlFullId, Map<String, Object> params,
            TplExecuteConfig config, Class<?> resultType) {
        Tuple2<String, ConditionParamsManager> result = getExecution(sqlFullId, config.getCount(), params, resultType);
        Constants.LOGGER.debug("sqlFullId -> {}  \nexecuteCountSql -> {}  \ncountTemplate -> {}", sqlFullId,
                result.get0(), config.getCount());
        return result;
    }

    private Tuple2<String, ConditionParamsManager> getExecution(String templateName, String sql,
            Map<String, Object> params, Class<?> resultType) {
        // TODO 把sqlid配置加入template include， 到时候进行include操作
        ConditionParamsManager manager = new ConditionParamsManager();
        Map<String, Object> root = new HashMap<>();
        root.putAll(params);
        root.put("where", new WhereTemplateDirectiveModel());
        root.put("and", new AndTemplateDirectiveModel(manager));
        root.put("or", new OrTemplateDirectiveModel(manager));
        root.put("columns", new PropertiesMappingDirectiveModel(mappingFactory, resultType));
        root.put("properties", new PropertiesMappingDirectiveModel("repository", mappingFactory, resultType));
        root.put("prop", new PropertiesMappingDirectiveModel("repo", mappingFactory, resultType));
        try {
            StringWriter stringWriter = new StringWriter();
            Template template = new Template(templateName, sql, cfg);
            template.process(root, stringWriter);
            String result = stringWriter.toString();
            return Tuples.of(result, manager);
            //            return new SimpleExecution(stringWriter.toString(), manager.getParamValues().toArray());
        } catch (IOException | TemplateException e) {
            throw new JuormJdbcException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(String sqlFullId, Class<E> entityType, Map<String, Object> params) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(sqlFullId, params,
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
    public <E> List<E> list(String sqlFullId, Class<E> entityType, Map<String, Object> params) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(sqlFullId, params,
                entityType);
        if (tuple3.get2().getParamNamed() == null || tuple3.get2().getParamNamed()) {
            return jdbc.queryList(tuple3.get0(), getEffectiveParams(params, tuple3.get2()), entityType);
        } else {
            return jdbc.queryList(tuple3.get0(), tuple3.get2().getParamNames().toArray(), entityType);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String sqlFullId, Class<E> entityType, Map<String, Object> params, int offset, int limit) {
        return findList(sqlFullId, entityType, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String sqlFullId, Class<E> entityType, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(sqlFullId, entityType, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(String sqlFullId, Class<E> entityType, Map<String, Object> params,
            int offset, int limit) {
        SimplePagination<E> pagination = new SimplePagination<>(offset, limit);

        Tuple4<List<E>, String, TplExecuteConfig, ConditionParamsManager> listTuple = findList(sqlFullId, entityType,
                params, offset, limit);
        pagination.setPageResults(listTuple.get0());

        String countSql = null;
        ConditionParamsManager manager = null;
        TplExecuteConfig config = listTuple.get2();
        if (LangUtils.isEmpty(config.getCount())) {
            countSql = SqlUtils.convertSelectToCount(listTuple.get1());
            manager = listTuple.get3();
        } else {
            Tuple2<String, ConditionParamsManager> countTuple = getCountExecution(sqlFullId, params, config,
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
    public <E> PaginationResults<E> pagination(String sqlFullId, Class<E> entityType, Map<String, Object> params,
            Page page) {
        Limit limit = new Limit(page);
        return pagination(sqlFullId, entityType, params, limit.getOffset(), limit.getLimit());
    }

    private <E> Tuple4<List<E>, String, TplExecuteConfig, ConditionParamsManager> findList(String sqlFullId,
            Class<E> entityType, Map<String, Object> params, int offset, int limit) {
        Tuple3<String, TplExecuteConfig, ConditionParamsManager> tuple3 = getQueryExecution(sqlFullId, params,
                entityType);
        List<E> list = null;
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();
        // 默认使用namedParameter
        if (manager.getParamNamed() == null || manager.getParamNamed()) {
            list = jdbc.queryList(jdbc.getDialect().getParamNamedPaginationSql(sql, offset, limit),
                    jdbc.getDialect().getPaginationSqlParameter(getEffectiveParams(params, manager), offset, limit),
                    entityType);
        } else {
            list = jdbc.queryList(jdbc.getDialect().getPaginationSql(sql, offset, limit),
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

}
