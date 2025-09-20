package com.course.islamiapp.Home.Quran


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.course.islamiapp.R


class SurasAdapter(var suras: List<String>) :
    RecyclerView.Adapter<SurasAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_of_suras, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        var title = suras[position]
        holder.title.setText(suras[position])
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener {
                onItemClickListener?.OnItemClick(position, title)
            }
        }
    }

    override fun getItemCount(): Int = suras.size
    var onItemClickListener: OnItemClickListener? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.suras_tv)
    }

    fun setFilteredList(suras: List<String>) {
        this.suras = suras
        notifyDataSetChanged()
    }

    fun interface OnItemClickListener {
        fun OnItemClick(position: Int, title: String)
    }
}