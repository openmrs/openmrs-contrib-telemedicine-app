package org.fortitudo.nigeriatelemedicineapp.help

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import org.fortitudo.nigeriatelemedicineapp.R
import org.fortitudo.nigeriatelemedicineapp.databinding.ActivityHelpBinding
import kotlinx.android.synthetic.main.activity_help.toolbar


class HelpActivity : AppCompatActivity() {

    private lateinit var viewModel: HelpViewModel
    private lateinit var binding: ActivityHelpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_help)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = "Help"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        viewModel = ViewModelProviders.of(this).get(HelpViewModel::class.java)

    }
}