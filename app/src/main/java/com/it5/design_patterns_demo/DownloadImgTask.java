package com.it5.design_patterns_demo;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.it5.design_patterns_demo.util.ImgUtil;

/**
 * Created by IT5 on 2016/8/15.
 */
public class DownloadImgTask extends AsyncTask<String,Integer,Bitmap>{
    private ImageView imageView=null;
    DownloadImgTask(ImageView iv){
        imageView=iv;
    }
    @Override
    protected Bitmap doInBackground(String... params) {
        return ImgUtil.downloadImage(params[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
        super.onPostExecute(bitmap);
    }
}
