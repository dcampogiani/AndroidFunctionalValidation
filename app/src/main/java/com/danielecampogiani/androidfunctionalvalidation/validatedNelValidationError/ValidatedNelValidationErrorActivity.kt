package com.danielecampogiani.androidfunctionalvalidation.validatedNelValidationError

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import com.google.android.material.textfield.TextInputLayout
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import arrow.data.Nel
import com.danielecampogiani.androidfunctionalvalidation.Data
import com.danielecampogiani.androidfunctionalvalidation.R
import com.danielecampogiani.androidfunctionalvalidation.ValidationError
import kotlinx.android.synthetic.main.activity_input.*

class ValidatedNelValidationErrorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val viewModel = ViewModelProviders.of(this)[ValidatedNelValidationErrorViewModel::class.java]

        signup_button.setOnClickListener {
            viewModel.validate(email.text.toString(), number.text.toString())
        }

        viewModel.validation.observe(this, Observer {
            clearErrors()
            it?.fold(this::handleInvalid, this::handleValid)
        })
    }

    private fun clearErrors() {
        emailWrapper.error = null
        numberWrapper.error = null
    }

    private fun handleInvalid(errors: Nel<ValidationError>) {
        errors.map { handleInvalidField(it) }.all.forEach { it.second.error = it.first }
    }

    private fun handleInvalidField(validationError: ValidationError): Pair<String, TextInputLayout> =
            when (validationError) {
                ValidationError.InvalidMail -> Pair(getString(R.string.invalid_mail), emailWrapper)
                ValidationError.InvalidPhoneNumber -> Pair(getString(R.string.invalid_phone_number), numberWrapper)
            }

    private fun handleValid(data: Data) {
        val message = "Mail: ${data.mail} Phone: ${data.phone}"
        showMessage(message)
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}