package cl.uandes.taskapp.ui.CreateProject

import androidx.lifecycle.*
import cl.uandes.taskapp.data.datasources.InMemoryDataSource
import cl.uandes.taskapp.data.db.entity.Project
import cl.uandes.taskapp.data.repository.ProjectRepository
import kotlinx.coroutines.launch

class CreateProjectViewModel (private val repository: ProjectRepository) : ViewModel(){
    val allProjects: LiveData<List<Project>> = repository.allProjects.asLiveData()
    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(project: Project) = viewModelScope.launch {
        repository.insertProject(project)
    }
}