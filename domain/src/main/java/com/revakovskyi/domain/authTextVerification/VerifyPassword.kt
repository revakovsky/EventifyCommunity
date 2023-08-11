package com.revakovskyi.domain.authTextVerification

import com.revakovskyi.domain.models.Status

internal class VerifyPassword {

    fun verify(password: String): Status {
        return if (password.isNotEmpty()) {
            if (isPasswordValid(password)) Status.Correct
            else Status.Incorrect
        } else Status.Neutral
    }

    private fun isPasswordValid(password: String): Boolean {
        val passwordPattern = Regex("^(?=.*[0-9])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{8,}$")
        return passwordPattern.matches(password)
    }

}