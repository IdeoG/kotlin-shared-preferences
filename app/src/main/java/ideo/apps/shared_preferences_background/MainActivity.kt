package ideo.apps.shared_preferences_background

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import ideo.apps.shared_preferences_background.adapter.BackgroundColorAdapter
import ideo.apps.shared_preferences_background.storage.Preferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IBackgroundColor {
    lateinit var prefs: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = Preferences(this)
        val colors = generateColors().toList()

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = BackgroundColorAdapter(colors, this)

        setBackground(prefs.bgColor)
    }

    fun generateColors() = mapOf(
            "WHITE" to Color.WHITE,
            "CYAN" to Color.CYAN,
            "MAGENTA" to Color.MAGENTA,
            "YELLOW" to Color.YELLOW,
            "GREEN" to Color.GREEN,
            "LTGRAY" to Color.LTGRAY,
            "BLUE" to Color.BLUE
    )

    override fun setBackground(color: Int) {
        container.setBackgroundColor(color)
        prefs.bgColor = color
    }
}
