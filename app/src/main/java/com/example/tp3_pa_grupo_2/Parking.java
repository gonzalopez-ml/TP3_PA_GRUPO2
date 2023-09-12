package com.example.tp3_pa_grupo_2;

public class Parking {
    private String matricula;
    private Float tiempo;


    public Parking(String matricula, Float tiempo) {
        this.matricula = matricula;
        this.tiempo = tiempo;
    }
    public Parking() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Float getTiempo() {
        return tiempo;
    }

    public void setTiempo(Float tiempo) {
        this.tiempo = tiempo;
    }
}
