package com.example.socialuijp.ui.theme.utils

import com.example.socialuijp.R

open class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("Home", R.drawable.ic_baseline_home_24, "Home")
    object Search : NavigationItem("Search", R.drawable.ic_baseline_search_24, "Search")
    object Add : NavigationItem("Add", R.drawable.ic_baseline_add_box_24, "Add")
    object Activities : NavigationItem("Activities", R.drawable.ic_baseline_favorite_24, "Activities")
    object Profile : NavigationItem("Profile", R.drawable.ic_baseline_person_24, "Profile")
}