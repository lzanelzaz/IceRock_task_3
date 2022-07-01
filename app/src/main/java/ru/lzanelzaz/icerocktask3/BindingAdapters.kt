package ru.lzanelzaz.icerocktask3

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("imageUrl")
fun setImage(imageView: ImageView, imgRcs: Int){
    imageView.setImageResource(imgRcs)
}