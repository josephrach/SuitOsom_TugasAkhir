package com.example.suitosomand12binar.sources.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.suitosomand12binar.dataclass.Pemain1
import com.example.suitosomand12binar.sources.interfaces.Pemain1Dao

@Database( entities = [Pemain1::class], version = 1)
abstract class PermainanDatabase: RoomDatabase(){
    abstract fun pemain1Dao(): Pemain1Dao

    companion object{
        private var _INSTANCE: PermainanDatabase? = null

        fun getInstance(context: Context): PermainanDatabase?{
            if (_INSTANCE == null){
                _INSTANCE = Room.databaseBuilder(context.applicationContext,
                    PermainanDatabase::class.java,"Permainan.db")
                    .build()
            }
            return _INSTANCE
        }
    }

    fun destroyInstance(){
        _INSTANCE = null
    }
}