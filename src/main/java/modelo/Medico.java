package modelo;

public class Medico {
    private String nombre;
    private String especialidades;
    private String telefono;
    private String email;
    private String direccion;

    public Medico(String nombre, String especialidades,
                  String telefono, String email, String direccion){
        this.nombre = nombre;
        this.especialidades = especialidades;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + //
                    ", Especialidad: "+ especialidades + //
                    ", Numero de Contacto: "+ telefono;
    }
}
