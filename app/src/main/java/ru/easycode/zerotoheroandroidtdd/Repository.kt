package ru.easycode.zerotoheroandroidtdd

import ru.easycode.zerotoheroandroidtdd.SimpleService

interface Repository {

    suspend fun load() : SimpleResponse

    class Base(private val service: SimpleService, private val url: String) : Repository {

        override suspend fun load(): SimpleResponse = service.fetch(url)
    }
}