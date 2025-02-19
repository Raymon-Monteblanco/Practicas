package grupo6.examen.practicas.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "docente")
public class Docente {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nombre;
    private String correo;
    private String password;

    public Docente(String nombre, String correo, String password) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}