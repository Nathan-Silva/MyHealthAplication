package com.myhealthaplication.myhealthaplication.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LembreteHelper extends SQLiteOpenHelper {

    public static final String BANCO = "dbLembrete";
    public static final String TABELA = "TB_lEMBRETE";
    public static final String ID = "id";
    public static final String TITULO = "titulo";
    public static final String CONTEUDO = "conteudo";
    public static final String DATA = "data";
    public static final String HORA = "hora";
    public static final int VERSION = 1;


    public LembreteHelper(Context context) {
        super(context, BANCO, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+" (" +
                ID + " integer primary key autoincrement," +
                TITULO+" text," +
                CONTEUDO+" text," +
                DATA + " text," +
                HORA + " text" +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABELA);
        onCreate(db);
    }
}
