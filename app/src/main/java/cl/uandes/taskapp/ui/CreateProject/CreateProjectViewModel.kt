package cl.uandes.taskapp.ui.CreateProject

import android.app.Application
import androidx.lifecycle.*
import cl.uandes.taskapp.data.datasources.InMemoryDataSource
import cl.uandes.taskapp.data.db.AppDatabase
import cl.uandes.taskapp.data.db.entity.Project
import cl.uandes.taskapp.data.repository.ProjectRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateProjectViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ProjectRepository
    private val allProjects: LiveData<List<Project>>

    init {
        val db = AppDatabase.invoke(application)
        val projectDao = db.getProjectDao()
        repository = ProjectRepository(db,projectDao)
        allProjects = repository.allProjects.asLiveData()
    }

    fun insert(project: Project) {
        viewModelScope.launch(Dispatchers.IO){
            repository.insertProject(project)
        }
    }
}