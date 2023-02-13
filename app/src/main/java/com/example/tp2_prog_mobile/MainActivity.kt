package com.example.tp2_prog_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.tp2_prog_mobile.ui.theme.Tp2progmobileTheme

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
                    DefaultPreview()
                }
            }
        }
    }
}

/**
 * # QUESTION 1
 *
 * *Créer une interface Linear layout avec un un texte à gauche, puis un bouton à droite*
 *
 *
 * L'équivalent d'un Linear layout en utilisant Jetpack Compose est une Row ou une Column.
 * Une Row permet de placer des éléments les uns à côté des autres.
 * Cet élément permet de placer des éléments les uns à côté des autres.
 * Pour placer le texte à gauche, il faut le placer en premier dans la Row..
 * Et pour placer le bouton à droite, il faut le placer en dernier.
 */
@Composable
fun textLeftButtonRight() {
    Row {
        Text(text = "I'm a text")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "This is a Button")
        }
    }
}

/**
 * # QUESTION 2
 *
 * *Créer une interface Linear layout avec un texte au dessus, puis un bouton en dessous*
 *
 * L'équivalent d'un Linear layout en utilisant Jetpack Compose est une Row ou une Column.
 * Une Column permet de placer des éléments les uns en dessous des autres.
 * Pour placer le texte au dessus, il faut le placer en premier dans la Column.
 * Et pour placer le bouton en dessous, il faut le placer en dernier.
 */
@Composable
fun textTopButtonBottom() {
    Column {
        Text(text = "I'm a text")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "This is a Button")
        }
    }
}

/**
 * # QUESTION 3
 *
 * *Créer une interface à bas de Linear layout avec un label au dessus, puis en dessous un texte remplissable à gauche et un bouton à droite*
 *
 * On décompose l'interface en deux layouts.
 * On va d'abord décomposer l'interface en lignes.
 * La première ligne contient le label.
 * La deuxième ligne contient le texte remplissable et le bouton.
 * Pour placer le texte remplissable côte à côte avec le bouton, on utilise une Row qui permet de décomposer la ligne en colonnes.
 * Le texte remplissable doit se placer à gauche, il faut donc le placer en premier dans la Row.
 * Le bouton doit se placer à droite, il faut donc le placer en dernier dans la Row.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
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

/**
 * # QUESTION 4
 *
 * *Faire la même chose qu'à la question précédente avec un Relative Layout*
 *
 * On utilise un ConstraintLayout pour faire un Relative Layout.
 * On utilise la fonction createRefs() pour créer des références aux éléments.
 * On utilise la fonction constrainAs() pour lier les éléments entre eux.
 * On utilise la méthode top.linkTo() pour lier le haut d'un élément au haut d'un autre élément.
 * On utilise la méthode start.linkTo() pour lier le début d'un élément au début d'un autre élément.
 *
 * On ajoute d'abord le label. Pas besoin d'ajouter de contrainte, il est placé par défaut en haut à gauche.
 * On ajoute ensuite le texte remplissable. On ajoute une contrainte pour le placer en dessous du label.
 * On ajoute enfin le bouton. On ajoute une contrainte pour le placer à droite du texte remplissable et en dessous du label.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun question4() {
    ConstraintLayout {
        val (label, text, button) = createRefs()
        Text(text = "I'm a label", modifier = Modifier.constrainAs(label) {
        })
        TextField(value = "", onValueChange = {}, modifier = Modifier.constrainAs(text) {
            top.linkTo(label.bottom)
        })
        Button(onClick = { /*TODO*/ }, modifier = Modifier.constrainAs(button) {
            start.linkTo(text.end)
            top.linkTo(label.bottom)
        }) {
            Text(text = "This is a Button")
        }
    }
}

/**
 * # QUESTION 5
 *
 * *Créer une interface avec une list View qui affichera le contenu d’une arraylist que vous aurez rempli auparavant avec le nom des 4 départements Breton*
 *
 * Il y a deux façons de faire une liste avec Jetpack Compose.
 * La première façon est d'utiliser une `LazyColumn` qui permet de créer une liste qui ne charge que les éléments qui sont affichés à l'écran.
 * La deuxième façon est d'utiliser une `Column` (scrollable ou non).
 *
 * Même si ici, on pourrait utiliser une Column (on a très peu d'éléments), on va utiliser une LazyColumn.
 *
 * On utilise la fonction `items()` pour boucler sur les éléments de la liste.
 *
 * On utilise la fonction `Text()` pour afficher le nom du département.
 */

@Composable
fun question5(departements: List<String>) {
    LazyColumn {
        items(departements) { name ->
            Text(text = name)
        }
    }
}

/**
 * # QUESTION 6
 *
 * *Même exercice qu’à la question précédente mais ajouter à la fin de l’affichage dechacun des noms de département le suffixe “ - Bretagne”*
 *
 * Il suffit d'ajouter le suffixe à la fin du nom du département. Pour cela, on utilise les string templates.
 */
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

/**
 * # QUESTION 7
 *
 * *Enfin faites en sorte que l’on puisse cliquer sur chacun des éléments de la liste et
 * affiche une popup avec le Nom du département et sa population qui sera stocker
 * dans une autre arrayList ou une map.*
 *
 * On utilise un autre composant `SingleDepartement` qui affiche le nom du département et qui affiche une popup quand on clique dessus.
 * On utilise une `LazyColumn` comme dans la question précédente.
 *
 * Dans le composant `SingleDepartement`, on utilise une variable `showPopup` qui permet de savoir si la popup doit être affichée ou non.
 * Le modifier `clickable` permet de rendre le texte cliquable. On met à jour la variable `showPopup` quand on clique dessus.
 * On utilise un `AlertDialog` pour afficher la popup.
 */
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
    val population = hashMapOf(
        "Côtes-d'Armor" to 650000,
        "Finistère" to 1000000,
        "Ille-et-Vilaine" to 1500000,
        "Morbihan" to 800000
    )
    Tp2progmobileTheme {
        question7(departements, population)
    }
}