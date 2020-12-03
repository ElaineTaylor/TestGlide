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
     *  (1) 资源类型（Resource）：磁盘缓存中转换过后的图片
     *  (2) 数据来源 (Data)：磁盘缓存中的原始图片
     *
     * ALL：既缓存原始图片，也缓存转换过后的图片。
     * NONE：不缓存任何内容。
     * DATA：只缓存原始图片。
     * RESOURCE：只缓存转换过后的图片。
     * AUTOMATIC：默认策略，它会尝试对本地和远程图片使用最佳的策略。如果是远程图片，则只缓存原始图片；如果是本地图片，那么只缓存转换过后的图片。
     *
     */

    /**
     * (1）.1 资源类型（Resource）  DecodeJob类
     */
    //从主线程切换到子线程去执行请求的时候用到了磁盘缓存策略,
    // 根据缓存策略获取到资源状态，然后再根据资源状态获取资源执行器,
    // 最后调用 runGenerators() 方法
//    private void runWrapped() {
//        switch (runReason) {
//            case INITIALIZE:
    /**
     *  1. 获取资源状态
     */
//                stage = getNextStage(Stage.INITIALIZE);
    /**
     *  2. 根据资源状态获取资源执行器
     */

//                currentGenerator = getNextGenerator();
    /**
     * 3. 执行
     */
//                runGenerators();
//                break;
//            case SWITCH_TO_SOURCE_SERVICE:
//                runGenerators();
//                break;
//            case DECODE_DATA:
//                decodeFromRetrievedData();
//                break;
//            default:
//                throw new IllegalStateException("Unrecognized run reason: " + runReason);
//        }
//    }
//
//    private Stage getNextStage(Stage current) {
//        switch (current) {
//            case INITIALIZE:
//                return diskCacheStrategy.decodeCachedResource()
//                        ? Stage.RESOURCE_CACHE
//                        : getNextStage(Stage.RESOURCE_CACHE);
//            case RESOURCE_CACHE:
//                return diskCacheStrategy.decodeCachedData()
//                        ? Stage.DATA_CACHE
//                        : getNextStage(Stage.DATA_CACHE);
//            case DATA_CACHE:
//                // Skip loading from source if the user opted to only retrieve the resource from cache.
//                return onlyRetrieveFromCache ? Stage.FINISHED : Stage.SOURCE;
//            case SOURCE:
//            case FINISHED:
//                return Stage.FINISHED;
//            default:
//                throw new IllegalArgumentException("Unrecognized stage: " + current);
//        }
//    }
//
//    private DataFetcherGenerator getNextGenerator() {
//        switch (stage) {
//            case RESOURCE_CACHE:
//                return new ResourceCacheGenerator(decodeHelper, this);
//            case DATA_CACHE:
//                return new DataCacheGenerator(decodeHelper, this);
//            case SOURCE:
//                return new SourceGenerator(decodeHelper, this);
//            case FINISHED:
//                return null;
//            default:
//                throw new IllegalStateException("Unrecognized stage: " + stage);
//        }
//    }


    /**
     * (1）.2 资源类型（Resource） DecodeJob类
     */
//    private void runGenerators() {
//        currentThread = Thread.currentThread();
//        startFetchTime = LogTime.getLogTime();
//        boolean isStarted = false;
//        while (!isCancelled
//                && currentGenerator != null
//                && !(isStarted = currentGenerator.startNext())) {
//            stage = getNextStage(stage);
//            currentGenerator = getNextGenerator();
//
//            if (stage == Stage.SOURCE) {
//                reschedule();
//                return;
//            }
//        }
//    }

    /**
     * (1）.3 资源类型（Resource）  ResourceCacheGenerator 类
     */
//    @Override
//    public boolean startNext() {
//
//        while (modelLoaders == null || !hasNextModelLoader()) {
//
//            //（1）构建缓存Key
//            currentKey =
//                    new ResourceCacheKey(
//                            helper.getArrayPool(),
//                            sourceId,
//                            helper.getSignature(),
//                            helper.getWidth(),
//                            helper.getHeight(),
//                            transformation,
//                            resourceClass,
//                            helper.getOptions());
//            //（2）缓存 Key 去获取缓存文件（获取转换后的图片）
//            cacheFile = helper.getDiskCache().get(currentKey);
//            if (cacheFile != null) {
//                sourceKey = sourceId;
//                modelLoaders = helper.getModelLoaders(cacheFile);
//                modelLoaderIndex = 0;
//            }
//        }
//
//        loadData = null;
//        boolean started = false;
//        while (!started && hasNextModelLoader()) {
//            ModelLoader<File, ?> modelLoader = modelLoaders.get(modelLoaderIndex++);
//            loadData =
//                    modelLoader.buildLoadData(
//                            cacheFile, helper.getWidth(), helper.getHeight(), helper.getOptions());
//            if (loadData != null && helper.hasLoadPath(loadData.fetcher.getDataClass())) {
//                started = true;
//                //（3）ByteBufferFileLoader
//                loadData.fetcher.loadData(helper.getPriority(), this);
//            }
//        }
//
//        return started;
//    }

    /**
     * (1）.4 资源类型（Resource）
     */
//    @Override
//    public void loadData(
//            @NonNull Priority priority, @NonNull DataCallback<? super ByteBuffer> callback) {
//        ByteBuffer result;
//        try {
//            result = ByteBufferUtil.fromFile(file);
//        } catch (IOException e) {
//            if (Log.isLoggable(TAG, Log.DEBUG)) {
//                Log.d(TAG, "Failed to obtain ByteBuffer for file", e);
//            }
    /**
     * 将缓存文件转换成 ByteBuffer，然后通过 onDataReady() 方法回调出去
     */
//            callback.onLoadFailed(e);
//            return;
//        }
//
//        callback.onDataReady(result);
//    }

    /**
     * (1）.5 资源类型（Resource） 存储资源类型 DecodeJob类
     */
//    <Z> Resource<Z> onResourceDecoded(DataSource dataSource, @NonNull Resource<Z> decoded) {
//
//
//        boolean isFromAlternateCacheKey = !decodeHelper.isSourceKey(currentSourceKey);
//        if (diskCacheStrategy.isResourceCacheable(
//                isFromAlternateCacheKey, dataSource, encodeStrategy)) {
//            if (encoder == null) {
//                throw new Registry.NoResultEncoderAvailableException(transformed.get().getClass());
//            }
//            final Key key;
//            //（1）根据缓存策略构建不同的缓存 Key
//            switch (encodeStrategy) {
//                case SOURCE:
//                    key = new DataCacheKey(currentSourceKey, signature);
//                    break;
//                case TRANSFORMED:
//                    key =
//                            new ResourceCacheKey(
//                                    decodeHelper.getArrayPool(),
//                                    currentSourceKey,
//                                    signature,
//                                    width,
//                                    height,
//                                    appliedTransformation,
//                                    resourceSubClass,
//                                    options);
//                    break;
//                default:
//                    throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
//            }
//
//            LockedResource<Z> lockedResult = LockedResource.obtain(transformed);
//            //（2）调用 init() 方法给变量 key 赋值
//            deferredEncodeManager.init(key, encoder, lockedResult);
//            result = lockedResult;
//        }
//        return result;
//    }

//    private static class DeferredEncodeManager<Z> {
//        private Key key;
//        private ResourceEncoder<Z> encoder;
//        private LockedResource<Z> toEncode;
//
//        <X> void init(Key key, ResourceEncoder<X> encoder, LockedResource<X> toEncode) {
//            this.key = key;
//            this.encoder = (ResourceEncoder<Z>) encoder;
//            this.toEncode = (LockedResource<Z>) toEncode;
//        }
//
//        void encode(DiskCacheProvider diskCacheProvider, Options options) {
//            GlideTrace.beginSection("DecodeJob.encode");
//            try {
//                //（3）在 encode() 方法中使用了，该方法中就做了存储缓存的操作（存储转换后的图片）。
//                diskCacheProvider
//                        .getDiskCache()
//                        .put(key, new DataCacheWriter<>(encoder, toEncode, options));
//            } finally {
//                toEncode.unlock();
//                GlideTrace.endSection();
//            }
//        }
//    }

//
    /**
     * 解码完成了通知下去的步骤 DecodeJob类
     */
//    private void notifyEncodeAndRelease(Resource<R> resource, DataSource dataSource) {
//        if (resource instanceof Initializable) {
//            ((Initializable) resource).initialize();
//        }
//
//        Resource<R> result = resource;
//        LockedResource<R> lockedResource = null;
//        if (deferredEncodeManager.hasResourceToEncode()) {
//            lockedResource = LockedResource.obtain(resource);
//            result = lockedResource;
//        }
//
//        notifyComplete(result, dataSource);
//
//        stage = Stage.ENCODE;
//        try {
//            if (deferredEncodeManager.hasResourceToEncode()) {
    /**
     * (1）.6 资源类型（Resource） 将资源缓存到磁盘
     */
//                deferredEncodeManager.encode(diskCacheProvider, options);
//            }
//        } finally {
//            if (lockedResource != null) {
//                lockedResource.unlock();
//            }
//        }
//        // Call onEncodeComplete outside the finally block so that it's not called if the encode process
//        // throws.
//        onEncodeComplete();
//    }

    /**
     * (2 数据来源 (Data)
     *
     * 取文件：首先构建缓存 Key，然后根据缓存 Key 去获取缓存文件（获取原始图片），最后将缓存文件加载成需要的数据。
     */

    /**
     * (2）.1 数据来源 (Data)存文件 网络请求完成时，将数据赋值给dataToCache
     */
//    void onDataReadyInternal(LoadData<?> loadData, Object data) {
//        DiskCacheStrategy diskCacheStrategy = helper.getDiskCacheStrategy();
//        if (data != null && diskCacheStrategy.isDataCacheable(loadData.fetcher.getDataSource())) {
//            // 赋值
//            dataToCache = data;
//            // We might be being called back on someone else's thread. Before doing anything, we should
//            // reschedule to get back onto Glide's thread.
//            cb.reschedule();
//        } else {
//            cb.onDataFetcherReady(
//                    loadData.sourceKey,
//                    data,
//                    loadData.fetcher,
//                    loadData.fetcher.getDataSource(),
//                    originalKey);
//        }
//    }

    /**
     * (2）.2 数据来源 (Data)存文件 SourceGenerator类
     */
//    @Override
//    public boolean startNext() {
//        //（1）
//        if (dataToCache != null) {
//            Object data = dataToCache;
//            dataToCache = null;
//            cacheData(data);
//        }
//
//        if (sourceCacheGenerator != null && sourceCacheGenerator.startNext()) {
//            return true;
//        }
//        sourceCacheGenerator = null;
//
//        loadData = null;
//        boolean started = false;
//        while (!started && hasNextModelLoader()) {
//            loadData = helper.getLoadData().get(loadDataListIndex++);
//            if (loadData != null
//                    && (helper.getDiskCacheStrategy().isDataCacheable(loadData.fetcher.getDataSource())
//                    || helper.hasLoadPath(loadData.fetcher.getDataClass()))) {
//                started = true;
//                startNextLoad(loadData);
//            }
//        }
//        return started;
//    }

    /**
     * (2）.3 数据来源 (Data)存文件  SourceGenerator类
     */
//    private void cacheData(Object dataToCache) {
//        long startTime = LogTime.getLogTime();
//        try {
//            Encoder<Object> encoder = helper.getSourceEncoder(dataToCache);
//            DataCacheWriter<Object> writer =
//                    new DataCacheWriter<>(encoder, dataToCache, helper.getOptions());
    /**
     * （1）获取缓存的key
     */
//            originalKey = new DataCacheKey(loadData.sourceKey, helper.getSignature());
    /**
     *（2）存储缓存（存储原始图片）
     */

//            helper.getDiskCache().put(originalKey, writer);
//
//
//        } finally {
//            loadData.fetcher.cleanup();
//        }
//
//        sourceCacheGenerator =
//                new DataCacheGenerator(Collections.singletonList(loadData.sourceKey), helper, this);
//    }


}
