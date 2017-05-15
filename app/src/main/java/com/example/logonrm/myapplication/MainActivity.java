package com.example.logonrm.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

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
        intent.putExtra("usuario", edtUsuario.getText().toString());
        intent.putExtra("senha", edtSenha.getText().toString());
        startService(intent);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
}
