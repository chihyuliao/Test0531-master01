package com.example.cjcu.test0531;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CJCU on 2018/6/14.
 */

public class TransctionAdapter extends RecyclerView.Adapter<TransctionAdapter.ViewHolder>{
private List<person> trans;


    public TransctionAdapter(List<person> trans) {
        this.trans = trans;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);
       ViewHolder vh =new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
person p =trans.get(position);
holder.cdate.setText((p.getCdate()));
        holder.info.setText((p.getInfo()));
        holder.amount.setText((p.getAmount()));
    }

    @Override
    public int getItemCount() {
        return trans.size();
    }

    public  class  ViewHolder extends  RecyclerView.ViewHolder{
private final  TextView cdate;
       private final  TextView info;
       private final  TextView amount;
       public ViewHolder(View itemView) {
           super(itemView);
           cdate=itemView.findViewById((R.id.tv_cdate));
           info=itemView.findViewById((R.id.tv_info));
           amount=itemView.findViewById((R.id.tv_amount));
       }
   }

}
