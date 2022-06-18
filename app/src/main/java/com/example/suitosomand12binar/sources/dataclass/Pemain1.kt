package com.example.suitosomand12binar.dataclass

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Pemain1(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @ColumnInfo(name = "Nama")
    var nama: String,

    @ColumnInfo(name = "Score")
    var score: Int

) : Parcelable