package com.example.myfirstapp.model;

import java.util.Date;

/**
 * Created by Erick on 21/3/2017.
 */

public class PlanNutrional {

    private Integer IdPlanNutricional;
    private String UsuInclusion;
    private Date FechaInclusion;
    private String UsuModificacion;
    private Integer Estado;
    private Integer IdMiembro;
    private String Nombre;
    private Date FechaInicio;
    private Date FechaFin;

    public PlanNutrional(Integer IdPlanNutrional, String UsuInclusion,
                         Date FechaInclusion, Integer Estado,
                         Integer IdMiembro,String Nombre,Date FechaInicio,Date FechaFin){

        this.IdPlanNutricional = IdPlanNutrional;
        this.UsuInclusion = UsuInclusion;
        this.FechaInclusion = FechaInclusion;
        this.Estado = Estado;
        this.IdMiembro = IdMiembro;
        this.Nombre = Nombre;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;

    }


    public Integer getIdPlanNutrional() {
        return IdPlanNutricional;
    }

    public void setIdPlanNutrional(Integer IdPlanNutricional) {
        IdPlanNutricional = IdPlanNutricional;
    }

    public Integer getEstado() {
        return Estado;
    }

    public void setEstado(Integer Estado) {
        Estado = Estado;
    }

    public Integer getIdMiembro() {
        return IdMiembro;
    }

    public void setIdMiembro(Integer idMiembro) {
        IdMiembro = idMiembro;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombrePrograma) {
        Nombre = nombrePrograma;
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
