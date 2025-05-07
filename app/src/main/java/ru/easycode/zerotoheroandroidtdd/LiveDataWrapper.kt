package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    interface Save {
        fun save(bundleWrapper: BundleWrapper.Save)
    }

    interface Update {
        fun update(uiState: UiState)
    }

    interface Observe {
        fun liveData(): LiveData<UiState>
    }

    interface Mutable : Save, Update, Observe

    class Base(private val liveData: MutableLiveData<UiState> = MutableLiveData()) : Mutable {

        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let { uiState -> bundleWrapper.save(uiState) }
        }

        override fun update(uiState: UiState) {
            liveData.value = uiState
        }

        override fun liveData(): LiveData<UiState> = liveData
    }
}