package com.metatest.tabbednavigationproject

import androidx.compose.ui.graphics.vector.ImageVector

interface Destinations {

    val route: String
    val icon: Int
    val titre: String
}

object Menu :Destinations {

    override val route = "Menu"
    override val icon = R.drawable.ic_menu
    override val titre = "Menu"



}

object Accueil :Destinations {



}


object Emplacement :Destinations {




}