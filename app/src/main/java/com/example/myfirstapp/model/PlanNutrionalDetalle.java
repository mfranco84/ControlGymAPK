package com.example.myfirstapp.model;

import java.util.Date;

/**
 * Created by Erick on 23/3/2017.
 */

public class PlanNutrionalDetalle {

    private Integer IdPlanNutricionalDetalle;
    private String UsuInclusion;
    private Date FechaInclusion;
    private String UsuModificacion;
    private Integer Estado;

    private Integer IdPlanNutricional;
    private String Detalle;

    public PlanNutrionalDetalle(Integer IdPlanNutricionalDetalle, String UsuInclusion,
                         Date FechaInclusion, Integer Estado,
                         Integer IdPlanNutricional,String Detalle){

        this.IdPlanNutricionalDetalle = IdPlanNutricionalDetalle;
        this.UsuInclusion = UsuInclusion;
        this.FechaInclusion = FechaInclusion;
        this.Estado = Estado;
        this.IdPlanNutricional = IdPlanNutricional;
        this.Detalle = Detalle;



    }

    public String getDetallePlanNutrional() {
        return Detalle;
    }

    public void setDetallePlanNutrional(String Detalle) {
        Detalle = Detalle;
    }

}
