package com.example.fitnessnation;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "users")
public class User implements Serializable {//serializable is for passing the object to the next activity
    public User(String name, int weight, int height, String pass, boolean choice,String gender, int goal) {
        this.username=name;
        this.weight = weight;
        this.height = height;
        this.password = pass;
        this.weightChoice=choice;
        this.gender=gender;
        this.goalWeight=goal;
    }
    public User() {


    }

    @PrimaryKey
    @NonNull

    @ColumnInfo(name = "user_username")
    private String username;


    @ColumnInfo(name = "user_weight")
    private int weight=0;

    @ColumnInfo(name = "user_height")
    private int height=0;

    @ColumnInfo(name = "user_password")
    private String password;

    @ColumnInfo(name = "user_gender")
    private String gender="nothing";

    @ColumnInfo(name = "user_weight_choice")
   protected boolean weightChoice;//1 is weight gain 0 is weight loss

    @ColumnInfo(name = "user_goal_weight")
    private int goalWeight=0;


    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public int getWeight() { return weight; }
    public int getHeight() {return height; }
    public int getGoalWeight() {return goalWeight; }
    public String getGender() {return gender; }
    public boolean getChoice() {return weightChoice; }


    public void setUsername(String username) {
        this.username = username;
    }
    public void setGender(String gender) {this.gender=gender; }
    public void setPassword(String password) {this.password = password; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setGoalWeight(int goalWeight) { this.goalWeight = goalWeight; }
    public void setHeight(int height) {this.height=height; }
    public void setChoice(boolean choice) {this.weightChoice=choice; }


}
