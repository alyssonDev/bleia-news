package com.projeto.bleianews.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.projeto.bleianews.R

class AdapterItensSelectMain : RecyclerView.Adapter<AdapterItensSelectMain.RecyclerViewHolder>() {

    private lateinit var mListener: AdapterListener

    private val listNames = listOf(
        "Ensaios de Jovens",
        "Ensaios de Adoslecentes",
        "Cultos de Missões",
        "Cultos de Mocidade",
        "Congresso de Jovens",
        "Congresso de Adolescentes",
        "Aniversários de Campanha",
        "Aniversários de Conjunto",
        "Aniversários de Coral",
        "Aniversários de Crianças",
        "Aniversários de Círculo de Oração"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return RecyclerViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return listNames.size
    }

    fun setListener(listener: AdapterListener) {
        mListener = listener
    }

    interface AdapterListener {
        fun openActivityByTitleNews(titleNews: String)
    }


    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {
            itemView.findViewById<TextView>(R.id.txv_title).text = listNames[adapterPosition]
            itemView.findViewById<ImageView>(R.id.image_news)
                .setOnClickListener { mListener.openActivityByTitleNews(listNames[adapterPosition]) }
        }
    }
}