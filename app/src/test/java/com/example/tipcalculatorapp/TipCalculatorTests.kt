package com.example.tipcalculatorapp

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {
    @Test
    fun calculateTip_20Percent(){
        val amount = 10.0
        val expected = NumberFormat.getCurrencyInstance().format(2.0)
        val actualTip = calculateTip(amount = amount, tipPercent = 20.0)
        assertEquals(expected, actualTip)
    }
}