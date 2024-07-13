package grupo6.examen.practicas;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class CursosOpcionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos_opciones);

        // Aquí puedes obtener el id del curso y usarlo como necesites
        int cursoId = getIntent().getIntExtra("curso_id", -1);

        // Por ejemplo, podrías usar el cursoId para cargar más detalles sobre el curso
    }
}