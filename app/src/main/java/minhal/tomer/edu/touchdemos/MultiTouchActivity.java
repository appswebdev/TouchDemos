package minhal.tomer.edu.touchdemos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MultiTouchActivity extends AppCompatActivity {

    private static final String TAG = "Minhal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_touch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        int actionMasked = e.getActionMasked();
        int pointerCount = e.getPointerCount();
        int index = e.getActionIndex();
        int pointerId = e.getPointerId(index);

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

        return true;
    }
}
