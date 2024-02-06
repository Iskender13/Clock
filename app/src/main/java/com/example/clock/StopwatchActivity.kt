package com.example.clock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clock.R
import com.example.clock.databinding.ActivityStopwatchBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StopwatchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStopwatchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStopwatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var seconds = 0

        val job = CoroutineScope(Dispatchers.Main).launch {
            while (seconds < 100000) {
                binding.tvStopwatch.text = seconds.toString()
                delay(1000)
                seconds++
            }
        }
        binding.btnStartStop.setOnClickListener{
            job.cancel()
        }
    }
}