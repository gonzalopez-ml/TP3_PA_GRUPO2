package com.example.tp3_pa_grupo_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registrarse extends AppCompatActivity {

    EditText nombre;
    EditText mail;
    EditText contra;
    EditText contraRepetida;
    Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        nombre = (EditText) findViewById(R.id.txt_nombre);
        mail = (EditText) findViewById(R.id.txt_mail);
        contra = (EditText) findViewById(R.id.txt_contra);
        contraRepetida = (EditText) findViewById(R.id.txt_contraRepetida);
        aceptar = (Button) findViewById(R.id.btn_aceptar);
    }

    public void registrarUsuario(View view) {
        if(!validateMail(mail.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Coloque un mail valido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (validarUsuario(nombre.getText().toString(), mail.getText().toString(), contra.getText().toString(), contraRepetida.getText().toString())) {
            Contacto contacto = new Contacto(nombre.getText().toString(), contra.getText().toString(), mail.getText().toString());

            AdminSqlLiteOpenHelper baseDeDatos = new AdminSqlLiteOpenHelper(this, "base_parking.db", null, 1);

            baseDeDatos.abrirBase();
            Long resultado = baseDeDatos.insertar(contacto);

            if (resultado != -1) {
                Toast.makeText(getApplicationContext(), "Usuario almacenado con exito", Toast.LENGTH_SHORT).show();
                baseDeDatos.cerrarBase();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Intente nuevamente", Toast.LENGTH_SHORT).show();
            }

        }

        Toast.makeText(getApplicationContext(), "Error, validar los datos", Toast.LENGTH_SHORT).show();
    }

    private Boolean validarUsuario(String nombre, String mail, String contra, String contraRepetida) {
        if (nombre.equals("") || mail.equals("") || contra.equals("")) {
            return false;
        } else return contra.equals(contraRepetida);
    }

    private boolean validateMail(String mail) {
        return mail.contains(".com") && mail.contains("@");
    }
}