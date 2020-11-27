package com.thanaa.rickmorty

import retrofit2.Response
import retrofit2.http.GET

interface api {
    @GET("character")
   suspend fun fetchCharacters():Response<CharacterResponse>
}