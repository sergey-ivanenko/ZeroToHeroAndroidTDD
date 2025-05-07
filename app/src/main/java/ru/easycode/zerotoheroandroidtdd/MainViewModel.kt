package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData

class MainViewModel(private val liveDataWrapper: LiveDataWrapper.Mutable) : LiveDataWrapper.Observe {

    override fun liveData(): LiveData<UiState> = liveDataWrapper.liveData()

    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
        liveDataWrapper.update(bundleWrapper.restore())
    }

    fun load(text: String) {
        liveDataWrapper.update(UiState.ShowData(text))
    }
}