package com.ryz.loginapp.ui.content.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ryz.loginapp.MainActivity
import com.ryz.loginapp.R
import com.ryz.loginapp.common.Resource
import com.ryz.loginapp.common.snackBarErrorMessage
import com.ryz.loginapp.common.snackBarSuccessMessage
import com.ryz.loginapp.data.entity.LoginEntity
import com.ryz.loginapp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListener()

        getToken()
        loginObserver()
    }

    private fun setupClickListener() {
        binding.btnLogin.setOnClickListener(this)
    }

    private fun loginObserver() {
        loginViewModel.login.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Resource.Loading -> binding.loading.root.isVisible = true
                is Resource.Success -> {
                    binding.loading.root.isVisible = false
                    getString(R.string.successful_login_message).snackBarSuccessMessage(activity as MainActivity)
                    val token = result.data?.token
                    loginViewModel.insertToken(token.toString())
                }

                is Resource.Error -> {
                    binding.loading.root.isVisible = false
                    result.message?.snackBarErrorMessage(activity as MainActivity)
                }
            }
        }
    }

    private fun getToken() {
        loginViewModel.getLoginToken().observe(viewLifecycleOwner) { result ->
            if (result?.token != null) {
                binding.loading.root.isVisible = true
                val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                findNavController().navigate(action)
            } else {
                binding.loading.root.isVisible = false
            }
        }
    }

    override fun onClick(p0: View?) {
        binding.apply {
            when (p0?.id) {
                btnLogin.id -> {
                    val email = etEmail.text.toString().trim()
                    val password = etPassword.text.toString().trim()

                    val loginData = LoginEntity(email = email, password = password)
                    loginViewModel.login(loginData)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}