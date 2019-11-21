package Entidades;

public class Jugador {
    private int NumJuego;
    private int intentos;
    private int numeroAleatorio;
    private int puntaje;

    public Jugador(int numjuego, int intentos,int numale,int punt){
        this.setNumJuego(numjuego);
        this.setIntentos(intentos);
        this.setNumeroAleatorio(numale);
        this.setPuntaje(punt);

    }


    public int getNumJuego() {
        return NumJuego;
    }

    public void setNumJuego(int numJuego) {
        NumJuego = numJuego;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getNumeroAleatorio() {
        return numeroAleatorio;
    }

    public void setNumeroAleatorio(int numeroAleatorio) {
        this.numeroAleatorio = numeroAleatorio;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
