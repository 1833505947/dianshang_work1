package com.example.lihuanhuan20190102;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.example.lihuanhuan20190102.adapter.Gvadapter;
import com.example.lihuanhuan20190102.adapter.Rcadapter;
import com.example.lihuanhuan20190102.entity.UserBean;
import com.example.lihuanhuan20190102.net.OkhttpCallback;
import com.example.lihuanhuan20190102.util.OkhttpUtil;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private GridView gv;
    private HashMap<String, String> map;
    private int page=1;
    private XRecyclerView xr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //initData(map);

    }

   /* private void initData(final HashMap<String,String> map) {


    }*/

    private void getSteam(String s) {
        UserBean userBean = new Gson().fromJson(s, UserBean.class);
        if (userBean!=null){
           /*Gvadapter gvadapter = new Gvadapter(this,userBean.data.tuijian.list);
            gv.setAdapter(gvadapter);*/
            Rcadapter rcadapter = new Rcadapter(this,userBean.data.tuijian.list);
            xr.setAdapter(rcadapter);

        }

    }

    private void initView() {
        //gv = findViewById(R.id.gv);
        xr = findViewById(R.id.xr);
        xr.setLayoutManager(new GridLayoutManager(this,3));
        map = new HashMap<>();
        map.put("tuijian","为你推荐");
        map.put("page",page+"");
        OkhttpUtil.getInstance().post(map, new OkhttpCallback() {
            @Override
            public void onFailok(String msg) {
                Toast.makeText(MainActivity.this,"错误！",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccessok(String msg) {
                getSteam(msg);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkhttpUtil.getInstance().cancel();
    }
}
