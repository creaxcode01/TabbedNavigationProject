package com.metatest.tabbednavigationproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
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
                    Greeting("Android")
                }
            }
        }
    }
}


@Composable
fun ControllerFunction() {


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


    val selectedIndexx = rememberSaveable { // pour l'erreur c'est pcq j'ai omis le @Composable
        mutableStateOf(0)

    }



    SetBottomNav() {
        destinationssList.forEachIndexed(index, destinations -> BottomNavigation Item)


    }  // fin de SetBottomNav() sans fun avant

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