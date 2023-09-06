package com.example.tp3_pa_grupo_2;

public class Contacto {
    private String nombre;
    private String contra;
    private String mail;

    public Contacto(String nombre, String contra, String mail) {
        this.nombre = nombre;
        this.contra = contra;
        this.mail = mail;
    }

    public Contacto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
