package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    fun update(value: UiState)
    fun liveData(): LiveData<UiState>

    class Base(
        private val liveData: MutableLiveData<UiState> = MutableLiveData()) : LiveDataWrapper {

        override fun update(uiState: UiState) {
            liveData.value = uiState
        }

        override fun liveData(): LiveData<UiState> = liveData
    }
}