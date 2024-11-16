package modelo.medicina;

import modelo.enums.Frecuencia;
import modelo.enums.FrecuenciaDia;
import modelo.enums.Presentacion;

public class Medicina {

    private String nombreMedicamento;
    private float unidadesDisponibles;
    private Presentacion presentacion;
    private Frecuencia frecuencia;
    private FrecuenciaDia frecuenciaDia;
    private float dosis;

    public Medicina(String nombreMedicamento, float unidadesDisponibles,
                    Presentacion presentacion, Frecuencia frecuencia,
                    FrecuenciaDia frecuenciaDia, float dosis){
        this.nombreMedicamento = nombreMedicamento;
        this.unidadesDisponibles = unidadesDisponibles;
        this.presentacion = presentacion;
        this.frecuencia = frecuencia;
        this.frecuenciaDia = frecuenciaDia;
        this.dosis = dosis;
    }
    public void mostrarMedicina(){
        System.out.println("Nombre del medicamento: " + nombreMedicamento);
        System.out.println("Unidades disponibles: " + unidadesDisponibles);
        System.out.println("Presentacion: " + presentacion);
        System.out.println("Frecuencia: " + frecuencia);
        System.out.println("Frecuencia dia: " + frecuenciaDia);
        System.out.println("Dosis: " + dosis);
    }

    public String getNombreMedicamento(){
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento){
        this.nombreMedicamento = nombreMedicamento;
    }

    public float getUnidadesDisponibles(){
        return unidadesDisponibles;
    }

    public void getUnidadesDisponibles(float unidadesDisponibles){
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public Presentacion getPresentacion(){
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion){
        this.presentacion = presentacion;
    }

    public Frecuencia getFrecuencia(){
        return frecuencia;
    }

    public void setFrecuencia(Frecuencia frecuencia){
        this.frecuencia = frecuencia;
    }

    public FrecuenciaDia getFrecuenciaDia(){
        return frecuenciaDia;
    }

    public void setFrecuenciaDia(FrecuenciaDia frecuenciaDia){
        this.frecuenciaDia = frecuenciaDia;
    }

    public float getDosis(){
        return dosis;
    }

    public void setDosis(float dosis){
        this.dosis = dosis;
    }
}

