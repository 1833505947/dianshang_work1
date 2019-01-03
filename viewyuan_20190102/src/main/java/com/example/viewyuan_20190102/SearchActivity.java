package com.example.viewyuan_20190102;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity implements SearchView.SearchViewCallback {

    private SearchView searchview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchview = findViewById(R.id.searchview);
        searchview.setSearchViewCallback(this);
    }

    @Override
    public void keywordsEmpty() {
        Toast.makeText(this,"关键词不能为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void backonclick(View v) {
        this.finish();
    }

    @Override
    public void searchonclick(String keywords) {
        String result = keywords;

    }
}
