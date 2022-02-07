package com.example.pinterest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GhimAdapter extends RecyclerView.Adapter<GhimAdapter.GhimViewHoldel> {
    private List<Ghim> mlistGhim;

    public void setData(List<Ghim> list) {
        this.mlistGhim = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GhimViewHoldel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ghim, parent, false);
        return new GhimViewHoldel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GhimViewHoldel holder, int position) {
        Ghim ghim = mlistGhim.get(position);
        if (ghim == null) {
            return;
        }
        holder.ghimview.setImageResource(ghim.getId());
        holder.textghim.setText(ghim.getName());

    }

    @Override
    public int getItemCount() {
        if (mlistGhim != null) {
            return mlistGhim.size();
        }
        return 0;
    }

    public class GhimViewHoldel extends RecyclerView.ViewHolder {
        private ImageView ghimview;
        private TextView textghim;

        public GhimViewHoldel(@NonNull View itemView) {
            super(itemView);
            ghimview = itemView.findViewById(R.id.ah);
            textghim = itemView.findViewById(R.id.ghimtext);
        }
    }
}
