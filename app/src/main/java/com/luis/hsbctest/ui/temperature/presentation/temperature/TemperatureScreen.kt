package com.luis.hsbctest.ui.temperature.presentation.temperature

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.luis.hsbctest.R
import com.luis.hsbctest.ui.temperature.presentation.temperature.states.LoadingState

@Composable
fun TemperatureScreen(viewModel: TemperatureViewModel = viewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        Temperature(Modifier.align(Alignment.Center), viewModel)
    }
}

@Composable
fun Temperature(modifier: Modifier, viewModel: TemperatureViewModel) {

    val state by viewModel.state.collectAsState()
    var isSearching = false
    var location = ""
    var temperature = ""

    when (state) {
        is LoadingState.Error -> {
        }

        LoadingState.Loading -> isSearching = true

        is LoadingState.Success -> {
            location = (state as LoadingState.Success).location
            temperature = (state as LoadingState.Success).temperature
        }
    }

    Column(modifier = modifier) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)))

        LocationField(location)
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)))
        TemperatureField(temperature)
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)))
        GetTemperatureRandomButton(isSearching.not()) { viewModel.onSearchTemperature() }
    }

    if (isSearching) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    }
}

@Composable
fun LocationField(location: String) {

    OutlinedTextField(
        value = location, onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .testTag("locationTextField"),
        singleLine = true,
        maxLines = 1,
        readOnly = true,
        label = {
            Text(
                text = stringResource(id = R.string.location),
                fontWeight = FontWeight.Bold
            )
        }
    )
}

@Composable
fun TemperatureField(temperature: String) {
    OutlinedTextField(
        value = temperature, onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .testTag("temperatureTextField"),
        singleLine = true,
        maxLines = 1,
        readOnly = true,

        label = {
            Text(
                text = stringResource(id = R.string.temperature),
                fontWeight = FontWeight.Bold
            )
        }
    )
}

@Composable
fun GetTemperatureRandomButton(enableButton: Boolean, onSearchTemperature: () -> Unit) {
    Button(
        onClick = { onSearchTemperature() }, modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.height_button))
            .testTag("getTemperatureButton"),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.orange),
            contentColor = Color.White,
            //Disable
            disabledContainerColor = colorResource(id = R.color.grey),
            disabledContentColor = Color.White
        ),
        enabled = enableButton
    ) {
        Text(text = stringResource(id = R.string.next_random_location))
    }
}

@Composable
fun HeaderImage(modifier: Modifier) {

    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.hong_kong_temperature),
        contentDescription = "Header"
    )
}
