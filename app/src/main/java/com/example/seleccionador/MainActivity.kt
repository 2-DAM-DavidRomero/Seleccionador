package com.example.seleccionador

import android.os.Bundle
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seleccionador.ui.theme.SeleccionadorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SeleccionadorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Seleccionador",
                        modifier = Modifier.padding(innerPadding)

                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val listaAlumnos = mutableListOf<String>()
    listaAlumnos.add("David Romero")
    listaAlumnos.add("Carlos Bermudez")
    listaAlumnos.add("Carlos Barrera")
    listaAlumnos.add("David Salvador")
    listaAlumnos.add("David Berlinches")
    listaAlumnos.add("Daniel Beltran")
    listaAlumnos.add("Daniel Beltran")
    listaAlumnos.add("Daniel Beltran")


    Column(
        modifier = Modifier
            .background(colorResource(R.color.secundario))
            .fillMaxWidth(),
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(25.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp) // 🔹 alto fijo para que se vea el borde
                    .border(2.dp, colorResource(R.color.black), RectangleShape) // 🔹 borde visible
                    .background(colorResource(R.color.primario))
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    listaAlumnos.forEach { alumno ->
                        ComponetesLista(alumno)
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.25F),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.primario) // 🔹 color de fondo
                ),
                onClick = {

            }){
                Text("Seleccionar")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(25.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp) // 🔹 alto fijo para que se vea el borde
                    .border(2.dp, colorResource(R.color.black), RectangleShape) // 🔹 borde visible
                    .background(colorResource(R.color.primario))
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    listaAlumnos.forEach { alumno ->
                        ComponetesLista(alumno)
                    }
                }
            }
        }
    }
}

@Composable
fun ComponetesLista(alumno: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp) // todas las cajas mismas dimensiones
            .padding(horizontal = 16.dp, vertical = 4.dp) // margen entre cajas
            .background(colorResource(R.color.secundario)),
        contentAlignment = Alignment.CenterStart // texto alineado a la izquierda y centrado vertical
    ) {
        Text(
            text = alumno,
            modifier = Modifier.padding(start = 100.dp) // margen interno del texto
        )
    }
}

@Preview( showBackground = true,
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp,dpi=420")
@Composable
fun GreetingPreview() {

    SeleccionadorTheme {
        Greeting("Seleccionador")
    }
}