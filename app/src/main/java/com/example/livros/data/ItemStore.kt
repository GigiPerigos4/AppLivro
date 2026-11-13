package com.example.livros.data

import androidx.compose.runtime.mutableStateListOf
import com.example.livros.model.Item

class ItemStore {
    val itens = mutableStateListOf(
        Item(1, "Dom Casmurro", "Machado de Assis", 1899),
        Item(2, "O Cortiço", "Aluísio Azevedo", 1890),
        Item(3, "Iracema", "José de Alencar", 1865)
    )

    fun add(titulo: String, autor: String, ano: Int) {
        itens.add(Item((itens.maxOfOrNull { it.id } ?: 0) + 1, titulo, autor, ano))
    }

    fun find(id: Int) = itens.find { it.id == id }
}
