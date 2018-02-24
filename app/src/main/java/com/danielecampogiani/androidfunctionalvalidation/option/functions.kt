package com.danielecampogiani.androidfunctionalvalidation.option

import arrow.core.None
import arrow.core.Option
import arrow.core.applicative
import arrow.core.ev
import arrow.syntax.option.some
import com.danielecampogiani.androidfunctionalvalidation.Data
import com.danielecampogiani.androidfunctionalvalidation.validMail
import com.danielecampogiani.androidfunctionalvalidation.validNumber


fun validateData(mail: String, phoneNumber: String): Option<Data> {

    return Option.applicative().map2(mail.optionMail(), phoneNumber.optionPhoneNumber()) {
        Data(it.a, it.b)
    }.ev()

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