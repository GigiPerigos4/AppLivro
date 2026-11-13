package com.example.livros.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.livros.data.ItemStore
import com.example.livros.screens.*

object Rotas {
    const val HOME = "home"
    const val CADASTRO = "cadastro"
    const val DETALHES = "detalhes"
    const val SOBRE = "sobre"
}

@Composable
fun AppNavigation() {
    val nav = rememberNavController()
    val store = remember { ItemStore() }

    NavHost(nav, Rotas.HOME) {
        composable(Rotas.HOME) {
            HomeScreen(
                itens = store.itens,
                onDetalhes = { nav.navigate("${Rotas.DETALHES}/$it") },
                onCadastro = { nav.navigate(Rotas.CADASTRO) },
                onSobre = { nav.navigate(Rotas.SOBRE) }
            )
        }
        composable(Rotas.CADASTRO) {
            CadastroScreen(
                onSalvar = { t, a, y -> store.add(t, a, y); nav.popBackStack() },
                onCancelar = { nav.popBackStack() }
            )
        }
        composable(
            "${Rotas.DETALHES}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            DetalhesScreen(store.find(it.arguments?.getInt("id") ?: -1)) { nav.popBackStack() }
        }
        composable(Rotas.SOBRE) { SobreScreen { nav.popBackStack() } }
    }
}
