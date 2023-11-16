package com.example.imdbapimvvm.data

import android.content.SharedPreferences
import com.google.gson.Gson

interface SearchHistoryStorage {

    // Методы для добавления элемента в историю поиска, получения списка элементов истории поиска и очистки истории

}


class SharedPreferencesSearchHistoryStorage(
    private val prefs: SharedPreferences,
    private val gson: Gson
) : SearchHistoryStorage {

    // Реализация методов, в которых происходит чтение и запись данных в SharedPreferences

}