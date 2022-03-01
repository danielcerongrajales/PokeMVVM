package com.alonsodelcid.pokemvvm.ui.pokelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alonsodelcid.pokemvvm.databinding.ActivityPokelistBinding
import com.alonsodelcid.pokemvvm.model.api.Pokemon

class PokeListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPokelistBinding
    private var pokemonList : MutableList<Pokemon> =mutableListOf()
    private lateinit var viewModel: PokeListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokelistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(PokeListViewModel::class.java)
        initUI()
    }

    private fun initUI() {
        binding.pokelistRecyclerView.layoutManager = LinearLayoutManager(this)

        binding.pokelistRecyclerView.adapter = PokeListAdapter{
//            val intent = Intent(this, PokeInfoActivity::class.java)
//            intent.putExtra("id", it)
//            startActivity(intent)
        }

        viewModel.getPokemonList()

        viewModel.pokemonList.observe(this) { pokelist ->
            (binding.pokelistRecyclerView.adapter as? PokeListAdapter)?.setData( pokelist)
//            for ((index, value) in pokelist.withIndex()) {
//                Log.d("TAG","${index}")
//                viewModel.getPokemonInfo(index + 1)
//
//            }

        }
//        viewModel.pokemonInfo.observe(this, Observer {
//
//            viewModel.add(it)

//            })
//        viewModel.lst.observe(this, Observer{
//
//if(!viewModel.newlist.isEmpty()){
//
//}
//
//        })


    }
}