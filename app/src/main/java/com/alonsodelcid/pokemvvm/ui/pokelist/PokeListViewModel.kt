package com.alonsodelcid.pokemvvm.ui.pokelist

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alonsodelcid.pokemvvm.model.api.PokeApiResponse
import com.alonsodelcid.pokemvvm.model.api.PokeResult
import com.alonsodelcid.pokemvvm.model.api.Pokemon
import com.alonsodelcid.pokemvvm.service.PokeApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PokeListViewModel() : ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: PokeApiService = retrofit.create(PokeApiService::class.java)

    val pokemonList = MutableLiveData<List<PokeResult>>()
    val pokemonInfo = MutableLiveData<Pokemon>()
//    var lst = MutableLiveData<ArrayList<Pokemon>>()
//    var newlist = arrayListOf<Pokemon>()

    fun getPokemonList(){
        val call = service.getPokemonList(100,0)

        call.enqueue(object : Callback<PokeApiResponse>{
            override fun onResponse(call: Call<PokeApiResponse>,response: Response<PokeApiResponse>) {
                response.body()?.results?.let { list ->
                    pokemonList.postValue(list)
                }

            }

            override fun onFailure(call: Call<PokeApiResponse>, t: Throwable) {
                call.cancel()
            }

        })
    }
    fun getPokemonInfo(id: Int) {
        val call = service.getPokemonInfo(id)

        call.enqueue(object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                response.body()?.let { pokemon ->
                    pokemonInfo.postValue(pokemon)
                }
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                call.cancel()
            }

        })
}
//    fun add(blog: Pokemon){
//        newlist.add(blog)
//
//        lst.value=newlist
//    }
}