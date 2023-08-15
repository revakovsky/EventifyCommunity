package com.revakovskyi.domain.authTextVerification

import com.revakovskyi.domain.models.Status

internal class VerifyLogin {

    private val verifyEmail = VerifyEmail()
    private val verifyPhoneNumber = VerifyPhoneNumber()

    fun verify(login: String): Status {
        return if (login.isNotEmpty()) {
            if (
                verifyEmail.verify(login) == Status.Correct ||
                verifyPhoneNumber.verify(login) == Status.Correct
            ) Status.Correct
            else if (
                verifyEmail.verify(login) == Status.Incorrect ||
                verifyPhoneNumber.verify(login) == Status.Incorrect
            ) Status.Incorrect
            else Status.Neutral

        } else Status.Neutral
    }

}