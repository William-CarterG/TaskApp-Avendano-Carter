package cl.uandes.taskapp.ui.ProjectProfile
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.uandes.taskapp.data.datasources.InMemoryDataSource
import cl.uandes.taskapp.data.db.entity.Project
import kotlinx.coroutines.launch
/*
class ProjectProfileViewModel: ViewModel() {

    private val projectList = InMemoryDataSource.projects
    private val loading = MutableLiveData(true)
    val selectedProject: MutableLiveData<Project?> = MutableLiveData()

    fun loadProject(projectId: Int) {
        getSelectedProject(projectId)

        loading.value = false
    }

    private fun getSelectedProject(projectId: Int) {
        viewModelScope.launch {
            val project = projectList.find { it.id === projectId }
            selectedProject.postValue(project)
        }
    }
}
*/