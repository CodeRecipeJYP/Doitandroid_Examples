package com.asuscomm.yangyinetwork.doitandroid_examples.services.db.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.asuscomm.yangyinetwork.doitandroid_examples.models.Chat;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by jaeyoung on 2017. 6. 18..
 */

public class OrmHelper extends OrmLiteSqliteOpenHelper {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();
    private static final String DB_NAME = "doitandroid.db";
    private static final int DB_VERSION = 2;

    private Dao<Chat, Integer> chatDao = null;
    private RuntimeExceptionDao<Chat, Integer> chatRuntimeDao = null;

    public OrmHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.d(TAG, "onCreate: ");
            TableUtils.createTable(connectionSource, Chat.class);
        } catch (SQLException e) {
            Log.e(TAG, "onCreate: ", e);
            e.printStackTrace();
        }

        RuntimeExceptionDao<Chat, Integer> dao = getChatDao();
        Chat chat = new Chat(false, "JYP", "stubs");
        dao.create(chat);
        chat = new Chat(false, "JYP", "stubs2");
        dao.create(chat);
        Log.d(TAG, "onCreate: insert stubs");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Chat.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Chat, Integer> getDao() throws SQLException {
        if (chatDao == null) {
            chatDao = getDao(Chat.class);
        }
        return chatDao;
    }

    public RuntimeExceptionDao<Chat, Integer> getChatDao() {
        if (chatRuntimeDao == null) {
            chatRuntimeDao = getRuntimeExceptionDao(Chat.class);
        }
        return chatRuntimeDao;
    }

    @Override
    public void close() {
        super.close();
        chatDao = null;
        chatRuntimeDao = null;
    }
}
