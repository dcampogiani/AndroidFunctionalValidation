package com.danielecampogiani.androidfunctionalvalidation

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.danielecampogiani.androidfunctionalvalidation.either.EitherActivity
import com.danielecampogiani.androidfunctionalvalidation.option.OptionActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        option_button.setOnClickListener {
            start<OptionActivity>()
        }

        either_button.setOnClickListener({
            start<EitherActivity>()
        })
    }

    private inline fun <reified T> start() {
        startActivity(Intent(this, T::class.java))
    }
}
