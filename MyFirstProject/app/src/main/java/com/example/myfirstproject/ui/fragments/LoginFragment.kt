package com.example.myfirstproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myfirstproject.R
import com.example.myfirstproject.ui.base.BaseFragment
import com.example.myfirstproject.viewmodel.TestViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : BaseFragment() {


    private val testViewModel: TestViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login()
        setUpObservers(testViewModel)

    }

    fun login(){
        login_btn.setOnClickListener {
            testViewModel.login(etpassword.text.toString(), etUsername.text.toString())
        }
    }
}