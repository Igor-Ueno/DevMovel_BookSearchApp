package com.example.booksearchapp.service

class OpenLibraryRepository {
    private val api = RetrofitInstance.api
    private val appid = "1b3d0e73c2837e05efe700a16d3756e2"

    suspend fun getBooksByQuery(query: String) : OpenLibraryResponse {
        return api.getBooksByQuery(appid, query)
    }
}