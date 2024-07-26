package com.wanglei.points24;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Test {
    public static void drawBlack(Bitmap bitmap, Rect rect) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawRect(rect, paint);
    }
}