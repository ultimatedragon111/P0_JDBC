package model;

public class persona {
    int id;
    String dni;
    String nombre;
    String apellidos;
    public persona(int id,String dni,String nombre,String apellidos){
       this.id = id;
       this.dni = dni;
       this.nombre = nombre;
       this.apellidos = apellidos;
    }
    public persona(String dni, String nombre, String apellidos){
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
