package br.com.rafaelfioretti.servicesapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import br.com.rafaelfioretti.servicesapp.R;

/**
 * Created by rafaelfioretti on 11/28/16.
 */

public class AlarmReceiver extends BroadcastReceiver{

    private MediaPlayer mp = null;

    public AlarmReceiver(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        mp = MediaPlayer.create(context, R.raw.teste);
        mp.start();
        Toast.makeText(context, "Alarm...", Toast.LENGTH_LONG).show();

    }
}
