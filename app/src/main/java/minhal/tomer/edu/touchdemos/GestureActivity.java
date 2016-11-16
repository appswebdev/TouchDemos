package minhal.tomer.edu.touchdemos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class GestureActivity extends AppCompatActivity {
    private static final String TAG = "Minhal";
    private GestureDetectorCompat detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        detector = new GestureDetectorCompat(this, new GestureDetector.SimpleOnGestureListener() {


            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.d(TAG, "Swipe");

                float x1 = e1.getX();
                float x2 = e2.getX();
                float dx = x2 - x1;


                float y1 = e1.getY();
                float y2 = e2.getY();
                float dy = y2 - y1;


                if (Math.abs(dy) > Math.abs(dx)) {
                    Log.d(TAG, "Vertical");
                    if (dy > 0) {
                        Log.d(TAG, "Down");
                    } else {
                        Log.d(TAG, "Up");
                    }
                } else {
                    Log.d(TAG, "Horizontal");
                    if (dx > 0) {
                        Log.d(TAG, "Right");
                    } else {
                        Log.d(TAG, "Left");
                    }
                }


                return true;
            }
        });
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Pass the event to the detector.
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
