package com.example.pictolingo.components


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pictolingo.objects.Pictogram

class MiViewModel : ViewModel() {
    var lista: MutableList<Pictogram> = mutableListOf()
    private val _sharedIndex = MutableLiveData<Int>(0)
   // var index: LiveData<Int> get() = _sharedIndex
    fun setSharedInt(value: Int) {
        _sharedIndex.value = value
    }
}