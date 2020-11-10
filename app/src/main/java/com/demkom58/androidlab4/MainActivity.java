package com.demkom58.androidlab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private GestureDetectorCompat detector;
    private TextView outView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outView = findViewById(R.id.outMainTextView);

        detector = new GestureDetectorCompat(this,this);
        detector.setOnDoubleTapListener(this);

        Button toSimpleButton = findViewById(R.id.buttonSimpleOnGesture);
        toSimpleButton.setOnClickListener(e ->
                startActivity(new Intent(MainActivity.this, SubsetGestActivity.class)));
    }

    public boolean onTouchEvent(MotionEvent event){
        this.detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        outView.setText("onDown: " + event.toString());
        return false;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        outView.setText("onFling: " + event1.toString()+event2.toString());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        outView.setText("onLongPress: " + event.toString());
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        outView.setText("onScroll: " + e1.toString()+e2.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        outView.setText("onShowPress: " + event.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        outView.setText("onSingleTapUp: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        outView.setText("onDoubleTap: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        outView.setText("onDoubleTapEvent: " + event.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        outView.setText("onSingleTapConfirmed: " + event.toString());
        return true;
    }
}
