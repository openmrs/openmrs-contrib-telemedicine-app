package com.example.nigeriatelemedicineapp.registerpatient

import android.content.Intent
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
import com.example.nigeriatelemedicineapp.dashboard.DashBoardActivity
import com.example.nigeriatelemedicineapp.databinding.ActivityAppointmentFormBinding
import android.app.Activity
import android.view.inputmethod.InputMethodManager


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
        viewModel.status.observe(this, Observer { handleStatus(it) })
        viewModel.dialog.observe(this, Observer { showAptDialog(it) })
    }

    private fun showAptDialog(it: Boolean?) {
        if (it!!)
            getSuccessDialog().show()
        else
            getFailureDialog().show()
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

        var gender: String? = null
        val radioGroup = findViewById<RadioGroup>(binding.gender.id)

        if (radioGroup.checkedRadioButtonId == binding.male.id)
            gender = "M"
        else if (radioGroup.checkedRadioButtonId == binding.female.id)
            gender = "F"

        checkNullability(gender)
    }

    private fun checkNullability(gender: String?) {
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
                binding.firstName.setError("Please enter your first name")
            }

            Status.EMPTY_LAST_NAME -> {
                binding.lastName.requestFocus()
                binding.lastName.setError("Please enter your last name")
            }

            Status.EMPTY_GENDER -> Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show()

            Status.EMPTY_PHONE -> {
                binding.phoneNumber.requestFocus()
                binding.phoneNumber.setError("Please Enter your phone number")
            }

            Status.EMPTY_DOB -> {
                binding.DOB.requestFocus()
                binding.DOB.setError("Please enter your DOB")
            }

            Status.SUCCESS -> startAnimations()
        }
    }

    fun hideKeyboard(activity: Activity = this) {
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = activity.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun startAnimations() {
        hideKeyboard()
        binding.CardView.visibility = View.INVISIBLE
        binding.text.visibility = View.INVISIBLE
        binding.progressbar.visibility = View.VISIBLE
        binding.loadingtext.visibility = View.VISIBLE
    }

    fun getSuccessDialog(): AlertDialog {
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(false)
        builder.setTitle("Success")
        builder.setMessage(R.string.SuccessDialogText)
        builder.setPositiveButton("back to dashboard") { dialog, which ->
            finish()
            startActivity(Intent(this, DashBoardActivity::class.java))
        }
        return builder.create()
    }

    fun getFailureDialog(): AlertDialog {
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(false)
        builder.setTitle("Error")
        builder.setMessage(R.string.FailureDialogText)
        builder.setPositiveButton("back to dashboard") { dialog, which ->
            finish()
            startActivity(Intent(this, DashBoardActivity::class.java))
        }
        return builder.create()
    }
}
