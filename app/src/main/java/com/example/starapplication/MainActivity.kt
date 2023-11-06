package com.example.starapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = Adapter()
        recyclerView.adapter = adapter

        // Fetch data from the API and populate the RecyclerView
        fetchData()
    }

    private fun fetchData() {
        val service = ApiConfig.getService()
        val call = service.getResponse()

        call.enqueue(object : Callback<Responses> {
            override fun onResponse(call: Call<Responses>, response: Response<Responses>) {
                if (response.isSuccessful) {
                    val data = response.body()?.results ?: emptyList()
                    adapter.submitList(data)
                } else {
                    Toast.makeText(this@MainActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Responses>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Network request failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
