package ru.lzanelzaz.icerocktask3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.RecyclerView

val contacts : List<Contact> = listOf(
    Contact("Lev", "Tolstoi", R.drawable.lev_tolstoi),
    Contact("Marilyn", "Monroe", R.drawable.marilyn_monroe),
    Contact("Van", "Gogh", R.drawable.van_gogh),
    Contact("Emma", avatarResourceId = R.drawable.emma),
    Contact("Julietta",  avatarResourceId = R.drawable.julietta),
    Contact("Aleksey", "Mikhailov"),
    Contact("Petr")
).sortedBy { it.firstName }

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}