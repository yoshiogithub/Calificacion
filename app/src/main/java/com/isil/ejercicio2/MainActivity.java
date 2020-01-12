package com.isil.ejercicio2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText n1, n2, n3;
    TextView resultado;
    double nota1, nota2, nota3, promedio;
    DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.txtn1);
        n2 = findViewById(R.id.txtn2);
        n3 = findViewById(R.id.txtn3);
        resultado = findViewById(R.id.txtresultado);

    }

    public void calcular(View view) {
        String msg="",condicion;

        if (!n1.getText().toString().isEmpty() && !n2.getText().toString().isEmpty() && !n3.getText().toString().isEmpty()) {
            nota1 = Double.parseDouble(n1.getText().toString());
            nota2 = Double.parseDouble(n2.getText().toString());
            nota3 = Double.parseDouble(n3.getText().toString());
        } else {
            msg = "COMPLETE LOS CAMPOS EN BLANCO";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        }
        if (nota1 < 0 || nota1 > 20 || nota2 < 0 || nota2 > 20 || nota3 < 0 || nota3 > 20) {
            msg = "CALIFICACION INVALIDA";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        if (msg.isEmpty()){
            promedio=(nota1+nota2+nota3)/3;
            if(promedio<=20 && promedio>18.5)condicion="A";
            else if(promedio<=18.5 && promedio>16.5) condicion="B";
            else if(promedio<=16.5 && promedio>12.5)condicion="C";
            else if(promedio<=12.5 && promedio>10.5)condicion="D";
            else condicion="desprobado";

            resultado.setText("PROMEDIO : "+df.format(promedio)+"\n"+"CONDICION : "+condicion);

        }else{
            resultado.setText("");
        }


    }
}

