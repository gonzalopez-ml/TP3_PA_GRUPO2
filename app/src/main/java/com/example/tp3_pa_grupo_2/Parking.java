package com.example.tp3_pa_grupo_2;

public class Parking {
    private Integer idUsuario;
    private String matricula;
    private Float tiempo;


    public Parking(Integer idUsuario, String matricula, Float tiempo) {
        this.idUsuario = idUsuario;
        this.matricula = matricula;
        this.tiempo = tiempo;
    }
    public Parking() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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
