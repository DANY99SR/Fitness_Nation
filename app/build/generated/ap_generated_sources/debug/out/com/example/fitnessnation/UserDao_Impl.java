package com.example.fitnessnation;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfUser;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUser;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `users`(`user_username`,`user_weight`,`user_height`,`user_password`,`user_gender`,`user_weight_choice`,`user_goal_weight`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getUsername() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUsername());
        }
        stmt.bindLong(2, value.getWeight());
        stmt.bindLong(3, value.getHeight());
        if (value.getPassword() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPassword());
        }
        if (value.getGender() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getGender());
        }
        final int _tmp;
        _tmp = value.weightChoice ? 1 : 0;
        stmt.bindLong(6, _tmp);
        stmt.bindLong(7, value.getGoalWeight());
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `users` WHERE `user_username` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getUsername() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUsername());
        }
      }
    };
    this.__preparedStmtOfUpdateUser = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update users SET user_weight=?, user_goal_weight=? WHERE user_username=?";
        return _query;
      }
    };
  }

  @Override
  public void addUser(final User user) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteUser(final User user) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUser(final int weight, final int goal, final String name) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUser.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, weight);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, goal);
    _argIndex = 3;
    if (name == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, name);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateUser.release(_stmt);
    }
  }

  @Override
  public List<User> getUsers() {
    final String _sql = "select * from users";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = DBUtil.query(__db, _statement, false);
    try {
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "user_username");
      final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "user_weight");
      final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "user_height");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "user_password");
      final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "user_gender");
      final int _cursorIndexOfWeightChoice = CursorUtil.getColumnIndexOrThrow(_cursor, "user_weight_choice");
      final int _cursorIndexOfGoalWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "user_goal_weight");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        _item = new User();
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _item.setUsername(_tmpUsername);
        final int _tmpWeight;
        _tmpWeight = _cursor.getInt(_cursorIndexOfWeight);
        _item.setWeight(_tmpWeight);
        final int _tmpHeight;
        _tmpHeight = _cursor.getInt(_cursorIndexOfHeight);
        _item.setHeight(_tmpHeight);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _item.setPassword(_tmpPassword);
        final String _tmpGender;
        _tmpGender = _cursor.getString(_cursorIndexOfGender);
        _item.setGender(_tmpGender);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfWeightChoice);
        _item.weightChoice = _tmp != 0;
        final int _tmpGoalWeight;
        _tmpGoalWeight = _cursor.getInt(_cursorIndexOfGoalWeight);
        _item.setGoalWeight(_tmpGoalWeight);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User getUserByName(final String name) {
    final String _sql = "select * from users where user_username=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    final Cursor _cursor = DBUtil.query(__db, _statement, false);
    try {
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "user_username");
      final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "user_weight");
      final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "user_height");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "user_password");
      final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "user_gender");
      final int _cursorIndexOfWeightChoice = CursorUtil.getColumnIndexOrThrow(_cursor, "user_weight_choice");
      final int _cursorIndexOfGoalWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "user_goal_weight");
      final User _result;
      if(_cursor.moveToFirst()) {
        _result = new User();
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _result.setUsername(_tmpUsername);
        final int _tmpWeight;
        _tmpWeight = _cursor.getInt(_cursorIndexOfWeight);
        _result.setWeight(_tmpWeight);
        final int _tmpHeight;
        _tmpHeight = _cursor.getInt(_cursorIndexOfHeight);
        _result.setHeight(_tmpHeight);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _result.setPassword(_tmpPassword);
        final String _tmpGender;
        _tmpGender = _cursor.getString(_cursorIndexOfGender);
        _result.setGender(_tmpGender);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfWeightChoice);
        _result.weightChoice = _tmp != 0;
        final int _tmpGoalWeight;
        _tmpGoalWeight = _cursor.getInt(_cursorIndexOfGoalWeight);
        _result.setGoalWeight(_tmpGoalWeight);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
