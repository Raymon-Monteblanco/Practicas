package grupo6.examen.practicas.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DocenteDao {
    @Insert
    void insert(Docente docente);

    @Insert
    void insertAll(Docente... docentes);

    @Query("SELECT * FROM docente WHERE correo = :correo AND password = :password LIMIT 1")
    Docente findByEmailAndPassword(String correo, String password);
}