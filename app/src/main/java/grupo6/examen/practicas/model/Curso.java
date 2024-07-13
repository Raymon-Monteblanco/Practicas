package grupo6.examen.practicas.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "curso")
public class Curso {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nombre;
    private String descripcion;

    public Curso(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}