package com.example.notepad.roomDb

import androidx.room.Insert

interface Dao {

    @Insert
    fun insertItem(vararg todo: TableRoom)
}