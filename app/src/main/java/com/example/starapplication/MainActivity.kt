package com.example.starapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: YourViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(YourViewModel::class.java)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = Adapter()
        binding.recyclerView.adapter = adapter

        // Observe the LiveData for adapter data
        viewModel.adapterData.observe(this, { data ->
            adapter.submitList(data)
        })

        // Fetch data from the API using LiveData
        viewModel.fetchData()
    }
}
