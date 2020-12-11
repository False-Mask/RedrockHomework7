package com.example.level2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.holder> {

    List<data>list;
    public adapter(List list){
        this.list=list;
    }
    static class holder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        public holder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.title);
            textView2=itemView.findViewById(R.id.shareUser);
            textView3=itemView.findViewById(R.id.link);
        }
    }

    @NonNull
    @Override
    public adapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new holder(LayoutInflater.from(parent.
                getContext()).inflate(R.layout.item,parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.holder holder, int position) {
        data Data=list.get(position);
        holder.textView1.setText(Data.title);
        holder.textView2.setText(Data.shareUsers);
        holder.textView3.setText(Data.link);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
