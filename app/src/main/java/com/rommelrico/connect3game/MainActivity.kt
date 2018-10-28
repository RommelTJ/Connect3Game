package com.rommelrico.connect3game

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    // 0 = yellow, 1 = red.
    var activePlayer = 0

    fun dropIn(view: View) {
        val counter = view as ImageView
        counter.translationY = -1500f

        if (activePlayer == 0) {
            counter.setImageResource(R.drawable.yellow)
            activePlayer = 1
        } else {
            counter.setImageResource(R.drawable.red)
            activePlayer = 0
        }

        counter.animate().translationYBy(1500f).setDuration(300).rotation(3600f)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
