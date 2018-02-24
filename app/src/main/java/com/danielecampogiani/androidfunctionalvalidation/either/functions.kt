package com.danielecampogiani.androidfunctionalvalidation.either

import arrow.core.Either
import arrow.core.applicative
import arrow.core.ev
import arrow.syntax.either.left
import arrow.syntax.either.right
import com.danielecampogiani.androidfunctionalvalidation.Data
import com.danielecampogiani.androidfunctionalvalidation.validMail
import com.danielecampogiani.androidfunctionalvalidation.validNumber

fun validateData(mail: String, phoneNumber: String): Either<String, Data> {

    return Either.applicative<String>().map2(mail.optionMail(), phoneNumber.optionPhoneNumber()) {
        Data(it.a, it.b)
    }.ev()

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