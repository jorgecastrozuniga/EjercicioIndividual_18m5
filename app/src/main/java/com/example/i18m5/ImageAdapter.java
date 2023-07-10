package com.example.i18m5;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.i18m5.databinding.DataListItemBinding;

import java.util.List;

//1 se crea clase adapter
//3 la clase adapter hereda de viewholder y se implementan los métodos

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private List<ClipData.Item>itemList;


    public ImageAdapter(Context context, List<ClipData.Item>itemList){
        this.itemList=itemList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //se infla la vista del data list item
        DataListItemBinding binding= DataListItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ImageViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        ClipData.Item descripcion= itemList.get(position);
        holder.textView.setText(descripcion.getText().toString());
        //Se carga bien la imagen
        Glide.with(holder.imageView).load(descripcion.getHtmlText()).into(holder.imageView);

       //TODO ordenar el layout se ve muy grande y el textview muy chico



        //al menos funciona
        //TODO: que es clipdata?


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    //2 se crea el viewholder
    public static class ImageViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;

        public TextView textView;
        //aca buscar bien el binding del xml donde se puso la lista
        public ImageViewHolder(DataListItemBinding binding){
            super(binding.getRoot());
            imageView=binding.imageView;
            textView=binding.textView;
        }
    }

}
