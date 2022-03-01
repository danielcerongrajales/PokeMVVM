package com.alonsodelcid.pokemvvm.ui.pokelist


    fun getUrlNumber(url:String):Int
    {
        val splitUrl = url.split("/")
        return splitUrl[splitUrl.lastIndex-1].toInt()
    }
fun String.extractId() = this.substringAfter("pokemon").replace("/", "").toInt()

fun String.getPicUrl(): String {
    val id = this.extractId()
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png"
}