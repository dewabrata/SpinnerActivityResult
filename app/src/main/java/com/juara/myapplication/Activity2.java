package com.juara.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    public static int CODE_ACTIVIY2 = 200;
    TextView txtDari;
    Button btnSendBack;
    EditText txtPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        txtDari = findViewById(R.id.txtDari);
        btnSendBack = findViewById(R.id.btnSendBack);
        txtPesan = findViewById(R.id.txtPesan);

       String pesandari =  getIntent().getStringExtra("informasi");

       if (pesandari!=null){
           txtDari.setText(pesandari);
       }

        btnSendBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("informasi",txtPesan.getText().toString());
                setResult(CODE_ACTIVIY2,intent);
                finish();
            }
        });
    }
}
