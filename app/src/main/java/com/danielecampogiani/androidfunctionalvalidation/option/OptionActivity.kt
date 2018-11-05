package com.danielecampogiani.androidfunctionalvalidation.option

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.danielecampogiani.androidfunctionalvalidation.Data
import com.danielecampogiani.androidfunctionalvalidation.R
import kotlinx.android.synthetic.main.activity_input.*

class OptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val viewModel = ViewModelProviders.of(this)[OptionViewModel::class.java]

        signup_button.setOnClickListener {
            viewModel.validate(email.text.toString(), number.text.toString())
        }

        viewModel.validation.observe(this, Observer {
            it?.fold(this::handleNone, this::handleSome)
        })

    }

    private fun handleSome(data: Data) {
        val message = "Mail: ${data.mail} Phone: ${data.phone}"
        showMessage(message)
    }

    private fun handleNone() {
        val message = getString(R.string.option_wrong)
        showMessage(message)
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}