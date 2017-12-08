package com.danielecampogiani.androidfunctionalvalidation


import java.util.regex.Pattern


val VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)!!
val VALID_PHONE_NUMBER_ADDRESS_REGEX = Pattern.compile("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}", Pattern.CASE_INSENSITIVE)!!


fun validMail(input: String): Boolean {
    val matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(input)
    return matcher.find()
}

fun validNumber(input: String): Boolean {
    val matcher = VALID_PHONE_NUMBER_ADDRESS_REGEX.matcher(input)
    return matcher.find()
}