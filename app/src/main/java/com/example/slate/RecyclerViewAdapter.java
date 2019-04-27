package com.example.slate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Integer> mSigns = new ArrayList<Integer>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext , ArrayList<Integer> mSigns) {
        this.mSigns = mSigns;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.sign.setImageResource(mSigns.get(i));

    }

    @Override
    public int getItemCount() {
        return mSigns.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView sign;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sign = itemView.findViewById(R.id.message_item);
        }
    }
}
