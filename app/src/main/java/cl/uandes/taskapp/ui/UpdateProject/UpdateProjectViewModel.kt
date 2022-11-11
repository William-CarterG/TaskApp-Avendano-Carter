package cl.uandes.taskapp.ui.UpdateProject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import cl.uandes.taskapp.data.db.AppDatabase
import cl.uandes.taskapp.data.db.entity.Project
import cl.uandes.taskapp.data.repository.ProjectRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateProjectViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ProjectRepository
    private val allProjects: LiveData<List<Project>>

    init {
        val db = AppDatabase.invoke(application)
        val projectDao = db.getProjectDao()
        repository = ProjectRepository(db,projectDao)
        allProjects = repository.allProjects.asLiveData()
    }

    fun update(project: Project) {
        viewModelScope.launch(Dispatchers.IO){
            repository.updateProject(project)
        }
    }
}