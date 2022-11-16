package com.yosha10.pahlawanku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.ClassViewHolder>{ // VH di dalam <> RecyclerView, adalah class view holder
    private ArrayList<ModelPahlawan> dataPahlawan; // Variabel Array List dari Model Pahlawan

    public AdapterCard(ArrayList<ModelPahlawan> dataPahlawan) { //Constructor
        this.dataPahlawan = dataPahlawan;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false); // Item card di pompa/disatukan ke parent (Recycler View) nya, tetapi tidak menyatu ke akarnya karena attactToRootnya false
        return new ClassViewHolder(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        ModelPahlawan pahlawan = dataPahlawan.get(position);
        holder.tvNama.setText(pahlawan.getNama());
        holder.tvTentang.setText(pahlawan.getTentang());
        Glide
                .with(holder.itemView.getContext())
                .load(pahlawan.getFoto())
                .centerCrop()
                .into(holder.ivFoto);
    }

    @Override
    public int getItemCount() {
        return dataPahlawan.size(); // Mengambil size total card view nya
    }

    public class ClassViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvTentang;
        ImageView ivFoto;
        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvTentang = itemView.findViewById(R.id.tv_tentang);
            ivFoto = itemView.findViewById(R.id.iv_foto);
        }
    }
}
