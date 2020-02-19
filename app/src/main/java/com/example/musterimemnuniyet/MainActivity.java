package com.example.musterimemnuniyet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView kotu;
    ImageView orta;
    ImageView iyi;
    int sayi = 1;

    SharedPreferences sharedPreferences;
    Runnable runnable;
    Handler handler;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        number = 0;
        kotu = (ImageView) findViewById(R.id.kotu);
        orta = (ImageView) findViewById(R.id.orta);
        iyi = (ImageView) findViewById(R.id.iyi);

        kotu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayackotu();

                Toast.makeText(MainActivity.this, "TEŞEKKÜRLER", Toast.LENGTH_SHORT).show();
                kotu.setEnabled(false);
                orta.setEnabled(false);
                iyi.setEnabled(false);
                sure();
            }
        });
        orta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayacorta();
                Toast.makeText(MainActivity.this, "TEŞEKKÜRLER", Toast.LENGTH_SHORT).show();
                kotu.setEnabled(false);
                orta.setEnabled(false);
                iyi.setEnabled(false);
                sure();
            }
        });
        iyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayaciyi();

                Toast.makeText(MainActivity.this, "TEŞEKKÜRLER", Toast.LENGTH_SHORT).show();
                kotu.setEnabled(false);
                orta.setEnabled(false);
                iyi.setEnabled(false);
                sure();
            }
        });


    }

    public void panel(View view) {

        Intent intent = new Intent(MainActivity.this, panel.class);
        startActivity(intent);
    }

    public void sayackotu() {
        try {
            SQLiteDatabase databasekotu = this.openOrCreateDatabase("Memnuniyetkotu", MODE_PRIVATE, null);
            databasekotu.execSQL("CREATE TABLE IF NOT EXISTS memnuniyetkotu(id INTEGER PRIMARY KEY , kotu INT)");
            databasekotu.execSQL("INSERT INTO memnuniyetkotu (kotu) VALUES(1)");

            //database.execSQL("DELETE FROM memnuniyet WHERE kotu =15");

            //database.execSQL("UPDATE memnuniyet SET kotu = 35");
            Cursor cursor = databasekotu.rawQuery("SELECT * FROM memnuniyetkotu", null);
            int idVeri = cursor.getColumnIndex("id");
            int kotuVeri = cursor.getColumnIndex("kotu");



            while (cursor.moveToNext()) {
                System.out.println("id: " + cursor.getInt(idVeri));
                System.out.println("kotu: " + cursor.getInt(kotuVeri));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sayacorta() {
        try {
            SQLiteDatabase database = this.openOrCreateDatabase("Memnuniyetorta", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS memnuniyetorta(id INTEGER PRIMARY KEY , orta INT)");

            database.execSQL("INSERT INTO memnuniyetorta ( orta ) VALUES(1)");
            //database.execSQL("DELETE FROM memnuniyet WHERE kotu =15");

            //database.execSQL("UPDATE memnuniyet SET kotu = 35");
            Cursor cursor = database.rawQuery("SELECT * FROM memnuniyetorta", null);
            int idVeri = cursor.getColumnIndex("id");
            int ortaVeri = cursor.getColumnIndex("orta");

            while (cursor.moveToNext()) {
                System.out.println("id: " + cursor.getInt(idVeri));
                System.out.println("orta: " + cursor.getInt(ortaVeri));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sayaciyi() {
        try {
            SQLiteDatabase database = this.openOrCreateDatabase("Memnuniyetiyi", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS memnuniyetiyi(id INTEGER PRIMARY KEY , iyi INT)");

            database.execSQL("INSERT INTO memnuniyetiyi (iyi) VALUES(1)");
            //database.execSQL("DELETE FROM memnuniyet WHERE kotu =15");

            //database.execSQL("UPDATE memnuniyet SET kotu = 35");
            Cursor cursor = database.rawQuery("SELECT * FROM memnuniyetiyi", null);
            int idVeri = cursor.getColumnIndex("id");
            int iyiVeri = cursor.getColumnIndex("iyi");

            while (cursor.moveToNext()) {
                System.out.println("id: " + cursor.getInt(idVeri));
                System.out.println("iyi: " + cursor.getInt(iyiVeri));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sure() {

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                number++;
                handler.postDelayed(runnable, 1000);
                if (number == 2) {
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    kotu.setEnabled(true);
                    orta.setEnabled(true);
                    iyi.setEnabled(true);
                    number = 0;
                    handler.removeCallbacks(runnable);
                }

            }
        };
        handler.post(runnable);
    }
}