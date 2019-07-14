package com.example.nigeriatelemedicineapp.registerpatient

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

        viewModel.status.observe(this, Observer { handleStatus(it)})

        viewModel.responseString.observe(this, nameObserver)

        val idfObv = Observer<String> { idf ->
            Toast.makeText(this, "Successfully Fetched identifier : $idf ", Toast.LENGTH_SHORT).show()
        }

        viewModel.identifier.observe(this, idfObv)

    }

    fun setUpUI() {
        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = "consult a doctor"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.register.setOnClickListener { Register() }

    }

    private fun Register() {

        var gender : String? = null
        val radioGroup=findViewById<RadioGroup>(binding.gender.id)

        if(radioGroup.checkedRadioButtonId==binding.male.id)
            gender="M"
        else if (radioGroup.checkedRadioButtonId==binding.female.id)
            gender="F"

        checkNullability(gender)
    }

    private fun checkNullability(gender:String?){
          viewModel.checkNullValues(
              binding.firstName.text.toString(),
              binding.lastName.text.toString(),
              binding.DOB.text.toString(),
              gender.toString(),
              binding.phoneNumber.text.toString()
          )
    }

    private fun handleStatus(status: Status?) {
        when (status) {

            Status.EMPTY_FIRST_NAME -> {
                binding.firstName.requestFocus()
                binding.firstName.setError("Please enter your first name")}

            Status.EMPTY_LAST_NAME ->{
                binding.lastName.requestFocus()
             binding.lastName.setError("Please enter your last name")}

            Status.EMPTY_GENDER-> Toast.makeText(this,"Please select your gender",Toast.LENGTH_SHORT).show()

            Status.EMPTY_PHONE->{
                binding.phoneNumber.requestFocus()
                binding.phoneNumber.setError("Please Enter your phone number")}

            Status.EMPTY_DOB->{
                binding.DOB.requestFocus()
                binding.DOB.setError("Please enter your DOB")}

            Status.SUCCESS-> startAnimations()
        }
    }

    private fun startAnimations() {
        
    }
}
