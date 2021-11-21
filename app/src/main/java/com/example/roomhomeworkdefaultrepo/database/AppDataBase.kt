package com.example.roomhomeworkdefaultrepo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Memo::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun memoDao() : MemoDao

    companion object{
        private var instance : AppDataBase? = null

        fun getInstance(context : Context) : AppDataBase?{
            instance = Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "memo")
                .fallbackToDestructiveMigration()
                .build()
            return instance
        }
    }
}