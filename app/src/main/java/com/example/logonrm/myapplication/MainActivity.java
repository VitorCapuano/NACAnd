package com.example.logonrm.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText edtUsuario, edtSenha;
    private DatePicker dpNascimento;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = (EditText) findViewById(R.id.editText);
        edtSenha = (EditText) findViewById(R.id.editText2);
        dpNascimento = (DatePicker) findViewById(R.id.dpNascimento);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }
    public void validaLogin(View v){
        Intent intent = new Intent(this, ValidaLoginService.class);
        String mes = String.valueOf(dpNascimento.getMonth());
        String ano = String.valueOf(dpNascimento.getYear());
        String dia = String.valueOf(dpNascimento.getDayOfMonth());

        Calendar calendar = Calendar.getInstance();
        calendar.set(dpNascimento.getYear(), dpNascimento.getMonth(), dpNascimento.getDayOfMonth());
        Date date = calendar.getTime();
        Date date1 = new Date();
        long fina = date.getTime() - date1.getTime();
        String fim = String.valueOf(fina);
        String final_date = dia + '/' + mes + '/' + ano;
        intent.putExtra("fim", fim);
        intent.putExtra("final_date", final_date);
        intent.putExtra("usuario", edtUsuario.getText().toString());
        intent.putExtra("senha", edtSenha.getText().toString());

        startService(intent);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
}
