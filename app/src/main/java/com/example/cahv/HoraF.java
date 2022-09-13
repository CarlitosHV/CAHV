package com.example.cahv;

import androidx.lifecycle.ViewModelProvider;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class HoraF extends Fragment {

    Handler handler = new Handler();
    private final int TIEMPO = 500;
    TextView reloj;

    public static HoraF newInstance() {
        return new HoraF();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_horaf, container, false);
        reloj = root.findViewById(R.id.reloj);
        actualizarReloj();

        return root;
    }


    public void actualizarReloj (){
        handler.postDelayed(new Runnable() {
            public void run() {
                DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern("hh:mm:ss");
                String hora = simpleDateFormat.format(LocalDateTime.now());
                reloj.setText(hora);
                handler.postDelayed(this, TIEMPO);
            }
        }, TIEMPO);
    }

}