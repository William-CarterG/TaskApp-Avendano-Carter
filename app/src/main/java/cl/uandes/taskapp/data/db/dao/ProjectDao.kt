package cl.uandes.taskapp.data.db.dao

import androidx.room.*
import cl.uandes.taskapp.data.db.entity.Project
import kotlinx.coroutines.flow.Flow


@Dao
interface ProjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //if some data is same/conflict, it'll be replace with new data.
    fun insertProject(project: Project)

    @Update
    fun updateProject(project: Project)

    @Delete
    fun deleteProject(project: Project)

    @Query("SELECT * FROM projects ORDER BY id DESC")
    fun getAllProjects(): Flow<List<Project>>
    // why not use suspend ? because Room does not support LiveData with suspended functions.
    // LiveData already works on a background thread and should be used directly without using coroutines


    @Query("DELETE FROM projects WHERE title = :title") //you can use this too, for delete note by id.
    fun deleteProjectByTitle(title: String)
}

