package cl.uandes.taskapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import cl.uandes.taskapp.databinding.FragmentLoginBinding
import android.util.Patterns

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
    }

    private fun loginAction() {
        val loginButton = binding.loginButton

        loginButton.setOnClickListener {
            val emailEntered = binding.editTextTextEmailAddress.text.toString()
            val passwordEntered = binding.editTextTextPassword.text.toString()

            val email = Patterns.EMAIL_ADDRESS.matcher(emailEntered).matches()


            //Ultra secret email, email = "
            //Ultra secret password, password="123456"
            if (passwordEntered == "123456" && email) {
                //TODO
                //The logic of the navigation.
            }
            else {
                Toast.makeText(context, "Invalid credentials", Toast.LENGTH_LONG).show()
            }

        }
    }
}
