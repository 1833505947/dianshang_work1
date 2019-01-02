package com.example.viewyuan_20190102;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLine;
    private MyView mMyview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            TextView textView = new TextView(this);
            textView.setText(i+"");
            mLine.addView(textView);

        }
        mMyview.invalidate();//重绘，直接触发onDraw()方法，只能在主线程通知重绘
        mMyview.postInvalidate();//重绘，直接触发onDraw()方法，面试题，区别，子线程可以通知重绘
    }

    private void initView() {
        mLine = (LinearLayout) findViewById(R.id.line);
        mMyview = (MyView) findViewById(R.id.myview);

    }
}
