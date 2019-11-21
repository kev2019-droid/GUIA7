package Adaptadores;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guia7.R;

public class viewholderJugador extends RecyclerView.ViewHolder  {
    private TextView Numjuego;
    private TextView intentos;
    private TextView numeroaleatorio;
    private TextView puntaje;


    public viewholderJugador(@NonNull View itemView) {
        super(itemView);
        this.Numjuego=(itemView.findViewById(R.id.edtNumJuego));
        this.intentos=(itemView.findViewById(R.id.Intentos));
        this.numeroaleatorio=(itemView.findViewById(R.id.NumerAdivinado));
        this.puntaje=(itemView.findViewById(R.id.Puntaje));
    }


    public TextView getNumjuego() {
        return Numjuego;
    }

    public TextView getIntentos() {
        return intentos;
    }

    public TextView getNumeroaleatorio() {
        return numeroaleatorio;
    }

    public TextView getPuntaje() {
        return puntaje;
    }
}
