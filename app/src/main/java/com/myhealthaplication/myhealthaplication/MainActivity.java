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
    String titulo;
    String conteudo;
    String txtData;
    String hora;
    private FloatingActionButton btnCall;
    private int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnCall = findViewById(R.id.btnCall);
        this.btnAdd = findViewById(R.id.btnAdd);
        this.lvLista = findViewById(R.id.lvLista);





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("Dados Recebidos!!!");
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                this.titulo = data.getStringExtra("titulo");
                this.conteudo = data.getStringExtra("conteudo");
                this.txtData = data.getStringExtra("data");
                this.hora = data.getStringExtra("hora");
                System.out.println(titulo);
                Lembretes lm = new Lembretes(this.titulo, this.conteudo, this.txtData, this.hora);
                this.lsLembrete.add(lm);
                System.out.println("Lembrete dentro da lista lembrete");
                LembreteAdapter la = new LembreteAdapter(this, this.lsLembrete);
                this.lvLista.setAdapter(la);
            }
        }
    }







    public void adicionarLembrete(View view) {
        Intent it = new Intent(this, NovoLembreteActivity.class);
        startActivity(it);
        startActivityForResult(it, REQUEST_CODE);

    }

    public void telaChamada(View view) {
        //Intent it = new Intent(this, CallActivity.class);
        //startActivity(it);

        Intent it = getIntent();
        this.titulo = it.getStringExtra("titulo");
        System.out.println(this.titulo);
    }
}
