package com.metatest.tabbednavigationproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.metatest.tabbednavigationproject.ui.theme.TabbedNavigationProjectTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TabbedNavigationProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ControllerFunction() // sans paramètres
                }
            }
        }
    }
}


@Composable
fun ControllerFunction() { // sans paramètres


    val navSave = rememberNavController() // function to save the state


    Scaffold(bottomBar =  { MySetBottomNav(navcontrolll = navSave) })  { // prend la fonction MySetBottomNav [juste en dessous] comme paramètre avec ses paramètres inhérent puis body du Scaffold


        Box(Modifier.padding(it)) { // fonction Modifier.padding comme argument de Box() corps de Box puis body de Box
            NavHost(navController = navSave, startDestination = Accueil0.route) {// début body de NavHost

                composable(Accueil0.route) { // body de ce composable
                    Accueil() // instanciation de la fonction Accueil()

                }

                composable(Menu0.route) { // body de ce composable

                    Menu()
                }

                composable(Emplacement0.route) {
                    Emplacement()
                }



            } // fin de body de Navhost

        } // fin de Box

    } // fin du body Scaffold

} // fin de ControllerFunction()

@Composable
fun MySetBottomNav (navcontrolll :NavController) {
    val destinationssList =
        listOf<Destinations>( // Destinations renvoie à l'interface Destinations.kt puis body de listOf

            Accueil0,
            Menu0,
            Emplacement0
        )


    val selectedIndexxRemember =
        rememberSaveable { // pour l'erreur c'est pcq j'ai omis le @Composable
            mutableStateOf(0)

        }



    BottomNavigation() {// méthode integré built-in
        destinationssList.forEachIndexed { indexx, destinationns -> // lambdas avec deux arguments
            BottomNavigationItem( // body of BottomNavItem, BottomNavItem is a built-in method
                label = { Text(text = destinationns.titre) },

                icon = {
                    Icon( // head of Icon


                      painter = painterResource(id = destinationns.icon), // painterRessources(args) convert an icon to a Painter
                      contentDescription = destinationns.titre


                    )  // fin de head of Icon, Icon has just head, but no body, it's the minimum for a method


                },

                selected = indexx == selectedIndexxRemember.value, // == veut dire est égale, non ce n'est pas comme = ( initialiser, affecter une valeur)
                onClick = {   // début de onClick

                    selectedIndexxRemember.value = indexx

                    navcontrolll.navigate(destinationssList[indexx].route) { // début navcontrolll.navigate

                        popUpTo(Accueil0.route)
                        launchSingleTop = true


                    } // fin de navcontrolll.navigate


                } // fin de onClick


            ) // fin de BottomNavItem


        }  // fin de destinationssList.forEachIndexed {}

    } // fin de BottomNavigation()

} // fin de MySetBottomNav @Composable


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TabbedNavigationProjectTheme {
        Greeting("Android")
    }
}