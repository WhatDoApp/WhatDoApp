package com.whatdo.whatdoco.whatdo;

/**
 * Created by sandeep on 2015-06-14.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder>{
    private static final int HEADER_TYPE = 0;
    private static final int ROW_TYPE = 1;

    private List<String> rows;

    public DrawerAdapter(List<String> rows) {
        this.rows = rows;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER_TYPE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_header, parent, false);
            return new ViewHolder(view, viewType);
        } else if (viewType == ROW_TYPE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_row, parent, false);
            return new ViewHolder(view, viewType);
        }
        return null;
    }

    ClickListener clickListener;

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        public void onClick(View v, int pos);

    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (holder.viewType == ROW_TYPE) {
            String rowText = rows.get(position - 1);
            holder.textView.setText(rowText);
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onClick(view, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rows.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return HEADER_TYPE;
        return ROW_TYPE;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnTouchListener {
        protected int viewType;

        @InjectView(R.id.drawer_row_icon) ImageView imageView;
        @InjectView(R.id.drawer_row_text) TextView textView;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);

            this.viewType = viewType;

            itemView.setOnTouchListener(this);
            if (viewType == ROW_TYPE) {
                ButterKnife.inject(this, itemView);
            }
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }
}