package com.example.tipcalculatorapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.xr.runtime.Config
import com.example.tipcalculatorapp.ui.theme.TipCalculatorAppTheme
import org.junit.Rule
import org.junit.runner.RunWith
import java.text.NumberFormat
import kotlin.test.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.junit.Test // <-- use JUnit4, not kotlin.test.Test

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34]) // optional but keeps it predictable
class TipUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_15_percent_tip() {
        composeTestRule.setContent {
            TipCalculatorAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TipCalculate(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        composeTestRule.onNodeWithText("Bill amount").performTextInput("10")
        val expected = NumberFormat.getCurrencyInstance().format("1.50")
        composeTestRule.onNodeWithText("Tip Amount: $expected").assertExists("Node with test was found.")
    }
}