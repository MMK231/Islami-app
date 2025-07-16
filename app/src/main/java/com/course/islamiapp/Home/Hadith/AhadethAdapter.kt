package com.course.islamiapp.Home.Hadith


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.course.islamiapp.databinding.ListOfAhadithBinding


class AhadethAdapter(val listOfAhadeth: List<String>) :
    RecyclerView.Adapter<AhadethAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        var binding = ListOfAhadithBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.binding.contentAhadithLayout.hadithTv.text = listOfAhadeth[position]
    }

    override fun getItemCount(): Int = listOfAhadeth.size


    class ViewHolder(val binding: ListOfAhadithBinding) : RecyclerView.ViewHolder(binding.root)

}