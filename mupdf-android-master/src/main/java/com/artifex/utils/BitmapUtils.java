package com.artifex.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

public class BitmapUtils {
    public static Bitmap nightMode(Bitmap src){
        int height = src.getHeight();
        int width = src.getWidth();

        Bitmap bitmap = Bitmap.createBitmap(width, height, src.getConfig());
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        ColorMatrix matrixGrayscale = new ColorMatrix();
//        matrixGrayscale.setSaturation(0);

        ColorMatrix matrixInvert = new ColorMatrix();
        matrixInvert.set(new float[]
                {
                        -1.0f, 0.0f, 0.0f, 0.0f, 255.0f,
                        0.0f, -1.0f, 0.0f, 0.0f, 255.0f,
                        0.0f, 0.0f, -1.0f, 0.0f, 255.0f,
                        0.0f, 0.0f, 0.0f, 1.0f, 0.0f
                });
        matrixInvert.preConcat(matrixGrayscale);

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrixInvert);
        paint.setColorFilter(filter);

        canvas.drawBitmap(src, 0, 0, paint);
        // src.recycle();
        return bitmap;

    }


}
