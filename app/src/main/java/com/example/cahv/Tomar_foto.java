package com.example.cahv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.IOException;
public class Tomar_foto extends AppCompatActivity {

    private Button fabCamara;
    private ImageView ImagenTomada;
    private String rutaImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomar_foto);

        fabCamara = findViewById(R.id.MiniMenuTomarFoto);
        ImagenTomada = findViewById(R.id.IVFotoTomada);

        fabCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCamara();
            }
        });
    }

    private void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivityForResult(intent,1);
            File imagenArchivo = null;
            try
            {
                imagenArchivo = crearImagen();
            }catch (IOException ex)
            {
                Log.e("Error ", ex.toString());
            }

            if(imagenArchivo != null)
            {
                Uri fotoUri = FileProvider.getUriForFile(Tomar_foto.this, "com.example.CAHV.fileprovider",imagenArchivo);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            //Bundle extras = data.getExtras();
            Bitmap imgBitMap = BitmapFactory.decodeFile(rutaImagen);
            ImagenTomada.setImageBitmap(imgBitMap);
            Toast.makeText(this, "Foto tomada con éxito", Toast.LENGTH_SHORT).show();
        }
    }

    private File crearImagen() throws IOException {
        String nombreImagen = "IMG_";
        File directorio = getExternalFilesDir("FOTOS_APP");
        File imagen = File.createTempFile(nombreImagen,".jpg",directorio);
        rutaImagen = imagen.getAbsolutePath();
        return imagen;
    }

}