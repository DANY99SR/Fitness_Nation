package com.example.fitnessnation;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MealDao {

    @Insert
    public void addMeal(Meal meal);

    @Query("select * from meals where meal_choice=0")
    public List<Meal> getWLossMeals();

    @Query("select * from meals where meal_choice=1")
    public List<Meal> getWGainMeals();

    @Delete
    public void deleteUser(Meal meal);

    @Insert
    void insertAll(Meal... meals);
}