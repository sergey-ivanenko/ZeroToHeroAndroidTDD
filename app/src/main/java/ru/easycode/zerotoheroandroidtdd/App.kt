package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import android.util.Log

class App : Application() {

    var viewModel: MainViewModel? = null

    init {
        Log.d("isg", "App init")
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("isg", "App onCreate")
        viewModel = MainViewModel(LiveDataWrapper.Base(), Repository.Base())
    }
}