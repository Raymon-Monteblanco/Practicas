package grupo6.examen.practicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txt_correo, txt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View v) {
        Intent sgute_pantalla = new Intent(this,ActivityError.class);
        Intent home_alumno = new Intent(this,Home_Alumno.class);
        String correo = "@unmsm.edu.pe";
        txt_correo = findViewById(R.id.txt_correo);
        txt_password = findViewById(R.id.txt_password);

        String email = txt_correo.getText().toString();
        String contra = txt_password.getText().toString();

        if(email.equals("")){
            Toast.makeText(this,"Por favor digite su correo institucional",Toast.LENGTH_LONG).show();
        }
        else if(contra.equals("")){
            Toast.makeText(this,"Por favor digite su contraseña",Toast.LENGTH_LONG).show();
        }
        else if (email.indexOf(correo) == -1){
            startActivity(sgute_pantalla);
        }
        else{
            startActivity(home_alumno);
        }
    }
}