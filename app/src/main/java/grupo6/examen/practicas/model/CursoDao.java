package grupo6.examen.practicas.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CursoDao {
    @Insert
    void insert(Curso curso);

    @Insert
    void insertAll(Curso... cursos);

    @Query("SELECT * FROM curso WHERE id = :id")
    Curso getCurso(int id);

    @Query("SELECT * FROM curso")
    List<Curso> getAll();
}