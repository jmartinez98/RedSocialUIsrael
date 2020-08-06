package com.uisrael.redsocialuisrael;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ly_ingresar extends AppCompatActivity {
    private Button btn1, btn2;
    private EditText etmail, etpas1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ly_ingresar);

        btn1 = findViewById(R.id.btnaceptar);
        btn2 = findViewById(R.id.btncancelar);
        etmail = findViewById(R.id.etemail);
        etpas1 = findViewById(R.id.etpassw);

        DisplayMetrics mVentanda = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(mVentanda);
        int ancho = mVentanda.widthPixels;
        int alto = mVentanda.heightPixels;

        getWindow().setLayout((int)(ancho*0.90), (int)(alto*0.50));

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ly_ingresar.this, MainActivity.class));
            }
        });
    }
}