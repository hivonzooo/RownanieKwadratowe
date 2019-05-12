package com.example.rownaniekwadratowe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void solution (android.view.View v) {
        EditText e = (EditText)findViewById(R.id.A);
        String sa = e.getText().toString();

        e = (EditText)findViewById(R.id.B);
        String sb = e.getText().toString();

        e = (EditText)findViewById(R.id.C);
        String sc = e.getText().toString();

        RKW r = new RKW ();
        r.setA(sa);
        r.setB(sb);
        r.setC(sc);
        r.calculate();

        TextView textView = (TextView)findViewById(R.id.Score);
        textView.setText(r.getResult());
    }

}
