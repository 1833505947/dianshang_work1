package com.example.lihuanhuan20190102.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lihuanhuan20190102.R;
import com.example.lihuanhuan20190102.entity.UserBean;

import java.util.List;

public class Gvadapter extends BaseAdapter {
    private Context context;
    private List<UserBean.UserData.TuijianData.ListTuijianData> list;

    public Gvadapter(Context context, List<UserBean.UserData.TuijianData.ListTuijianData> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            viewHolder = new ViewHolder(convertView);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.bindData((UserBean.UserData.TuijianData.ListTuijianData) getItem(position));
        return convertView;
    }
    class ViewHolder{
        ImageView img;
        TextView name,price;

        public ViewHolder(View convertView) {
            name = convertView.findViewById(R.id.name);
            price = convertView.findViewById(R.id.price);
            img = convertView.findViewById(R.id.img);
            convertView.setTag(this);
        }

        public void bindData(UserBean.UserData.TuijianData.ListTuijianData item) {
            name.setText(item.title);
            price.setText(item.price);
        }
    }
}
