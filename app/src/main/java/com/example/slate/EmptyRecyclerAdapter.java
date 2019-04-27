package com.example.slate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class EmptyRecyclerAdapter extends RecyclerView.Adapter<EmptyRecyclerAdapter.ViewHolder> {

    private ArrayList<Object> mSigns = new ArrayList<Object>();
    private Context mContext;

    public EmptyRecyclerAdapter(ArrayList<Object> mSigns, Context mContext) {
        this.mSigns = mSigns;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.clickble_linear_layout,viewGroup,false);
        return new EmptyRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {



        viewHolder.linearLayout.addView(null);

    }

    @Override
    public int getItemCount() {
        return mSigns.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.clickable_item);
        }
    }
}
