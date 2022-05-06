package com.projeto.bleianews.ui.news.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projeto.bleianews.R

class AdapterNews : RecyclerView.Adapter<AdapterNews.ViewHolderItemListNews>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItemListNews {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_list_news, parent, false)
        return ViewHolderItemListNews(view)

    }

    override fun onBindViewHolder(holder: ViewHolderItemListNews, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 5
    }


    inner class ViewHolderItemListNews(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {

        }
    }
}