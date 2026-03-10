package com.example.screenswitch;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView infoTextView = findViewById(R.id.textViewInfo);

        Intent intent = getIntent();
        String user = intent.getStringExtra("username");
        String gift = intent.getStringExtra("gift");

        // Отправитель
        String sender = intent.getStringExtra("sender");

        // Формируем строку и выводим на экран
        String finalMessage = user + ", вам передали: " + gift + "\n\nОтправитель: " + sender;
        infoTextView.setText(finalMessage);
    }
}