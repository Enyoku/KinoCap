package com.example.kinocap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launch_activity)
        val timer = object: CountDownTimer(3000, 1000){
            override fun onTick(p0: Long) {
//                Написать код для получения информации с API для двух категорий
            }

            override fun onFinish() {
                val intent = Intent(this@LaunchActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        timer.start()
    }
}