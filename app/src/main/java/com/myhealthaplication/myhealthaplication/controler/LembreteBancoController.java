package com.myhealthaplication.myhealthaplication.controler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.myhealthaplication.myhealthaplication.entidades.Lembretes;
import com.myhealthaplication.myhealthaplication.helper.LembreteHelper;

public class LembreteBancoController {

    private SQLiteDatabase db;
    private LembreteHelper lembreteHelper;

    public LembreteBancoController(Context context) {
        this.lembreteHelper = new LembreteHelper(context);
    }

    public boolean add(Lembretes lembretes) {
        ContentValues valores;
        long resultado;
        this.db = lembreteHelper.getWritableDatabase();
        valores = new ContentValues();
        valores.put(LembreteHelper.TITULO, lembretes.getTitulo());
        valores.put(LembreteHelper.CONTEUDO, lembretes.getConteudo());
        valores.put(LembreteHelper.DATA, lembretes.getData());
        valores.put(LembreteHelper.HORA, lembretes.getHora());

        resultado = db.insert(LembreteHelper.TABELA, null, valores);
        db.close();

        return resultado != -1;

    }

    public Cursor getAll() {
        Cursor cursor;
        String[] campos = {
                LembreteHelper.ID, LembreteHelper.TITULO, LembreteHelper.CONTEUDO, LembreteHelper.DATA, LembreteHelper.HORA
        };
        cursor = this.db.query(LembreteHelper.TABELA, campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor getById(Integer id) {
        Cursor cursor;
        String[] campos = {
                LembreteHelper.ID, LembreteHelper.TITULO, LembreteHelper.CONTEUDO, LembreteHelper.DATA, LembreteHelper.HORA
        };
        String where = LembreteHelper.ID + "=" + id;
        this.db = lembreteHelper.getReadableDatabase();
        cursor = this.db.query(LembreteHelper.ID, campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        this.db.close();
        return cursor;
    }

    public void update(Lembretes lembretes) {
        ContentValues valores;
        String where;

        this.db = lembreteHelper.getWritableDatabase();

        where = LembreteHelper.ID + "=" + lembretes.getId();

        valores = new ContentValues();
        valores.put(LembreteHelper.TITULO, lembretes.getTitulo());
        valores.put(LembreteHelper.CONTEUDO, lembretes.getConteudo());
        valores.put(LembreteHelper.DATA, lembretes.getData());
        valores.put(LembreteHelper.HORA, lembretes.getHora());

        this.db.update(LembreteHelper.TABELA, valores, where, null);
        this.db.close();
    }

    public void remove(Integer id) {
        String where = LembreteHelper.ID + "=" + id;
        this.db = lembreteHelper.getReadableDatabase();
        this.db.delete(LembreteHelper.TABELA, where, null);
        this.db.close();
    }
}
