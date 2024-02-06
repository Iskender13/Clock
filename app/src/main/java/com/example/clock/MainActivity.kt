package com.example.clock

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnStopwatch).setOnClickListener {
            startActivity(Intent(this, StopwatchActivity::class.java))
        }

        findViewById<Button>(R.id.btnTimer).setOnClickListener {
            startActivity(Intent(this, TimerActivity::class.java))
        }

        findViewById<Button>(R.id.btnAlarm).setOnClickListener {
            startActivity(Intent(this, AlarmActivity::class.java))
        }
    }
}
