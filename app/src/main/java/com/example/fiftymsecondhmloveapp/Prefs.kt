package com.example.fiftymsecondhmloveapp

import android.content.Context

class Prefs() {


    fun saveState(context: Context) {
        val preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
        preferences.edit().putBoolean("isShow", true).apply()
    }

    fun isShown(context: Context): Boolean {
        val preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
        return preferences.getBoolean("isShow", false)
    }


}