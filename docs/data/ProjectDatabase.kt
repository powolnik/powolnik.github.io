// entire file content ...
package com.powolnik.portfolio.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Category::class, Project::class], version = 1)
abstract class ProjectDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun projectDao(): ProjectDao

    companion object {
        @Volatile
        private var INSTANCE: ProjectDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): ProjectDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProjectDatabase::class.java,
                    "project_database"
                )
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            INSTANCE?.let { database ->
                                scope.launch {
                                    populateDefaultCategories(database.categoryDao())
                                }
                            }
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private suspend fun populateDefaultCategories(dao: CategoryDao) {
            listOf(
                "Game Development",
                "AI/ML Projects",
                "Mobile Apps",
                "Web Applications"
            ).forEach { categoryName ->
                dao.insert(Category(name = categoryName))
            }
        }
    }
}
