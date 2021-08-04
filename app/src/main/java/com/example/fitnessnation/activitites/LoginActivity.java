package com.example.fitnessnation.activitites;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnessnation.AppDatabase;
import com.example.fitnessnation.ApplicationController;
import com.example.fitnessnation.FitnessRepository;
import com.example.fitnessnation.Meal;
import com.example.fitnessnation.R;
import com.example.fitnessnation.fragments.MenuLoginFragment;

public class LoginActivity extends AppCompatActivity {


    public static FitnessRepository fitnessRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fitnessRepository=new FitnessRepository(getApplicationContext());
        //fitnessRepository.mealInsertTask(Meal.populateData());



        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.primary_frame_s_session, MenuLoginFragment.newInstance()).commitNow();
        }



    }





}
