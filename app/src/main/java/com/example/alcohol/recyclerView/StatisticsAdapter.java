package com.example.alcohol.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.alcohol.R;

import java.util.List;

public class StatisticsAdapter extends RecyclerView.Adapter<StatisticsAdapter.VHolder> {
    private List<Information> infoList;

    public StatisticsAdapter(List<Information> list) {
        this.infoList = list;
    }

    @Override
    public VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.information_table, parent, false));
    }

    @Override
    public void onBindViewHolder(VHolder holder, int position) {
        Information information = infoList.get(position);
        holder.tvAction.setText(information.getAction());
        holder.tvTime.setText(information.getTime());
        holder.tvDescription.setText(information.getDescription());
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    public static class VHolder extends RecyclerView.ViewHolder {
        private TextView tvAction;
        private TextView tvTime;
        private TextView tvDescription;

        public VHolder(View view) {
            super(view);
            tvAction = view.findViewById(R.id.tvAction);
            tvTime = view.findViewById(R.id.tvTime);
            tvDescription = view.findViewById(R.id.tvDescription);
        }
    }
}
