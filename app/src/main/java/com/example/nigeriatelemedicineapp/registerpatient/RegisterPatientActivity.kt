package com.example.nigeriatelemedicineapp.registerpatient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.nigeriatelemedicineapp.databinding.ActivityAppointmentFormBinding
import android.R



class RegisterPatientActivity : AppCompatActivity() {

    private lateinit var  viewModel : RegisterPatientViewModel
    private lateinit var binding: ActivityAppointmentFormBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,com.example.nigeriatelemedicineapp.R.layout.activity_appointment_form)
        viewModel= ViewModelProviders.of(this).get(RegisterPatientViewModel::class.java)
        setUpUI()
        setUpObservers()
    }

    private fun setUpObservers() {
        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            Toast.makeText(this," $newName ",Toast.LENGTH_SHORT)
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.responseString.observe(this,nameObserver)


        val idfObv = Observer<String> {idf->
            Toast.makeText(this," $idf ",Toast.LENGTH_SHORT).show()
        }

        viewModel.identifier.observe(this,idfObv)

    }

    fun setUpUI()
    {
        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = "Appointment Form"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.register.setOnClickListener{Register()}

    }

    private fun Register() {
        viewModel.registerPatient(binding.firstName.text.toString(),
            binding.lastName.text.toString())
    }

}
