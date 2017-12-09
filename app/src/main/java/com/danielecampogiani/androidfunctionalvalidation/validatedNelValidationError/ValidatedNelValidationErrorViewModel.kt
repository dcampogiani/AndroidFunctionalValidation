package com.danielecampogiani.androidfunctionalvalidation.validatedNelValidationError

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.danielecampogiani.androidfunctionalvalidation.Data
import com.danielecampogiani.androidfunctionalvalidation.ValidationError
import kategory.Nel
import kategory.Validated

class ValidatedNelValidationErrorViewModel : ViewModel() {

    private val mutableValidation: MutableLiveData<Validated<Nel<ValidationError>, Data>> = MutableLiveData()

    val validation: LiveData<Validated<Nel<ValidationError>, Data>>
        get() = mutableValidation


    fun validate(mail: String, phoneNumber: String) {
        mutableValidation.value = validateData(mail, phoneNumber)
    }

}