package com.theholidayapp.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    ArrayList<MainModel> mainModels;
    Context context;
    private OnTreeListener mOntreeListener;

    public MainAdapter(Context context, ArrayList<MainModel> mainModels, OnTreeListener onTreeListener){
        this.context = context;
        this.mainModels = mainModels;
        this.mOntreeListener = onTreeListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_intem, parent, false);
        return new ViewHolder(view, mOntreeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(mainModels.get(position).getTreeLogo());
        holder.textView.setText(mainModels.get(position).getTreeName());

    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        OnTreeListener onTreeListener;

        public ViewHolder(@NonNull View itemView, OnTreeListener onTreeListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
            this.onTreeListener = onTreeListener;
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View view) {
            onTreeListener.onTreeClick(getAdapterPosition());
        }
    }

    public interface OnTreeListener{
        void onTreeClick(int position);
    }
}
