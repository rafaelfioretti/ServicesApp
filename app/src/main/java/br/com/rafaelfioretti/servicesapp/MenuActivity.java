package br.com.rafaelfioretti.servicesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void iniciaAtividade1(View v){

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void iniciaAtividade2(View v){
        Intent i = new Intent(this, Atividade2Activity.class);
        startActivity(i);
    }


    public void iniciaAtividade4(View v){
        Intent i = new Intent(this, BoundActivity.class);
        startActivity(i);
    }

}
