package com.example.nigeriatelemedicineapp.registerpatient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.nigeriatelemedicineapp.R
import com.example.nigeriatelemedicineapp.api.models.Identifier
import com.example.nigeriatelemedicineapp.databinding.ActivityAppointmentFormBinding
import kotlinx.android.synthetic.main.activity_appointment_form.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPatientActivity : AppCompatActivity() {

    private lateinit var  viewModel : RegisterPatientViewModel
    private lateinit var binding: ActivityAppointmentFormBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_appointment_form)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = "Appointment Form"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        viewModel= ViewModelProviders.of(this).get(RegisterPatientViewModel::class.java)
        binding.register.setOnClickListener{getresponseCode(it)}
    }

    private fun getresponseCode(it: View?) {
        viewModel.repository.getIdentifier()?.enqueue(object : Callback<Identifier> {
            override fun onResponse(call: Call<Identifier>, response: Response<Identifier>) {
                if (response.code() == 200) {

                    val s=response.body()?.getUuid()
                    Toast.makeText(applicationContext, "Response 200 :  $s ",Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<Identifier>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed",Toast.LENGTH_SHORT).show()

            }
        })
    }
}
