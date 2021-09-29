package com.gunder.myservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        inisialisasi button
        val btnStartService = findViewById<Button>(R.id.btn_start_service)
        btnStartService.setOnClickListener {  }

        val btnStartJonIntentService = findViewById<Button>(R.id.btn_start_job_intent_service)
        btnStartJonIntentService.setOnClickListener {  }

        val btnStartBoundService = findViewById<Button>(R.id.btn_start_bound_service)
        btnStartBoundService.setOnClickListener {  }

        val btnStopBoundService = findViewById<Button>(R.id.btn_stop_bound_service)
        btnStopBoundService.setOnClickListener {  }
    }
}