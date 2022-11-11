package cl.uandes.taskapp.data.repository

import androidx.lifecycle.LiveData


import cl.uandes.taskapp.data.db.AppDatabase
import cl.uandes.taskapp.data.db.dao.ProjectDao
import cl.uandes.taskapp.data.db.entity.Project
import kotlinx.coroutines.flow.Flow

class ProjectRepository(
    private val projectDatabase: AppDatabase,
    private val projectDao: ProjectDao
) {
    val allProjects: Flow<List<Project>> = projectDao.getAllProjects()
    suspend fun insertProject(project: Project) = projectDatabase.getProjectDao().insertProject(project)

    suspend fun updateProject(project: Project) = projectDatabase.getProjectDao().updateProject(project)

    suspend fun deleteProject(project: Project) = projectDatabase.getProjectDao().deleteProject(project)

    suspend fun deleteProjectByTitle(title: String) = projectDatabase.getProjectDao().deleteProjectByTitle(title)

    //fun getAllProjects(): Flow<List<Project>> = projectDatabase.getProjectDao().getAllProjects()
}

