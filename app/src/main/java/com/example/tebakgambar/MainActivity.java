package com.example.tebakgambar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tv_name;
    Button btn_masuk;
    Button btn_keluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tv_name), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_masuk=findViewById(R.id.btn_masuk);
        btn_keluar=findViewById(R.id.btn_keluar);

        btn_masuk.setOnClickListener(this::mulaiPermainan);
        btn_keluar.setOnClickListener(this::keluarPermainan);
    }

    private boolean mulaiPermainan(View view){
        startActivity(new Intent(this, PermainanMulai.class));
        return true;
    }
    private void keluarPermainan(View view){
        new AlertDialog.Builder(this)
                .setTitle("konfirmasi Pilihan")
                .setMessage("Apakah anda mau keluar")
                .setNegativeButton("Tidak", null)
                .setPositiveButton("Iya", (dialogInterface, i) -> finish()).show();
    }
}