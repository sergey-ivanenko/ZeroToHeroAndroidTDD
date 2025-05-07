package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App : Application() {

    var viewModel: MainViewModel? = null

    override fun onCreate() {
        super.onCreate()

        viewModel = MainViewModel(LiveDataWrapper.Base())
    }
}