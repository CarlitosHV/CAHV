package com.example.cahv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button btnacceso, btnsalir;
    ToggleButton btnmodo;
    TextView usuario, contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        usuario = findViewById(R.id.CajaUsuario);
        contrasena = findViewById(R.id.CajaContrasena);

        btnacceso = findViewById(R.id.btnAcceder);
        btnacceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usuario.getText().toString().equals("DM1p22B") && contrasena.getText().toString().equals("Carlos")){
                    Intent intent = new Intent(view.getContext(), Bienvenida.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
                    usuario.setText("");
                    contrasena.setText("");
                }
            }
        });

        btnsalir = findViewById(R.id.btnCerrar);
        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "¡Hasta pronto!", Toast.LENGTH_SHORT).show();
                finishAffinity();
            }
        });

        btnmodo = findViewById(R.id.modooscuro);
        btnmodo.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });
    }
}