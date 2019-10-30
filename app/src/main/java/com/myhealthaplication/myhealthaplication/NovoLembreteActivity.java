package com.myhealthaplication.myhealthaplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.annotation.NonNull;
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

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                    String data = dayOfMonth + "/" + month + "/" + year;
                    txtData.setText(data);
            }
        });
    }


    public void cadastrarLembrete(View view){
        String titulo = this.txtTitulo.getText().toString();
        String conteudo = this.txtConteudo.getText().toString();
        String data = this.txtData.getText().toString();
        String hora = this.txtHora.getText().toString();

        lembrete = new Lembretes(titulo, conteudo, data, hora);
        boolean cond = new LembreteBancoController(this).add(lembrete);
        System.out.println(cond);
        Intent it = new Intent(this, MainActivity.class);
        it.putExtra("titulo", titulo);
        it.putExtra("conteudo", conteudo);
        it.putExtra("data", data);
        it.putExtra("hora", hora);
        System.out.println("Pegou todos os dados e enviou a proxima activity");
        setResult(RESULT_OK, it);
        finish();
    }

}