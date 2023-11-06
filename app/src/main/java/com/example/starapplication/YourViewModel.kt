package com.example.starapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YourViewModel : ViewModel() {
    private val _response = MutableLiveData<Response<Responses>>()
    val response: LiveData<Response<Responses>> get() = _response

    private val _adapterData = MutableLiveData<List<ResultsItem>>()
    val adapterData: LiveData<List<ResultsItem>> get() = _adapterData


}
