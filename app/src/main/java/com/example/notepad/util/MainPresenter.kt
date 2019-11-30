package com.example.notepad.util

import androidx.room.Room
import com.example.notepad.roomDb.DataBase

class MainPresenter {

    var db = Room.databaseBuilder(this, DataBase::class.java, "EmployeeDB")

}