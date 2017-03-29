package com.example.myfirstapp.model;

import java.util.Date;

/**
 * Created by Erick on 27/3/2017.
 */

public class Clase {

    private Integer IdClase;
    private String Nombre;


    public Clase(Integer IdClase, String Nombre){
        this.IdClase = IdClase;
        this.Nombre = Nombre;

 }

    public Integer getIdClase() {
        return IdClase;
    }

    public void setIdClase(Integer IdClase) {
        IdClase = IdClase;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        Nombre = Nombre;
    }
}
