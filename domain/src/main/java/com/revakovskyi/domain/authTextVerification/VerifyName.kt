package com.revakovskyi.domain.authTextVerification

import com.revakovskyi.domain.models.Status

internal class VerifyName {

    fun verify(name: String): Status {
        return if (name.isNotEmpty()) {
            if (isNameValid(name)) Status.Correct
            else if (isIncorrectStartOfName(name)) Status.Incorrect
            else Status.Neutral
        } else Status.Neutral
    }

    private fun isNameValid(name: String): Boolean {
        val emailPattern = Regex("""^[a-zA-Z].*""")
        return emailPattern.matches(name)
    }

    private fun isIncorrectStartOfName(name: String): Boolean {
        val startPattern = Regex("""^[^a-zA-Z].*""")
        return startPattern.matches(name)
    }

}