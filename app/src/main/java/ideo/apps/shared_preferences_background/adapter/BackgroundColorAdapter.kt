package ideo.apps.shared_preferences_background.adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ideo.apps.shared_preferences_background.IBackgroundColor
import ideo.apps.shared_preferences_background.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.color_item.*

class BackgroundColorAdapter(
        val colors: List<Pair<String, Int>>,
        val callback: IBackgroundColor
) : RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(colors[position].first, colors[position].second)
    }

    override fun getItemCount(): Int {
        return colors.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.color_item, parent, false)
        return ViewHolder(view, view, callback)
    }
}

class ViewHolder(
        view: View?,
        override val containerView: View?,
        val callback: IBackgroundColor
) : RecyclerView.ViewHolder(view), LayoutContainer, View.OnClickListener {
    var sColor: String = "White"
    var cColor: Int = Color.WHITE

    override fun onClick(v: View?) {
        callback.setBackground(cColor)
    }

    fun bind(sColor: String, cColor: Int) {
        this.cColor = cColor
        this.sColor = sColor

        cardview_color.setOnClickListener(this)
        cardview_color.setCardBackgroundColor(cColor)
        color_item_text.text = sColor
    }
}