package com.danielecampogiani.androidfunctionalvalidation.option

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import arrow.core.Option
import com.danielecampogiani.androidfunctionalvalidation.Data


class OptionViewModel : ViewModel() {

    private val mutableValidation: MutableLiveData<Option<Data>> = MutableLiveData()

    val validation: LiveData<Option<Data>>
        get() = mutableValidation


    fun validate(mail: String, phoneNumber: String) {
        val validationResult = validateData(mail, phoneNumber)
        mutableValidation.value = validationResult
    }

}