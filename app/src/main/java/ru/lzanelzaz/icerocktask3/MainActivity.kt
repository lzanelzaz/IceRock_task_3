package ru.lzanelzaz.icerocktask3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, contacts)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)
    }
}