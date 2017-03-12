package com.example.myfirstapp.model;

import java.util.Date;

/**
 * Created by M.Franco on 3/12/2017.
 */

public class Programa {

    private Integer IdProgramaEjercicio;
    private Integer Estado;
    private String NombrePrograma;
    private Integer IdMiembro;
    private Date FechaInicio;
    private Date FechaFin;

    public Programa(Integer IdProgramaEjercicio, Integer Estado,
                    String NombrePrograma, Integer IdMiembro,
                    Date FechaInicio, Date FechaFin){
        this.IdProgramaEjercicio = IdProgramaEjercicio;
        this.Estado = Estado;
        this.NombrePrograma = NombrePrograma;
        this.IdMiembro = IdMiembro;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
    }

    public Integer getIdProgramaEjercicio() {
        return IdProgramaEjercicio;
    }

    public void setIdProgramaEjercicio(Integer idProgramaEjercicio) {
        IdProgramaEjercicio = idProgramaEjercicio;
    }

    public Integer getEstado() {
        return Estado;
    }

    public void setEstado(Integer estado) {
        Estado = estado;
    }

    public String getNombrePrograma() {
        return NombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        NombrePrograma = nombrePrograma;
    }

    public Integer getIdMiembro() {
        return IdMiembro;
    }

    public void setIdMiembro(Integer idMiembro) {
        IdMiembro = idMiembro;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        FechaFin = fechaFin;
    }
}
