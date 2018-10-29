package com.rommelrico.connect3game

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // 0 = yellow, 1 = red.
    var activePlayer = 0
    // Tracks game state.
    var gameActive = true

    // Game state
    var gameState = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    // Winning positions
    val winningPositions = arrayOf(
            intArrayOf(0, 1, 2), intArrayOf(3, 4, 5), intArrayOf(6, 7, 8),
            intArrayOf(0, 3, 6), intArrayOf(1, 4, 7), intArrayOf(2, 5, 8),
            intArrayOf(0, 4, 8), intArrayOf(2, 4, 6)
    )

    fun dropIn(view: View) {
        val counter = view as ImageView

        val tappedCounter = (counter.getTag().toString()).toInt()
        if (gameState[tappedCounter] == 2 && gameActive) {
            gameState[tappedCounter] = activePlayer

            counter.translationY = -1500f

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow)
                activePlayer = 1
            } else {
                counter.setImageResource(R.drawable.red)
                activePlayer = 0
            }

            counter.animate().translationYBy(1500f).setDuration(300).rotation(3600f)

            // Check winning positions
            for (winningPosition in winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]]
                        && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                        && gameState[winningPosition[0]] != 2) {

                    // Someone has won!
                    gameActive = false
                    var winner = ""
                    if (activePlayer == 1) {
                        winner = "Yellow"
                    } else {
                        winner = "Red"
                    }

                    Toast.makeText(this, "$winner won!", Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
