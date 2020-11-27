package com.thanaa.rickmorty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CharacterAdapter(private val characters:List<Result>):RecyclerView.Adapter<CharacterAdapter.ViewHolder>(){


    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val itemImage :ImageView = view.findViewById(R.id.item_image)
        val itemName : TextView = view.findViewById(R.id.item_name)
        val itemSpecies :TextView = view.findViewById(R.id.item_species)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false))
    }

    override fun getItemCount()= characters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val characterItem =  characters[position]
        holder.itemName.text = characterItem.name
        holder.itemSpecies.text = characterItem.species

        Glide.with(holder.itemImage).load(characterItem.image).into(holder.itemImage)
    }

}