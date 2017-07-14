package edu.pucmm.encapsulacion;

/**
 * Pojo estudiante
 */
public class Estudiante {

    private int id;
    private String matricula;
    private  String nombre;
    private String apellido;
    private  String telefono;

    public Estudiante() {

    }
    public Estudiante(int id, String matricula, String nombre, String apellido, String telefono) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", matricula=" + matricula +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public void createCopy(Estudiante estudiante){
        id= estudiante.getId();
        nombre= estudiante.getNombre();
        apellido= estudiante.getApellido();
        matricula = estudiante.getMatricula();
        telefono=estudiante.getTelefono();
    }
    public Estudiante clone(){
        return new Estudiante(id,matricula,nombre,apellido,telefono);
    }
}
