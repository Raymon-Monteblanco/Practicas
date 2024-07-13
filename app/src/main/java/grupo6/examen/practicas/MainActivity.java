package grupo6.examen.practicas;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.room.Room;
import grupo6.examen.practicas.model.Alumno;
import grupo6.examen.practicas.model.AlumnoDao;
import grupo6.examen.practicas.model.Curso;
import grupo6.examen.practicas.model.CursoDao;
import grupo6.examen.practicas.model.Docente;
import grupo6.examen.practicas.model.DocenteDao;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    private AlumnoDao alumnoDao;
    private DocenteDao docenteDao;
    private CursoDao cursoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();
        alumnoDao = db.alumnoDao();
        docenteDao = db.docenteDao();
        cursoDao = db.cursoDao();

        // Inicializar la base de datos con algunos datos
        inicializarDatos();

        EditText emailField = findViewById(R.id.txt_correo);
        EditText passwordField = findViewById(R.id.txt_password);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button loginButton = findViewById(R.id.btn_ingresar);

        loginButton.setOnClickListener(v -> {
            String email = emailField.getText().toString();
            String password = passwordField.getText().toString();

            new Thread(() -> {
                Alumno alumno = alumnoDao.findByEmailAndPassword(email, password);
                Docente docente = docenteDao.findByEmailAndPassword(email, password);

                runOnUiThread(() -> {
                    if (alumno != null) {
                        Intent intent = new Intent(this, Home_Alumno.class);
                        startActivity(intent);
                    } else if (docente != null) {
                        Intent intent = new Intent(this, HomeDocenteActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                    }
                });
            }).start();
        });
    }

    private void inicializarDatos() {
        new Thread(() -> {
            Alumno[] alumnos = {
                    new Alumno("Kevin", "kevingersy.perez@unmsm.edu.pe", "19200195"),
                    new Alumno("Raymon", "raymon@unmsm.edu.pe", "password2"),
                    new Alumno("Pedro", "alumno3@mail.com", "password3"),
                    new Alumno("Alumno 4", "alumno4@mail.com", "password4"),
                    new Alumno("Alumno 5", "alumno5@mail.com", "password5"),
                    new Alumno("Alumno 6", "alumno6@mail.com", "password6")
            };
            Docente[] docentes = {
                    new Docente("Juan", "juansoto@mail.com", "19200195"),
                    new Docente("Docente 2", "docente2@mail.com", "password2")
            };
            Curso[] cursos = {
                    new Curso("PROGRAMACIÓN II G1", "Descripción del curso 1"),
                    new Curso("DESARROLLO DE SISTEMAS WEB G2", "Descripción del curso 2"),
                    new Curso("PRÁCTICAS PRE-PROFESIONALES G2", "Descripción del curso 3"),
                    new Curso("GESTIÓN DE CONOCIMIENTO G2", "Descripción del curso 4"),
                    new Curso("INTELIGENCIA ARTIFICIAL G3", "Descripción del curso 5")
            };
            alumnoDao.insertAll(alumnos);
            docenteDao.insertAll(docentes);
            cursoDao.insertAll(cursos);
        }).start();
    }
}