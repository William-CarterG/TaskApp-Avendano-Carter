package cl.uandes.taskapp.ui.HomeTasks

import android.app.Application
import androidx.lifecycle.*
import cl.uandes.taskapp.data.datasources.InMemoryDataSource
import cl.uandes.taskapp.data.db.AppDatabase
import cl.uandes.taskapp.data.db.entity.Project
import cl.uandes.taskapp.data.db.entity.Task
import cl.uandes.taskapp.data.repository.ProjectRepository
import cl.uandes.taskapp.data.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeTasksViewModel(application: Application): AndroidViewModel(application) {

    private var loading = MutableLiveData(true)
    var taskListLiveData: MutableLiveData<MutableList<Task>> = MutableLiveData()
    val titleLiveData = MutableLiveData("Tasks List")

    fun loadTasks() {
        getTasks()
        loading.value = false
    }

    private fun getTasks() {
        viewModelScope.launch {
            taskListLiveData.postValue(InMemoryDataSource.tasks)
        }
    }

    private val repository: TaskRepository
    private val allTasks: LiveData<List<Task>>

    init {
        val db = AppDatabase.invoke(application)
        val taskDao = db.getTaskDao()
        repository = TaskRepository(db,taskDao)
        allTasks = repository.allTasks.asLiveData()
    }

    fun delete(title: String) {
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteTaskByTitle(title)
        }
    }
}
