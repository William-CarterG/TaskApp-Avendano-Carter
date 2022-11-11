package cl.uandes.taskapp.ui.HomeProjects

import android.app.Application
import androidx.lifecycle.*
import cl.uandes.taskapp.data.datasources.InMemoryDataSource
import cl.uandes.taskapp.data.db.AppDatabase
import cl.uandes.taskapp.data.db.entity.Project
import cl.uandes.taskapp.data.repository.ProjectRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeProjectsViewModel(application: Application): AndroidViewModel(application) {

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
