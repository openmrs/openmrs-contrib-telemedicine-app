package com.example.nigeriatelemedicineapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity;
import com.example.nigeriatelemedicineapp.dashboard.DashBoardActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        Handler().postDelayed({
            startActivity(Intent(this, DashBoardActivity::class.java))
            finish()
        },1000)
    }
}
