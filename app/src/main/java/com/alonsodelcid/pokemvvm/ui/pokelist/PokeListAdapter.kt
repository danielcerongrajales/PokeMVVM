package com.alonsodelcid.pokemvvm.ui.pokelist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alonsodelcid.pokemvvm.R
import com.alonsodelcid.pokemvvm.model.api.Pokemon
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_pokemon_search.view.*

class PokeListAdapter(val pokemonClick: (Int) -> Unit): RecyclerView.Adapter<PokeListAdapter.SearchViewHolder>() {
    private var pokemonList: List<Pokemon> = emptyList()

    fun setData(list: List<Pokemon>){
        pokemonList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_pokemon_search, parent,false))
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.itemView.pokemonText.text = "#${position + 1} - ${pokemon.name}"
        Log.d("TAG", "onBindViewHolder: ${itemCount}")
        holder.itemView.setOnClickListener { pokemonClick(position + 1) }
        Glide.with(holder.itemView.context).load(pokemon.sprites.frontDefault).into(holder.itemView.imageView2)
    }

    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}