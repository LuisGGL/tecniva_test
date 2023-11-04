package com.prueba.tecniva.ui.movie.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.prueba.tecniva.R
import com.prueba.tecniva.databinding.FragmentMovieBinding
import com.prueba.tecniva.ui.base.BaseFragment
import com.prueba.tecniva.ui.home.viewmodel.HomeViewModel

class MovieFragment : BaseFragment<HomeViewModel>() {

    override val viewModel: HomeViewModel by factory(R.id.nav_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMovieBinding.inflate(inflater, container, false).bindLayout {
        vm = viewModel
    }
}