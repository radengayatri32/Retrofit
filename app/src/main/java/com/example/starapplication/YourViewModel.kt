package com.example.starapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YourViewModel : ViewModel() {
    private val _adapterData = MutableLiveData<List<ResultsItem>>()
    val adapterData: LiveData<List<ResultsItem>> get() = _adapterData

    fun fetchData() {
        val service = ApiConfig.getService()
        val call = service.getResponse()

        call.enqueue(object : Callback<Responses> {
            override fun onResponse(call: Call<Responses>, response: Response<Responses>) {
                if (response.isSuccessful) {
                    val data = response.body()?.results
                    if (data != null) {
                        _adapterData.value = data as List<ResultsItem>?
                    } else {
                        _adapterData.value = emptyList()
                    }
                } else {
                    _adapterData.value = emptyList()
                }
            }

            override fun onFailure(call: Call<Responses>, t: Throwable) {
                // Handle the failure here
                _adapterData.value = emptyList()
            }
        })
    }

    fun formatHeight(height: String?): String {
        return "$height cm"
    }
}
