package cl.uandes.taskapp.ui.CreateTasks

import android.app.Application
import androidx.lifecycle.*
import cl.uandes.taskapp.data.db.AppDatabase
import cl.uandes.taskapp.data.db.entity.Project
import cl.uandes.taskapp.data.db.entity.Task
import cl.uandes.taskapp.data.repository.ProjectRepository
import cl.uandes.taskapp.data.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateTaskViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TaskRepository
    private val allTasks: LiveData<List<Task>>

    init {
        val db = AppDatabase.invoke(application)
        val taskDao = db.getTaskDao()
        repository = TaskRepository(db,taskDao)
        allTasks = repository.allTasks.asLiveData()
    }

    fun insert(task: Task) {
        viewModelScope.launch(Dispatchers.IO){
            repository.insertTask(task)
        }
    }
}