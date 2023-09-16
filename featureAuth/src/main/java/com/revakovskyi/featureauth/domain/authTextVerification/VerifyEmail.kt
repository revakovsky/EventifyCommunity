package com.revakovskyi.featureauth.domain.authTextVerification

import com.revakovskyi.featureauth.domain.models.Status

internal object VerifyEmail {

    fun verify(email: String): Status {
        return if (email.isNotEmpty()) {
            if (isEmailValid(email)) Status.Correct
            else if (isIncorrectStartOfEmail(email)) Status.Incorrect
            else Status.Neutral
        } else Status.Neutral
    }

    private fun isEmailValid(login: String): Boolean {
        val emailPattern = Regex("""^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$""")
        return emailPattern.matches(login)
    }

    private fun isIncorrectStartOfEmail(login: String): Boolean {
        val startPattern = Regex("""^[^a-zA-Z0-9+_].*""")
        return startPattern.matches(login)
    }

}