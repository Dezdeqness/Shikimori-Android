package com.dezdeqness.presentation.features.unauthorized

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.dezdeqness.R
import com.dezdeqness.core.BaseFragment
import com.dezdeqness.databinding.FragmentUnauthorizedBinding
import com.dezdeqness.di.AppComponent
import com.dezdeqness.presentation.features.authorization.AuthorizationActivity

class UnauthorizedFragment : BaseFragment<FragmentUnauthorizedBinding>() {

    private val viewModel: UnauthorizedViewModel by viewModels(
        factoryProducer = {
            viewModelFactory
        }
    )

    private val authorizationObserver =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val code = result.data?.getStringExtra(AuthorizationActivity.KEY_AUTHORIZATION_CODE)
                viewModel.onAuthorizationCodeReceived(code)
            }
        }

    override fun setupScreenComponent(component: AppComponent) {
        component
            .unauthorizedComponent()
            .create()
            .inject(this)
    }

    override fun getFragmentBinding(layoutInflater: LayoutInflater) =
        FragmentUnauthorizedBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        setupListeners()
    }

    private fun setupView() {
        arguments
            ?.getInt("titleResId", R.string.unauthorized_title_default)
            ?.let {
                binding.title.text = getString(it)
            }
    }

    private fun setupListeners() {
        binding.signIn.setOnClickListener {
            AuthorizationActivity.startActivity(
                authorizationObserver,
                requireContext(),
                isLogin = true
            )
        }

        binding.signUp.setOnClickListener {
            AuthorizationActivity.startActivity(
                authorizationObserver,
                requireContext(),
                isLogin = false
            )
        }
    }

}
