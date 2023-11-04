package com.prueba.tecniva.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.prueba.tecniva.R
import com.prueba.tecniva.data.entities.movies.Results
import com.prueba.tecniva.databinding.FragmentHomeBinding
import com.prueba.tecniva.ui.base.BaseFragment
import com.prueba.tecniva.ui.home.epoxycontroller.MovieController
import com.prueba.tecniva.ui.home.listener.MovieListener
import com.prueba.tecniva.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel>(), MovieListener {

    override val viewModel: HomeViewModel by factory(R.id.nav_graph)

    private val movieController by lazy {
        MovieController(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentHomeBinding.inflate(inflater, container, false).bindLayout {
        vm = viewModel
        this.recyclerMovies.adapter = movieController.adapter
        scrollView.viewTreeObserver.addOnScrollChangedListener {
            val maxScroll = scrollView.getChildAt(0).height - scrollView.height
            val currentScroll = scrollView.scrollY

            if (currentScroll == maxScroll && viewModel.canRefresh) {
                viewModel.addMovies()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMovies()

        viewModel.movies.observeEvent {
            movieController.movies = it.results
        }

        viewModel.errorLoadingItems.observeEvent {
            Toast.makeText(
                requireContext(), "Error al consumir el servicio", Toast.LENGTH_LONG
            ).show()
        }

        viewModel.errorNotFound.observeEvent {
            Toast.makeText(
                requireContext(), "No se encontró ningún título relacionado", Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onMovieClicked(movie: Results) {
        viewModel.setMovie(movie)
        findNavController().navigate(
            HomeFragmentDirections.actionDetailFragment()
        )
    }

    override fun onResume() {
        super.onResume()
        viewModel.recoverSearch()
    }
}