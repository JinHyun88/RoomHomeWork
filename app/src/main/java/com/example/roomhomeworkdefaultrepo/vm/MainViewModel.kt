package com.example.roomhomeworkdefaultrepo.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomhomeworkdefaultrepo.database.Memo
import com.example.roomhomeworkdefaultrepo.repo.DbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application)  {
    private val dbRepository : DbRepository = DbRepository(application)

    fun insertData(memo: Memo) = viewModelScope.launch(Dispatchers.IO){
        dbRepository.insert(memo)
    }

    fun deleteData(memo: Memo) = viewModelScope.launch(Dispatchers.IO){
        dbRepository.delete(memo)
    }

    fun getAllData() : LiveData<List<Memo>> {
        return dbRepository.memos
    }

    fun getAllTitle() : LiveData<List<String>> {
        return dbRepository.memoTitle
    }

    fun getAllContent() : LiveData<List<String>> {
        return dbRepository.memoContent
    }
}