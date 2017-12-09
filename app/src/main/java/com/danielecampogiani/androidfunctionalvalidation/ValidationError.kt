package com.danielecampogiani.androidfunctionalvalidation


sealed class ValidationError {
    object InvalidMail : ValidationError()
    object InvalidPhoneNumber : ValidationError()
}