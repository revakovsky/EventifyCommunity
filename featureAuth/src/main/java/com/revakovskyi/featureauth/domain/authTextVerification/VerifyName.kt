package com.revakovskyi.featureauth.domain.authTextVerification

import com.revakovskyi.featureauth.domain.models.Status

internal object VerifyName {

    fun verify(name: String): Status {
        return if (name.isNotEmpty()) {
            if (isNameValid(name)) Status.Correct
            else if (isIncorrectStartOfName(name)) Status.Incorrect
            else Status.Neutral
        } else Status.Neutral
    }

    private fun isNameValid(name: String): Boolean {
        val namePattern = Regex("""^[a-zA-Z].*""")
        return namePattern.matches(name)
    }

    private fun isIncorrectStartOfName(name: String): Boolean {
        val startPattern = Regex("""^[^a-zA-Z].*""")
        return startPattern.matches(name)
    }

}