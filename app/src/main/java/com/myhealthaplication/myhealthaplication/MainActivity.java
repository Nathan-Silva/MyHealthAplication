package com.myhealthaplication.myhealthaplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.myhealthaplication.myhealthaplication.adapter.LembreteAdapter;
import com.myhealthaplication.myhealthaplication.entidades.Lembretes;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public FloatingActionButton btnAdd;
    ListView lvLista;
    ArrayList<Lembretes> lsLembrete = new ArrayList<>();
    private FloatingActionButton btnCall;
    private int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnCall = findViewById(R.id.btnCall);
        this.btnAdd = findViewById(R.id.btnAdd);
        this.lvLista = findViewById(R.id.lvLista);
        LembreteAdapter la = new LembreteAdapter(this, lsLembrete);
        this.lvLista.setAdapter(la);
    }


    public void adicionarLembrete(View view) {
        Intent it = new Intent(this, NovoLembreteActivity.class);
        startActivityForResult(it, REQUEST_CODE);

    }

    public void telaChamada(View view) {
        Intent it = new Intent(this, CallActivity.class);
        startActivity(it);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String titulo = data.getStringExtra("titulo");
                String conteudo = data.getStringExtra("conteudo");
                String txtData = data.getStringExtra("data");
                String hora = data.getStringExtra("hora");
                Lembretes lm = new Lembretes(titulo, conteudo, txtData, hora);
                lsLembrete.add(lm);
            }
        }
    }
}
