package com.suphan.landmarkbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suphan.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {

    ArrayList<Landmark> allLandMarkList;

    public LandmarkAdapter(ArrayList<Landmark> allLandMarkList) {
        this.allLandMarkList = allLandMarkList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, int position) {

    holder.binding.recyclerViewTextView.setText(allLandMarkList.get(position).name);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(holder.itemView.getContext(),DetailActivity.class);
            intent.putExtra("landMark",allLandMarkList.get(holder.getAdapterPosition()));
            holder.itemView.getContext().startActivity(intent);
        }
    });

    }

    @Override
    public int getItemCount() {
        return allLandMarkList.size();
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder{

        private RecyclerRowBinding binding;

        public LandmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }


}
