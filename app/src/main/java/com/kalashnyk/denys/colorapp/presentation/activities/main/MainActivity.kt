package com.kalashnyk.denys.colorapp.presentation.activities.main

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import com.kalashnyk.denys.colorapp.R
import com.kalashnyk.denys.colorapp.di.component.ViewModelComponent
import com.kalashnyk.denys.colorapp.domain.ColorsViewModel
import com.kalashnyk.denys.colorapp.presentation.adapter.ColorAdapter
import com.kalashnyk.denys.colorapp.presentation.base.BaseActivity
import com.kalashnyk.denys.colorapp.usecases.repository.database.entity.ColorEntity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    var viewModel: ColorsViewModel? = null
        @Inject set

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel?.getAllItems()
        viewModel?.getLiveDataItems()?.observe(this, Observer { it?.let { initRecyclerView(it) } } )
    }

    private fun initRecyclerView(colors: List<ColorEntity>) {
        val manager = LinearLayoutManager(this)
        val colorAdapter = ColorAdapter(this, colors)
        rvColors.layoutManager = manager
        rvColors.adapter = colorAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            return intent
        }
    }

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

}
