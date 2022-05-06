package com.projeto.bleianews.ui.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.projeto.bleianews.databinding.ActivityNewsBinding
import com.projeto.bleianews.ui.news.adapters.AdapterNews

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding
    private val adapterItemNews: AdapterNews by lazy {
        AdapterNews()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActionBar()
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.recyclerNews.layoutManager = LinearLayoutManager(this)
        binding.recyclerNews.adapter = adapterItemNews
    }

    private fun setupActionBar() {
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.title = intent.extras?.get("title").toString()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()

    }
}