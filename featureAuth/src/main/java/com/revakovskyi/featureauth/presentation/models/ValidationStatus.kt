package com.revakovskyi.featureauth.presentation.models

import com.revakovskyi.featureauth.domain.models.Status

internal enum class ValidationStatus {
    Correct, Incorrect, Neutral
}


internal fun Status.toValidationStatus(): ValidationStatus {
    return when (this) {
        Status.Correct   -> ValidationStatus.Correct
        Status.Incorrect -> ValidationStatus.Incorrect
        Status.Neutral   -> ValidationStatus.Neutral
    }
}
