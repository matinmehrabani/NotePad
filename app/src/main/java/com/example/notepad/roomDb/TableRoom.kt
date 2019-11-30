package com.example.notepad.roomDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notepad_items")
data class TableRoom(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "title") var title: String,

    @ColumnInfo(name = "text") var text: String

)

