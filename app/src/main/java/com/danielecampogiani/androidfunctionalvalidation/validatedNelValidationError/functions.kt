package com.danielecampogiani.androidfunctionalvalidation.validatedNelValidationError

import arrow.data.*
import arrow.instances.nonemptylist.semigroup.semigroup
import arrow.instances.validated.applicative.applicative

import com.danielecampogiani.androidfunctionalvalidation.Data
import com.danielecampogiani.androidfunctionalvalidation.ValidationError
import com.danielecampogiani.androidfunctionalvalidation.validMail
import com.danielecampogiani.androidfunctionalvalidation.validNumber

fun validateData(mail: String, phoneNumber: String): Validated<Nel<ValidationError>, Data> {

    return Validated.applicative<Nel<ValidationError>>(Nel.semigroup()).map(mail.validatedMail(), phoneNumber.validatedPhoneNumber()) {
        Data(it.a, it.b)
    }.fix()

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