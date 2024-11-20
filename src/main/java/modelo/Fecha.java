package modelo;

public class Fecha {
    private String dia;
    private String hora;

    public Fecha(String dia, String hora){
        this.dia = dia;
        this.hora = hora;
    }
    public Fecha(String hora){
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
        return "Dia: " + dia + ", hora: "+ hora;
    }
}
