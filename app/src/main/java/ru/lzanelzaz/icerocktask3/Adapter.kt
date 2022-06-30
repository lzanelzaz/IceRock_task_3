package ru.lzanelzaz.icerocktask3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class ItemAdapter(private val dataset: List<Contact>)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.contact_name)
        val imageView: ImageView = view.findViewById(R.id.avatar)
        val materialCard : MaterialCardView = view.findViewById(R.id.materialCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = "${item.firstName} ${item.lastName}"
        holder.imageView.setImageResource(item.avatarResourceId)

        holder.materialCard.setOnClickListener { view: View ->
            val lastNameShow : Boolean = item.lastName != ""
            val bundle = bundleOf(
                "lastNameShow" to lastNameShow,
                "firstName" to item.firstName,
                "lastName" to item.lastName,
                "avatar" to item.avatarResourceId)

            view.findNavController().navigate(R.id.action_contactsFragment_to_contactFragment, bundle)
        }
    }

    override fun getItemCount() = dataset.size
}