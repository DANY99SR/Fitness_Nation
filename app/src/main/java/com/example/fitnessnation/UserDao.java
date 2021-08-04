package com.example.fitnessnation;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public void addUser(User user);

    @Query("select * from users")
    public List<User> getUsers();

    @Query("select * from users where user_username=:name")
    public User getUserByName(String name);

    @Delete
    public void deleteUser(User user);

    @Query("update users SET user_weight=:weight, user_goal_weight=:goal WHERE user_username=:name")
    public void updateUser(int weight, int goal, String name);


}