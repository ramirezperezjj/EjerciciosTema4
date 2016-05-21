package com.example.juanjo.ejerciciostema4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crearListeners();
    }

    private void crearListeners() {
        Button b = (Button) findViewById(R.id.goToOne);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarActivityOne();
            }
        });

        b = (Button) findViewById(R.id.goToTwo);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarActivityTwo();
            }
        });
        b = (Button) findViewById(R.id.goToThree);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarActivityThree();
            }
        });
    }

    private void lanzarActivityOne() {//creamos y lanzamos actividad 1
        Intent intent = new Intent(getBaseContext(), Ejercicio1Activity.class);
        startActivity(intent);

    }

    private void lanzarActivityTwo() {//creamos y lanzamos actividad 2
        Intent intent = new Intent(getBaseContext(), Ejercicio2Activity.class);
        startActivity(intent);
    }

    private void lanzarActivityThree() {//creamos y lanzamos actividad 3
        Intent intent = new Intent(getBaseContext(), Ejercicio3Activity.class);
        startActivity(intent);
    }
}
