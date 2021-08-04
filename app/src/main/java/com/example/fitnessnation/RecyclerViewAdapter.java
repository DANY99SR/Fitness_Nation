package com.example.fitnessnation;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessnation.activitites.FoodActivity;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Meal> mealList;


    public RecyclerViewAdapter(List<Meal> mealList)
    {
        this.mealList = mealList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_meal,parent,false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.food_name.setText(mealList.get(position).getName());
        holder.food_image.setImageResource(mealList.get(position).getImagePath());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context=v.getContext();
               Intent intent=new Intent(context, FoodActivity.class);
                intent.putExtra("Meal",mealList.get(position));

               context.startActivity(intent);


            }
        }) ;
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder {


            TextView food_name;
            ImageView food_image;
            CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                food_name=(TextView) itemView.findViewById(R.id.nameFood);
                food_image=(ImageView) itemView.findViewById(R.id.imageFood);
                cardView=(CardView)itemView.findViewById(R.id.cardview);
            }
        }


}
