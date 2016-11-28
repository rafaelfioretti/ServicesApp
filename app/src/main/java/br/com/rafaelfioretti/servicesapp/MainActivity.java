package br.com.rafaelfioretti.servicesapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.rafaelfioretti.servicesapp.receiver.AlarmReceiver;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void disparar (View v){
        EditText text = (EditText) findViewById(R.id.edTempo);
        int i = Integer.parseInt(text.getText().toString());

        Intent intent = new Intent(this, AlarmReceiver.class);

        PendingIntent pi = PendingIntent.getBroadcast(this.getApplicationContext(), 0, intent, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i+ 1000), pi);

        Toast.makeText(this, "Alarm set in " + i + " seconds", Toast.LENGTH_SHORT).show();



    }

}
