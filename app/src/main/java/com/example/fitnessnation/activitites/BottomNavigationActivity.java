package com.example.fitnessnation.activitites;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.fitnessnation.FitnessRepository;
import com.example.fitnessnation.R;
import com.example.fitnessnation.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BottomNavigationActivity extends AppCompatActivity {
    public static User user;

    public static FitnessRepository fitnessRepository;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        user= (User) getIntent().getSerializableExtra("user");
        Toast.makeText(this, user.getUsername(), Toast.LENGTH_SHORT).show();

        fitnessRepository = new FitnessRepository(getApplicationContext());
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_statistics, R.id.navigation_profile, R.id.navigation_notifications,R.id.navigation_meal).build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }




}
