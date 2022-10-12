package cl.uandes.taskapp.data.repository

import androidx.lifecycle.LiveData
import cl.uandes.taskapp.data.db.AppDatabase
import cl.uandes.taskapp.data.db.entity.User

class UserRepository(
    private val userDatabase: AppDatabase
) {

    suspend fun insertUser(user: User) = userDatabase.getUserDao().insertUser(user)

    suspend fun updateUser(user: User) = userDatabase.getUserDao().updateUser(user)

    suspend fun deleteUser(user: User) = userDatabase.getUserDao().deleteUser(user)

    suspend fun deleteUserById(id: Int) = userDatabase.getUserDao().deleteUserById(id)

    suspend fun clearUser() = userDatabase.getTaskDao().clearTask()

    fun getAllUsers(): LiveData<List<User>> = userDatabase.getUserDao().getAllUsers()
}