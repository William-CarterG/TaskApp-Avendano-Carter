package cl.uandes.taskapp.data.repository


import androidx.lifecycle.LiveData
import cl.uandes.taskapp.data.db.AppDatabase
import cl.uandes.taskapp.data.db.dao.ProjectDao
import cl.uandes.taskapp.data.db.dao.TaskDao
import cl.uandes.taskapp.data.db.entity.Project
import cl.uandes.taskapp.data.db.entity.Task
import kotlinx.coroutines.flow.Flow

class TaskRepository(
    private val taskDatabase: AppDatabase,
    private val taskDao: TaskDao
) {
    val allTasks: Flow<List<Task>> = taskDao.getAllTasks()
    suspend fun insertTask(task: Task) = taskDatabase.getTaskDao().insertTask(task)

    suspend fun updateTask(task: Task) = taskDatabase.getTaskDao().updateTask(task)

    suspend fun deleteTask(task: Task) = taskDatabase.getTaskDao().deleteTask(task)

    suspend fun deleteTaskById(id: Int) = taskDatabase.getTaskDao().deleteTaskById(id)

    suspend fun clearTask() = taskDatabase.getTaskDao().clearTask()

    //fun getAllTasks(): LiveData<List<Task>> = taskDatabase.getTaskDao().getAllTasks()
}

