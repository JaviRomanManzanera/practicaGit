package com.company;


import com.google.gson.Gson;

public class Contacto {
    private int id,telefono;
    private String nombre, ciudad;

    public Contacto(int id, String nombre, String ciudad, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getTelefono() {
        return telefono;
    }

    //Setters
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    //pasar un objeto contacto a Json
    public String getJson(){
        Gson cadena = new Gson();

        return cadena.toJson(this);
    }

    //crear un objeto contacto de un Json
    public static Contacto crearObjeto(String cadena){
        Gson gson = new Gson();
        Contacto contacto = gson.fromJson(cadena, Contacto.class);

        return contacto;
    }
}
