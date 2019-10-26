package com.myhealthaplication.myhealthaplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.myhealthaplication.myhealthaplication.controler.LembreteBancoController;
import com.myhealthaplication.myhealthaplication.entidades.Lembretes;

public class NovoLembreteActivity extends AppCompatActivity {

    private EditText txtTitulo;
    private EditText txtConteudo;
    private EditText txtData;
    private EditText txtHora;
    Lembretes lembrete;
    private CalendarView calendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_lembrete);
        this.calendario = findViewById(R.id.calendar);
        this.txtTitulo = findViewById(R.id.txtTitulo);
        this.txtConteudo = findViewById(R.id.txtConteudo);
        this.txtData = findViewById(R.id.txtData);
        this.txtHora = findViewById(R.id.txtHora);


    }


    public void cadastrarLembrete(View view){
        String titulo = this.txtTitulo.getText().toString();
        String conteudo = this.txtConteudo.getText().toString();
        String data = this.txtData.getText().toString();
        String hora = this.txtHora.getText().toString();

        lembrete = new Lembretes(titulo, conteudo, data, hora);
        new LembreteBancoController(this).add(lembrete);
        Intent it = new Intent(this, MainActivity.class);
        it.putExtra("titulo", titulo);
        it.putExtra("conteudo", conteudo);
        it.putExtra("data", data);
        it.putExtra("hora", hora);
        setResult(RESULT_OK, it);
    }
}