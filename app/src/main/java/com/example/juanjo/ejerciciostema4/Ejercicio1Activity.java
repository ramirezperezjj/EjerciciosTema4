package com.example.juanjo.ejerciciostema4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Ejercicio1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        ImageButton b = (ImageButton) findViewById(R.id.imageButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int estadoCivilMarcado = ((RadioGroup) findViewById(R.id.radioGroup)).getCheckedRadioButtonId();
                CharSequence txtEstado;

                if (estadoCivilMarcado == R.id.rbOtros) {
                    txtEstado = "No estás ni soltero ni casado";
                } else {
                    txtEstado = "Estás " + ((RadioButton) findViewById(estadoCivilMarcado)).getText();
                }

                ((EditText) findViewById(R.id.txtEstadoCivil)).setText(txtEstado);

                CharSequence txtMayorEdad;
                boolean mayorEdad = ((CheckBox) findViewById(R.id.cbMayorEdad)).isChecked();
                if (mayorEdad) {
                    txtMayorEdad = "Es mayor de edad";
                } else {
                    txtMayorEdad = "Eres menor de edad";
                }
                ((EditText) findViewById(R.id.txtMayorEdad)).setText(txtMayorEdad);
            }
        });
    }
}
