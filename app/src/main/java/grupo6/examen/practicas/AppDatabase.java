package grupo6.examen.practicas;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import grupo6.examen.practicas.model.Alumno;
import grupo6.examen.practicas.model.AlumnoDao;
import grupo6.examen.practicas.model.Curso;
import grupo6.examen.practicas.model.CursoDao;
import grupo6.examen.practicas.model.Docente;
import grupo6.examen.practicas.model.DocenteDao;

@Database(entities = {Alumno.class, Docente.class, Curso.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AlumnoDao alumnoDao();
    public abstract DocenteDao docenteDao();
    public abstract CursoDao cursoDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "app_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "app_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}