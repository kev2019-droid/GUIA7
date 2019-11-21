package com.example.guia7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.guia7.MainActivity.listacontacto;

import Entidades.Jugador;

public class Jugar extends AppCompatActivity {
    private int NumeroAleatorio = -1;
    int comparar;
    public static final String KEY_ALMACENAMIENTOA="NUMEROALEATORIO";
    public static final String KEY_ALMACENAMIENTOB="INTENTOS";
    public static final String KEY_ALMACENAMIENTOC="PUNTAJE";
    public static final String KEY_ALMACENAMIENTOD="JUEGOS";
    public static final String NAME_FILE= "CONFIGURACION";
    //DECLARAMOS LAS VARIABLES
    private SharedPreferences Juego;
    private int intentos = 1;
    private  int juegos = 1;
    private int  puntaje = 10;
    TextView juegonum,intento,puntajes;
    Button btn;
    EditText etingreso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        this.btn = findViewById(R.id.btn);
        this.juegonum = findViewById(R.id.Juegonum);
        this.intento = findViewById(R.id.intento);
        this.etingreso = findViewById(R.id.etIngreso);
        this.puntajes = findViewById(R.id.puntaje);
        this.Juego = getSharedPreferences(NAME_FILE,MODE_PRIVATE);
        CargarConfiguracion();


    }
    public void CargarConfiguracion(){
        this.NumeroAleatorio = this.Juego.getInt(KEY_ALMACENAMIENTOA,-1);
        if(this.NumeroAleatorio != -1){
            Toast.makeText(this, "El numero ya se ha generado prevamente", Toast.LENGTH_LONG).show();
            this.intentos = this.Juego.getInt(KEY_ALMACENAMIENTOB,1);
            this.juegos = this.Juego.getInt(KEY_ALMACENAMIENTOD,1);
            this.puntaje = this.Juego.getInt(KEY_ALMACENAMIENTOC,10);
            this.intento.setText("Numero de intentos: "+ String.valueOf(this.intentos));
            this.juegonum.setText("Numero de Juego: "+ String.valueOf(this.juegos));
            this.puntajes.setText("Puntaje actual: "+String.valueOf(this.puntaje));

        }
        else{
            this.NumeroAleatorio = (int)(Math.random() * 10);
            this.intento.setText("Numero de intentos: "+ String.valueOf(this.intentos));
            this.juegonum.setText("Numero de Juego: "+ String.valueOf(this.juegos));
            this.puntajes.setText("Puntaje actual: "+String.valueOf(this.puntaje));
            SharedPreferences.Editor edobj = this.Juego.edit();
            edobj.putInt(KEY_ALMACENAMIENTOA,this.NumeroAleatorio);
            edobj.putInt(KEY_ALMACENAMIENTOB,this.intentos);
            edobj.putInt(KEY_ALMACENAMIENTOC,this.puntaje);
            edobj.putInt(KEY_ALMACENAMIENTOD,this.juegos);
            edobj.commit();
            Toast.makeText(this, "Numero Generado Por primera vez", Toast.LENGTH_LONG).show();
        }
    }
    public void Juego(View v){
        if(this.etingreso.getText().toString().isEmpty()){
            Toast.makeText(this,"Ingrese un numero",Toast.LENGTH_SHORT);
        }
        else{
            comparar = Integer.parseInt(this.etingreso.getText().toString());
            if(this.NumeroAleatorio == comparar){
                Toast.makeText(this, "Felicidades adivino", Toast.LENGTH_LONG).show();
                SharedPreferences.Editor edobj = this.Juego.edit();
                edobj.putInt(KEY_ALMACENAMIENTOA,this.NumeroAleatorio);
                edobj.putInt(KEY_ALMACENAMIENTOB,this.intentos);
                edobj.putInt(KEY_ALMACENAMIENTOC,this.puntaje);
                edobj.putInt(KEY_ALMACENAMIENTOD,this.juegos);
                edobj.commit();
                this.puntaje = this.puntaje + 10;
                Jugador juga=new Jugador(this.juegos,this.intentos,this.NumeroAleatorio,this.puntaje);
                listacontacto.add(juga);
                this.NumeroAleatorio = (int)(Math.random() * 10);
                Toast.makeText(this, "El nuevo numero generado es: "+this.NumeroAleatorio, Toast.LENGTH_LONG).show();
                this.intentos = 1;
                this.puntaje = 10;
                this.juegos= this.juegos + 1;

                this.etingreso.setText("");
                this.intento.setText("Numero de intentos: "+ String.valueOf(this.intentos));
                this.juegonum.setText("Numero de Juego: "+ String.valueOf(this.juegos));
                this.puntajes.setText("Puntaje actual: "+String.valueOf(this.puntaje));
            }
            else{
                this.intentos++;
                this.puntaje = this.puntaje - 1;
                Toast.makeText(this, "Intentelo de nuevo intento:"+this.intentos+"Juego: "+this.juegos, Toast.LENGTH_LONG).show();
                this.intento.setText("Numero de intentos: "+ String.valueOf(this.intentos));
                this.juegonum.setText("Numero de Juego: "+ String.valueOf(this.juegos));
                this.puntajes.setText("Puntaje actual: "+String.valueOf(this.puntaje));
            }
        }
    }
}
