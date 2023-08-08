package com.revakovskyi.domain.authTextVerification

import com.revakovskyi.domain.models.Status

internal class VerifyName {

    fun verify(name: String): Status {
        return Status.Neutral
    }

}