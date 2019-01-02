package com.example.lihuanhuan20190102.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lihuanhuan20190102.R;
import com.example.lihuanhuan20190102.entity.UserBean;

import java.util.List;

public class Rcadapter extends RecyclerView.Adapter<Rcadapter.RcViewHolder> {
    private Context context;
    private List<UserBean.UserData.TuijianData.ListTuijianData> list;

    public Rcadapter(Context context, List<UserBean.UserData.TuijianData.ListTuijianData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RcViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        RcViewHolder rcViewHolder = new RcViewHolder(inflate);
        return rcViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RcViewHolder rcViewHolder, int i) {
        UserBean.UserData.TuijianData.ListTuijianData listTuijianData = list.get(i);
        rcViewHolder.name.setText(listTuijianData.title);
        rcViewHolder.price.setText(listTuijianData.price);
        /*rcViewHolder.img.setImageResource(R.mipmap.ic_launcher);*/

        Glide.with(context).load(listTuijianData.images).into(rcViewHolder.img);
    }

    @Override
    public int getItemCount() {

        return list==null?0:list.size();
    }

    class RcViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name,price;
        public RcViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
}
