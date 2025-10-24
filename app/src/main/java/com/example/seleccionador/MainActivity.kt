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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    val listaAlumnos1 = remember { mutableStateListOf<String>() }
    val listaAlumnos2 = remember { mutableStateListOf<String>() }

    listaAlumnos1.addAll(
        listOf(
            "David Romero",
            "Carlos Bermudez",
            "Carlos Barrera",
            "David Salvador",
            "David Berlinches",
            "Daniel Beltran"
        )
    )



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
            VistaLista(listaAlumnos1)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.25F),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier.padding(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.primario)
                ),
                onClick = {
                    if (listaAlumnos1.size!=0) {
                        val selecionado = (0..listaAlumnos1.size - 1).random()
                        listaAlumnos2.add(listaAlumnos1[selecionado])
                        listaAlumnos1.removeAt(selecionado)
                    }
            }){
                Text("Seleccionar")
            }
            Button(
                modifier = Modifier.padding(10.dp),
                colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.primario)
                    ),
            onClick = {
                listaAlumnos1.addAll(listaAlumnos2)
                listaAlumnos2.clear()
            }){
            Text("Reiniciar")
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
            VistaLista(listaAlumnos2)
        }
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
@Composable
fun VistaLista(lista: MutableList<String>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .border(2.dp, colorResource(R.color.black), RectangleShape)
            .background(colorResource(R.color.primario))
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            lista.forEach { alumno ->
                ComponetesLista(alumno)
            }
        }
    }
}

@Composable
fun ComponetesLista(alumno: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .background(colorResource(R.color.secundario)),
        contentAlignment = Alignment.CenterStart
    ) {
            Text(
                text = "$alumno",
                modifier = Modifier.padding(start = 100.dp)
            )
    }
}