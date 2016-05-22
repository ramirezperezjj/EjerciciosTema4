package com.example.juanjo.ejerciciostema4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Ejercicio2Activity extends AppCompatActivity {
    CharSequence[] opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);
        opciones = new CharSequence[]{getText(R.string.soltero), getText(R.string.casado), getText(R.string.otros)};

        ImageButton b = (ImageButton) findViewById(R.id.imageButton2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });
    }


    @Override
    protected Dialog onCreateDialog(int id) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.documento);
        builder.setTitle(getText(R.string.estadoCivil));
        builder.setMessage(getText(R.string.elijaEstadoCivil));

        builder.setSingleChoiceItems(opciones, 0, null);

        builder.setPositiveButton(getText(R.string.aceptar), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //((EditText) findViewById(R.id.txtResultado2)).setText(opciones[which]);
                dialog.cancel();
            }


        });

        builder.setNegativeButton(getText(R.string.cancelar), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), getText(R.string.cancelar), Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }


        });

        return builder.create();
    }
}
