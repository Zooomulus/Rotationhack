package com.example.rotationhack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar

class Mainscreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screentwo)

        val progressBar = findViewById<ProgressBar>(R.id.circular_progress_bar)
        progressBar.progress = 50 // set the progress (0-100)
    }
}
