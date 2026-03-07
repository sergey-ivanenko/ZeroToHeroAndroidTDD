package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle

interface BundleWrapper {

    interface Save {
        fun save(list: ArrayList<CharSequence>)
    }

    interface Restore {
        fun restore(): List<CharSequence>
    }

    interface Mutable: Save, Restore

    class Base(private val bundle: Bundle) : Mutable {

        override fun save(list: ArrayList<CharSequence>) {
            bundle.putCharSequenceArrayList(BUNDLE_KEY, list)
        }

        override fun restore(): List<CharSequence> =
            bundle.getCharSequenceArrayList(BUNDLE_KEY) ?: ArrayList()

        companion object {
            private const val BUNDLE_KEY = "bundleKey"
        }
    }
}