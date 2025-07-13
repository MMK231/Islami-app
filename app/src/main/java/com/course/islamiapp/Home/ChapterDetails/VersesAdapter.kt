package com.course.islamiapp.Home.ChapterDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.course.islamiapp.R

class VersesAdapter(val listOfVerses: List<String> = listOf()) :
    RecyclerView.Adapter<VersesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_of_verses,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
       val verse = listOfVerses[position]
        holder.verse.text = "$verse (${position +1})"
    }

    override fun getItemCount(): Int = listOfVerses.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val verse = itemView.findViewById<TextView>(R.id.tv_verse)
    }
}