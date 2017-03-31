package com.example.myfirstapp.model;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Erick on 30/3/2017.
 */

public class HorarioClase {


    private String Dia;
    private String HoraInicio;
    private String HoraFin;

    public HorarioClase(String Dia, String HoraInicio, String HoraFin){

        this.Dia = Dia;
        this.HoraInicio = HoraInicio;
        this.HoraFin = HoraFin;

    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String Dia) {
        Dia = Dia;
    }


    public String getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(Time HoraInicio) {
        HoraInicio = HoraInicio;
    }


    public String getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(Time HoraFin) {
        HoraFin = HoraFin;
    }

}
