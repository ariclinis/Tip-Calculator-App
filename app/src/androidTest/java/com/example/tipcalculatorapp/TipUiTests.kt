package com.example.tipcalculatorapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tipcalculatorapp.ui.theme.TipCalculatorAppTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUiTests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_15_percent_tip() {
        composeTestRule.setContent {
            TipCalculatorAppTheme {
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                    TipCalculate(
                        name = "Android",
                        modifier = Modifier.Companion.padding(innerPadding)
                    )
                }
            }
        }
        composeTestRule.onNodeWithText("Bill amount").performTextInput("10")
        val expected = NumberFormat.getCurrencyInstance().format("1.50")
        composeTestRule.onNodeWithText("Tip Amount: $expected").assertExists("Node with test was found.")
    }
}