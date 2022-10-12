package cl.uandes.taskapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import cl.uandes.taskapp.data.db.entity.Task



@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM task_table ORDER BY id DESC")
    fun getAllTasks(): LiveData<List<Task>>

    @Query("DELETE FROM task_table")
    suspend fun clearTask()

    @Query("DELETE FROM task_table WHERE id = :id")
    suspend fun deleteTaskById(id: Int)
}