package com.outerspace.coroutines_experiment

import androidx.lifecycle.MutableLiveData

class WebModel {

    fun fetchFreshData(live: MutableLiveData<String>) {
        live.value = "Data produced at the model - data layer"
    }

}