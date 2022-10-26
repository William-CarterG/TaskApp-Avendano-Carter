package cl.uandes.taskapp.ui.Register

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.R
import cl.uandes.taskapp.data.datasources.InMemoryDataSource
import cl.uandes.taskapp.data.db.entity.User
import cl.uandes.taskapp.data.repository.UserRepository
import kotlinx.coroutines.launch

class RegisterViewModel(private  val userRepository : UserRepository) : ViewModel() {

    /*
    var emailEntered : MutableLiveData<String> = MutableLiveData("")
    var passEntered : MutableLiveData<String> = MutableLiveData("")
    var roleEntered : MutableLiveData<String> = MutableLiveData("")
    */

    private var loading = MutableLiveData(true)

    fun saveUser(emailEntered : String, passEntered : String, roleEntered : String) : Int {
        val userInData = InMemoryDataSource.users.find {it.email == emailEntered}

        if (userInData != null) {
            return 0
        }

        var userCreated = User(id = 0, email = emailEntered, password = passEntered, role = roleEntered)
        saveUserIntoRepository(userCreated)
        loading.value = false

        InMemoryDataSource.users.add(User(InMemoryDataSource.users.size.toLong(), emailEntered, passEntered, roleEntered))
        return 1
    }

    private fun saveUserIntoRepository(user: User) {
        viewModelScope.launch {
            userRepository.insertUser(user)
        }
    }
}