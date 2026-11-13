package com.example.livros.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.livros.model.Item

@Composable
fun DetalhesScreen(item: Item?, onVoltar: () -> Unit) {
    Scaffold { p ->
        Column(Modifier.padding(p).padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            if (item == null) {
                Text("Livro não encontrado.")
            } else {
                Text("Código: ${item.id}")
                Text("Título: ${item.titulo}")
                Text("Autor: ${item.autor}")
                Text("Ano: ${item.ano}")
            }
            Button(onVoltar) { Text("Voltar") }
        }
    }
}
