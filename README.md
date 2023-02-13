<h1 align="center">TP2 - Programmation mobile</h1>
<h4 align="center">Mael KERICHARD (@Pixselve) - Romain BRIEND (@Yami2200)</h4>
<p align="center">
   <img src="https://img.shields.io/badge/-ESIR-orange" alt="ESIR">
   <img src="https://img.shields.io/badge/-Android-blue" alt="Android">
   <img src="https://img.shields.io/badge/-Kotlin-red" alt="Kotlin">
</p>

---

En se basant sur les informations du cours, puis :
https://developer.android.com/guide/topics/ui/declaring-layout

1. Créer une interface Linear layout avec un un texte à gauche, puis un bouton à droite

L'équivalent d'un Linear layout en utilisant Jetpack Compose est une Row ou une Column.

Une Row permet de placer des éléments les uns à côté des autres.

Cet élément permet de placer des éléments les uns à côté des autres.

Pour placer le texte à gauche, il faut le placer en premier dans la Row.

Et pour placer le bouton à droite, il faut le placer en dernier.

2. Créer une interface Linear layout avec un texte au dessus, puis un bouton en
   dessous

L'équivalent d'un Linear layout en utilisant Jetpack Compose est une Row ou une Column.

Une Column permet de placer des éléments les uns en dessous des autres.

Pour placer le texte au dessus, il faut le placer en premier dans la Column.

Et pour placer le bouton en dessous, il faut le placer en dernier.

3. Créer une interface à bas de Linear layout avec un label au dessus, puis en dessous
   un texte remplissable à gauche et un bouton à droite

On décompose l'interface en deux layouts.

On va d'abord décomposer l'interface en lignes.

La première ligne contient le label.

La deuxième ligne contient le texte remplissable et le bouton.

Pour placer le texte remplissable côte à côte avec le bouton, on utilise une Row qui permet de

décomposer la ligne en colonnes.

Le texte remplissable doit se placer à gauche, il faut donc le placer en premier dans la Row.

Le bouton doit se placer à droite, il faut donc le placer en dernier dans la Row.

4. Faire la même chose qu'à la question précédente avec un Relative Layout

On utilise un ConstraintLayout pour faire un Relative Layout.

On utilise la fonction createRefs() pour créer des références aux éléments.

On utilise la fonction constrainAs() pour lier les éléments entre eux.

On utilise la méthode top.linkTo() pour lier le haut d'un élément au haut d'un autre élément.

On utilise la méthode start.linkTo() pour lier le début d'un élément au début d'un autre élément.

On ajoute d'abord le label. Pas besoin d'ajouter de contrainte, il est placé par défaut en haut à
gauche.

On ajoute ensuite le texte remplissable. On ajoute une contrainte pour le placer en dessous du
label.

On ajoute enfin le bouton. On ajoute une contrainte pour le placer à droite du texte remplissable et
en dessous du label.

5. Créer une interface avec une list View qui affichera le contenu d’une arraylist que
   vous aurez rempli auparavant avec le nom des 4 départements Breton

Il y a deux façons de faire une liste avec Jetpack Compose.

La première façon est d'utiliser une `LazyColumn` qui permet de créer une liste qui ne charge que

les éléments qui sont affichés à l'écran.

La deuxième façon est d'utiliser une `Column` (scrollable ou non).

Même si ici, on pourrait utiliser une Column (on a très peu d'éléments), on va utiliser une

LazyColumn.

On utilise la fonction `items()` pour boucler sur les éléments de la liste.

On utilise la fonction `Text()` pour afficher le nom du département.

6. Même exercice qu’à la question précédente mais ajouter à la fin de l’affichage de
   chacun des noms de département le suffixe “ - Bretagne”

Il suffit d'ajouter le suffixe à la fin du nom du département. Pour cela, on utilise les string
templates.

7. Enfin faites en sorte que l’on puisse cliquer sur chacun des éléments de la liste et
   affiche une popup avec le Nom du département et sa population qui sera stocker
   dans une autre arrayList ou une map.

On utilise un autre composant `SingleDepartement` qui affiche le nom du département et qui affiche
une popup quand on clique dessus.

On utilise une `LazyColumn` comme dans la question précédente.

Dans le composant `SingleDepartement`, on utilise une variable `showPopup` qui permet de savoir si
la popup doit être affichée ou non.

Le modifier `clickable` permet de rendre le texte cliquable. On met à jour la variable `showPopup`
quand on clique dessus.

On utilise un `AlertDialog` pour afficher la popup.