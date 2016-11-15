package minhal.tomer.edu.touchdemos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ANDROID on 15/11/2016.
 */
public class TouchView extends View {

    private Paint paint;
    private Path path;
    Bitmap bmp;
    private float androidX;
    private float androidY;
    private int halfWidth;

    public TouchView(Context context) {
         this(context, null);
    }


    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }



    private void init() {
        path = new Path();
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(30);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        bmp =  BitmapFactory.decodeResource(
                getContext().getResources(),
                R.mipmap.ic_launcher);

        halfWidth = bmp.getWidth() / 2;
    }



    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();

        androidX = x;
        androidY = y;
        int action = e.getAction();

        switch (action){

            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
        }

        //ReDraw:
        invalidate();

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bmp, androidX - halfWidth, androidY - halfWidth, null);
       // canvas.drawPath(path, paint);
    }
}
