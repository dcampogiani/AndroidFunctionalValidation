package com.danielecampogiani.androidfunctionalvalidation.validatedNelValidationError

import com.danielecampogiani.androidfunctionalvalidation.Data
import com.danielecampogiani.androidfunctionalvalidation.ValidationError
import com.danielecampogiani.androidfunctionalvalidation.validMail
import com.danielecampogiani.androidfunctionalvalidation.validNumber
import kategory.*

fun validateData(mail: String, phoneNumber: String): Validated<Nel<ValidationError>, Data> {

    return Validated.applicative<Nel<ValidationError>>().map2(mail.validatedMail(), phoneNumber.validatedPhoneNumber()) {
        Data(it.a, it.b)
    }.ev()

}

private fun String.validatedMail(): Validated<Nel<ValidationError>, String> =
        when {
            validMail(this) -> this.valid()
            else -> ValidationError.InvalidMail.nel().invalid()
        }

private fun String.validatedPhoneNumber(): Validated<Nel<ValidationError>, String> =
        when {
            validNumber(this) -> this.valid()
            else -> ValidationError.InvalidPhoneNumber.nel().invalid()
        }