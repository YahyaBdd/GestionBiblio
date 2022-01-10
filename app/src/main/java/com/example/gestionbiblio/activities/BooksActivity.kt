package com.example.gestionbiblio.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gestionbiblio.models.jsonResponse.JsonResponse
import com.example.gestionbiblio.R
import com.example.gestionbiblio.adapters.BooksAdapter
import com.example.gestionbiblio.models.Book
import okhttp3.*
import com.google.gson.GsonBuilder
import java.io.IOException

class BooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        val booksRV = findViewById<RecyclerView>(R.id.BooksRV)
        booksRV.layoutManager= LinearLayoutManager(this)

        fetchJson()


    }
    fun fetchJson() {
        val books:ArrayList<Book> = arrayListOf()

        val url = "https://www.googleapis.com/books/v1/volumes?q=kotlin"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                print("ERROR")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()

                val gson = GsonBuilder().create()

                val jsonResponse = gson.fromJson(body, JsonResponse::class.java)

                runOnUiThread {
                    val booksRV = findViewById<RecyclerView>(R.id.BooksRV)

                    booksRV.adapter= BooksAdapter(jsonResponse)
                }
            }
        })
    }
}