package com.revakovskyi.core.presentation.ui

import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Tablet",
    group = "Devices",
    device = Devices.TABLET,
    showSystemUi = true,
    showBackground = true
)
@Preview(
    name = "Phone",
    group = "Devices",
    device = Devices.DEFAULT,
    showSystemUi = true,
    showBackground = true
)
annotation class DivicePreviews
