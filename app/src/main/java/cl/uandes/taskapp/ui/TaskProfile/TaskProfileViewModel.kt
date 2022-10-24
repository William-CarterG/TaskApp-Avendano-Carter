package cl.uandes.taskapp.ui.TaskProfile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.uandes.taskapp.data.datasources.InMemoryDataSource
import cl.uandes.taskapp.data.db.entity.Task
import kotlinx.coroutines.launch

class TaskProfileViewModel : ViewModel() {
    /*private val taskList = InMemoryDataSource.tasks
    private val loading = MutableLiveData(true)
    val selectedTask: MutableLiveData<Task?> = MutableLiveData()

    fun loadTask(taskId: Int) {
        getSelectedTask(taskId)

        loading.value = false
    }

    private fun getSelectedTask(taskId: Int) {
        viewModelScope.launch {
            val task = taskList.find { it.id === taskId }
            selectedTask.postValue(task)
        }
    }*/
}
