package com.example.notepad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private val mList = mutableListOf<ModelNote>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sample_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: ModelNote = mList[position]
        holder.mTitle.text = model.title
        holder.mText.text = model.text
    }

    fun addItem(newItem: ModelNote) {
        mList.add(newItem)
        notifyItemInserted(mList.size)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val mTitle = itemView.findViewById<TextView>(R.id.TextView_Title)
        val mText = itemView.findViewById<TextView>(R.id.TextView_Text)
        val mCardView = itemView.findViewById<CardView>(R.id.CardView)

    }
}