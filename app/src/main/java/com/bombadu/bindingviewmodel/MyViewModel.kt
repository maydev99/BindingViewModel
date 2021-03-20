package com.bombadu.bindingviewmodel

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class MyViewModel(application: Application) : AndroidViewModel(application) {

    private var _myData = MutableLiveData<String>()
    val myData: LiveData<String>
        get() = _myData

    private val _navigateToFragmentTwo = MutableLiveData<String>()
    val navigateToFragmentTwo: LiveData<String>
        get() = _navigateToFragmentTwo

    fun onNavigateToFragmentTwo() {
        viewModelScope.launch {
            val name = myData.value ?: return@launch
            _navigateToFragmentTwo.value = name
        }
    }

}

