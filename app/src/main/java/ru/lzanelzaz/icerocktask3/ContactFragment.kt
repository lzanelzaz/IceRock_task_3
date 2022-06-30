package ru.lzanelzaz.icerocktask3

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.lzanelzaz.icerocktask3.databinding.FragmentContactBinding
import ru.lzanelzaz.icerocktask3.databinding.FragmentContactsBinding

class ContactFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = FragmentContactBinding.inflate(inflater, container, false)
        binding.imageView.setImageResource(requireArguments().getInt("avatar"))
        binding.firstNameInput.text = requireArguments().getString("firstName")
        if (requireArguments().getBoolean("lastNameShow")) {
            binding.lastName.text = "Last name"
            binding.lastNameInput.text = requireArguments().getString("lastName")
        }
        return binding.root
    }
}