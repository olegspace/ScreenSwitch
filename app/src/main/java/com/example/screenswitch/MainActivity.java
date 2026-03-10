package com.example.screenswitch;

import android.os.Bundle;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import android.widget.Button;
import android.widget.EditText;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnAbout = findViewById(R.id.button_about);
        btnAbout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });

        Button buttonSecond = findViewById(R.id.button_second);
        buttonSecond.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        EditText userEditText = findViewById(R.id.editTextUser);
        EditText giftEditText = findViewById(R.id.editTextGift);
        EditText senderEditText = findViewById(R.id.editTextSender);

        Button btnSendData = findViewById(R.id.button_send_data);

        btnSendData.setOnClickListener(v -> {
            // Создаем Intent для перехода на второй экран
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            // Упаковываем данные (putExtra). Первое слово - ключ, второе - само значение.
            intent.putExtra("username", userEditText.getText().toString());
            intent.putExtra("gift", giftEditText.getText().toString());

            // Отправитель
            intent.putExtra("sender", senderEditText.getText().toString());
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}