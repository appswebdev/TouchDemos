package minhal.tomer.edu.touchdemos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    RelativeLayout layout;
    private String TAG = "Minhal";
    Button btnA, btnB, btnC, btnD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        btnA = (Button) findViewById(R.id.btnA);
        btnB = (Button) findViewById(R.id.btnB);
        btnC = (Button) findViewById(R.id.btnC);
        btnD = (Button) findViewById(R.id.btnD);

        layout = (RelativeLayout) findViewById(R.id.layout);

/*
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent e) {
                float x = e.getX();
                float y = e.getY();


                float btnAX = btnA.getX();
                float btnAY = btnA.getY();
                int btnAWidth = btnA.getWidth();
                int btnAHeight = btnA.getHeight();


                Log.d(TAG, "btnAX " + btnAX);
                Log.d(TAG, "btnAY " + btnAY);
                Log.d(TAG, "btnAWidth " + btnAWidth);
                Log.d(TAG, "btnAHeight " + btnAHeight);




                int action = e.getAction();

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG, "Down " + x + ", " + y);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d(TAG, "Move " + x + ", " + y);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(TAG, "Up " + x + ", " + y);
                        break;
                }
                //The event is of interest
                //continue receiving updates about the event.
                return true;
            }
        });*/
    }


    float btnAX;//= btnA.getX();
    float btnAY;// = btnA.getY();
    int btnAWidth; //= btnA.getWidth();
    int btnAHeight;// = btnA.getHeight();


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {


        btnAX = btnA.getX();
        btnAY = btnA.getY();
        btnAWidth = btnA.getWidth();
        btnAHeight = btnA.getHeight();
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();


        float y = e.getY();


        Log.d(TAG, "btnAX " + btnAX);
        Log.d(TAG, "btnAY " + btnAY);
        Log.d(TAG, "btnAWidth " + btnAWidth);
        Log.d(TAG, "btnAHeight " + btnAHeight);


        int action = e.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "Down " + x + ", " + y);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "Move " + x + ", " + y);
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "Up " + x + ", " + y);
                break;
        }
        //The event is of interest
        //continue receiving updates about the event.
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
