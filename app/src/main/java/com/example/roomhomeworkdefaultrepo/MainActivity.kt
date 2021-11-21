package com.example.roomhomeworkdefaultrepo

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomhomeworkdefaultrepo.adapter.MemoAdapter
import com.example.roomhomeworkdefaultrepo.database.AppDataBase
import com.example.roomhomeworkdefaultrepo.database.Memo
import com.example.roomhomeworkdefaultrepo.databinding.ActivityMainBinding
import com.example.roomhomeworkdefaultrepo.listener.OnItemClick
import com.example.roomhomeworkdefaultrepo.vm.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), OnItemClick {
    private lateinit var binding : ActivityMainBinding
    private lateinit var db : AppDataBase
    private lateinit var wordList : LiveData<List<Memo>>
    private lateinit var adapter: MemoAdapter
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.vm = viewModel

        initRecyclerView()

        viewModel.getAllData().observe(this, Observer{
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })

        binding.saveDataButton.setOnClickListener {
            val title : String = findViewById<EditText>(R.id.titleEditText).text.toString()
            val content : String = findViewById<EditText>(R.id.contentEditText).text.toString()
            viewModel.insertData(Memo(title, content))
        }
    }

    private fun initRecyclerView() {
        binding.memoRecycler.layoutManager = LinearLayoutManager(this)
        adapter = MemoAdapter(this)
        binding.memoRecycler.adapter = adapter
    }

    override fun deleteMemo(memo: Memo) {
        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.deleteData(memo)
        }
    }
}