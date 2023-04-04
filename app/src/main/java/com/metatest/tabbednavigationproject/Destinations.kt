package com.metatest.tabbednavigationproject



interface Destinations { // une classe peut hériter plusieurs fois d'une interface, mais qu'une seule fois d'une classe abstraite


    val route: String  // dans l'interface, les éléments doivent être déclarer mais pas initialiser
    val icon: Int
    val titre: String

}





object Accueil0 :Destinations {

    override val route = "Accueil"
    override val icon = R.drawable.ic_home
    override val titre = "Accueil"

}




object Menu0 :Destinations {

    override val route = "Menu"
    override val icon = R.drawable.ic_menu
    override val titre = "Menu"



}


object Emplacement0 :Destinations {

    override val route = "Emplacement"
    override val icon = R.drawable.ic_location
    override val titre = "Emplacement"

}