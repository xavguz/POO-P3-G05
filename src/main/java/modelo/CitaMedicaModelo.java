package modelo;

public class CitaMedicaModelo {
    private String titulo;
    private FechaModelo fecha;
    private MedicoModelo doctor;

    public CitaMedicaModelo(String titulo, FechaModelo fecha, MedicoModelo doctor){
        this.titulo = titulo;
        this.fecha = fecha;
        this.doctor = doctor;
    }

    public CitaMedicaModelo(){}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public FechaModelo getFecha() {
        return fecha;
    }

    public void setFecha(FechaModelo fecha) {
        this.fecha = fecha;
    }

    public MedicoModelo getDoctor() {
        return doctor;
    }

    public void setDoctor(MedicoModelo doctor) {
        this.doctor = doctor;
    }
    @Override
    public String toString(){
        return titulo + " / " + doctor.getNombre() + " ("+ doctor.getEspecialidades() + ")" + " / " + fecha;
    }
}
