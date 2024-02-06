package com.example.clock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.clock.databinding.ActivityTimerBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTimerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartTimer.setOnClickListener {
            val time = binding.etTimerSeconds.text.toString().toIntOrNull() ?: 0
            startTimer(time)
        }
    }

    private fun startTimer(seconds: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            var timeLeft = seconds
            while (timeLeft > 0) {
                binding.tvTimer.text = timeLeft.toString()
                delay(1000)
                timeLeft--
            }
            Toast.makeText(this@TimerActivity, "Время вышло!", Toast.LENGTH_SHORT).show()
        }
    }
}