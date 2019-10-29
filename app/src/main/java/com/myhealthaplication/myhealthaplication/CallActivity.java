package com.myhealthaplication.myhealthaplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CallActivity extends AppCompatActivity {

    private Button btnAmbulancia;
    private Button btnPolicia;
    private Button btnBombeiros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        this.btnAmbulancia = findViewById(R.id.btnAmbulancia);
        this.btnPolicia = findViewById(R.id.btnPolicia);
        this.btnBombeiros = findViewById(R.id.btnBombeiros);
    }

    public void ligarAmbulancia(View view) {
        String numAmbulancia = "180";
        Intent it = new Intent(Intent.ACTION_CALL);
        it.setData(Uri.parse("tel:" + numAmbulancia));
        if (it.resolveActivity(getPackageManager()) != null) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }

        }

        startActivity(it);
    }

    public void ligarPolicia(View view) {
        String numPolicia = "190";
        Intent it = new Intent(Intent.ACTION_CALL);
        it.setData(Uri.parse("tel:" + numPolicia));
        if (it.resolveActivity(getPackageManager()) != null) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }

        }
        startActivity(it);
    }

    public void ligarBombeiros(View view) {
        String numBombeiros = "193";
        Intent it = new Intent(Intent.ACTION_CALL);
        it.setData(Uri.parse("tel:" + numBombeiros));
        if (it.resolveActivity(getPackageManager()) != null) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }

        }
        startActivity(it);
    }
}
