package com.example.roomhomeworkdefaultrepo.repo

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.roomhomeworkdefaultrepo.database.AppDataBase
import com.example.roomhomeworkdefaultrepo.database.Memo
import com.example.roomhomeworkdefaultrepo.database.MemoDao

class DbRepository(application: Application) {
    private val db : AppDataBase = AppDataBase.getInstance(application)!!
    private val dao : MemoDao = db.memoDao()
    val memos : LiveData<List<Memo>> = dao.getAll()
    val memoTitle : LiveData<List<String>> = dao.getAllTitle()
    val memoContent : LiveData<List<String>> = dao.getAllContent()

    fun insert(memo: Memo){
        dao.insertData(memo)
    }

    fun delete(memo: Memo){
        dao.deleteData(memo)
    }


}