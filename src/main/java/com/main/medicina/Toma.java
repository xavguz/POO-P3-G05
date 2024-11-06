package com.main.medicina;

import com.main.Fecha;

public class Toma {
    private Medicina medicina;
    private Fecha fecha;

    public Toma(Medicina medicina, Fecha fecha){
        this.medicina = medicina;
        this.fecha = fecha;
    }

    public Medicina getMedicina() {
        return medicina;
    }

    public void setMedicina(Medicina medicina) {
        this.medicina = medicina;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
}
