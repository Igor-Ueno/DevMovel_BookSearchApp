package com.example.booksearchapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.booksearchapp.ui.theme.BookSearchAppTheme

//import com.example.retrofit1app_kt2.ui.theme.Retrofit1App_kt2Theme

@Composable
fun App() {
    val viewModel = viewModel<MainViewModel>()
    var searchString by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        OutlinedTextField(
            value = searchString,
            onValueChange = { searchString = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Pesquise aqui") }
        )
        Spacer(Modifier.height(10.dp))
//        Button(onClick = { viewModel.getBooks(searchString) }) {
//            Text(text = "Pesquisar")
//        }
        if (viewModel.loading)
//            Text(text = "loading...")
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        else
            Text(
                style = MaterialTheme.typography.headlineMedium,
                text = viewModel.bookLabel
            )
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    BookSearchAppTheme {
        App()
    }
}