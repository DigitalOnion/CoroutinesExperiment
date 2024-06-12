package com.outerspace.coroutines_experiment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class WebViewModel: ViewModel() {
    private val model = WebModel()

    private val infoLiveData = MutableLiveData<String>()
    private val infoReturnLive = MutableLiveData<String>()

    private val infoObserver = Observer<String> {
            value -> infoLiveData.value = value
    }

    init {
        infoReturnLive.observeForever(infoObserver)
    }

    fun getFreshData() {
        model.fetchFreshData(infoReturnLive)
    }

    override fun onCleared() {
        infoReturnLive.removeObserver(infoObserver)
        super.onCleared()
    }
}