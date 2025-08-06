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
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults

val mascotas = mutableListOf(
    Mascota("Grace", "Gato", "Esfinge", false, imageId = R.drawable.gato_pelon),
    Mascota("Chipilin", "Gato", "Azul Ruso", false, imageId = R.drawable.gato_azul_ruso),
    Mascota("Kitty", "Gato", "Persa", false, imageId = R.drawable.gato_persa),
    Mascota("Cusi", "Perro", "Chihuahua", false, imageId = R.drawable.perro_chihuahua),
    Mascota("Tiborius", "Perro", "Pastor Aleman", false, imageId = R.drawable.perro_pastor_aleman),
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
fun cardMascota(mascota: Mascota, modifier: Modifier = Modifier) {
    var adoptado by remember { mutableStateOf(mascota.adoptado) }

    Row(
        modifier = modifier
            .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
    ) {
        Column (
            modifier = Modifier.weight(1f)
        ) {
            Image(
                painter = painterResource(id = mascota.imageId),
                contentDescription = "Imagen de ${mascota.nombre}",
                modifier = Modifier.size(100.dp).
                clip(CircleShape)
            )
        }

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = mascota.nombre,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${mascota.tipo}, ${mascota.raza}",
                color = Color.Gray
            )
        }

        Button(
            onClick = { adoptado = !adoptado },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green) // Color verde
        ) {
            Text(
                text = if (adoptado) "¡Adoptado!" else "Adoptar",
                fontSize = 18.sp
            )
        }
    }
}

