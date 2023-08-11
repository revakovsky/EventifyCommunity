package com.revakovskyi.domain.authTextVerification

import com.revakovskyi.domain.models.Status

internal class VerifyLogin {

    fun verify(login: String): Status {
        return if (login.isNotEmpty()) {
            if (isPhoneNumberValid(login) || isEmailValid(login)) Status.Correct
            else if (isIncorrectPhoneNumberLength(login) || isIncorrectStartOfLogin(login)) Status.Incorrect
            else Status.Neutral
        } else Status.Neutral
    }

    private fun isPhoneNumberValid(login: String): Boolean {
        val phonePattern = Regex("""^\+380\d{9}$""")
        return phonePattern.matches(login)
    }

    private fun isEmailValid(login: String): Boolean {
        val emailPattern = Regex("""^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$""")
        return emailPattern.matches(login)
    }

    private fun isIncorrectPhoneNumberLength(inputText: String) =
        inputText.startsWith("+380") && inputText.length > 13

    private fun isIncorrectStartOfLogin(login: String): Boolean {
        val startPattern = Regex("""^[^a-zA-Z0-9+_].*""")
        return startPattern.matches(login)
    }

}