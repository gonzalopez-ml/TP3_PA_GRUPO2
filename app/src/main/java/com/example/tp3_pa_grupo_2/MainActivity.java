package com.example.tp3_pa_grupo_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mail;
    EditText contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = (EditText) findViewById(R.id.txt_nombreUsuario);
        contra = (EditText) findViewById(R.id.txt_loginContra);
    }

    public void loguearse(View view) {
        String mailUsuario = mail.getText().toString();
        String contrasenia = contra.getText().toString();

        if(!validateMail(mailUsuario)) {
            Toast.makeText(getApplicationContext(), "Coloque un mail valido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (mailUsuario.equals("") || contrasenia.equals("")) {
            Toast.makeText(getApplicationContext(), "Debe colocar los datos de usuario y contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        AdminSqlLiteOpenHelper baseDeDatos = new AdminSqlLiteOpenHelper(this, "base_parking.db", null, 1);
        baseDeDatos.abrirBase();
        Cursor cursor = baseDeDatos.consultarUsuario(mailUsuario, contrasenia);

        if (!cursor.moveToFirst()) {
            Toast.makeText(getApplicationContext(), "Credenciales invalidas", Toast.LENGTH_SHORT).show();
            cursor.close();
            return;
        }

        Toast.makeText(getApplicationContext(), "Logueado con exito", Toast.LENGTH_SHORT).show();
        //TODO lógica que falte.

    }

    public void registrarse(View view) {
        Intent intent = new Intent(this, registrarse.class);
        startActivity(intent);
    }

    private boolean validateMail(String mail) {
        return mail.contains(".com") && mail.contains("@");
    }
}