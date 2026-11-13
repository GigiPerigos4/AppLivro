package com.example.livros.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import com.example.livros.model.Item

@Composable
fun HomeScreen(
    itens: List<Item>,
    onDetalhes: (Int) -> Unit,
    onCadastro: () -> Unit,
    onSobre: () -> Unit
) {
    Scaffold { p ->
        Column(Modifier.padding(p).padding(16.dp)) {
            Text("Meus Livros", style = MaterialTheme.typography.headlineMedium)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onCadastro) { Text("Novo livro") }
                Button(onSobre) { Text("Sobre") }
            }
            LazyColumn {
                items(itens) {
                    Row(
                        Modifier.fillMaxWidth().padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column { Text(it.titulo); Text(it.autor) }
                        Button({ onDetalhes(it.id) }) { Text("Ver") }
                    }
                }
            }
        }
    }
}
