package minhal.tomer.edu.touchdemos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ANDROID on 16/11/2016.
 */
public class MultiTouchView extends View {


    private static final float RADIUS = 30;
    float pointerX;
    float pointerY;
    Paint mPaint;
    private String TAG = "Minhal";

    public MultiTouchView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        int actionMasked = e.getActionMasked();
        int pointerCount = e.getPointerCount();
        int index = e.getActionIndex();
        int pointerId = e.getPointerId(index);


        pointerX = e.getX(0);
        pointerY = e.getY(0);
        switch (actionMasked){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                //Log.d(TAG, "Down");
                Log.d(TAG, String.format("Down index = %d id = %d", index, pointerId));

                break;

            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "Move");
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
                //Log.d(TAG, "Up");
                Log.d(TAG, String.format("Up index = %d id = %d", index, pointerId));
                break;
        }
        //Schedule a ReDraw
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(pointerX, pointerY, RADIUS, mPaint);
    }
}
