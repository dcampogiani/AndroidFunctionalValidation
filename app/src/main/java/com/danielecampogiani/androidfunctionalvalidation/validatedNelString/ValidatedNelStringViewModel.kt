package com.danielecampogiani.androidfunctionalvalidation.validatedNelString

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.danielecampogiani.androidfunctionalvalidation.Data
import kategory.Nel
import kategory.Validated

class ValidatedNelStringViewModel : ViewModel() {

    private val mutableValidation: MutableLiveData<Validated<Nel<String>, Data>> = MutableLiveData()

    val validation: LiveData<Validated<Nel<String>, Data>>
        get() = mutableValidation


    fun validate(mail: String, phoneNumber: String) {
        mutableValidation.value = validateData(mail, phoneNumber)
    }

}