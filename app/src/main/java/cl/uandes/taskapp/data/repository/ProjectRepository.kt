package cl.uandes.taskapp.data.repository

import androidx.lifecycle.LiveData

/*
import cl.uandes.taskapp.data.db.AppDatabase
import cl.uandes.taskapp.data.db.entity.Project

class ProjectRepository(
    private val projectDatabase: AppDatabase
) {

    suspend fun insertProject(project: Project) = projectDatabase.getProjectDao().insertProject(project)

    suspend fun updateProject(project: Project) = projectDatabase.getProjectDao().updateProject(project)

    suspend fun deleteProject(project: Project) = projectDatabase.getProjectDao().deleteProject(project)

    suspend fun deleteProjectById(id: String) = projectDatabase.getProjectDao().deleteProjectById(id)

    suspend fun clearProject() = projectDatabase.getProjectDao().clearProject()

    fun getAllProjects(): LiveData<List<Project>> = projectDatabase.getProjectDao().getAllProjects()
}

 */