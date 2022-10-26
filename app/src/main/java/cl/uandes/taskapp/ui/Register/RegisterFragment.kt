package cl.uandes.taskapp.ui.Register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cl.uandes.taskapp.R
import cl.uandes.taskapp.databinding.FragmentRegisterBinding
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.data.datasources.InMemoryDataSource
import cl.uandes.taskapp.data.db.entity.User
import cl.uandes.taskapp.ui.HomeProjects.HomeProjectsViewModel

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    //View model implementation
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var registerButton = binding.registerButton

        registerButton.setOnClickListener {
            val emailEntered = binding.editTextTextEmailAddress.text.toString()
            val passEntered = binding.editTextTextPassword.text.toString()
            val roleEntered = binding.editTextTextRole.text.toString()

            val result = viewModel.saveUser(emailEntered, passEntered, roleEntered)
            if (result == 0) {
                Toast.makeText(context,"Email account already in use.", Toast.LENGTH_LONG).show()
            }
            else if(result == 1){
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }

        toLogin()
    }

    private fun toLogin() {
        var loginButton = binding.loginButton
        loginButton.setOnClickListener{
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
}