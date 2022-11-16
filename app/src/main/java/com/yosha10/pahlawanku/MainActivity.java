package com.yosha10.pahlawanku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPahlawan;
    private ArrayList<ModelPahlawan> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPahlawan = findViewById(R.id.rv_pahlawan);
        rvPahlawan.setHasFixedSize(true); // Karena telah mengetahui jumlah data pahlawan

        data.addAll(DataPahlawan.ambilDataPahlawan()); // Mengisi variabel data dengan semua data pahlawan dari class Data Pahlawan
        tampilDataCard();
    }

    // Menyambungkan dengan Adapter
    private void tampilDataCard(){
        rvPahlawan.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard AC = new AdapterCard(data); // MenColokan Adapter
        rvPahlawan.setAdapter(AC);
    }
}