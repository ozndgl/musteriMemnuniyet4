package com.example.musterimemnuniyet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnkotu;
    Button btnorta;
    Button btniyi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //btnkotu.setOnClickListener(findViewById(R.id.btn));
    }

    public void btnkotu(View view){
        Toast.makeText(MainActivity.this,"KÖTÜ",Toast.LENGTH_LONG).show();
    }
    public void btnorta(View view){
        Toast.makeText(MainActivity.this,"ORTA",Toast.LENGTH_LONG).show();
    }

    public void btniyi(View view){
        Toast.makeText(MainActivity.this,"İYİ",Toast.LENGTH_LONG).show();
    }



}
