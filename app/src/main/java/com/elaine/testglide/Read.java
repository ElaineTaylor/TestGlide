package com.elaine.testglide;

public class Read {
    /**
     * 缓存Key
     */
    /**
     * 1.Engine 类
     */
//    public <R> LoadStatus load(
//            GlideContext glideContext,
//            Object model,
//            Key signature,
//            int width,
//            int height,
//            Class<?> resourceClass,
//            Class<R> transcodeClass,
//            Priority priority,
//            DiskCacheStrategy diskCacheStrategy,
//            Map<Class<?>, Transformation<?>> transformations,
//            boolean isTransformationRequired,
//            boolean isScaleOnlyOrNoTransform,
//            Options options,
//            boolean isMemoryCacheable,
//            boolean useUnlimitedSourceExecutorPool,
//            boolean useAnimationPool,
//            boolean onlyRetrieveFromCache,
//            ResourceCallback cb,
//            Executor callbackExecutor) {
//        // 构建缓存 Key
//        EngineKey key =
//                keyFactory.buildKey(
//                        model,
//                        signature,
//                        width,
//                        height,
//                        transformations,
//                        resourceClass,
//                        transcodeClass,
//                        options);
//
//    }

    /**
     * 2.EngineKeyFactory
     * */
//    EngineKey buildKey(
//            Object model,
//            Key signature,
//            int width,
//            int height,
//            Map<Class<?>, Transformation<?>> transformations,
//            Class<?> resourceClass,
//            Class<?> transcodeClass,
//            Options options) {
//        return new EngineKey(
//                model, signature, width, height, transformations, resourceClass, transcodeClass, options);
//    }

    /**
     * 3.EngineKey   即缓存的Key
     * 通过重写 equals() 与 hashCode() 方法来保证缓存 Key 的唯一性。
     */
//    class EngineKey implements Key {
//
//        @Override
//        public boolean equals(Object o) {
//            if (o instanceof EngineKey) {
//                EngineKey other = (EngineKey) o;
//                return model.equals(other.model)
//                        && signature.equals(other.signature)
//                        && height == other.height
//                        && width == other.width
//                        && transformations.equals(other.transformations)
//                        && resourceClass.equals(other.resourceClass)
//                        && transcodeClass.equals(other.transcodeClass)
//                        && options.equals(other.options);
//            }
//            return false;
//        }
//
//        @Override
//        public int hashCode() {
//            if (hashCode == 0) {
//                hashCode = model.hashCode();
//                hashCode = 31 * hashCode + signature.hashCode();
//                hashCode = 31 * hashCode + width;
//                hashCode = 31 * hashCode + height;
//                hashCode = 31 * hashCode + transformations.hashCode();
//                hashCode = 31 * hashCode + resourceClass.hashCode();
//                hashCode = 31 * hashCode + transcodeClass.hashCode();
//                hashCode = 31 * hashCode + options.hashCode();
//            }
//            return hashCode;
//        }
//
//    }


    /**
     * 内存缓存
     * 1.活动资源 (Active Resources)：正在使用的图片
     * 2.内存缓存 (Memory cache)：内存缓存中的图片
     */
    /**
     * 1.Engine类
     */
    /*Engine*/
//    public <R> LoadStatus load(...) {
//
//        // 构建缓存 Key
//        EngineKey key =
//                keyFactory.buildKey(
//                        model,
//                        signature,
//                        width,
//                        height,
//                        transformations,
//                        resourceClass,
//                        transcodeClass,
//                        options);
//
//        EngineResource<?> memoryResource;
//        synchronized (this) {
//            // 从内存中加载缓存数据
//            memoryResource = loadFromMemory(key, isMemoryCacheable, startTime);
//
//        }
//
//        // 加载完成回调
//        cb.onResourceReady(memoryResource, DataSource.MEMORY_CACHE);
//        return null;
//    }

    /**
     * 2.Engine
     */
//    private EngineResource<?> loadFromMemory(
//            EngineKey key, boolean isMemoryCacheable, long startTime) {
//        if (!isMemoryCacheable) {
//            return null;
//        }
//
//        //（1）从 ActiveResources 中加载缓存数据。 采用一个弱引用的 HashMap 来缓存活动资源
//        EngineResource<?> active = loadFromActiveResources(key);
//        if (active != null) {
//            if (VERBOSE_IS_LOGGABLE) {
//                logWithTimeAndKey("Loaded resource from active resources", startTime, key);
//            }
//            return active;
//        }
//
//        //（2）从内存缓存中加载缓存数据。
//        EngineResource<?> cached = loadFromCache(key);
//        if (cached != null) {
//            if (VERBOSE_IS_LOGGABLE) {
//                logWithTimeAndKey("Loaded resource from cache", startTime, key);
//            }
//            return cached;
//        }
//
//        return null;
//    }


    /**
     * （1）.1活动资源 (Active Resources)  Engine类
     */
//    private EngineResource<?> loadFromActiveResources(Key key) {
//        EngineResource<?> active = activeResources.get(key);
//        if (active != null) {
    /**
     * 如果活动资源不为空，则次数+1，用来记录图片被引用的次数
     */
//            active.acquire();
//        }
//
//        return active;
//    }


    /**
     * （1）.2活动资源 (Active Resources)  ActiveResources类
     *   获取活动资源
     */
//    synchronized EngineResource<?> get(Key key) {
//        // 从 HashMap 中获取 ResourceWeakReference
//        ResourceWeakReference activeRef = activeEngineResources.get(key);
//        if (activeRef == null) {
//            return null;
//        }
//
//        // 从弱引用中获取活动资源
//        EngineResource<?> active = activeRef.get();
//        if (active == null) {
//            cleanupActiveReference(activeRef);
//        }
//        return active;
//    }


    /**
     * （1）.3活动资源 (Active Resources) EngineResource类
     *  将 acquired 变量 +1，这个变量用来记录图片被引用的次数
     */
//    synchronized void acquire() {
//        if (isRecycled) {
//            throw new IllegalStateException("Cannot acquire a recycled resource");
//        }
//        ++acquired;
//    }


    /**
     * （1）.4活动资源 (Active Resources) EngineResource类
     *  release() 方法中做了 -1 的操作
     */
//    void release() {
//        boolean release = false;
//        synchronized (this) {
//            if (acquired <= 0) {
//                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
//            }
//            if (--acquired == 0) {
//                release = true;
//            }
//        }
    /**
     * 如果活动资源回收了，则将活动资源存储到内存中
     */
//        if (release) {
//            listener.onResourceReleased(key, this);
//        }
//    }


    /**
     * （1）.5活动资源 (Active Resources) Engine类
     */
//    @Override
//    public void onResourceReleased(Key cacheKey, EngineResource<?> resource) {
    /**
     * 根据Key从活动资源移除
     */
//        activeResources.deactivate(cacheKey);
//        if (resource.isMemoryCacheable()) {
    /**
     * 将活动资源存储到缓存中 //TODO 缓存到了内存里面
     */
//            cache.put(cacheKey, resource);
//        } else {
//            resourceRecycler.recycle(resource, /*forceNextFrame=*/ false);
//        }
//    }


    /**
     * * （1）.6活动资源 (Active Resources) ActiveResources
     */
//    synchronized void deactivate(Key key) {
//        ResourceWeakReference removed = activeEngineResources.remove(key);
//        if (removed != null) {
//            removed.reset();
//        }
//    }

    /**
     * TODO 小结
     *
     * 活动资源的流程：
     *
     * 从活动资源中找，如有则计数+1，释放资源的时候计数-1，若计数为0则缓存到内存中，同时在活动资源中删除。
     */


    /**
     * （2）.1 内存缓存 (Memory cache) Engine类
     */
//    private EngineResource<?> loadFromCache(Key key) {
    /**
     *  获取内存缓存
     */
//        EngineResource<?> cached = getEngineResourceFromCache(key);
//        if (cached != null) {
    /**
     * 计数+1，用来记录图片被引用的次数。
     */
//            cached.acquire();
    /**
     * 将内存中获取的缓存数据缓存到弱引用的 HashMap 中。
     */
//            activeResources.activate(key, cached);
//        }
//        return cached;
//    }

    /**
     * （2）.2 内存缓存 (Memory cache) Engine类
     */
//    private EngineResource<?> getEngineResourceFromCache(Key key) {
    /**
     * remove() 操作就是移除缓存的同时获取该缓存（获取内存缓存）
     */
//        Resource<?> cached = cache.remove(key);
//
//        final EngineResource<?> result;
//        if (cached == null) {
//            result = null;
//        } else if (cached instanceof EngineResource) {
//            // Save an object allocation if we've cached an EngineResource (the typical case).
//            result = (EngineResource<?>) cached;
//        } else {
//            result =
//                    new EngineResource<>(
//                            cached, /*isMemoryCacheable=*/ true, /*isRecyclable=*/ true, key, /*listener=*/ this);
//        }
//        return result;
//    }

    /**
     * TODO 小结
     * 内存缓存的流程：
     * 根据Key从内存中删除的同时找出来，然后记录引用次数+1，然后将内存中获取的缓存数据缓存到弱引用的 HashMap 中。
     *
     */

    /**
     * TODO  内存缓存中的疑问：
     * 1.活动资源的内容哪里来的？其实就是我们从网络请求中返回的数据。
     * 2.为啥要用一个弱引用的HashMap？
     *          1.提高访问效率。HashMap 的访问速度是要比 LinkedHashMap 快;
     *          2.防止内存泄漏.
     *              强引用： 直接的对象引用。
     *              软引用： 当一个对象只有软引用存在时，系统内存不足时此对象会被 gc 回收。
     *              弱引用： 当一个对象只有弱引用存在时, 此对象会随时被 gc 回收。
     */


    /**
     *  磁盘缓存
     */

}
