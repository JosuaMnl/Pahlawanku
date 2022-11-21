package com.yosha10.pahlawanku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private TextView tvNama, tvTentang;
    private ImageView ivFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNama = findViewById(R.id.tv_nama);
        tvTentang = findViewById(R.id.tv_tentang);
        ivFoto = findViewById(R.id.iv_foto);

        Intent terimaIntent = getIntent();
        tvNama.setText(terimaIntent.getStringExtra("xNama"));
        tvTentang.setText(terimaIntent.getStringExtra("xTentang"));
        Glide.with(DetailActivity.this)
                .load(terimaIntent.getStringExtra("xFoto"))
                .into(ivFoto);





    }
}