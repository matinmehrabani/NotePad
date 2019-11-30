package com.example.notepad.roomDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notepad.util.BaseInterface

@Database(entities = [(TableRoom::class)], version = 1)

abstract class DataBase : RoomDatabase() {

    abstract fun empDAO(): Dao


    companion object {

        private var INSTANCE: DataBase? = null

        fun getInstance(context: Context): DataBase? {
            if (INSTANCE == null) {

                synchronized(DataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java, "notepaddata.db"
                    )
                        .build()
                }
            }
            return INSTANCE
        }


        fun destroyInstance() {
            INSTANCE = null
        }
    }


}

