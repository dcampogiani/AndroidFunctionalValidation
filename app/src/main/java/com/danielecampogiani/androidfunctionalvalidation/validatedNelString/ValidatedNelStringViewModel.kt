package com.danielecampogiani.androidfunctionalvalidation.validatedNelString

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import arrow.data.Nel
import arrow.data.Validated
import com.danielecampogiani.androidfunctionalvalidation.Data

class ValidatedNelStringViewModel : ViewModel() {

    private val mutableValidation: MutableLiveData<Validated<Nel<String>, Data>> = MutableLiveData()

    val validation: LiveData<Validated<Nel<String>, Data>>
        get() = mutableValidation


    fun validate(mail: String, phoneNumber: String) {
        mutableValidation.value = validateData(mail, phoneNumber)
    }

}