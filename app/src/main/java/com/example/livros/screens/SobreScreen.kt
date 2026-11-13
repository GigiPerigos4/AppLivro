package com.example.livros.screens

import android.content.ActivityNotFoundException
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SobreScreen(onVoltar: () -> Unit) {
    val ctx = LocalContext.current
    val texto = "Meus Livros: app para cadastrar e consultar livros."

    Scaffold { p ->
        Column(Modifier.padding(p).padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Meus Livros", style = MaterialTheme.typography.headlineMedium)
            Text("Finalidade: cadastrar e consultar livros.")
            Text("Como usar: toque em Novo livro para cadastrar e em Ver para abrir os detalhes.")
            Text("Autor: Seu Nome")
            Button({
                val envio = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, texto)
                }
                try {
                    ctx.startActivity(Intent.createChooser(envio, "Compartilhar"))
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(ctx, "Nenhum app compatível.", Toast.LENGTH_SHORT).show()
                }
            }) { Text("Compartilhar aplicativo") }
            OutlinedButton(onVoltar) { Text("Voltar") }
        }
    }
}