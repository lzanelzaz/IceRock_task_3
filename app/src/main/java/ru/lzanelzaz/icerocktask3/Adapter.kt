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

class ItemAdapter(
    private val dataset: List<Contact>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.contact_name)
        val imageView: ImageView = view.findViewById(R.id.avatar)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = "${item.firstName} ${item.lastName}"
        holder.imageView.setImageResource(item.avatarResourceId)

        holder.itemView.setOnClickListener { view: View ->
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