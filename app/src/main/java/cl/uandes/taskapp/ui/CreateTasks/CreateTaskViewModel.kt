package cl.uandes.taskapp.ui.CreateTasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import cl.uandes.taskapp.data.db.entity.Task
import cl.uandes.taskapp.data.repository.TaskRepository
import kotlinx.coroutines.launch

class CreateTaskViewModel (private val repository: TaskRepository) : ViewModel(){
    val allTasks: LiveData<List<Task>> = repository.allTasks.asLiveData()
    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(task: Task) = viewModelScope.launch {
        repository.insertTask(task)
    }
}