package org.fortitudo.nigeriatelemedicineapp.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import org.fortitudo.nigeriatelemedicineapp.registerpatient.RegisterPatientActivity
import org.fortitudo.nigeriatelemedicineapp.R
import org.fortitudo.nigeriatelemedicineapp.databinding.DashboardActivityBinding
import org.fortitudo.nigeriatelemedicineapp.help.HelpActivity
import kotlinx.android.synthetic.main.dashboard_activity.*

class DashBoardActivity : AppCompatActivity() {

    private lateinit var  viewModel : DashBoardViewModel
    private lateinit var binding: DashboardActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.dashboard_activity)
        setSupportActionBar(toolbar)
        val actionBar= supportActionBar
        actionBar!!.title=getString(R.string.dashboard_actionbar)
        viewModel= ViewModelProviders.of(this).get(DashBoardViewModel::class.java)
        setupUI()
    }

    private fun setupUI()
    {
        binding.registerPatient.setOnClickListener { startActivity(it) }
        binding.about.setOnClickListener{startActivity(it)}
    }

    private fun startActivity(it: View?) {
        when(it){
              binding.registerPatient->
                  startActivity(Intent(this, RegisterPatientActivity::class.java))

            binding.about->
                startActivity(Intent(this, HelpActivity::class.java))
        }

    }
}
