package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.easycode.zerotoheroandroidtdd.SimpleService

class App: Application() {

    var viewModel: MainViewModel? = null
    private var retrofit: Retrofit? = null

    override fun onCreate() {
        super.onCreate()

        retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        viewModel = MainViewModel(
            LiveDataWrapper.Base(),
            Repository.Base(retrofit?.create(SimpleService::class.java) as SimpleService, URL)
        )
    }

    companion object {
        private const val URL = "https://raw.githubusercontent.com/sergey-ivanenko/ZeroToHeroAndroidTDD/refs/heads/task/018-clouddatasource/app/sampleresponse.json"
    }
}