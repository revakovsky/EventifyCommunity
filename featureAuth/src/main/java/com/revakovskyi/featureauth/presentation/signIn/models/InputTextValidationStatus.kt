package com.revakovskyi.featureauth.presentation.signIn.models

import com.revakovskyi.featureauth.presentation.models.ValidationStatus

internal data class InputTextValidationStatus(
    val loginStatus: ValidationStatus = ValidationStatus.Neutral,
    val passwordStatus: ValidationStatus = ValidationStatus.Neutral,
    val emailStatus: ValidationStatus = ValidationStatus.Neutral,
    val nameStatus: ValidationStatus = ValidationStatus.Neutral,
    val surnameStatus: ValidationStatus = ValidationStatus.Neutral,
    val verificationPasswordStatus: ValidationStatus = ValidationStatus.Neutral,
)
