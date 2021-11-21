package com.example.roomhomeworkdefaultrepo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomhomeworkdefaultrepo.database.Memo
import com.example.roomhomeworkdefaultrepo.databinding.RvListBinding
import com.example.roomhomeworkdefaultrepo.listener.OnItemClick

class MemoAdapter(listener: OnItemClick)  : RecyclerView.Adapter<MemoAdapter.MemoViewHolder>(){

    private val mCallback = listener
    private val items = ArrayList<Memo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvListBinding.inflate(layoutInflater)
        return MemoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setList(memo: List<Memo>) {
        items.clear()
        items.addAll(memo)
    }

    inner class MemoViewHolder(private val binding : RvListBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Memo){
            binding.rvTitle.text = item.title
            binding.rvContent.text = item.content
            binding.imageView.setOnClickListener {
                mCallback.deleteMemo(item)
            }
        }
    }

}