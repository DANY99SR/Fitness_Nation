package com.example.fitnessnation;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class MealDao_Impl implements MealDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfMeal;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfMeal;

  public MealDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMeal = new EntityInsertionAdapter<Meal>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `meals`(`meal_name`,`meal_type`,`meal_image`,`meal_calorie`,`meal_choice`,`meal_description`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Meal value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getType() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getType());
        }
        stmt.bindLong(3, value.getImagePath());
        stmt.bindLong(4, value.getCalorie());
        final int _tmp;
        _tmp = value.getChoice() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        if (value.getDescription() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDescription());
        }
      }
    };
    this.__deletionAdapterOfMeal = new EntityDeletionOrUpdateAdapter<Meal>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `meals` WHERE `meal_name` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Meal value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
      }
    };
  }

  @Override
  public void addMeal(final Meal meal) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfMeal.insert(meal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final Meal... meals) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfMeal.insert(meals);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteUser(final Meal meal) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfMeal.handle(meal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Meal> getWLossMeals() {
    final String _sql = "select * from meals where meal_choice=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = DBUtil.query(__db, _statement, false);
    try {
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "meal_name");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "meal_type");
      final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "meal_image");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "meal_calorie");
      final int _cursorIndexOfChoice = CursorUtil.getColumnIndexOrThrow(_cursor, "meal_choice");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "meal_description");
      final List<Meal> _result = new ArrayList<Meal>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Meal _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        final int _tmpImagePath;
        _tmpImagePath = _cursor.getInt(_cursorIndexOfImagePath);
        final int _tmpCalorie;
        _tmpCalorie = _cursor.getInt(_cursorIndexOfCalorie);
        final boolean _tmpChoice;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfChoice);
        _tmpChoice = _tmp != 0;
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _item = new Meal(_tmpName,_tmpType,_tmpImagePath,_tmpCalorie,_tmpDescription,_tmpChoice);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Meal> getWGainMeals() {
    final String _sql = "select * from meals where meal_choice=1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = DBUtil.query(__db, _statement, false);
    try {
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "meal_name");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "meal_type");
      final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "meal_image");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "meal_calorie");
      final int _cursorIndexOfChoice = CursorUtil.getColumnIndexOrThrow(_cursor, "meal_choice");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "meal_description");
      final List<Meal> _result = new ArrayList<Meal>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Meal _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        final int _tmpImagePath;
        _tmpImagePath = _cursor.getInt(_cursorIndexOfImagePath);
        final int _tmpCalorie;
        _tmpCalorie = _cursor.getInt(_cursorIndexOfCalorie);
        final boolean _tmpChoice;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfChoice);
        _tmpChoice = _tmp != 0;
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _item = new Meal(_tmpName,_tmpType,_tmpImagePath,_tmpCalorie,_tmpDescription,_tmpChoice);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
