package com.example.logonrm.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class ValidaLoginService extends Service {
    public ValidaLoginService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationCompat.Builder nb = new NotificationCompat.Builder(this);
        nb.setTicker("Aviso");
        nb.setContentTitle("Aviso");
        nb.setSmallIcon(R.mipmap.ic_launcher);
        nb.setAutoCancel(true);

        Bundle params = intent.getExtras();
        String usuario = params.getString("usuario");
        String senha = params.getString("senha");
        String final_date = params.getString("final_date");
        String fim = params.getString("fim");

        if(usuario.equalsIgnoreCase("ps@fiap.com.br") && senha.equalsIgnoreCase("10")) {
            nb.setContentText("Login OK "+final_date + " " + fim);
        } else {
            nb.setContentText("Login inválido "+final_date + " " + fim);
        }

        nm.notify(100, nb.build());
        Intent it = new Intent(this, MainActivity.class);
        nb.setContentIntent(PendingIntent.getActivity(this, 0, it, PendingIntent.FLAG_UPDATE_CURRENT));

        return START_STICKY;
    }
}
