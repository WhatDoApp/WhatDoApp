package com.whatdo.whatdoco.whatdo;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder> {

    List<String> mItems;

    public CategoryRecyclerViewAdapter() {
        super();
        mItems = new ArrayList<String>();
        mItems.add("Academics");
        mItems.add("Health");
        mItems.add("Gaming and Entertainment");
        mItems.add("Relationships");
        mItems.add("Technology");
        mItems.add("Movies");
        mItems.add("General");
        mItems.add("Fashion");
        mItems.add("Arts");
        mItems.add("Sports");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item_simple_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    public List<String> getmItems()
    {
        return mItems;
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemView.setText(mItems.get(i));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = (TextView)itemView.findViewById(R.id.tv_recycler_view_item);
        }
    }
}

