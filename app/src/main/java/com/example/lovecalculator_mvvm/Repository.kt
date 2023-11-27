package com.example.lovecalculator_mvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculator_mvvm.remote.LoveModel
import com.example.lovecalculator_mvvm.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    val api = RetrofitService.api
    fun getData(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val love = MutableLiveData<LoveModel>()

        api.getLove(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        love.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("sagsag", "onFailure:${t.message}")
            }

        })
        return love
    }
}