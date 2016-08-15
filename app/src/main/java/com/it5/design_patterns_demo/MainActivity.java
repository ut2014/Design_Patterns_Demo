package com.it5.design_patterns_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.it5.design_patterns_demo.image02.ImageLoader_2;

public class MainActivity extends AppCompatActivity {
    final String imgurl = "http://img.my.csdn.net/uploads/201402/24/1393242467_3999.jpg";
    final String imgurl_1="http://www.baidu.com/img/baidu_logo.gif";
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv= (ImageView) findViewById(R.id.imageview);
        final ImageLoader_2 imgload=new ImageLoader_2();
        imgload.userDiskCache(true);
        imgload.displayImage(imgurl,iv);
//        iv.setImageBitmap(imageLoader0.downloadImage(imgurl));
//        iv.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
//            new DownloadImgTask(iv).execute(imgurl);
    }
}
