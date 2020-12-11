package com.example.level3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.holder> {
    List<Date> list;
    Context context;
    public adapter(List<Date> list) {
        this.list=list;
    }

    public class holder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textView1,textView2,textView3;
        public holder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.T1);
            textView2=itemView.findViewById(R.id.T2);
            textView3=itemView.findViewById(R.id.T3);
            cardView=(CardView)itemView;
        }
    }

    @NonNull
    @Override
    public adapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        return new holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,
                parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.holder holder, int position) {
        Date date=list.get(position);
        holder.textView1.setText(date.getTitle());
        holder.textView2.setText(date.getShareUser());
        holder.textView3.setText(date.getIn());

        holder.cardView.setOnClickListener(v -> {
            Intent intent=new Intent(context,Activity.class);
            intent.putExtra("in",list.get(position).getIn());
            intent.putExtra("title",list.get(position).getTitle());
            intent.putExtra("shareUser",list.get(position).getShareUser());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
