package com.example.cahv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class Bienvenida extends AppCompatActivity {

    ImageView salir, acercade, television, linterna, fotos, pestanias, galeria;
    int band = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        acercade = findViewById(R.id.btnAcercade);
        acercade.setOnClickListener(view -> getCreditos());

        television = findViewById(R.id.btnTelevision);
        television.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), Television.class);
            startActivity(intent);
        });

        fotos = findViewById(R.id.btnCamara);
        fotos.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), Tomar_foto.class);
            startActivity(intent);
        });

        linterna = findViewById(R.id.btnLinterna);
        linterna.setOnClickListener(view -> {
            CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            String cameraId = null;
            if (band == 1){
                try {
                    cameraId = camManager.getCameraIdList()[0];
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
                try {
                    camManager.setTorchMode(cameraId, false);
                    band = 0;
                    linterna.setBackgroundResource(R.drawable.antorchaoff);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    cameraId = camManager.getCameraIdList()[0];
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
                try {
                    camManager.setTorchMode(cameraId, true);
                    band = 1;
                    linterna.setBackgroundResource(R.drawable.antorchaon);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        pestanias = findViewById(R.id.btnPestanias);
        pestanias.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), Pestanias.class);
            startActivity(intent);
        });

        galeria = findViewById(R.id.btnGaleria);
        galeria.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), Galeria.class);
            startActivity(intent);
        });


        salir = findViewById(R.id.btnSalir);
        salir.setOnClickListener(view -> {
            Toast.makeText(Bienvenida.this, "¡Adiós!", Toast.LENGTH_SHORT).show();
            finishAffinity();
        });
    }

    public void getCreditos(){
        new AlertDialog.Builder(this).setTitle("Acerca de").setMessage("" + "Carlos Alberto Hernández Velázquez \n"
                + "Profesora: Rocío Elizabeth Pulido Alba\n" + "Programación Android :D \n" + "Examen Primer Parcial\n" + "Versión 1.1").setPositiveButton("Aceptar", null).show();
    }
}