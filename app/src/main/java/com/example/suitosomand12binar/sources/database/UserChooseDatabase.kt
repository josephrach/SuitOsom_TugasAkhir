package com.example.suitosomand12binar.sources.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.suitosomand12binar.sources.dataclass.UserChoose
import com.example.suitosomand12binar.sources.interfaces.UserChooseDao

@Database(entities = [UserChoose::class], version = 1)
abstract class UserChooseDatabase : RoomDatabase() {

    abstract fun userChooseDao(): UserChooseDao

    companion object {
        private var _instance: UserChooseDatabase? = null

        fun getInstance(context: Context): UserChooseDatabase? {
            if (_instance == null) {
                synchronized(UserChooseDatabase::class) {
                    _instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserChooseDatabase::class.java,
                        "user_choose.db"
                    ).build()
                }
            }
            return _instance
        }

        fun destroyDatabase() {
            _instance = null
        }
    }
}