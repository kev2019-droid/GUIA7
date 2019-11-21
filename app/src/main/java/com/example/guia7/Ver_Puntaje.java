package com.example.guia7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.guia7.MainActivity.KEY_ALMACENAMIENTOLISTA;
import static com.example.guia7.MainActivity.listacontacto;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import Adaptadores.Adaptader;
import Entidades.Jugador;

public class Ver_Puntaje extends AppCompatActivity {
    SharedPreferences nulista;
    RecyclerView recycler;
    List<Jugador> datasource = new ArrayList<>();
    LinearLayoutManager manager;
    Adaptader adaptadorobjeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver__puntaje);
        recycler = findViewById(R.id.rcvPuntajes);
        this.nulista = getSharedPreferences(MainActivity.NAME_FILE_LISTA,MODE_PRIVATE);
        CargarDatos();
        this.manager = new LinearLayoutManager(this);


        this.adaptadorobjeto = new Adaptader(this.datasource);


        //Establecemos las propiedades
        this.recycler.setHasFixedSize(true);
        this.recycler.setLayoutManager(this.manager);

        // adaptamos los datos
        this.recycler.setAdapter(this.adaptadorobjeto);
    }
    public void CargarDatos(){
        Gson gson= new Gson();
        String json = nulista.getString(KEY_ALMACENAMIENTOLISTA,null);
        Type type = new TypeToken<ArrayList<Jugador>>() {}.getType();
        listacontacto = gson.fromJson(json,type);
        for(int i =0; i<listacontacto.size(); i++)
        {
            datasource.add(listacontacto.get(i));
        }

    }
}
