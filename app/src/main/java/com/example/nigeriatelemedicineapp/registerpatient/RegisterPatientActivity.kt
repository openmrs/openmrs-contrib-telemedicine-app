package com.example.nigeriatelemedicineapp.registerpatient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.nigeriatelemedicineapp.R
import com.example.nigeriatelemedicineapp.databinding.ActivityAppointmentFormBinding


class RegisterPatientActivity : AppCompatActivity() {

    private lateinit var viewModel: RegisterPatientViewModel
    private lateinit var binding: ActivityAppointmentFormBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, com.example.nigeriatelemedicineapp.R.layout.activity_appointment_form)
        viewModel = ViewModelProviders.of(this).get(RegisterPatientViewModel::class.java)
        setUpUI()
        setUpObservers()
    }

    private fun setUpObservers() {
        val nameObserver = Observer<String> { newName ->
            Toast.makeText(this, " $newName ", Toast.LENGTH_LONG).show()
        }

        viewModel.responseString.observe(this, nameObserver)

        val idfObv = Observer<String> { idf ->
            Toast.makeText(this, "Successfully Fetched identifier : $idf ", Toast.LENGTH_SHORT).show()
        }

        viewModel.identifier.observe(this, idfObv)

    }

    fun setUpUI() {
        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.appointmentFormheading)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.register.setOnClickListener { Register() }

    }

    private fun Register() {
        viewModel.registerPatient(
            binding.firstName.text.toString(),
            binding.lastName.text.toString()
        )
    }

}
