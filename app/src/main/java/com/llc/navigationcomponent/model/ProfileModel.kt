package com.llc.navigationcomponent.model

import java.io.Serializable

data class ProfileModel(
    val name: String,
    val mobileNo: String,
    val email: String,
    val address: String,
    val dob :String
) : Serializable
