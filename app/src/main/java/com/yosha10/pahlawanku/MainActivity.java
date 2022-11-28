package com.yosha10.pahlawanku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
        tampilDataGrid();
    }

    // Menyambungkan dengan Adapter
    private void tampilDataCard(){
        rvPahlawan.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard AC = new AdapterCard(data, MainActivity.this); // MenColokan Adapter
        rvPahlawan.setAdapter(AC);
    }

    private void tampilDataGrid(){
        rvPahlawan.setLayoutManager(new GridLayoutManager(this, 2));
        AdapterGrid AG = new AdapterGrid(data, MainActivity.this);
        rvPahlawan.setAdapter(AG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tampilan, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_card:
                tampilDataCard();
                break;
            case R.id.menu_grid:
                tampilDataGrid();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}