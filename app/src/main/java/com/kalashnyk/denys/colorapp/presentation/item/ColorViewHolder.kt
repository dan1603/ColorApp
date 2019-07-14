package com.kalashnyk.denys.colorapp.presentation.item

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import com.kalashnyk.denys.colorapp.R
import com.kalashnyk.denys.colorapp.usecases.repository.database.entity.ColorEntity
import kotlinx.android.synthetic.main.item_color.view.*

class ColorViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private var colorEntity: ColorEntity? = null

    fun bind(color: ColorEntity) {
        colorEntity = color
        setupItem()
    }

    private fun setupItem() {
        view.txtRvColorName.text = colorEntity?.name.toString()
        view.txtRvColorName.setTextColor(Color.parseColor(colorEntity?.color))
        view.setOnClickListener { handleClick() }
    }

    private fun handleClick() {
        view.expandableLayout.toggle()

        if (view.expandableLayout.isExpanded) {
            view.viewHolderColorRootLayout.setBackgroundColor(Color.parseColor(colorEntity?.color))
            view.txtRvColorName.setTextColor(view.resources.getColor(R.color.colorBlack))
        }
        else {
            view.viewHolderColorRootLayout.setBackgroundColor(view.resources.getColor(R.color.colorWhite))
            view.txtRvColorName.setTextColor(Color.parseColor(colorEntity?.color))
        }
    }
}
