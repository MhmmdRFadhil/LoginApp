package com.ryz.loginapp.ui.content.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ryz.loginapp.MainActivity
import com.ryz.loginapp.common.UserViewState
import com.ryz.loginapp.common.snackBarErrorMessage
import com.ryz.loginapp.databinding.FragmentHomeBinding
import com.ryz.loginapp.ui.adapter.UserAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()
    private val userAdapter: UserAdapter by lazy { UserAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showRecyclerView()
        getUser()
    }

    private fun getUser() {
        homeViewModel.getUser()
        lifecycleScope.launch {
            homeViewModel.user.collectLatest { result ->
                when (result) {
                    is UserViewState.Loading -> {}
                    is UserViewState.Success -> {
                        userAdapter.submitData(result.data)
                    }

                    is UserViewState.Error -> {
                        result.error.snackBarErrorMessage(activity as MainActivity)
                    }
                }
            }
        }
    }

    private fun showRecyclerView() {
        binding.rvUser.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = userAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}