package com.example.lovecalculator_mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator_mvvm.remote.LoveModel

class LoveViewModel : ViewModel() {

    val repository = Repository()

    fun getLiveLoveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getData(firstName, secondName)
    }
}