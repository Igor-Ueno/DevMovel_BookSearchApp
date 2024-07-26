package com.example.booksearchapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.booksearchapp.service.OpenLibraryRepository
import com.example.booksearchapp.service.OpenLibraryResponse
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = OpenLibraryRepository()

    var bookLabel by mutableStateOf("")
    var loading by mutableStateOf(false)

    fun getBooks(query: String) {
        val queryString = if (query.trim().isEmpty()) "Harry Potter" else query
        bookLabel = ""
        loading = true

        viewModelScope.launch {
            try {
                val response = repository.getBooksByQuery(queryString)
                val label = "Book: "
                bookLabel = String.format(label, response.main.numFound)
            } catch (e: Exception) {
                bookLabel = "Error: " + e.message
            } finally {
                loading = false
            }
        }
    }
}