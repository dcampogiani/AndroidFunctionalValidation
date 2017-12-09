package com.danielecampogiani.androidfunctionalvalidation.either

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.danielecampogiani.androidfunctionalvalidation.Data
import com.danielecampogiani.androidfunctionalvalidation.R
import kotlinx.android.synthetic.main.activity_input.*

class EitherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val viewModel = ViewModelProviders.of(this)[EitherViewModel::class.java]

        signup_button.setOnClickListener {
            viewModel.validate(email.text.toString(), number.text.toString())
        }

        viewModel.validation.observe(this, Observer {
            it?.fold(this::handleLeft, this::handleRight)
        })
    }

    private fun handleLeft(error: String) {
        showMessage(error)
    }

    private fun handleRight(data: Data) {
        val message = "Mail: ${data.mail} Phone: ${data.phone}"
        showMessage(message)
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}