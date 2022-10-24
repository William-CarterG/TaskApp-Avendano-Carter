package cl.uandes.taskapp.data.db



import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.uandes.taskapp.data.db.entity.Project
import cl.uandes.taskapp.data.db.dao.ProjectDao

import cl.uandes.taskapp.data.db.entity.Task
import cl.uandes.taskapp.data.db.dao.TaskDao

import cl.uandes.taskapp.data.db.entity.User
import cl.uandes.taskapp.data.db.dao.UserDao




@Database(
    entities = [Project::class, Task::class, User::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase: RoomDatabase() {
    abstract fun getProjectDao(): ProjectDao
    abstract fun getTaskDao(): TaskDao
    abstract fun getUserDao(): UserDao

    companion object {
        private const val DB_NAME = "taskapp_database.db"
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            DB_NAME
        ).build()
    }
}

