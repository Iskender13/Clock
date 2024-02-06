package com.example.clock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.clock.databinding.ActivityAlarmBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AlarmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlarmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSetAlarm.setOnClickListener {
            val alarmTime = binding.etAlarmTime.text.toString().toIntOrNull() ?: 0
            setAlarm(alarmTime)
        }
    }

    private fun setAlarm(secondsFromNow: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            delay(secondsFromNow * 1000L)
            Toast.makeText(this@AlarmActivity, "Будильник сработал!", Toast.LENGTH_SHORT).show()
        }
    }
}
