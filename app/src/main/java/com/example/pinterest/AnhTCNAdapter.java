package com.example.pinterest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnhTCNAdapter extends RecyclerView.Adapter<AnhTCNAdapter.AnhTCNViewHoldel> {
    private List<Anhtrangcanhan> mlistAnhTCN;

    public void setData(List<Anhtrangcanhan> list){
        this.mlistAnhTCN= list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public AnhTCNViewHoldel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anhtrangcanhan,parent,false);
        return new AnhTCNViewHoldel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnhTCNViewHoldel holder, int position) {
Anhtrangcanhan anhtrangcanhan=mlistAnhTCN.get(position);
    if(anhtrangcanhan==null){
        return;
    }
    holder.anhview.setImageResource(anhtrangcanhan.getId());


    }

    @Override
    public int getItemCount() {
        if( mlistAnhTCN!= null){
            return mlistAnhTCN.size();
        }
        return 0;
    }

    public class AnhTCNViewHoldel extends RecyclerView.ViewHolder {
        private ImageView anhview;

        public AnhTCNViewHoldel(@NonNull View itemView) {
            super(itemView);
            anhview= itemView.findViewById(R.id.anhtcn);

        }
    }
}
