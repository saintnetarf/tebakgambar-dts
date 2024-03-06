package com.example.tebakgambar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TebakActivity extends AppCompatActivity {
    Button btn_cek, btn_kembali2;
    EditText txt_jawab;
    ImageView iv_tebak;
    private String jawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tebak);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txt_jawab = findViewById(R.id.txt_jawab);
        btn_cek = findViewById(R.id.btn_cek);
        btn_kembali2 = findViewById(R.id.btn_kembali2);
        iv_tebak = findViewById(R.id.iv_tebak);

        btn_kembali2.setOnClickListener(this::kembaliMenu2);
        cekIntentGambar();
        cekJawaban();
    }

    private boolean kembaliMenu2(View view){
        startActivity(new Intent(this, PermainanMulai.class));
        return true;
    }

    private void cekIntentGambar() {
        Intent cek = getIntent();
        String iconName = cek.getStringExtra("Nama Icon");
        int drawableResource = 0;
        switch (iconName != null ? iconName.toLowerCase() : "") {
            case "instagram":
                drawableResource = R.drawable.instagram;
                jawaban = "instagram";
                break;
            case "whatsapp":
                drawableResource = R.drawable.whatsapp;
                jawaban = "whatsapp";
                break;
            case "twiter": // Ubah dari "twiter" menjadi "twitter"
                drawableResource = R.drawable.twiter; // Ubah dari "twiter" menjadi "twitter"
                jawaban = "twiter"; // Ubah dari "twiter" menjadi "twitter"
                break;
            default:
                drawableResource = R.drawable.banana;
                jawaban = "banana";
                break;
        }
        iv_tebak.setImageResource(drawableResource);
    }

    private void cekJawaban() {
        btn_cek.setOnClickListener(view -> {
            String jawabanPengguna = txt_jawab.getText().toString();
            if (jawabanPengguna.equalsIgnoreCase(jawaban)) { // Menggunakan equalsIgnoreCase untuk membandingkan jawaban
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_LONG).show();
            }
        });
    }
}
