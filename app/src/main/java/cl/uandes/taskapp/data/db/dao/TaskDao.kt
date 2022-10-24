package cl.uandes.taskapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import cl.uandes.taskapp.data.db.entity.Task


@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("SELECT * FROM task ORDER BY id DESC")
    fun getAllTasks(): LiveData<List<Task>>

    @Query("DELETE FROM task")
    fun clearTask()

    @Query("DELETE FROM task WHERE id = :id")
    fun deleteTaskById(id: Int)
}

