package cl.uandes.taskapp.ui.HomeProjects

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.uandes.taskapp.data.datasources.InMemoryDataSource
import cl.uandes.taskapp.data.db.entity.Project
import kotlinx.coroutines.launch

class HomeProjectsViewModel: ViewModel() {

    private var loading = MutableLiveData(true)
    var projectListLiveData: MutableLiveData<MutableList<Project>> = MutableLiveData()
    val titleLiveData = MutableLiveData("Projects List")

    fun loadProjects() {
        getProjects()
        loading.value = false
    }

    private fun getProjects() {
        viewModelScope.launch {
            projectListLiveData.postValue(InMemoryDataSource.projects)
        }
    }
}
