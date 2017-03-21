package com.example.myfirstapp.model;

import android.content.Intent;

import java.util.Date;

/**
 * Created by Erick on 18/3/2017.
 */

public class Rutina {


    private Integer IdRutina;
    private Integer Estado;
    private Integer IdProgramaEjercicio;
    private String NombreRutina;
    private String DetalleRutina;


    public Rutina(Integer IdRutina, Integer Estado,
                    Integer IdProgramaEjercicio, String NombreRutina,
                    String DetalleRutina){

        this.IdRutina = IdRutina;
        this.Estado = Estado;
        this.IdProgramaEjercicio = IdProgramaEjercicio;
        this.NombreRutina = NombreRutina;
        this.DetalleRutina = DetalleRutina;

    }

    public Integer getIdRutina() {
        return IdRutina;
    }

    public void setIdRutina(Integer idRutina) {
        IdRutina = idRutina;
    }

    public Integer getEstado() {
        return Estado;
    }

    public void setEstado(Integer estado) {
        Estado = estado;
    }


    public Integer getIdProgramaEjercicio() {
        return IdProgramaEjercicio;
    }

    public void setIdProgramaEjercicio(Integer nombreProgramaEjercicio) {
        IdProgramaEjercicio = nombreProgramaEjercicio;
    }



    public String getNombreRutina() {
        return NombreRutina;
    }

    public void setNombreRutina(String nombreRutina) {
        NombreRutina = nombreRutina;
    }



    public String getDetalleRutina() {
        return DetalleRutina;
    }

    public void setDetalleRutina(String detalleRutina) {
        DetalleRutina = detalleRutina;
    }

}
