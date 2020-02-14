package com.juara.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static int CODE_MAINACTIVITY = 100;
    TextView txtBalikan;
    EditText txtPesan;
    Spinner spnMantan;
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBalikan = findViewById(R.id.txtBalikan);
        txtPesan = findViewById(R.id.txtPesan);
        btnSend = findViewById(R.id.btnSend);

        spnMantan = findViewById(R.id.spnMantan);

        List<String> list = new ArrayList<String>();
        list.add("Lucinta Luna");
        list.add("Nong Poy");
        list.add("TEssy");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnMantan.setAdapter(dataAdapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( MainActivity.this,Activity2.class);
                intent.putExtra("informasi",txtPesan.getText().toString());
              //  startActivityForResult(intent,CODE_MAINACTIVITY);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == MainActivity.CODE_MAINACTIVITY && resultCode == Activity2.CODE_ACTIVIY2){
            txtBalikan.setText(data.getStringExtra("informasi"));
        }


    }
}
