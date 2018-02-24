package com.danielecampogiani.androidfunctionalvalidation.either

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
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