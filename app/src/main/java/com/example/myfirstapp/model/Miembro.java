package com.example.myfirstapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M.Franco on 2/18/2017.
 */

public class Miembro {

    @SerializedName("IdMiembro")
    private Integer IdMiembro;

    @SerializedName("Nombre")
    private String Nombre;

    @SerializedName("Correo")
    private String Correo;

    public Miembro(Integer IdMiembro, String Nombre){
        this.IdMiembro = IdMiembro;
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Integer getIdMiembro() {
        return IdMiembro;
    }

    public void setIdMiembro(Integer idMiembro) {
        IdMiembro = idMiembro;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

}
