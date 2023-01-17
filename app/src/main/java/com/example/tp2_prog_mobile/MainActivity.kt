package com.example.tp2_prog_mobile

import android.os.Bundle
import android.os.Message
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.tp2_prog_mobile.ui.theme.Tp2progmobileTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Popup

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tp2progmobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun textLeftButtonRight() {
    Row {
        Text(text = "I'm a text")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "This is a Button")
        }
    }
}

@Composable
fun textTopButtonBottom() {
    Column {
        Text(text = "I'm a text")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "This is a Button")
        }
    }
}

@Composable
fun question3() {
    Column {
        Text(text = "I'm a label")
        Row {
            TextField(value = "", onValueChange = {})
            Button(onClick = { /*TODO*/ }) {
                Text(text = "This is a Button")
            }
        }
    }
}

@Composable
fun question5(departements: List<String>) {
    LazyColumn() {
        items(departements) { name ->
            Text(text = name)
        }
    }
}

@Composable
fun question6(departements: List<String>) {
    LazyColumn {
        items(departements) { name ->
            Text(text = "$name - Bretagne")
        }
    }
}

@Composable
fun SingleDepartement(departement: String, population: Int) {
    val showPopup = remember { mutableStateOf(false) }
    Text(text = departement, modifier = Modifier.clickable {
        showPopup.value = true
    })
    if (showPopup.value) {
        AlertDialog(
            onDismissRequest = { showPopup.value = false },
            icon = {
                Icon(Icons.Filled.Person, contentDescription = null)
            },
            title = { Text(text = "Population") },
            text = { Text(text = "La population du département $departement est de $population habitants") },
            confirmButton = {
                Button(onClick = { showPopup.value = false }) {
                    Text(text = "OK")
                }
            }
        )
    }
}
@Composable
fun question7(departements: List<String>, population: HashMap<String, Int>) {
    LazyColumn {
        items(departements) { name ->
            SingleDepartement(departement = name, population = population[name]!!)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val departements = listOf("Côtes-d'Armor", "Finistère", "Ille-et-Vilaine", "Morbihan")
    val population = hashMapOf("Côtes-d'Armor" to 650000, "Finistère" to 1000000, "Ille-et-Vilaine" to 1500000, "Morbihan" to 800000)
    Tp2progmobileTheme {
        question7(departements, population)
    }
}