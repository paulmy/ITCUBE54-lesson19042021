package com.example.lesson12042021;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyDraw extends View {
    public MyDraw(Context context) {
        super(context);
        Init();
    }

    int N = 50;
    Paint paint = new Paint();
    int[] R = new int[N];
    int[] G = new int[N];
    int[] B = new int[N];
    int[] x = new int[N];
    int[] y = new int[N];
    int[] dx = new int[N];
    int[] dy = new int[N];

    void fillRandom(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 100 + (int) (Math.random() * 500);
        }
    }

    void fillRandomColor(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 256);
        }
    }

    void fillRandomdxy(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 7 - 3);
        }
    }

    void Init() {
        fillRandom(x);
        fillRandom(y);
        fillRandom(R);
        fillRandomdxy(dx);
        fillRandomdxy(dy);
        fillRandomColor(R);
        fillRandomColor(G);
        fillRandomColor(B);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        for (int i = 0; i < N; i++) {
            paint.setColor(Color.rgb(R[i], G[i], B[i]));
            //paint.setStrokeWidth(5f);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(x[i], y[i], 50, paint);

        }
        for (int i = 0; i < N; i++) {
            if (x[i] + 50 > canvas.getWidth() || x[i] - 50 < 0)
                dx[i] = -dx[i];

            if (y[i] + 50 > canvas.getHeight() || y[i] - 50 < 0)
                dy[i] = -dy[i];

            x[i] += dx[i];
            y[i] += dy[i];
        }

/*
        int count = 1;
        for (int y = 0; y < canvas.getHeight(); y = y + 100) {//Количество строк
            count=0;
            for (int x = 0; x < canvas.getWidth(); x = x + 100) {//Количество столбцов
                if (count % 2 == 0) {
                    paint.setColor(Color.BLACK);
                    paint.setStrokeWidth(5f);
                    paint.setStyle(Paint.Style.FILL);
                    count=1;
                } else {
                    paint.setColor(Color.WHITE);
                    paint.setStrokeWidth(5f);
                    paint.setStyle(Paint.Style.FILL);
                    count=0;
                }

                canvas.drawRect(x, y, x + 100, y + 100, paint);

            }

        }
*/
        /*int R = canvas.getWidth() / 2;
        while (R > 0) {
            paint.setColor(Color.rgb((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
            canvas.drawCircle(canvas.getWidth() / 2,
                    canvas.getHeight() / 2, R, paint);
            R = R/2;
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
*/


        /*while (y<canvas.getHeight()) {
            canvas.drawLine(0, y, canvas.getWidth(), y, paint);
            y+=100;

        }
        while (x<canvas.getWidth()) {
            canvas.drawLine(x, 0, x, canvas.getHeight(), paint);
            x+=100;

        }*/
        invalidate();
    }
}
