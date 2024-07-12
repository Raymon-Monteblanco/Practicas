package grupo6.examen.practicas;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class Home_Alumno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_alumno);
    }

    public void escanear_qr(View v) {
        if (v.getId()==R.id.escanear_qr){
            IntentIntegrator integrator = new IntentIntegrator(this);
            integrator.setOrientationLocked(true);
            integrator.initiateScan();
        }
    }
}