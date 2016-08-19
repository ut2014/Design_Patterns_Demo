package com.it5.design_patterns_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.it5.design_patterns_demo.image02.ImageLoader_2;
import com.it5.design_patterns_demo.simple_image.SimpleImageLoader;
import com.it5.design_patterns_demo.simple_image.cache.MemoryCache;
import com.it5.design_patterns_demo.simple_image.config.ImageLoaderConfig;

public class MainActivity extends AppCompatActivity {
    final String imgurl = "http://img.my.csdn.net/uploads/201402/24/1393242467_3999.jpg";
    final String imgurl_1="http://www.baidu.com/img/baidu_logo.gif";
    final String imglocal="sdcard/download/timg.jpeg";
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv= (ImageView) findViewById(R.id.imageview);
        loadImage_simple();
    }

    private void loadimage_0(){
        final ImageLoader_2 imgload=new ImageLoader_2();
        imgload.userDiskCache(true);
        imgload.displayImage(imgurl,iv);
//        iv.setImageBitmap(imageLoader0.downloadImage(imgurl));
//        iv.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
//            new DownloadImgTask(iv).execute(imgurl);
    }
    private void loadImage_simple(){
        ImageLoaderConfig config = new ImageLoaderConfig()
                .setLoadingPlaceholder(R.mipmap.ic_launcher)
//                .setNotFoundPlaceholder(R.drawable.not_found)
                .setCache(new MemoryCache())
                .setThreadCount(4);
//                .setLoadPolicy(new ReversePolicy());
        // 初始化
        SimpleImageLoader.getInstance().init(config);
        SimpleImageLoader.getInstance().displayImage(iv,imglocal);
    }
}
