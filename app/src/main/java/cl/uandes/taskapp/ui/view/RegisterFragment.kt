package cl.uandes.taskapp.ui.view

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import cl.uandes.taskapp.R
import cl.uandes.taskapp.databinding.FragmentRegisterBinding
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import cl.uandes.taskapp.data.datasources.InMemoryDataSource
import cl.uandes.taskapp.data.model.User

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var registerButton = binding.registerButton

        registerButton.setOnClickListener {
            val emailEntered = binding.editTextTextEmailAddress.text.toString()
            val passEntered = binding.editTextTextPassword.text.toString()
            val roleEntered = binding.editTextTextRole.text.toString()

            val userInData = InMemoryDataSource.users.find {it.email == emailEntered}

            if (userInData != null) {
                Toast.makeText(context,"User already exists.", Toast.LENGTH_LONG).show()

            } else {
                InMemoryDataSource.users.add(User(InMemoryDataSource.users.size.toLong(),emailEntered,passEntered,roleEntered))
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