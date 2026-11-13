package com.example.livros.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun CadastroScreen(onSalvar: (String, String, Int) -> Unit, onCancelar: () -> Unit) {
    var titulo by rememberSaveable { mutableStateOf("") }
    var autor by rememberSaveable { mutableStateOf("") }
    var ano by rememberSaveable { mutableStateOf("") }
    var erro by rememberSaveable { mutableStateOf("") }

    Scaffold { p ->
        Column(Modifier.padding(p).padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(titulo, { titulo = it }, Modifier.fillMaxWidth(), label = { Text("Título") })
            OutlinedTextField(autor, { autor = it }, Modifier.fillMaxWidth(), label = { Text("Autor") })
            OutlinedTextField(
                ano, { ano = it }, Modifier.fillMaxWidth(), label = { Text("Ano") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Text(erro, color = MaterialTheme.colorScheme.error)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button({
                    val n = ano.toIntOrNull()
                    erro = when {
                        titulo.isBlank() -> "Informe o título."
                        autor.trim().length < 3 -> "O autor deve ter ao menos 3 letras."
                        n == null || n <= 0 -> "O ano deve ser um número positivo."
                        else -> ""
                    }
                    if (erro.isEmpty()) onSalvar(titulo.trim(), autor.trim(), n!!)
                }) { Text("Salvar") }
                OutlinedButton(onCancelar) { Text("Cancelar") }
            }
        }
    }
}
