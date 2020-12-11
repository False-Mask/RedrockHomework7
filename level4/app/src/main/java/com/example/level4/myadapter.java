package com.example.level4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.holder> {//对list进行初始化
    List<Data> list;
    public myadapter(List<Data> list){
        this.list=list;
    }

    //重新Adapter类的方法

    class holder extends RecyclerView.ViewHolder {
        TextView textView1,textView2,textView3;
        Context context;
        public holder(@NonNull View itemView) {
            super(itemView);
            context=itemView.getContext();
        }
    }

    @NonNull
    @Override
    public myadapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new holder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter.holder holder, int position) {
        Data data=list.get(position);
        holder.textView1.setText(data.getTitle());
        holder.textView2.setText(data.getShareUser());
        holder.textView3.setText(data.getIn());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
