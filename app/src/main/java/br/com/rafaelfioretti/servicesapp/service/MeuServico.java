package br.com.rafaelfioretti.servicesapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by rafaelfioretti on 11/28/16.
 */

public class MeuServico extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand (Intent intent, int flags, int startid){
        Log.i("Meu serviço", "Serviço iniciando...");
        return START_STICKY;
s

    }

    @Override
    public void onCreate() {
        Log.i("ServicoMessage", "***-Serviço Iniciado... ***");
    }

    @Override
    public void onDestroy() {
        Log.i("ServicoMessage", "***-Servico encerrado");
    }
}
