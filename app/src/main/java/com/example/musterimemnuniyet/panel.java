package com.example.musterimemnuniyet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class panel extends AppCompatActivity {
    TextView toplamoykotu;
   
    TextView toplamkotu;
    TextView toplamorta;
    TextView toplamiyi;
    int idkotu;
    int idorta;
    int idiyi;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);
        toplamoykotu = findViewById(R.id.toplamoytextyaz);
        toplamkotu = findViewById(R.id.toplamkotuyaz);
        toplamorta = findViewById(R.id.toplamortayaz);
        toplamiyi = findViewById(R.id.toplamiyiyaz);
        sonuckotu();
        sonucorta();
        sonuciyi();

    }




    public void sonuckotu() {
        try {
            SQLiteDatabase databasekotu = this.openOrCreateDatabase("Memnuniyetkotu", MODE_PRIVATE, null);
            databasekotu.execSQL("CREATE TABLE IF NOT EXISTS memnuniyetkotu(id INTEGER PRIMARY KEY , kotu INT)");

            Cursor cursor = databasekotu.rawQuery("SELECT * FROM memnuniyetkotu", null);
            idkotu = cursor.getColumnIndex("id");
            int kotuVeri = cursor.getColumnIndex("kotu");

            while (cursor.moveToNext()) {
                System.out.println("id: " + cursor.getInt(idkotu));
                toplamkotu.setText("" + cursor.getInt(idkotu));
                System.out.println("kotu: " + cursor.getInt(kotuVeri));
                //toplamkotu.setText("" + cursor.getInt(kotuVeri));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sonucorta() {
        try {
            SQLiteDatabase database = this.openOrCreateDatabase("Memnuniyetorta", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS memnuniyetorta(id INTEGER PRIMARY KEY , orta INT)");

            Cursor cursor = database.rawQuery("SELECT * FROM memnuniyetorta", null);
            idorta = cursor.getColumnIndex("id");
            int ortaVeri = cursor.getColumnIndex("orta");

            while (cursor.moveToNext()) {
                System.out.println("id: " + cursor.getInt(idorta));
                toplamorta.setText("" + cursor.getInt(idorta));
                System.out.println("kotu: " + cursor.getInt(ortaVeri));
                //toplamorta.setText("" + cursor.getInt(ortaVeri));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sonuciyi() {
        try {
            SQLiteDatabase database = this.openOrCreateDatabase("Memnuniyetiyi", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS memnuniytiyi(id INTEGER PRIMARY KEY , iyi INT)");

            Cursor cursor = database.rawQuery("SELECT * FROM memnuniyetiyi", null);
            idiyi = cursor.getColumnIndex("id");
            int iyiVeri = cursor.getColumnIndex("iyi");

            while (cursor.moveToNext()) {
                System.out.println("id: " + cursor.getInt(idiyi));
                toplamiyi.setText("" + cursor.getInt(idiyi));
                System.out.println("iyi: " + cursor.getInt(iyiVeri));
                //toplamiyi.setText("" + cursor.getInt(iyiVeri));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gerigit(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }
}
