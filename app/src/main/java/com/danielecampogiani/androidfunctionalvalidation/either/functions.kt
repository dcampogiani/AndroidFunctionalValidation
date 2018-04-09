package com.danielecampogiani.androidfunctionalvalidation.either

import arrow.core.*
import com.danielecampogiani.androidfunctionalvalidation.Data
import com.danielecampogiani.androidfunctionalvalidation.validMail
import com.danielecampogiani.androidfunctionalvalidation.validNumber

fun validateData(mail: String, phoneNumber: String): Either<String, Data> {

    return Either.applicative<String>().map(mail.optionMail(), phoneNumber.optionPhoneNumber()) {
        Data(it.a, it.b)
    }.fix()

}

private fun String.optionMail(): Either<String, String> =
        when {
            validMail(this) -> this.right()
            else -> "Invalid email".left()
        }

private fun String.optionPhoneNumber(): Either<String, String> =
        when {
            validNumber(this) -> this.right()
            else -> "Invalid phone number".left()
        }