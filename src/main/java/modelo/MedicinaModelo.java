package modelo;

public class MedicinaModelo {

    private String nombreMedicamento;
    private float unidadesDisponibles;
    private String presentacion;
    private String frecuencia;
    private String frecuenciaDia;
    private float dosis;

    public MedicinaModelo(String nombreMedicamento, float unidadesDisponibles,
                    String presentacion, String frecuencia,
                    String frecuenciaDia, float dosis){
        this.nombreMedicamento = nombreMedicamento;
        this.unidadesDisponibles = unidadesDisponibles;
        this.presentacion = presentacion;
        this.frecuencia = frecuencia;
        this.frecuenciaDia = frecuenciaDia;
        this.dosis = dosis;
    }

    public MedicinaModelo(){}
    
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

    public String getPresentacion(){
        return presentacion;
    }

    public void setPresentacion(String presentacion){
        this.presentacion = presentacion;
    }

    public String getFrecuencia(){
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia){
        this.frecuencia = frecuencia;
    }

    public String getFrecuenciaDia(){
        return frecuenciaDia;
    }

    public void setFrecuenciaDia(String frecuenciaDia){
        this.frecuenciaDia = frecuenciaDia;
    }

    public float getDosis(){
        return dosis;
    }

    public void setDosis(float dosis){
        this.dosis = dosis;
    }
    @Override
    public String toString(){
        return nombreMedicamento +" / "+ unidadesDisponibles +" / "+ presentacion +" / "+ frecuencia +" / "+ frecuenciaDia +" / "+ dosis;
    }
}

