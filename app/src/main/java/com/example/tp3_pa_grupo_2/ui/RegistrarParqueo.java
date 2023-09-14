package com.example.tp3_pa_grupo_2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp3_pa_grupo_2.AdminSqlLiteOpenHelper;
import com.example.tp3_pa_grupo_2.MainActivity;
import com.example.tp3_pa_grupo_2.Parking;
import com.example.tp3_pa_grupo_2.R;

public class RegistrarParqueo extends AppCompatActivity {

    EditText id_usuario;
    EditText matricula;
    EditText tiempo;
    Button registrar;
    Button cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_agregar_registro);

        matricula = (EditText) findViewById(R.id.txt_matricula);
        tiempo = (EditText) findViewById(R.id.txt_tiempo);
        registrar = (Button) findViewById(R.id.btnRegistrar);
        cancelar = (Button)  findViewById(R.id.btnCancelar);
    }

    public void registrarParqueo(View view) {

        if (validarParqueo(matricula.getText().toString(), tiempo.getText().toString())) {
            Parking parqueo = new Parking(matricula.getText().toString(), tiempo.getText().toString());

            AdminSqlLiteOpenHelper baseDeDatos = new AdminSqlLiteOpenHelper(this, "base_parking.db", null, 1);

            baseDeDatos.abrirBase();
            Long resultado = baseDeDatos.insertarParqueo(parqueo);

            if (resultado != -1) {
                Toast.makeText(getApplicationContext(), "Parqueo registrado con exito", Toast.LENGTH_SHORT).show();
                baseDeDatos.cerrarBase();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Intente nuevamente", Toast.LENGTH_SHORT).show();
            }

        }

        Toast.makeText(getApplicationContext(), "Error, validar los datos", Toast.LENGTH_SHORT).show();
    }

    public void cancelarParqueo(View view) {
        finish();
    }
    private Boolean validarParqueo(String matricula, String tiempo) {
        if (matricula.equals("") || tiempo.equals("")) {
            return false;
        }
        else {
            return true;
        }
    }



}
