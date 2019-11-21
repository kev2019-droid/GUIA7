package com.example.guia7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import Entidades.Jugador;

public class MainActivity extends AppCompatActivity {
    public static List<Jugador> listacontacto = new ArrayList<>();
    public static final String KEY_ALMACENAMIENTOLISTA="LISTA";
    public static final String NAME_FILE_LISTA= "CONFIGURACIONLISTA";
    private SharedPreferences configuracion;
    private SharedPreferences lista;
    private String valor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.configuracion = this.getSharedPreferences(Jugar.NAME_FILE, MODE_PRIVATE);
        this.lista = this.getSharedPreferences(NAME_FILE_LISTA,MODE_PRIVATE);
        validarConfig();

    }
    public void validarConfig(){
        int config = this.configuracion.getInt(Jugar.KEY_ALMACENAMIENTOA,-1);
        if(config == -1){
            Toast.makeText(this,"Aun no se ha generado el numero pulse 'Jugar' para generarlo y jugar", Toast.LENGTH_LONG).show();
        }
    }
    public void Juego(View v){
        Intent nu = new Intent(this,Jugar.class);
        startActivity(nu);
    }
    public void Respuesta(View v){
        int cont = this.configuracion.getInt(Jugar.KEY_ALMACENAMIENTOA,-1);

        if(cont == -1){
            Toast.makeText(this,"Aun no se ha generado el numero pulse 'Jugar' para generarlo y jugar", Toast.LENGTH_LONG).show();
        }
        else{
            Intent res = new Intent(this,Respuesta.class);
            startActivity(res);
        }


    }
    public void ver_puntajes(View v){
        valor = this.lista.getString(KEY_ALMACENAMIENTOLISTA,null);
        if (valor != null) {
            SharedPreferences.Editor editn = this.lista.edit();
            Gson gson = new Gson();
            String json = gson.toJson(listacontacto);
            editn.putString(KEY_ALMACENAMIENTOLISTA,json);
            editn.commit();
            Intent nn = new Intent(this, Ver_Puntaje.class);
            startActivity(nn);

        } else {

            Toast.makeText(this, "Aun no hay Puntajes", Toast.LENGTH_SHORT).show();
        }
    }
    public void misdatos(View v){
        Intent vt = new Intent(this, Mis_Datos.class);
        startActivity(vt);
    }
}
