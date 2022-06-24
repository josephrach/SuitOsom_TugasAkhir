package com.example.suitosomand12binar.sources.interfaces

import androidx.room.*
import com.example.suitosomand12binar.sources.dataclass.UserChoose


@Dao
interface UserChooseDao {

    @Query("SELECT * from UserChoose")
    fun getAllUser(): List<UserChoose>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(userChoose: UserChoose): Long

    @Update
    fun updateUser(userChoose: UserChoose): Int

    @Delete
    fun deleteUser(userChoose: UserChoose): Int

}