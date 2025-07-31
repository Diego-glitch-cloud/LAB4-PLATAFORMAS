package com.example.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.laboratorio4.ui.theme.Laboratorio4Theme

val mascotas = mutableListOf(
    Mascota("Luna", "Gato", "Esfinge", false, imageId = R.drawable.gato_pelon),
    Mascota("Chipilin", "Gato", "Azul Ruso", false, imageId = R.drawable.gato_azul_ruso),
    Mascota("Max", "Gato", "Persa", false, imageId = R.drawable.gato_persa),
    Mascota("Cusi", "Perro", "Chihuahua", false, imageId = R.drawable.perro_chihuahua),
    Mascota("Toby", "Perro", "Pastor Aleman", false, imageId = R.drawable.perro_pastor_aleman),
    Mascota("Nemito", "Pez", "Koi", false, imageId = R.drawable.pez_koi),
    Mascota("Hulk", "Pez", "Beta", false, imageId = R.drawable.pez_beta)
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Aquí va tu LazyColumn
                    LazyColumn(modifier = Modifier.padding(innerPadding)) {
                        items(mascotas) { mascota_it ->
                            cardMascota(mascota = mascota_it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun cardMascota(mascota: Mascota, modifier: Modifier = Modifier){

}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun cardMascotaPreview() {
    Laboratorio4Theme {
        cardMascota(mascota = mascotas[0])
    }
}