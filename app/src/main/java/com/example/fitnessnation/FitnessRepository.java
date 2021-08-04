package com.example.fitnessnation;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class FitnessRepository {

    private AppDatabase appDatabase;

    public FitnessRepository(Context context) {
        appDatabase = ApplicationController.getAppDatabase();
    }

    public void mealInsertTask(final Meal meal[])   {
        new MealInsertTask().execute(meal);
    }

    public void updateUser(int weight, int goal, String name) {
        new UpdateUserTask(weight, goal, name).execute();
    }
    public void addUserTask(final User user)   {
        new AddUserTask().execute(user);
    }

    public List<Meal> getWLossMealsTask() throws ExecutionException, InterruptedException {
        return new GetWLossMealsTask().execute().get();
    }

    public List<Meal> getWGainMealsTask() throws ExecutionException, InterruptedException {
        return new GetWGainMealsTask().execute().get();
    }

    public List<User> getUsersTask() throws ExecutionException, InterruptedException {
        return  new GetUsersTask().execute().get();
    }

    public User getUserByNameTask(final String name) throws ExecutionException, InterruptedException {
        return  new GetUserByNameTask().execute(name).get();
    }

    private class MealInsertTask extends AsyncTask<Meal, Void, Void> {

        // OnFitnessRepositoryActionListener listener;

        @Override
        protected Void doInBackground(Meal...meal) {
            appDatabase.mealDao().insertAll(meal);
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //    listener.actionSuccess();
        }


    }


    private class UpdateUserTask extends AsyncTask<Void, Void, Void> {
        int weight;
        int goal;
        String name;

        UpdateUserTask(int w,int g,String n)
        {
            this.weight=w;
            this.goal=g;
            this.name=n;
        }

        @Override
        protected Void doInBackground(Void...params) {
            appDatabase.userDao().updateUser(weight,goal,name);
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //    listener.actionSuccess();
        }


    }


    private class GetWLossMealsTask extends AsyncTask<Void, Void, List<Meal>> {

        @Override
        protected List<Meal>  doInBackground(Void...params) {
            return  appDatabase.mealDao().getWLossMeals();
        }

        @Override
        protected void onPostExecute(List<Meal> meal) {
            super.onPostExecute(meal);
        }
    }

    private class GetWGainMealsTask extends AsyncTask<Void, Void, List<Meal>> {

        @Override
        protected List<Meal>  doInBackground(Void...params) {
            return  appDatabase.mealDao().getWGainMeals();

        }

        @Override
        protected void onPostExecute(List<Meal> meal) {
            super.onPostExecute(meal);
            //    listener.actionSuccess();
        }
    }

    private class GetUsersTask extends AsyncTask<Void, Void, List<User>> {

        @Override
        protected List<User>  doInBackground(Void...params) {
            return  appDatabase.userDao().getUsers();

        }

        @Override
        protected void onPostExecute(List<User> user) {
            super.onPostExecute(user);
            //    listener.actionSuccess();
        }
    }

    private class GetUserByNameTask extends AsyncTask<String, Void, User> {

        @Override
        protected User  doInBackground(String...params) {
            return  appDatabase.userDao().getUserByName(params[0]);

        }

        @Override
        protected void onPostExecute(User user) {
            super.onPostExecute(user);
            //    listener.actionSuccess();
        }
    }


    private class AddUserTask extends AsyncTask<User, Void, Void> {


        @Override
        protected Void doInBackground(User... users) {
            appDatabase.userDao().addUser(users[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }


}



