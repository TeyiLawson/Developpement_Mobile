package utils;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class DbAccess extends SQLiteOpenHelper {

    private SQLiteDatabase database;
    public DbAccess(@Nullable Context context) {
        super(context, "ContactDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Contact ( ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NOM VARCHAR(30)," +
                "PRENOM VARCHAR(60)," +
                "TELEPHONE VARCHAR(8)" +
                ")");
        database = db;

    }

    public SQLiteDatabase getDatabase() {
        return this.getWritableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
