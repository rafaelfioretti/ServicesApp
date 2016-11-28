package br.com.rafaelfioretti.servicesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.rafaelfioretti.servicesapp.service.MeuServico;

public class Atividade2Activity extends AppCompatActivity {

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade2);
        i = new Intent(this, MeuServico.class);
    }

    public void startServico(View v){
        startService(i);

    }

    public void stopServico(View v){

        stopService(i);
    }
}
