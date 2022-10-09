package com.llc.navigationcomponent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private var _name = MutableLiveData(" ")
    val name: LiveData<String> get() = _name

    private var _mobileNo = MutableLiveData(" ")
    val mobileNo: LiveData<String> get() = _mobileNo

    private var _email = MutableLiveData(" ")
    val email: LiveData<String> get() = _email

    private var _address = MutableLiveData(" ")
    val address: LiveData<String> get() = _address

    private var _uiEvent = MutableLiveData<Boolean>()
    val uiEvent: LiveData<Boolean> get() = _uiEvent

    fun login(
        name: String,
        mobileNo: String,
        email: String,
        address: String,
        listener: (Boolean) -> Unit
    ) {
        if (name.isNotBlank() && mobileNo.isNotBlank() && email.isNotBlank() && address.isNotBlank()) {
            // ToDo Navigate to next page
            listener.invoke(true)
            // _uiEvent.postValue(true)
        } else {
            // ToDo show field required message
            listener.invoke(false)
            // _uiEvent.postValue(false)
        }
    }
}