package com.danielecampogiani.androidfunctionalvalidation.option

import arrow.core.*
import com.danielecampogiani.androidfunctionalvalidation.Data
import com.danielecampogiani.androidfunctionalvalidation.validMail
import com.danielecampogiani.androidfunctionalvalidation.validNumber


fun validateData(mail: String, phoneNumber: String): Option<Data> {

    return Option.applicative().map(mail.optionMail(), phoneNumber.optionPhoneNumber()) {
        Data(it.a, it.b)
    }.fix()

}


private fun String.optionMail(): Option<String> =
        when {
            validMail(this) -> this.some()
            else -> None
        }

private fun String.optionPhoneNumber(): Option<String> =
        when {
            validNumber(this) -> this.some()
            else -> None
        }