package com.example.viewyuan_20190102;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class DotActivity extends AppCompatActivity {

    private DotView dotview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dot);
        dotview = findViewById(R.id.dotview);
    }

    public void add(View view) {
        DotBean dotBean = new DotBean();
        dotBean.setX(new Random().nextInt(800));
        dotBean.setY(new Random().nextInt(1000));
        dotBean.setChecked(false);
        dotview.add(dotBean);
    }

    public void clear(View view) {
    }
}
