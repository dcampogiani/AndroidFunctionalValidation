package com.danielecampogiani.androidfunctionalvalidation.either

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import arrow.core.Either
import com.danielecampogiani.androidfunctionalvalidation.Data

class EitherViewModel : ViewModel() {

    private val mutableValidation: MutableLiveData<Either<String, Data>> = MutableLiveData()

    val validation: LiveData<Either<String, Data>>
        get() = mutableValidation


    fun validate(mail: String, phoneNumber: String) {
        mutableValidation.value = validateData(mail, phoneNumber)
    }

}