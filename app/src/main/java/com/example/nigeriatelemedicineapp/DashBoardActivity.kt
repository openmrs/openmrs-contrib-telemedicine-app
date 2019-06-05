package com.example.nigeriatelemedicineapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick


import kotlinx.android.synthetic.main.activity_main.*

class DashBoardActivity : AppCompatActivity() {

    @BindView(R.id.register_patient)
    lateinit var registerPatient : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)
        setSupportActionBar(toolbar)
        ButterKnife.bind(this)
        val actionBar= supportActionBar
        actionBar!!.title="DashBoard"
    }

    @OnClick(R.id.register_patient)
    private fun onClick()
    {

    }



}
