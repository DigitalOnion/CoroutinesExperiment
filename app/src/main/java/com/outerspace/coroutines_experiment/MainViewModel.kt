package com.outerspace.coroutines_experiment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val model = MainModel()
    val infoObservable = MutableLiveData<String>()
    val infoObservablenew = MutableLiveData<String>()
    fun getFreshData() {
        infoObservable.value = model.getFreshData()

    }

    fun getData(){
        infoObservablenew.value= model.getData()
    }
}
