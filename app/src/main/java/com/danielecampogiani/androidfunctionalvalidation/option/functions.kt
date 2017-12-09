package com.danielecampogiani.androidfunctionalvalidation.option

import com.danielecampogiani.androidfunctionalvalidation.Data
import com.danielecampogiani.androidfunctionalvalidation.validMail
import com.danielecampogiani.androidfunctionalvalidation.validNumber
import kategory.Option
import kategory.applicative
import kategory.ev
import kategory.some


fun validateData(mail: String, phoneNumber: String): Option<Data> {

    return Option.applicative().map2(mail.optionMail(), phoneNumber.optionPhoneNumber()) {
        Data(it.a, it.b)
    }.ev()

}


private fun String.optionMail(): Option<String> =
        when {
            validMail(this) -> this.some()
            else -> Option.None
        }

private fun String.optionPhoneNumber(): Option<String> =
        when {
            validNumber(this) -> this.some()
            else -> Option.None
        }