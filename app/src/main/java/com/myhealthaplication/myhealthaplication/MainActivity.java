package com.myhealthaplication.myhealthaplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.myhealthaplication.myhealthaplication.adapter.LembreteAdapter;
import com.myhealthaplication.myhealthaplication.controler.LembreteBancoController;
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
    ContextMenu contextMenu;
    Lembretes lembretes;
    private FloatingActionButton btnCall;
    private int REQUEST_CODE = 1;
    LembreteAdapter lembreteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnCall = findViewById(R.id.btnCall);
        this.btnAdd = findViewById(R.id.btnAdd);
        this.lvLista = findViewById(R.id.lvLista);
        registerForContextMenu(lvLista);


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
                System.out.println(lsLembrete.get(0).getHora());
            }
        }
    }


    public void adicionarLembrete(View view) {
        Intent it = new Intent(this, NovoLembreteActivity.class);
        startActivity(it);
        startActivityForResult(it, REQUEST_CODE);

    }

    public void telaChamada(View view) {
        Intent it = new Intent(this, CallActivity.class);
        startActivity(it);
    }

    public void excluirLembrete(View view, Integer id){
        new LembreteBancoController(this).remove((Integer) lvLista.getSelectedItem());
        lembreteAdapter.notifyDataSetChanged();
    }
}
