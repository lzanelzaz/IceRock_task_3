package ru.lzanelzaz.icerocktask3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.NonDisposableHandle.parent
import ru.lzanelzaz.icerocktask3.databinding.FragmentContactsBinding

class ContactsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = FragmentContactsBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter = ItemAdapter(contacts)

        return binding.root
    }
}