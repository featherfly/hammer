
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-29 02:42:29
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.repository.Params;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePage;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.config.cache.CacheConfigImpl;
import cn.featherfly.hammer.sqldb.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.SimpleSqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.User2;
import cn.featherfly.hammer.sqldb.tpl.SqlTplExecutor;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.TplExecutor;
import cn.featherfly.hammer.tpl.TransverterManager;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerTemplatePreProcessor;

/**
 * QueryPaginationCacheTest.
 *
 * @author zhongj
 */

public class QueryCacheTest extends JdbcTestBase {

    SqlQuery query;

    CacheManager cacheManager;

    CacheProxy<Object, Integer> countResultCache;

    protected TplExecutor executor;

    @BeforeClass
    void setup() {
        CachingProvider cachingProvider = Caching
            .getCachingProvider("com.github.benmanes.caffeine.jcache.spi.CaffeineCachingProvider");
        cacheManager = cachingProvider.getCacheManager();
        MutableConfiguration<Object,
            Integer> mutableConfiguration = new MutableConfiguration<Object, Integer>()
                .setTypes(Object.class, Integer.class) //
                .setStoreByValue(false) //
                .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(TimeUnit.MINUTES, 30)));
        Cache<Object, Integer> countResultCache = cacheManager.createCache("countResultCache", mutableConfiguration);

        this.countResultCache = new CacheProxy<>(countResultCache);

        // set cache
        ((HammerConfigImpl) hammerConfig)
            .setCacheConfig(new CacheConfigImpl().setCountResultCache(this.countResultCache));

        query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory, hammerConfig);

        TplConfigFactoryImpl configFactory = TplConfigFactoryImpl.builder() //
            .prefixes("tpl_pre/", "tpl_pre2/").suffixes(".yaml.sql", ".yaml.tpl")
            .config(hammerConfig.getTemplateConfig())
            .preCompile(new FreemarkerTemplatePreProcessor(hammerConfig.getTemplateConfig())).build();

        executor = new SqlTplExecutor(hammerConfig, configFactory,
            new SqldbFreemarkerTemplateEngine(configFactory, hammerConfig.getTemplateConfig()), jdbc, mappingFactory,
            new SimpleSqlPageFactory(), new TransverterManager());

    }

    @AfterClass
    void after() {
        cacheManager.close();
    }

    @Test
    public void entityQueryPaginationCountCache() {
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        PaginationResults<User2> results = null;

        results = query.find(User2.class).where().gt(User2::getAge, 0).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(countResultCache.getIndex() == 0);

        page.setNumber(2);
        results = query.find(User2.class).where().gt(User2::getAge, 0).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(countResultCache.getIndex() == 1);

        page.setNumber(3);
        results = query.find(User2.class).where().gt(User2::getAge, 0).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(countResultCache.getIndex() == 2);

        page.setNumber(4);
        results = query.find(User2.class).where().gt(User2::getAge, 0).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(countResultCache.getIndex() == 3);

        // ----------------------------------------------------------------------------------------------------------------

        page.setNumber(1);
        results = query.find(User2.class).where().gt(User2::getAge, 5).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(countResultCache.getIndex() == 0);

        page.setNumber(2);
        results = query.find(User2.class).where().gt(User2::getAge, 5).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(countResultCache.getIndex() == 1);

    }

    @Test
    public void repositoryQueryPaginationCountCache() {
        // NOIMPL 后续来实现
        throw new NotImplementedException();
    }

    @Test
    public void tplQueryPaginationCountCache() {
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        PaginationResults<User2> results = null;

        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 0), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(countResultCache.getIndex() == 0);

        page.setNumber(2);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 0), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(countResultCache.getIndex() == 1);

        page.setNumber(3);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 0), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(countResultCache.getIndex() == 2);

        page.setNumber(4);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 0), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(countResultCache.getIndex() == 3);

        // ----------------------------------------------------------------------------------------------------------------

        page.setNumber(1);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 5), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(countResultCache.getIndex() == 0);

        page.setNumber(2);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 5), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(countResultCache.getIndex() == 1);

    }
}

class CacheProxy<K, V> implements Cache<K, V> {

    private final Cache<K, V> proxy;

    private int index;

    /**
     * @param proxy
     */
    public CacheProxy(Cache<K, V> proxy) {
        super();
        this.proxy = proxy;
    }

    /**
     * @param action
     * @see java.lang.Iterable#forEach(java.util.function.Consumer)
     */
    @Override
    public void forEach(Consumer<? super Entry<K, V>> action) {
        proxy.forEach(action);
    }

    /**
     * @return
     * @see java.lang.Iterable#spliterator()
     */
    @Override
    public Spliterator<Entry<K, V>> spliterator() {
        return proxy.spliterator();
    }

    /**
     * @param key
     * @return
     * @see javax.cache.Cache#get(java.lang.Object)
     */
    @Override
    public V get(K key) {
        V v = proxy.get(key);
        if (v != null) {
            index++;
        } else {
            index = 0;
        }
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

    /**
     * @param key
     * @param value
     * @see javax.cache.Cache#put(java.lang.Object, java.lang.Object)
     */
    @Override
    public void put(K key, V value) {
        proxy.put(key, value);
    }

    /**
     * @param key
     * @param value
     * @return
     * @see javax.cache.Cache#getAndPut(java.lang.Object, java.lang.Object)
     */
    @Override
    public V getAndPut(K key, V value) {
        return proxy.getAndPut(key, value);
    }

    /**
     * @param map
     * @see javax.cache.Cache#putAll(java.util.Map)
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        proxy.putAll(map);
    }

    /**
     * @param key
     * @param value
     * @return
     * @see javax.cache.Cache#putIfAbsent(java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean putIfAbsent(K key, V value) {
        return proxy.putIfAbsent(key, value);
    }

    /**
     * @param key
     * @return
     * @see javax.cache.Cache#remove(java.lang.Object)
     */
    @Override
    public boolean remove(K key) {
        return proxy.remove(key);
    }

    /**
     * @param key
     * @param oldValue
     * @return
     * @see javax.cache.Cache#remove(java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean remove(K key, V oldValue) {
        return proxy.remove(key, oldValue);
    }

    /**
     * @param key
     * @return
     * @see javax.cache.Cache#getAndRemove(java.lang.Object)
     */
    @Override
    public V getAndRemove(K key) {
        return proxy.getAndRemove(key);
    }

    /**
     * @param key
     * @param oldValue
     * @param newValue
     * @return
     * @see javax.cache.Cache#replace(java.lang.Object, java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return proxy.replace(key, oldValue, newValue);
    }

    /**
     * @param key
     * @param value
     * @return
     * @see javax.cache.Cache#replace(java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean replace(K key, V value) {
        return proxy.replace(key, value);
    }

    /**
     * @param key
     * @param value
     * @return
     * @see javax.cache.Cache#getAndReplace(java.lang.Object, java.lang.Object)
     */
    @Override
    public V getAndReplace(K key, V value) {
        return proxy.getAndReplace(key, value);
    }

    /**
     * @param keys
     * @see javax.cache.Cache#removeAll(java.util.Set)
     */
    @Override
    public void removeAll(Set<? extends K> keys) {
        proxy.removeAll(keys);
    }

    /**
     * @see javax.cache.Cache#removeAll()
     */
    @Override
    public void removeAll() {
        proxy.removeAll();
    }

    /**
     * @see javax.cache.Cache#clear()
     */
    @Override
    public void clear() {
        proxy.clear();
    }

    /**
     * @param <C>
     * @param clazz
     * @return
     * @see javax.cache.Cache#getConfiguration(java.lang.Class)
     */
    @Override
    public <C extends Configuration<K, V>> C getConfiguration(Class<C> clazz) {
        return proxy.getConfiguration(clazz);
    }

    /**
     * @param <T>
     * @param key
     * @param entryProcessor
     * @param arguments
     * @return
     * @throws EntryProcessorException
     * @see javax.cache.Cache#invoke(java.lang.Object, javax.cache.processor.EntryProcessor,
     *      java.lang.Object[])
     */
    @Override
    public <T> T invoke(K key, EntryProcessor<K, V, T> entryProcessor, Object... arguments)
        throws EntryProcessorException {
        return proxy.invoke(key, entryProcessor, arguments);
    }

    /**
     * @param <T>
     * @param keys
     * @param entryProcessor
     * @param arguments
     * @return
     * @see javax.cache.Cache#invokeAll(java.util.Set, javax.cache.processor.EntryProcessor,
     *      java.lang.Object[])
     */
    @Override
    public <T> Map<K, EntryProcessorResult<T>> invokeAll(Set<? extends K> keys, EntryProcessor<K, V, T> entryProcessor,
        Object... arguments) {
        return proxy.invokeAll(keys, entryProcessor, arguments);
    }

    /**
     * @return
     * @see javax.cache.Cache#getName()
     */
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

    /**
     * @see javax.cache.Cache#close()
     */
    @Override
    public void close() {
        proxy.close();
    }

    /**
     * @return
     * @see javax.cache.Cache#isClosed()
     */
    @Override
    public boolean isClosed() {
        return proxy.isClosed();
    }

    /**
     * @param <T>
     * @param clazz
     * @return
     * @see javax.cache.Cache#unwrap(java.lang.Class)
     */
    @Override
    public <T> T unwrap(Class<T> clazz) {
        return proxy.unwrap(clazz);
    }

    /**
     * @param cacheEntryListenerConfiguration
     * @see javax.cache.Cache#registerCacheEntryListener(javax.cache.configuration.CacheEntryListenerConfiguration)
     */
    @Override
    public void registerCacheEntryListener(CacheEntryListenerConfiguration<K, V> cacheEntryListenerConfiguration) {
        proxy.registerCacheEntryListener(cacheEntryListenerConfiguration);
    }

    /**
     * @param cacheEntryListenerConfiguration
     * @see javax.cache.Cache#deregisterCacheEntryListener(javax.cache.configuration.CacheEntryListenerConfiguration)
     */
    @Override
    public void deregisterCacheEntryListener(CacheEntryListenerConfiguration<K, V> cacheEntryListenerConfiguration) {
        proxy.deregisterCacheEntryListener(cacheEntryListenerConfiguration);
    }

    /**
     * @return
     * @see javax.cache.Cache#iterator()
     */
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
