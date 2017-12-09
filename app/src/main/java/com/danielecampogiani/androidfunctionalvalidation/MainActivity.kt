package com.danielecampogiani.androidfunctionalvalidation

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.danielecampogiani.androidfunctionalvalidation.either.EitherActivity
import com.danielecampogiani.androidfunctionalvalidation.option.OptionActivity
import com.danielecampogiani.androidfunctionalvalidation.validatedNelString.ValidatedNelStringActivity
import com.danielecampogiani.androidfunctionalvalidation.validatedNelValidationError.ValidatedNelValidationErrorActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        option_button.bindActivity<OptionActivity>()
        either_button.bindActivity<EitherActivity>()
        validated_nel_string_button.bindActivity<ValidatedNelStringActivity>()
        validated_nel_validation_error_button.bindActivity<ValidatedNelValidationErrorActivity>()
    }

    private inline fun <reified T : AppCompatActivity> Button.bindActivity() {
        this.setOnClickListener {
            start<T>()
        }
    }

    private inline fun <reified T : AppCompatActivity> start() {
        startActivity(Intent(this, T::class.java))
    }
}
