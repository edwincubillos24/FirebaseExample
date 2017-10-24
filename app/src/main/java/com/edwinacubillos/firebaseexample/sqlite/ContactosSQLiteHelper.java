package com.edwinacubillos.firebaseexample.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by edwin on 24/10/17.
 */

public class ContactosSQLiteHelper extends SQLiteOpenHelper {

    private String DATA_BASE_NAME="agendaBD";
    private int DATA_VERSION=1;

    private String sqlCreate = "CREATE TABLE contactos (" +
            "id         INTEGER PRIMARY KEY AUTOINCREMENT," + //0
            "nombre     TEXT," + //1
            "telefono   TEXT," + //2
            "correo     TEXT)"; //3

    public ContactosSQLiteHelper(Context context, String name,
                                 SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contactos");
        db.execSQL(sqlCreate);

    }
}
