package com.example.spinner_sueldo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Spinner spinner1;
    EditText txtnombre, txtApe, txtdias, txthoras;
    Button btn;
    TextView importe, bon1, bon2, sobretiempo, total;


    public void initComponentPantalla2() {
        importe = (TextView) findViewById(R.id.txtimporte);
        bon1 = (TextView) findViewById(R.id.txtboni1);
        bon2 = (TextView) findViewById(R.id.txtboni2);
        sobretiempo = (TextView) findViewById(R.id.txtsobretiempo);
        total = (TextView) findViewById(R.id.txttotal);


    }

    public void initComponentPantalla1() {
        txtnombre = (EditText) findViewById(R.id.txtnombre);
        txtApe = (EditText) findViewById(R.id.txtapellido);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        txtdias = (EditText) findViewById(R.id.dias);
        txthoras = (EditText) findViewById(R.id.horas);


        btn = (Button) findViewById(R.id.btnprocesar);
        btn.setOnClickListener(this);

        spinner1 = (Spinner) findViewById(R.id.spinner);
        // String []opciones={"Analista","Programador","Tecnico","Operario"};

        ArrayList<String> Lista = new ArrayList<String>();
        Lista.add("Seleccionar");
        Lista.add("Analista");
        Lista.add("Programador");
        Lista.add("Tecnico");
        Lista.add("Operario");

        ArrayAdapter<CharSequence> adapter = new
                ArrayAdapter(this, android.R.layout.simple_spinner_item, Lista);


        spinner1.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponentPantalla1();
    }

    @Override
    public void onClick(View view) {
        double boni1 = 0, boni2 = 0, sobretiem = 0, totales = 0;

        int sueldo, importes = 0, dias = 0;

        String selec = spinner1.getSelectedItem().toString();

        dias = Integer.parseInt(txtdias.getText().toString());


        if (selec.equals("Analista")) {
            sueldo = 4000;
            importes = sueldo / 30 * dias;
            boni1 = sueldo * 0.15;
            boni2 = sueldo * 0.20;
            sobretiem = Math.round(sueldo / 30 / 8);
            totales = Math.round(sueldo + boni1 + boni2 + sobretiem);


        } else if (selec.equals("Programador")) {
            sueldo = 3000;
            importes = sueldo / 30 * dias;
            boni1 = sueldo * 0.15;
            boni2 = sueldo * 0.20;
            sobretiem = Math.round(sueldo / 30 / 8);
            totales = Math.round(sueldo + boni1 + boni2 + sobretiem);

        } else if (selec.equals("Tecnico")) {
            sueldo = 1500;
            importes = sueldo / 30 * dias;
            boni1 = sueldo * 0.15;
            boni2 = sueldo * 0.20;
            sobretiem = Math.round(sueldo / 30 / 8);
            totales = Math.round(sueldo + boni1 + boni2 + sobretiem);


        } else if (selec.equals("Operario")) {
            sueldo = 1000;
            importes = sueldo / 30 * dias;
            boni1 = sueldo * 0.15;
            boni2 = sueldo * 0.20;
            sobretiem = Math.round(sueldo / 30 / 8);
            totales = Math.round(sueldo + boni1 + boni2 + sobretiem);

        }


        setContentView(R.layout.activity_actividad2);

        initComponentPantalla2();


        importe.setText("El sueldo es " + String.valueOf(importes));
        bon1.setText("La Primera bonificacion: " + String.valueOf(boni1));
        bon2.setText("La Segunda bonificacion: " + String.valueOf(boni2));
        sobretiempo.setText("Su sobretiempo es: " + String.valueOf(sobretiem));
        total.setText("El sueldo Bruto es " + "es " + String.valueOf(totales));


    }
}

