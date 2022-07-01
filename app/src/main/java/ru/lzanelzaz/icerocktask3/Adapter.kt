package ru.lzanelzaz.icerocktask3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.transition.MaterialElevationScale
import ru.lzanelzaz.icerocktask3.databinding.ContactBinding

class ItemAdapter(private val dataset: List<Contact>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ContactBinding) : RecyclerView.ViewHolder(binding.root) {
        val materialCard = binding.materialCard
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = DataBindingUtil.inflate<ContactBinding>(
            LayoutInflater.from(parent.context),
            R.layout.contact,
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.contact = item

        holder.materialCard.setOnClickListener { view: View ->
            val extras = bundleOf(
                "firstName" to item.firstName,
                "lastName" to item.lastName,
                "avatar" to item.avatarResourceId
            )

            view.findNavController().navigate(
                R.id.action_contactsFragment_to_contactFragment, extras,
                null, FragmentNavigatorExtras(view to "contact_detail")
            )
        }
    }

    override fun getItemCount() = dataset.size
}