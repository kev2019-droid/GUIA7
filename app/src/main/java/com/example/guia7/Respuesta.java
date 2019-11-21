package com.example.guia7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Respuesta extends AppCompatActivity {
    private SharedPreferences Num;
    TextView respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta);
        this.Num = getSharedPreferences(Jugar.NAME_FILE,MODE_PRIVATE);
        this.respuesta = findViewById(R.id.Respuesta);
        int numero = this.Num.getInt(Jugar.KEY_ALMACENAMIENTOA,-1);
        this.respuesta.setText(String.valueOf(numero));
    }
}
