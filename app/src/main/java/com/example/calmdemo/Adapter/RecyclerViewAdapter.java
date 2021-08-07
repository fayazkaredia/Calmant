package com.example.calmdemo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.calmdemo.Interface.ItemClickListener;
import com.example.calmdemo.Model.Exercise;
import com.example.calmdemo.R;
import com.example.calmdemo.ViewExerciseActivity;

import java.util.List;

/**
 * Created by James Sarkar.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Exercise> exerciseList;

    private Context context;

    public RecyclerViewAdapter(List<Exercise> exerciseList, Context context) {
        this.exerciseList = exerciseList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View itemView = inflater.inflate(R.layout.item_exercise, parent, false);

        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.image.setImageResource(exerciseList.get(position).getImageId());
        holder.name.setText(exerciseList.get(position).getName());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                // Call new activity
                Intent intent1=new Intent(context,ViewExerciseActivity.class);
                intent1.putExtra("imageId", exerciseList.get(position).getImageId());
                intent1.putExtra("name", exerciseList.get(position).getName());
              intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }
}

class RecyclerViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener{

    ImageView image;

    TextView name;

    private ItemClickListener itemClickListener;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        image = (ImageView) itemView.findViewById(R.id.exercise_image);
        name = (TextView) itemView.findViewById(R.id.exercise_name);

        itemView.setOnClickListener(this);
    }

    void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition());
    }
}
