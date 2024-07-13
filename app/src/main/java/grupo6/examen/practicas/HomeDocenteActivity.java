package grupo6.examen.practicas;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import grupo6.examen.practicas.model.Curso;

public class HomeDocenteActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CursoAdapter cursoAdapter;
    private Executor executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_docente);

        // Configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cursoAdapter = new CursoAdapter();
        recyclerView.setAdapter(cursoAdapter);

        // Configurar el botón de volver
        ImageButton backButton = findViewById(R.id.btn_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Volver a la actividad anterior
            }
        });

        // Obtener y mostrar la lista de cursos en segundo plano
        obtenerYMostrarCursos();
    }

    private void obtenerYMostrarCursos() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                // Aquí obtienes la lista de cursos desde la base de datos o donde los hayas guardado
                // Aquí se muestra un ejemplo de cómo obtener la instancia de la base de datos y los cursos
                AppDatabase db = AppDatabase.getInstance(HomeDocenteActivity.this);
                final List<Curso> cursos = db.cursoDao().getAll();

                // Actualizar el adaptador con los cursos obtenidos en el hilo principal
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        cursoAdapter.setCursos(cursos);
                    }
                });
            }
        });
    }
}