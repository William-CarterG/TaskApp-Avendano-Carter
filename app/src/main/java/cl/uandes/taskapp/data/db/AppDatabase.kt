package cl.uandes.taskapp.data.db



import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import cl.uandes.taskapp.data.db.entity.Project
import cl.uandes.taskapp.data.db.dao.ProjectDao

import cl.uandes.taskapp.data.db.entity.Task
import cl.uandes.taskapp.data.db.dao.TaskDao

import cl.uandes.taskapp.data.db.entity.User
import cl.uandes.taskapp.data.db.dao.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(
    entities = [Project::class, Task::class, User::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase: RoomDatabase() {
    abstract fun getProjectDao(): ProjectDao
    abstract fun getTaskDao(): TaskDao
    abstract fun getUserDao(): UserDao

    private class AppDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.getProjectDao())
                }
            }
        }

        suspend fun populateDatabase(projectDao: ProjectDao) {
            // Delete all content here.
            projectDao.clearProject()

            var project = Project(1,"FootballApp","Organize your games","ME","You","29-10-2022","30-10-2022","20%","In Progress")
            projectDao.insertProject(project)

        }
    }

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "taskapp_database"
                )
                    .addCallback(AppDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}

