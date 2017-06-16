package com.example.admin.dta_android_sante.database.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DBOpenHelper<T extends Modele> extends SQLiteOpenHelper {

    private Modele modele;

    public DBOpenHelper(Context context, T modele, int versionDB) {
        super(context, modele.getDataBase(), null, versionDB);
        this.modele = modele;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the new database using the SQL string Database_create
        db.execSQL(modele.getCreateDataBase());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the old database
        if (oldVersion != newVersion)
            db.execSQL("DROP TABLE IF EXISTS " + modele.getTable());
        // Create the new one
        onCreate(db);
    }
}