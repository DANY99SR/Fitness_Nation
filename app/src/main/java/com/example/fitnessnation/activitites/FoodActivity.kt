package com.example.fitnessnation.activitites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnessnation.Meal
import com.example.fitnessnation.R
import kotlinx.android.synthetic.main.activity_food.*

class FoodActivity : AppCompatActivity() {

   private var meal: Meal? =null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        meal=intent.getSerializableExtra("Meal") as Meal;

        foodName.setText(meal!!.getName());
        foodImage.setImageResource(meal!!.getImagePath());
        calorie.setText("Calorie: "+meal!!.getCalorie().toString());
       description.setText(meal!!.getDescription());
    }
}
