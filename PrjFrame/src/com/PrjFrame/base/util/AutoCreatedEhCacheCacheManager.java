package com.PrjFrame.base.util;

import net.sf.ehcache.Ehcache;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;

/**
 * 找不到对应的cache名时，默认创建一个该名字的ehCache并返回
 */
public class AutoCreatedEhCacheCacheManager extends EhCacheCacheManager {

    @Override
    public Cache getCache(String name) {
        Cache cache = super.getCache(name);
        if (cache == null) {
            // check the EhCache cache again
            // (in case the cache was added at runtime)
            getCacheManager().addCache(name);
            Ehcache ehcache = getCacheManager().getCache(name);
            if (ehcache != null) {
                cache = new EhCacheCache(ehcache);
                addCache(cache);
            }
        }
        return cache;
    }
}
