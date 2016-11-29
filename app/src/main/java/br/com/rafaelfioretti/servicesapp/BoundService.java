package br.com.rafaelfioretti.servicesapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;

import static br.com.rafaelfioretti.servicesapp.Constantes.LOG_TAG_EXERCICIO4;

/**
 * Created by rafaelfioretti on 11/28/16.
 */

public class BoundService extends Service {

    private Chronometer mChronometer;
    private IBinder mBinder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(LOG_TAG_EXERCICIO4, "on Create");
        mChronometer = new Chronometer(this);
        mChronometer.setBase(SystemClock.elapsedRealtime());
        mChronometer.start();
    }


    @Override
    public IBinder onBind(Intent intent) {
        Log.v(LOG_TAG_EXERCICIO4, "OnBind");
        return mBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.v(LOG_TAG_EXERCICIO4, "onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(LOG_TAG_EXERCICIO4, "onUnbind");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(LOG_TAG_EXERCICIO4, "OnDestroy");
        mChronometer.stop();
    }

    public String getTimestamp() {
        long elapsedMillis = SystemClock.elapsedRealtime() - mChronometer.getBase();
        int hours = (int) (elapsedMillis / 3600000);
        int min = (int) (elapsedMillis - hours * 3600000) / 60000;
        int sec = (int) (elapsedMillis - hours * 3600000 - min * 60000) / 1000;
        int mil = (int) (elapsedMillis - hours * 3600000 - min * 60000 - sec * 1000);
        return hours + ":" + min + ":" + sec + ":" + mil;

    }


    public class MyBinder extends Binder {
        BoundService getService() {
            return BoundService.this;
        }

    }
}