package com.example.tebakgambar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PermainanMulai extends AppCompatActivity {
    ImageView iv_instagram;
    ImageView iv_wa;
    ImageView iv_twitter;
    Button btn_kembali;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permainan_mulai);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            v.setPadding(insets.getSystemWindowInsetLeft(), insets.getSystemWindowInsetTop(),
                    insets.getSystemWindowInsetRight(), insets.getSystemWindowInsetBottom());
            return insets.consumeSystemWindowInsets();
        });

        iv_instagram=findViewById(R.id.iv_instagram);
        iv_wa=findViewById(R.id.iv_wa);
        iv_twitter=findViewById(R.id.iv_twitter);
        btn_kembali=findViewById(R.id.btn_kembali);

        btn_kembali.setOnClickListener(this::kembaliMenu);
        klikGambar();
    }

    private boolean kembaliMenu(View view){
        startActivity(new Intent(this, MainActivity.class));
        return true;
    }

    private void startTebakActivity(String iconName){
        Intent i = new Intent(this, TebakActivity.class);
        i.putExtra("Nama Icon", iconName);
        startActivity(i); // tambahkan ini untuk memulai aktivitas
    }

    private void klikGambar(){
        iv_instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTebakActivity("instagram");
            }
        });
        iv_wa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTebakActivity("whatsapp");
            }
        });
        iv_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTebakActivity("twiter");
            }
        });
    }
}
