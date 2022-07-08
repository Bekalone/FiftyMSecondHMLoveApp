package com.example.fiftymsecondhmloveapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fiftymsecondhmloveapp.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase : RoomDatabase(){

    abstract fun historyDao():HistoryDao
}