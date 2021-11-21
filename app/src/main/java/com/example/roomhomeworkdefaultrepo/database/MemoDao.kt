package com.example.roomhomeworkdefaultrepo.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MemoDao {
    @Query("SELECT * FROM Memo")
    fun getAll() : LiveData<List<Memo>>

    @Query("SELECT title FROM Memo")
    fun getAllTitle() : LiveData<List<String>>

    @Query("SELECT content FROM Memo")
    fun getAllContent() : LiveData<List<String>>


    @Insert
    fun insertData(vararg memo: Memo)

    @Delete
    fun deleteData(memo: Memo)

    @Update
    fun updateData(memo: Memo)
}