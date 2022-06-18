package com.example.suitosomand12binar.sources.interfaces

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.suitosomand12binar.dataclass.Pemain1

@Dao
interface Pemain1Dao {
    @Query("SELECT * FROM Pemain1")
    fun getAllPemain1(): List<Pemain1>

    @Insert(onConflict = REPLACE)
    fun insertPemain1(pemain1: Pemain1): Long

    @Update
    fun updatePemain1(pemain1: Pemain1):Int

    @Delete
    fun deletePemain1(pemain1: Pemain1):Int
}