package cl.uandes.taskapp.data.repository


import androidx.lifecycle.LiveData
import cl.uandes.taskapp.data.db.AppDatabase
import cl.uandes.taskapp.data.db.entity.Task

class TaskRepository(
    private val taskDatabase: AppDatabase
) {

    suspend fun insertTask(task: Task) = taskDatabase.getTaskDao().insertTask(task)

    suspend fun updateTask(task: Task) = taskDatabase.getTaskDao().updateTask(task)

    suspend fun deleteTask(task: Task) = taskDatabase.getTaskDao().deleteTask(task)

    suspend fun deleteTaskById(id: Int) = taskDatabase.getTaskDao().deleteTaskById(id)

    suspend fun clearTask() = taskDatabase.getTaskDao().clearTask()

    fun getAllTasks(): LiveData<List<Task>> = taskDatabase.getTaskDao().getAllTasks()
}

