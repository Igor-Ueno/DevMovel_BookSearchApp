package com.example.booksearchapp.service

import retrofit2.http.GET
import retrofit2.http.Query

interface OpenLibraryApiInterface {

    @GET()
    suspend fun getBooksByQuery(
        @Query("appid") appid: String,
        @Query("q") queryString: String
    ) : OpenLibraryResponse

}