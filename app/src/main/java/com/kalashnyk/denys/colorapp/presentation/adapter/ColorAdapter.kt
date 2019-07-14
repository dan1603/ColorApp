package com.kalashnyk.denys.colorapp.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kalashnyk.denys.colorapp.R
import com.kalashnyk.denys.colorapp.presentation.base.BaseAdapter
import com.kalashnyk.denys.colorapp.presentation.item.ColorViewHolder
import com.kalashnyk.denys.colorapp.usecases.repository.database.entity.ColorEntity

class ColorAdapter(private val context: Context, private val colors: List<ColorEntity>) :
    BaseAdapter<ColorViewHolder, ColorEntity>(colors as MutableList<ColorEntity>) {

    override fun getItemCount(): Int {
        return colors.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        return ColorViewHolder(LayoutInflater.from(context).inflate(R.layout.item_color, parent, false))
    }

    override fun onBindViewHolder(colorViewHolder: ColorViewHolder, i: Int) {
        super.onBindViewHolder(colorViewHolder, i)
        colorViewHolder.bind(colors[i])
    }
}
