package com.danielecampogiani.androidfunctionalvalidation.validatedNelString

import com.danielecampogiani.androidfunctionalvalidation.Data
import com.danielecampogiani.androidfunctionalvalidation.validMail
import com.danielecampogiani.androidfunctionalvalidation.validNumber
import kategory.*

fun validateData(mail: String, phoneNumber: String): Validated<Nel<String>, Data> {

    return Validated.applicative<Nel<String>>().map2(mail.validatedMail(), phoneNumber.validatedPhoneNumber()) {
        Data(it.a, it.b)
    }.ev()

}

private fun String.validatedMail(): Validated<Nel<String>, String> =
        when {
            validMail(this) -> this.valid()
            else -> "Invalid email".nel().invalid()
        }

private fun String.validatedPhoneNumber(): Validated<Nel<String>, String> =
        when {
            validNumber(this) -> this.valid()
            else -> "Invalid phone number".nel().invalid()
        }