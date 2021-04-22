package com.example.dechproduct.rebooapplicationproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class Categories{
    Man,Women,DarkVader,TheHulk,ChipMunk
}

//Ex)
//@Entity(tableName = "favourites")
//data class Favourite(@PrimaryKey(autoGenerate = true) val id: Long,
//                     val name : String,
//                     val category: Int)