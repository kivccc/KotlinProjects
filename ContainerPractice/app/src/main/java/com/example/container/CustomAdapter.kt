package com.example.container

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.container.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class CustomAdapter: RecyclerView.Adapter<Holder>() {
    var listData = mutableListOf<Memo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)

    }

    override fun getItemCount(): Int {
        return listData.size
    }
}

class  Holder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
    fun setMemo(memo:Memo){
        binding.textNo.text="${memo.no}"
        binding.textTitle.text= memo.title

        var sdf = SimpleDateFormat("yyyy/MM/dd")
        var formattedData = sdf.format(memo.timestamp)
        binding.textDate.text = formattedData
    }
}