package com.rommelrico.connect3game

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    fun dropIn(view: View) {
        val counter = view as ImageView
        counter.translationY = -1500f
        counter.setImageResource(R.drawable.yellow)
        counter.animate().translationYBy(1500f).setDuration(300).rotation(3600f)

        Log.i("INFO", "Image received: ${counter}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
