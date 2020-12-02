package com.elaine.testglide;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.elaine.testglide.databinding.ActivityMainBinding;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        basic();
        basicWithGif();
        basicWithPlaceholder();
        basicWithError();
        basicWithFallback();
        basicWithRequestOptions();
        basicWithTransitionOptions();
        basicWithThumbnail();
        basicWithCache();
        getBitmapWithGlide();
    }

    /**
     * 基础使用
     * this---上下文
     * R.mipmap.pic---图片资源(资源文件，GIF图片，网络图片等)
     * mBinding.ivOne---ImageView控件
     */
    private void basic() {
        Glide.with(this).load(R.mipmap.pic).into(mBinding.ivOne);
    }

    /**
     * 指定GIF图片
     * 注：只能使用GIF格式的图片，不然无法显示
     * this---上下文
     * asGif()---设置为GIF
     * R.mipmap.gif---动态图片资源
     * mBinding.ivTwo---ImageView控件
     */
    private void basicWithGif() {
        Glide.with(this).asGif().load(R.mipmap.gif).into(mBinding.ivTwo);
    }

    /**
     * 占位符(Placeholder)
     * 显示在请求到资源之前，若请求资源为空且未设置错误符和后备回调符则会一直显示。
     * .placeholder(new ColorDrawable(Color.GRAY))设置为灰色背景
     * .placeholder()--参数为int或者Drawable
     */
    private void basicWithPlaceholder() {
        Glide.with(this).load("").placeholder(new ColorDrawable(Color.GRAY)).into(mBinding.ivThree);
    }

    /**
     * 错误符（Error）
     * 若请求资源失败或者为空且未设置后备回调符则会显示。
     * .error(new ColorDrawable(Color.RED))设置失败为红色背景
     * .error()--参数为int或者Drawable
     */
    private void basicWithError() {
        Glide.with(this).load("").error(new ColorDrawable(Color.RED)).into(mBinding.ivFour);
    }

    /**
     * 后备回调符(Fallback)
     * 显示在请求资源为空后，则设置默认显示的资源。
     * .fallback(R.mipmap.no_data)设置为默认的没有数据的图片
     * .fallback()--参数为int或者Drawable
     */
    private void basicWithFallback() {
        Bitmap bitmap = null;
        Glide.with(this).load(bitmap).fallback(R.mipmap.no_data).into(mBinding.ivFive);
    }

    /**
     * RequestOptions
     * 带有特殊处理的图片选项，例如填充方式，圆形，Corners(角弧度)等
     */
    private void basicWithRequestOptions() {
        //圆形图片
//        RequestOptions circle = RequestOptions.circleCropTransform();
//        Glide.with(this).applyDefaultRequestOptions(circle).load(R.mipmap.pic).into(mBinding.ivSix);
        //圆形图片
        Glide.with(this).load(R.mipmap.pic).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(mBinding.ivSix);
        //填充方式，中间剪切 width改为50看效果
//        Glide.with(this).load(R.mipmap.pic).centerCrop().into(mBinding.ivSix);
        //角弧度
//        RoundedCorners roundedCorners = new RoundedCorners(100);
//        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);
//        Glide.with(this).load(R.mipmap.pic).apply(options).into(mBinding.ivSix);
        //指定长宽
//        Glide.with(this).load(R.mipmap.pic).override(10,10).into(mBinding.ivSix);
    }

    /**
     * 过渡选项
     * 即图片载入时的动画效果
     * DrawableTransitionOptions普通图片
     * BitmapTransitionOptions请求Bitmap时使用
     */
    private void basicWithTransitionOptions() {
        //交叉淡入  看效果切入到ivOne
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606658922596&di=f449f13a338c9fa2895f003b48b73c6e&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F13%2F41%2F01300000201800122190411861466.jpg").transition(withCrossFade()).into(mBinding.ivSeven);
    }

    /**
     * 缩略图
     * 用于加载高质量图片之前加载
     * 两种方法，一种是后端提供缩略图和原图；一种是只有原图的情况下，设置缩略比例。
     */
    private void basicWithThumbnail() {
        //https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606658922596&di=f449f13a338c9fa2895f003b48b73c6e&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F13%2F41%2F01300000201800122190411861466.jpg 小图
        //https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606661672186&di=c7eb85e4ce9de9c76bcc4b566ff7b640&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fitbbs%2F1509%2F12%2Fc35%2F12543950_1442056644323.jpg 大图
//        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606661672186&di=c7eb85e4ce9de9c76bcc4b566ff7b640&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fitbbs%2F1509%2F12%2Fc35%2F12543950_1442056644323.jpg").thumbnail(Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606658922596&di=f449f13a338c9fa2895f003b48b73c6e&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F13%2F41%2F01300000201800122190411861466.jpg")).into(mBinding.ivEight);
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606661672186&di=c7eb85e4ce9de9c76bcc4b566ff7b640&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fitbbs%2F1509%2F12%2Fc35%2F12543950_1442056644323.jpg").thumbnail(0.25f).into(mBinding.ivEight);
    }

    /**
     * 缓存相关
     * 磁盘缓存策略（Disk Cache Strategy）
     * ALL：既缓存原始图片，也缓存转换过后的图片；
     * AUTOMATIC (默认策略)：它会尝试对本地和远程图片使用最佳的策略。当你加载远程数据（比如，从URL下载）时，AUTOMATIC 策略仅会存储未被你的加载过程修改过(比如，变换，裁剪–译者注)的原始数据，因为下载远程数据相比调整磁盘上已经存在的数据要昂贵得多。对于本地数据，AUTOMATIC 策略则会仅存储变换过的缩略图，因为即使你需要再次生成另一个尺寸或类型的图片，取回原始数据也很容易。
     * DATA：只缓存未被处理的文件。我的理解就是我们获得的 stream。它是不会被展示出来的，需要经过装载decode，对图片进行压缩和转换，等等操作，得到最终的图片才能被展示。
     * NONE：表示不缓存任何内容。
     */
    private void basicWithCache() {
        //磁盘缓存策略
        Glide.with(this)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606658922596&di=f449f13a338c9fa2895f003b48b73c6e&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F13%2F41%2F01300000201800122190411861466.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mBinding.ivNine);
        //仅从缓存加载图片
        //如果图片在内存缓存或在磁盘缓存中，它会被展示出来。否则只要这个选项被设置为true，这次加载会视同失败。
        Glide.with(this)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606658922596&di=f449f13a338c9fa2895f003b48b73c6e&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F13%2F41%2F01300000201800122190411861466.jpg")
                .onlyRetrieveFromCache(true)
                .into(mBinding.ivTen);
        //跳过缓存
        Glide.with(this)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606658922596&di=f449f13a338c9fa2895f003b48b73c6e&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F13%2F41%2F01300000201800122190411861466.jpg")
                .skipMemoryCache(true) //跳过内存缓存
                .diskCacheStrategy(DiskCacheStrategy.NONE) //跳过磁盘缓存
                .into(mBinding.ivEleven);
    }

    /**
     * 获取Bitmap
     */
    private void getBitmapWithGlide(){
        Glide.with(this)
                .asBitmap()
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606658922596&di=f449f13a338c9fa2895f003b48b73c6e&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F13%2F41%2F01300000201800122190411861466.jpg")
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        mBinding.ivTwelve.setImageBitmap(resource);
                    }
                });
    }

}
