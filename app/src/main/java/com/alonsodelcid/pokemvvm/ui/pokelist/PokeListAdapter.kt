package com.alonsodelcid.pokemvvm.ui.pokelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alonsodelcid.pokemvvm.databinding.CardPokemonSearchBinding
import com.alonsodelcid.pokemvvm.model.api.PokeResult
import com.alonsodelcid.pokemvvm.model.api.Pokemon
import com.bumptech.glide.Glide


class PokeListAdapter(val pokemonClick: (Int) -> Unit): RecyclerView.Adapter<PokeListAdapter.SearchViewHolder>() {
    private var pokemonList: List<PokeResult> = emptyList<PokeResult>()
    private lateinit var binding: CardPokemonSearchBinding
    fun setData(list: List<PokeResult>) {
        pokemonList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        binding = CardPokemonSearchBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        binding.pokemonText.text = pokemon.name
        holder.itemView.setOnClickListener { pokemonClick(position + 1) }
        var picture = pokemon.url.getPicUrl()
        Glide.with(holder.itemView.context).load(picture).into(binding.imageView2)
    }

    class SearchViewHolder(private val binding: CardPokemonSearchBinding) :
        RecyclerView.ViewHolder(binding.root)
}