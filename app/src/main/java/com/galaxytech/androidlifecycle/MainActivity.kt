package com.galaxytech.androidlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var create : TextView
    private lateinit var start : TextView
    private lateinit var resume : TextView
    private lateinit var pause : TextView
    private lateinit var stop : TextView
    private lateinit var destroy : TextView
    private var count : Int = 0

    var gameState: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameState = savedInstanceState?.getString("GAME_STATE_KEY")
        setContentView(R.layout.activity_main)

        create = findViewById(R.id.create)
        start = findViewById(R.id.start)
        resume = findViewById(R.id.resume)
        pause = findViewById(R.id.pause)
        stop = findViewById(R.id.stop)
        destroy = findViewById(R.id.destroy)

        count++;

        create.text = "onCreate Called $count"
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        create.text = savedInstanceState?.getString("TEXT_VIEW_KEY")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run {
            putString("GAME_STATE_KEY", gameState)
            putString("TEXT_VIEW_KEY", create.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        count++
        start.text = "onStart() Called $count"
    }

    override fun onResume() {
        super.onResume()
        count++
        resume.text = "onResume() Called $count"
    }

    override fun onPause() {
        super.onPause()
        count++
        pause.text = "OnPause() Called $count"
    }

    override fun onStop() {
        super.onStop()
        count++
        stop.text = "onStop() Called $count"
    }

    override fun onDestroy() {
        super.onDestroy()
        count++
        destroy.text = "onDestroy() Called $count"
    }
}