package grupo6.examen.practicas.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AlumnoDao {
    @Insert
    void insert(Alumno alumno);
    @Insert
    void insertAll(Alumno... alumnos);

    @Query("SELECT * FROM alumno WHERE correo = :correo AND password = :password LIMIT 1")
    Alumno findByEmailAndPassword(String correo, String password);
}