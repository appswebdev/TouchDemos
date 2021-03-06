package minhal.tomer.edu.touchdemos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ANDROID on 16/11/2016.
 */
public class MultiTouchView extends View {


    private static final float RADIUS = 30;
    private static final int[] COLORS = {Color.BLACK, Color.BLUE, Color.RED, Color.BLACK, Color.MAGENTA
            , Color.GREEN, Color.GRAY};

    Paint mPaint;
    private String TAG = "Minhal";
    HashMap<Integer, PointF> mPointers = new HashMap<>();


    public MultiTouchView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(30);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        int actionMasked = e.getActionMasked();
        int pointerCount = e.getPointerCount();
        int index = e.getActionIndex();
        int pointerId = e.getPointerId(index);


        float x = e.getX(index);
        float y = e.getY(index);

        switch (actionMasked) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                PointF p = new PointF(x, y);
                mPointers.put(pointerId, p);
                //Log.d(TAG, "Down");
                Log.d(TAG, String.format("Down index = %d id = %d", index, pointerId));

                break;

            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "Move");
                for (int pointerIndex = 0; pointerIndex < pointerCount; pointerIndex++) {
                    int id = e.getPointerId(pointerIndex);
                    PointF currentPointer = mPointers.get(id);
                    currentPointer.x = e.getX(pointerIndex);
                    currentPointer.y = e.getY(pointerIndex);
                    //currentPointer.set(e.getX(pointerIndex), e.getY(pointerIndex));
                }


                for (int h = 0; h < e.getHistorySize(); h++) {
                    for (int po = 0; po < e.getPointerCount(); po++) {
                        Log.d(TAG, "" + e.getHistoricalX(h,po));
                        Log.d(TAG, "" + e.getHistoricalY(h,po));
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
                //Log.d(TAG, "Up");
                mPointers.remove(pointerId);
                Log.d(TAG, String.format("Up index = %d id = %d", index, pointerId));
                break;
        }
        //Schedule a ReDraw
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.BLUE);
        canvas.drawText("Total Pointers: " + mPointers.size(), 40, 40, mPaint);
        for (Integer key : mPointers.keySet()) {
            mPaint.setColor(COLORS[key % COLORS.length]);
            PointF p = mPointers.get(key);
            if (p != null) {
                canvas.drawCircle(p.x, p.y, RADIUS, mPaint);
            }
        }
    }
}
