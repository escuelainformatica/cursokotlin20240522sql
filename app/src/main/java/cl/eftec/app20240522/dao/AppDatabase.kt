package cl.eftec.app20240522.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.eftec.app20240522.entidad.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}