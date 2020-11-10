package com.demkom58.androidlab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

public class SubsetGestActivity extends AppCompatActivity {

    private GestureDetectorCompat detector;
    private TextView outView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subset_gest);

        outView = findViewById(R.id.outSubsetGestTextView);
        detector = new GestureDetectorCompat(this, new MyGestListener());

        Button toInterfaceButton = findViewById(R.id.buttonInterface);
        toInterfaceButton.setOnClickListener(e ->
                startActivity(new Intent(SubsetGestActivity.this, MainActivity.class)));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            outView.setText("onFling: " + event1.toString()+event2.toString());
            return true;
        }
    }

}

