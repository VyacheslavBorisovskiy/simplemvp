package com.borisovskiy.simplemvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borisovskiy.simplemvp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.QuoteViewHolder> {

    private List<String> items;

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recview_item, parent, false);
        return new QuoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
        String item = items.get(position);
        holder.recViewItem.setText(item);
    }

    public void setItems(List<String> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class QuoteViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recview_item_tv)
        TextView recViewItem;

        public QuoteViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
