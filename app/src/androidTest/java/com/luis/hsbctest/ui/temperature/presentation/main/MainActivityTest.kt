package com.luis.hsbctest.ui.temperature.presentation.main

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class MainActivityTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val tagTemperatureButton = "getTemperatureButton"
    private val tagLocationTextField = "locationTextField"
    private val tagTemperatureTextField = "temperatureTextField"

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun the_get_temperature_button_is_enable() {
        composeTestRule.onNodeWithTag(tagTemperatureButton).assertIsEnabled()
    }

    @Test
    fun when_the_get_temperature_button_is_hit_then_the_button_is_not_enable() {
        val button = composeTestRule.onNodeWithTag(tagTemperatureButton)
        button.performClick()
        button.assertIsNotEnabled()
    }

    @Test
    fun when_get_temperature_button_is_hit_then_the_location_is_showed() {

        composeTestRule.onNodeWithTag(tagTemperatureButton).performClick()
        runBlocking { delay(5000) }

        val testText = ""
        val locationField = composeTestRule.onNodeWithTag(tagLocationTextField)
        locationField.assert(hasText(testText).not())
    }

    @Test
    fun when_get_temperature_button_is_hit_then_the_temperature_is_showed() {

        composeTestRule.onNodeWithTag(tagTemperatureButton).performClick()
        runBlocking { delay(5000) }

        val testText = ""
        val temperatureField = composeTestRule.onNodeWithTag(tagTemperatureTextField)
        temperatureField.assert(hasText(testText).not())
    }

    @Test
    fun when_the_get_location_and_temperature_are_showed_then_button_is_enable_again() {

        val button = composeTestRule.onNodeWithTag(tagTemperatureButton)
        button.performClick()
        runBlocking { delay(5000) }

        button.assertIsEnabled()
    }
}

