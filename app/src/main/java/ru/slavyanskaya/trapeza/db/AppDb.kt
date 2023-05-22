package ru.slavyanskaya.trapeza.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.slavyanskaya.trapeza.dao.DishDao
import ru.slavyanskaya.trapeza.entity.*

@Database(
    entities = [
        DishEntity::class,
        OrderedDishEntity::class
    ],
    version = 1
)
abstract class AppDb : RoomDatabase() {
    abstract fun dishDao(): DishDao

    companion object {
        @Volatile
        private var instance: AppDb? = null

        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context)
                    .also { instance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context,
                AppDb::class.java,
                "strapeza.db"
            )
                .allowMainThreadQueries()
                .build()
    }
}