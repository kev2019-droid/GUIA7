package Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.guia7.R;

import java.util.List;


import Entidades.Jugador;


public class Adaptader extends RecyclerView.Adapter<viewholderJugador> {
    private List<Jugador> listContactos;

    public Adaptader(List<Jugador> datasources){
        //Inicializamos el datasources
        this.listContactos = datasources;
    }
    @NonNull
    @Override
    public viewholderJugador onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantilla,parent,false);
        viewholderJugador vhContactos = new viewholderJugador(v);
        return vhContactos;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholderJugador holder, int position) {
        holder.getNumjuego().setText("Numero de Juego: "+ this.listContactos.get(position).getNumJuego());
        holder.getIntentos().setText("Cantidad de Intentos "+ ( this.listContactos.get(position).getIntentos()));
        holder.getPuntaje().setText("El Puntaje obtenido es "+ ( this.listContactos.get(position).getPuntaje()));
        holder.getNumeroaleatorio().setText("El Numero Adivinado es: "+ ( this.listContactos.get(position).getNumeroAleatorio()));


    }

    @Override
    public int getItemCount() {
        return this.listContactos.size();
    }
}
