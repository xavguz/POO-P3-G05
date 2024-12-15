package modelo;

public class FechaModelo {
    private String dia;
    private String mes;
    private String año;
    private String hora;

    public FechaModelo(String dia, String mes, String año, String hora){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }
    public void setDia(String dia){
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    @Override
    public String toString(){
        return dia + "/"+ mes + "/" + año + " - " + hora;
    }
}
