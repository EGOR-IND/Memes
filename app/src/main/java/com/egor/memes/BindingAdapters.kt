package com.egor.memes

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("loadImageFromUrlWithNullCheck")
        fun setImageFromPostWithNullCheck(
            imageView: ImageView,
            imageUrl: String?,
        ) {
            imageUrl?.let {
                Glide.with(imageView.context).load(imageUrl).into(imageView)
            }
        }
    }
}