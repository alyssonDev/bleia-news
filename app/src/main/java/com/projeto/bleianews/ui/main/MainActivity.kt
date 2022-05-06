package com.projeto.bleianews.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.projeto.bleianews.R
import com.projeto.bleianews.ui.news.NewsActivity
import com.projeto.bleianews.databinding.ActivityMainBinding
import com.projeto.bleianews.ui.main.adapters.AdapterItensSelectMain

class MainActivity : AppCompatActivity(), AdapterItensSelectMain.AdapterListener {
    private lateinit var binding: ActivityMainBinding
    private val adapterItensSelectMain: AdapterItensSelectMain by lazy {
        AdapterItensSelectMain()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.recyclerNews.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerNews.adapter = adapterItensSelectMain
        adapterItensSelectMain.setListener(this)
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("TAG", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            // Log and toast
            val msg = "Token --> $token"
            Log.d("TAG", msg)
            Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
        })
    }

    override fun openActivityByTitleNews(titleNews: String) {
        val intent = Intent(this, NewsActivity::class.java)
        intent.putExtra("title", titleNews)
        startActivity(intent)
    }
}