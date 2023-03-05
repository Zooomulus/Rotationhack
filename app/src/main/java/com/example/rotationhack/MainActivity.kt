package com.example.rotationhack

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var myButton: Button
    private lateinit var textView: TextView
    private lateinit var fadeOutAnimation: Animation
    private var textIndex = 0

    private val textList = listOf("Hello, Icarus", "Welcome to Earth")

    private val handler = Handler(Looper.getMainLooper())
    private val runnable = object : Runnable {
        override fun run() {
            updateText()
            handler.postDelayed(this, 10000) // Change delay here (in milliseconds)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myButton = findViewById(R.id.button)
        myButton.setOnClickListener {
            // Do something when button is clicked
        }

        textView = findViewById(R.id.textView)
        fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out)

        handler.post(runnable)
    }

    fun updateText() {
        textView.startAnimation(fadeOutAnimation)
        fadeOutAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationRepeat(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                textView.text = textList[textIndex]
                textIndex = (textIndex + 1) % textList.size
                textView.startAnimation(
                    AnimationUtils.loadAnimation(
                        this@MainActivity,
                        R.anim.text_scale
                    )
                )
            }
        })
    }

    override fun onDestroy() {
        handler.removeCallbacks(runnable)
        super.onDestroy()
    }
}

