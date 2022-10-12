package cl.uandes.taskapp.ui.Login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import cl.uandes.taskapp.databinding.FragmentLoginBinding
import androidx.navigation.fragment.findNavController
import android.util.Patterns
import cl.uandes.taskapp.R

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginAction()
        registerAction()
    }

    private fun loginAction() {
        val loginButton = binding.loginButton

        loginButton.setOnClickListener {
            val emailEntered = binding.editTextTextEmailAddress.text.toString()
            val passwordEntered = binding.editTextTextPassword.text.toString()

            val email = Patterns.EMAIL_ADDRESS.matcher(emailEntered).matches()


            //Ultra secret email is actually any email with the right format :)
            //Ultra secret password, password="123456"
            if (passwordEntered == "123456" && email) {

                //If credentials are okay, enter the HomeProjects view, where you can see all your projects
                val action =
                    cl.uandes.taskapp.ui.Login.LoginFragmentDirections.actionLoginFragmentToHomeProjects()
                findNavController().navigate(action)

            }
            else {
                Toast.makeText(context, "Invalid credentials", Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun registerAction() {
        val registerButton = binding.registerButton

        registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}
