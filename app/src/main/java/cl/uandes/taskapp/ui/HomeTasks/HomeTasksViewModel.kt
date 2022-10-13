package cl.uandes.taskapp.ui.HomeTasks

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.uandes.taskapp.data.datasources.InMemoryDataSource
import cl.uandes.taskapp.data.db.entity.Task
import kotlinx.coroutines.launch

class HomeTasksViewModel: ViewModel() {

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
}
