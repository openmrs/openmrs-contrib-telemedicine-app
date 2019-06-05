package com.example.nigeriatelemedicineapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;


import kotlinx.android.synthetic.main.activity_main.*

class DashBoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)
        setSupportActionBar(toolbar)

    }

}
