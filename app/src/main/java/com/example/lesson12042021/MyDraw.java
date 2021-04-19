package com.example.lesson12042021;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyDraw extends View {
    public MyDraw(Context context) {
        super(context);
    }

    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5f);
        paint.setStyle(Paint.Style.STROKE);
        int y = 0;
        int x = 0;
        int R = canvas.getWidth() / 2;
        while (R > 0) {
            paint.setColor(Color.rgb((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
            canvas.drawCircle(canvas.getWidth() / 2,
                    canvas.getHeight() / 2, R, paint);
            R -= 100;
        }
        paint.setColor(Color.BLACK);
        canvas.drawLine(0,
                canvas.getHeight() / 2,
                canvas.getWidth(),
                canvas.getHeight() / 2, paint);
        canvas.drawLine(canvas.getWidth() / 2,
                0,
                canvas.getWidth() / 2,
                canvas.getHeight(), paint);
        canvas.drawRect(20, 20, 100, 200, paint);

        /*while (y<canvas.getHeight()) {
            canvas.drawLine(0, y, canvas.getWidth(), y, paint);
            y+=100;

        }
        while (x<canvas.getWidth()) {
            canvas.drawLine(x, 0, x, canvas.getHeight(), paint);
            x+=100;

        }*/
    }
}
