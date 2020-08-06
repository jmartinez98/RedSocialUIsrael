package com.uisrael.redsocialuisrael;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ly_registrarse extends AppCompatActivity {
    private Button btn1, btn2;
    private EditText etnom, etape, etmail, etpas1, etpas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ly_registrarse);
        btn1 = findViewById(R.id.btnaceptar);
        btn2 = findViewById(R.id.btncancelar);
        etnom = findViewById(R.id.etnombre);
        etape = findViewById(R.id.etapellido);
        etmail = findViewById(R.id.etemail);
        etpas1 = findViewById(R.id.etpassw);
        etpas2 = findViewById(R.id.etpasswc);

        DisplayMetrics mVentanda = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(mVentanda);
        int ancho = mVentanda.widthPixels;
        int alto = mVentanda.heightPixels;

        getWindow().setLayout((int)(ancho*0.90), (int)(alto*0.80));

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ly_registrarse.this, MainActivity.class));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom, app, mail, ps1, ps2;
                nom = etnom.getText().toString();
                app = etape.getText().toString();
                mail = etmail.getText().toString();
                ps1 = etpas1.getText().toString();
                ps2 = etpas2.getText().toString();

                if (ps1.equals("")||ps2.equals("")){
                    Toast.makeText(getApplicationContext(), "Los campos de contraseña no pueden estar vacios", Toast.LENGTH_LONG).show();
                }else{
                    if(ps1.equals(ps2)){
                        if(nom.equals("") || mail.equals("")){
                            Toast.makeText(getApplicationContext(), "Es necesario ingresar el NOMBRE y el EMAIL", Toast.LENGTH_LONG).show();
                        }else{
                            //ingreso del api para registrar un usuario nuevo a la base
                            //Toast.makeText(getApplicationContext(), "La Contraseña correcta", Toast.LENGTH_LONG).show();
                            registroC();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "La Contraseña no coincide", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });



    }

    public void registroC(){

        String nom= etnom.getText().toString();
        String app= etape.getText().toString();
        String mail= etmail.getText().toString();
        String ps1= etpas1.getText().toString();

        ServicioTask servicioTask= new ServicioTask(this,"https://192.168.0.3:4040/registro",nom,app,mail,ps1);
        servicioTask.execute();

    }
}
