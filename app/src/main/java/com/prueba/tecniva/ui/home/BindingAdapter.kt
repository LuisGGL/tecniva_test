package com.prueba.tecniva.ui.home

import android.view.View
import android.widget.ImageView
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputEditText
import com.prueba.tecniva.util.constants.Constants

@BindingAdapter("setImage")
fun ImageView.setImage(path: String?) {
    path?.let {
        Glide.with(context)
            .load(Constants.BASE_IMAGE + path)
            .into(this)
    }
}

@BindingAdapter("setVisible")
fun View.setVisible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("onTextChanged")
fun TextInputEditText.onTextChanged(onTextChanged: OnTextChange) {
    addTextChangedListener {
        onTextChanged.onChanged()
    }
}

interface OnTextChange {
    fun onChanged()
}