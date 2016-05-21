package com.example.juanjo.ejerciciostema4;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);
    }

    public void llamadaIntent(View view) {
        Intent intent = null;
        CharSequence valor = ((TextView) findViewById(R.id.editText)).getText();
        if (valor == null || valor.toString().trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Introduzca un dato", Toast.LENGTH_SHORT);
            return;
        }
        switch (view.getId()) {
            case R.id.botonNavegador:
                if (!valor.toString().startsWith("http://")) {
                    valor = "http://" + valor;
                }
                try {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(valor.toString()));
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "No se puede navegar a " + valor, Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.botonContactos:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content:/contacts/people/"));
                startActivity(intent);
                break;
            case R.id.botonMarcar:
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + valor.toString()));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
                break;
            default:

                break;
        }

    }
}
