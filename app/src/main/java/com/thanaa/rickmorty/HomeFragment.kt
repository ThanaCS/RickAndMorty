package com.thanaa.rickmorty

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var characterAdapter :CharacterAdapter
        val characterList : RecyclerView = requireView().findViewById(R.id.character_list)
        val retrofit:api = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(api::class.java)

        GlobalScope.launch {

           val response= retrofit.fetchCharacters()
           if(response.isSuccessful){
               if (response.body() != null){
                   val data = response.body()!!.results
              //     characterAdapter = CharacterAdapter(data)
                   withContext(Dispatchers.Main){
                       characterList.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
                       characterList.adapter = CharacterAdapter(data)
                   }

               }

           }
        }
    }
}