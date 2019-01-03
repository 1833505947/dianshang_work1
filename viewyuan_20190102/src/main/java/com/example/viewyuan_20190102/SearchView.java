package com.example.viewyuan_20190102;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchView extends LinearLayout {
    private ImageView back;
    private EditText ed_search;
    private TextView tv_search;
    private int searchColor;
    private int searchsize;
    public SearchView(Context context) {
        this(context,null);
    }

    public SearchView(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SearchView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    public void init(Context context,AttributeSet attributeSet) {
        initAttrs(context,attributeSet);
        initView();
        initData();
    }

    private void initData() {
    }

    private void initAttrs(Context context,AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.SearchView);
        searchColor = typedArray.getColor(R.styleable.SearchView_searchColor,Color.BLUE);
        if (typedArray!=null){
            typedArray.recycle();//回收资源
        }

    }

    private void initView() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.search_layout,this,true);
        back = view.findViewById(R.id.back);
        tv_search= view.findViewById(R.id.tv_search);
        ed_search = view.findViewById(R.id.ed_search);
        tv_search.setTextColor(searchColor);//动态设置颜色
        tv_search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(ed_search.getText().toString())){
                    if (searchViewCallback!=null){
                        searchViewCallback.keywordsEmpty();
                        return;
                    }
                }
                    if (searchViewCallback!=null){
                       searchViewCallback.searchonclick(ed_search.getText().toString());
                    }
            }
        });
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchViewCallback!=null){
                    searchViewCallback.backonclick(v);
                }
            }
        });
    }
    private SearchViewCallback searchViewCallback;

    public void setSearchViewCallback(SearchViewCallback searchViewCallback) {
        this.searchViewCallback = searchViewCallback;
    }

    public interface SearchViewCallback{
        void keywordsEmpty();
        void backonclick(View v);
        void searchonclick(String keywords);
    }
}
