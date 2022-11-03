package cl.uandes.taskapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import cl.uandes.taskapp.data.db.entity.Task
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("SELECT * FROM tasks ORDER BY id DESC")
    fun getAllTasks(): Flow<List<Task>>

    @Query("DELETE FROM tasks")
    fun clearTask()

    @Query("DELETE FROM tasks WHERE id = :id")
    fun deleteTaskById(id: Int)
}

