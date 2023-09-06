package com.example.tp3_pa_grupo_2;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//Esta clase es para crear la base de datos
public class AdminSqlLiteOpenHelper extends SQLiteOpenHelper {

    private static final String USUARIO_TABLA = "create table users (_ID integer primary key autoincrement, name text not null, mail text not null unique, contra text not null)";

    private static final String PARKING_TABLA = "CREATE TABLE parkings " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "user_id INTEGER NOT NULL, " +
            "matricula TEXT NOT NULL, " +
            "tiempo TEXT NOT NULL, " +
            "FOREIGN KEY (user_id) REFERENCES users (id))";

    public AdminSqlLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase baseDeDatos) {
        baseDeDatos.execSQL(USUARIO_TABLA);
        baseDeDatos.execSQL(PARKING_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void abrirBase() {
        this.getWritableDatabase();
    }

    public void cerrarBase() {
        this.close();
    }

    //CONTENT VALUES
    public Long insertar(Contacto contacto) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", contacto.getNombre());
        contentValues.put("mail", contacto.getMail());
        contentValues.put("contra", contacto.getContra());

        Long restulado = this.getWritableDatabase().insert("users", null, contentValues);
        return restulado;
    }

    public Cursor consultarUsuario(String mail, String contra) throws SQLException {
        Cursor mcursor = null;
        mcursor = this.getWritableDatabase().query(
                "users",
                new String[]{"name", "mail"},
                "mail = ? AND contra = ?",
                new String[]{mail, contra},
                null,
                null,
                null
        );
        return mcursor;
    }
}
