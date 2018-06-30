package ideo.apps.shared_preferences_background.storage

import android.content.Context
import android.graphics.Color

class Preferences (context: Context) {
    val FILE_NAME = "preferences"
    val BACKGROUND_COLOR = "background_color"
    val prefs = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    var bgColor: Int
        get() = prefs.getInt(BACKGROUND_COLOR, Color.BLACK)
        set(value) = prefs.edit().putInt(BACKGROUND_COLOR, value).apply()
}