package com.bombadu.bindingviewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MyViewModelFactory(
    //private dataSource: MyDatabaseDao, *Does not exist for example*
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            return MyViewModel(application) as T //add application constructor in MyViewModel
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}