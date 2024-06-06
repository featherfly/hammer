
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-06-05 19:16:05
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.integration.CompletionListener;
import javax.cache.processor.EntryProcessor;
import javax.cache.processor.EntryProcessorException;
import javax.cache.processor.EntryProcessorResult;
import javax.cache.spi.CachingProvider;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.config.cache.CacheConfigImpl;
import cn.featherfly.hammer.config.cache.QueryPageResult;
import cn.featherfly.hammer.sqldb.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.SimpleSqlPageFactory;
import cn.featherfly.hammer.sqldb.tpl.SqlTplExecutor;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.TplExecutor;
import cn.featherfly.hammer.tpl.TransverterManager;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerTemplatePreProcessor;

/**
 * AbstractQueryCacheTest.
 *
 * @author zhongj
 */
public abstract class AbstractQueryCacheTest extends JdbcTestBase {

    static SqlQuery query;

    static TplExecutor executor;

    static CacheManager cacheManager;

    static TplConfigFactory configFactory2;

    static CacheProxy<Object, QueryPageResult> queryPageResultCache;

    int age0 = 0;

    int age1 = 1;

    @BeforeSuite
    void setup() {
        CachingProvider cachingProvider = Caching
            .getCachingProvider("com.github.benmanes.caffeine.jcache.spi.CaffeineCachingProvider");
        cacheManager = cachingProvider.getCacheManager();
        MutableConfiguration<Object,
            QueryPageResult> mutableConfiguration = new MutableConfiguration<Object, QueryPageResult>()
                .setTypes(Object.class, QueryPageResult.class) //
                .setStoreByValue(false) //
                .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(TimeUnit.MINUTES, 30)));
        Cache<Object,
            QueryPageResult> countResultCache = cacheManager.createCache("countResultCache", mutableConfiguration);

        queryPageResultCache = new CacheProxy<>(countResultCache);

        // set cache
        HammerConfig hammerConfig = new HammerConfigImpl(true)
            .setCacheConfig(new CacheConfigImpl().setQueryPageResultCache(queryPageResultCache));

        configFactory2 = TplConfigFactoryImpl.builder() //
            .prefixes("tpl_pre/", "tpl_pre2/").suffixes(".yaml.sql", ".yaml.tpl")
            .config(hammerConfig.getTemplateConfig())
            .preCompile(new FreemarkerTemplatePreProcessor(hammerConfig.getTemplateConfig())).build();

        executor = new SqlTplExecutor(hammerConfig, configFactory2,
            new SqldbFreemarkerTemplateEngine(configFactory2, hammerConfig.getTemplateConfig()), jdbc, mappingFactory,
            new SimpleSqlPageFactory(), new TransverterManager());

        query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory, hammerConfig);
    }

    @AfterSuite
    void finish() {
        cacheManager.close();
    }

    @BeforeClass
    void before() {

    }

    @BeforeMethod
    void bm() {
        queryPageResultCache.clear();
        queryPageResultCache.reset();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
    }

    public abstract void queryPagination_CountCache();

    public abstract void queryPagination_CountCache_PageListCache();

    public abstract void queryPagination_CountCache_OptimizationPage();

    public abstract void queryPagination_CountCache_OptimizationPage_PageNumber_Gt_MaxPageNumber();

    public abstract void queryPagination_CountCache_OptimizationPage_Find_Empty();

    public abstract void queryPagination_CountCache_PageListCache_OptimizationPage();

    public abstract void queryPagination();

    public abstract void queryList_OptimizationPage();

    public abstract void queryList_PageListCache();

    public abstract void queryList_PageListCache_OptimizationPage();

    public abstract void queryList_OptimizationPage_PageNumber_Gt_MaxPageNumber();

    public abstract void queryList_OptimizationPage_Find_Empty();

}

class CacheProxy<K, V> implements Cache<K, V> {

    private final Cache<K, V> proxy;

    private int index;

    private V last;

    /**
     * @param proxy
     */
    public CacheProxy(Cache<K, V> proxy) {
        super();
        this.proxy = proxy;
    }

    public void reset() {
        index = 0;
        last = null;
    }

    /**
     * get last value
     *
     * @return last
     */
    public V getLast() {
        return last;
    }

    @Override
    public void forEach(Consumer<? super Entry<K, V>> action) {
        proxy.forEach(action);
    }

    @Override
    public Spliterator<Entry<K, V>> spliterator() {
        return proxy.spliterator();
    }

    @Override
    public V get(K key) {
        V v = proxy.get(key);
        if (v != null) {
            index++;
        } else {
            index = 0;
        }
        last = v;
        return v;
    }

    /**
     * @param keys
     * @return
     * @see javax.cache.Cache#getAll(java.util.Set)
     */
    @Override
    public Map<K, V> getAll(Set<? extends K> keys) {
        return proxy.getAll(keys);
    }

    /**
     * @param key
     * @return
     * @see javax.cache.Cache#containsKey(java.lang.Object)
     */
    @Override
    public boolean containsKey(K key) {
        return proxy.containsKey(key);
    }

    /**
     * @param keys
     * @param replaceExistingValues
     * @param completionListener
     * @see javax.cache.Cache#loadAll(java.util.Set, boolean,
     *      javax.cache.integration.CompletionListener)
     */
    @Override
    public void loadAll(Set<? extends K> keys, boolean replaceExistingValues, CompletionListener completionListener) {
        proxy.loadAll(keys, replaceExistingValues, completionListener);
    }

    @Override
    public void put(K key, V value) {
        proxy.put(key, value);
    }

    @Override
    public V getAndPut(K key, V value) {
        return proxy.getAndPut(key, value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        proxy.putAll(map);
    }

    @Override
    public boolean putIfAbsent(K key, V value) {
        return proxy.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(K key) {
        return proxy.remove(key);
    }

    @Override
    public boolean remove(K key, V oldValue) {
        return proxy.remove(key, oldValue);
    }

    @Override
    public V getAndRemove(K key) {
        return proxy.getAndRemove(key);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return proxy.replace(key, oldValue, newValue);
    }

    @Override
    public boolean replace(K key, V value) {
        return proxy.replace(key, value);
    }

    @Override
    public V getAndReplace(K key, V value) {
        return proxy.getAndReplace(key, value);
    }

    @Override
    public void removeAll(Set<? extends K> keys) {
        proxy.removeAll(keys);
    }

    @Override
    public void removeAll() {
        proxy.removeAll();
    }

    @Override
    public void clear() {
        proxy.clear();
    }

    @Override
    public <C extends Configuration<K, V>> C getConfiguration(Class<C> clazz) {
        return proxy.getConfiguration(clazz);
    }

    @Override
    public <T> T invoke(K key, EntryProcessor<K, V, T> entryProcessor, Object... arguments)
        throws EntryProcessorException {
        return proxy.invoke(key, entryProcessor, arguments);
    }

    @Override
    public <T> Map<K, EntryProcessorResult<T>> invokeAll(Set<? extends K> keys, EntryProcessor<K, V, T> entryProcessor,
        Object... arguments) {
        return proxy.invokeAll(keys, entryProcessor, arguments);
    }

    @Override
    public String getName() {
        return proxy.getName();
    }

    /**
     * @return
     * @see javax.cache.Cache#getCacheManager()
     */
    @Override
    public CacheManager getCacheManager() {
        return proxy.getCacheManager();
    }

    @Override
    public void close() {
        proxy.close();
    }

    @Override
    public boolean isClosed() {
        return proxy.isClosed();
    }

    @Override
    public <T> T unwrap(Class<T> clazz) {
        return proxy.unwrap(clazz);
    }

    @Override
    public void registerCacheEntryListener(CacheEntryListenerConfiguration<K, V> cacheEntryListenerConfiguration) {
        proxy.registerCacheEntryListener(cacheEntryListenerConfiguration);
    }

    @Override
    public void deregisterCacheEntryListener(CacheEntryListenerConfiguration<K, V> cacheEntryListenerConfiguration) {
        proxy.deregisterCacheEntryListener(cacheEntryListenerConfiguration);
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return proxy.iterator();
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