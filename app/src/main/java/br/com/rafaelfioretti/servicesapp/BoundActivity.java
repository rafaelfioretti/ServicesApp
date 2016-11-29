package br.com.rafaelfioretti.servicesapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BoundActivity extends AppCompatActivity {

    private TextView timestampText;
    private Button btnPrint;
    private Button btnStop;
    BoundService mBoundService;
    boolean mServiceBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound);

        timestampText = (TextView) findViewById(R.id.tvTimestamp);
        btnPrint = (Button) findViewById(R.id.btnPrint);
        btnStop = (Button) findViewById(R.id.btnStop);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, BoundService.class);
        startService(intent);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mServiceBound){
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
    }

    public void printTimeStamp(View v){
        if(mServiceBound){
            timestampText.setText(mBoundService.getTimestamp());

        }

    }

    public void stop(View v){
        if (mServiceBound){
                unbindService(mServiceConnection);
                mServiceBound = false;
        }

        Intent intent = new Intent(BoundActivity.this, BoundService.class);
        stopService(intent);
    }


    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.MyBinder myBinder = (BoundService.MyBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mServiceBound = false;
        }
    };




}
