package ru.lzanelzaz.icerocktask3

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import com.google.android.material.transition.MaterialContainerTransform
import ru.lzanelzaz.icerocktask3.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.myNavHostFragment
            duration = 200L
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(requireContext().getColor(R.color.white))
        }
    }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
    }
}