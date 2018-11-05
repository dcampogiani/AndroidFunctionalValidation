package com.danielecampogiani.androidfunctionalvalidation.validatedNelValidationError

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import arrow.data.Nel
import arrow.data.Validated
import com.danielecampogiani.androidfunctionalvalidation.Data
import com.danielecampogiani.androidfunctionalvalidation.ValidationError

class ValidatedNelValidationErrorViewModel : ViewModel() {

    private val mutableValidation: MutableLiveData<Validated<Nel<ValidationError>, Data>> = MutableLiveData()

    val validation: LiveData<Validated<Nel<ValidationError>, Data>>
        get() = mutableValidation


    fun validate(mail: String, phoneNumber: String) {
        mutableValidation.value = validateData(mail, phoneNumber)
    }

}