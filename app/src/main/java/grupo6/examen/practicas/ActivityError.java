package grupo6.examen.practicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityError extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
    }

    public void regresar(View v) {
        Intent ant_pantalla = new Intent(this,MainActivity.class);
        startActivity(ant_pantalla);
    }
}