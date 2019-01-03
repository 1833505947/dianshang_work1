package com.example.day7_20190103;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.example.day7_20190103.adapter.Myadapter;
import com.example.day7_20190103.userentity.UserBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XRecyclerView mXrv;
    private ArrayList<String> list;
    private ArrayList<UserBean> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {

            list.add(i+"");

        }

        Myadapter myadapter = new Myadapter(this,list);
        mXrv.setAdapter(myadapter);
        mXrv.loadMoreComplete();
        mXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                initData();
            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    private void initView() {
        mXrv = (XRecyclerView) findViewById(R.id.xrv);
        mXrv.setLayoutManager(new GridLayoutManager(this,1));
        mXrv.setLoadingMoreEnabled(true);

    }
}
