package cl.uandes.taskapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import cl.uandes.taskapp.data.db.entity.Project



@Dao
interface ProjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //if some data is same/conflict, it'll be replace with new data.
    suspend fun insertProject(project: Project)

    @Update
    suspend fun updateProject(project: Project)

    @Delete
    suspend fun deleteProject(project: Project)

    @Query("SELECT * FROM project_table ORDER BY id DESC")
    fun getAllProjects(): LiveData<List<Project>>
    // why not use suspend ? because Room does not support LiveData with suspended functions.
    // LiveData already works on a background thread and should be used directly without using coroutines

    @Query("DELETE FROM project_table")
    suspend fun clearProject()

    @Query("DELETE FROM project_table WHERE id = :id") //you can use this too, for delete note by id.
    suspend fun deleteProjectById(id: Int)
}