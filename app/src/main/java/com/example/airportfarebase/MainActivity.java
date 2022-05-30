package com.example.airportfarebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText EdName,EdVVP,EdLocation;
    // ссылка на бд
    private DatabaseReference mDataBase;
    private String AIR_KEY = "AIR";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        EdName = findViewById(R.id.EdName);
        EdVVP = findViewById(R.id.EdVVP);
        EdLocation = findViewById(R.id.EdLocation);
        mDataBase = FirebaseDatabase.getInstance().getReference(AIR_KEY);
    }

    // Сохранение инфы в бд и ее заполнение
    public void onclickSave(View view){
        String id = mDataBase.getKey();
        String name = EdName.getText().toString();
        String VVP = EdVVP.getText().toString();
        String location = EdLocation.getText().toString();
        Air newAir = new Air(id,name,VVP,location);
        // Проверка на пустоту , если не пустой, то все корректно запустится
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(VVP)&& !TextUtils.isEmpty(location))
        {
            mDataBase.push().setValue(newAir);
            Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
        }
        else {
            // У вас пустое поле
            Toast.makeText(this, "пустое поле", Toast.LENGTH_SHORT).show();
        }

    }
    public void onclickRead(View view){
        Intent i = new Intent(MainActivity.this,ReadActivity.class);
        startActivity(i);
    }
}