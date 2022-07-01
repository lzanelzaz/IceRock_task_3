package ru.lzanelzaz.icerocktask3

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.transition.MaterialContainerTransform
import ru.lzanelzaz.icerocktask3.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    private fun isDarkModeOn(): Boolean {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.myNavHostFragment
            duration = 300L
            if (isDarkModeOn())
                setAllContainerColors(Color.parseColor("#010000"))
                // for some reason there is a transition bug when color is full black
                // (clicked contact is visible in the background)
            else
                setAllContainerColors(requireContext().getColor(R.color.white))
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentContactBinding.inflate(inflater, container, false)
        binding.imageView.setImageResource(requireArguments().getInt("avatar"))
        binding.firstNameInput.text = requireArguments().getString("firstName")
        val lastName = requireArguments().getString("lastName")
        if (lastName != "") {
            binding.lastName.text = "Last name"
            binding.lastNameInput.text = lastName
        }
        return binding.root
    }

}