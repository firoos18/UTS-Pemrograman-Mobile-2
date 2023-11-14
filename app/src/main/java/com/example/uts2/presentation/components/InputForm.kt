package com.example.uts2.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uts2.R
import com.example.uts2.presentation.viewmodels.InputViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputForm(inputViewModel: InputViewModel) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(text = stringResource(id = R.string.bodyMass))
        Spacer(modifier = Modifier.size(8.dp))
        OutlinedTextField(
            value = inputViewModel.bodyMass,
            onValueChange = { bodyMass -> inputViewModel.updateBodyMass(bodyMass) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Black.copy(alpha = 0.3f)
            ),
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = stringResource(id = R.string.bodyHeight))
        Spacer(modifier = Modifier.size(8.dp))
        OutlinedTextField(
            value = inputViewModel.bodyHeight,
            onValueChange = { bodyHeight -> inputViewModel.updateBodyHeight(bodyHeight) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Black.copy(alpha = 0.3f)
            ),
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(16.dp))
        Row {
            Text(
                text = "Kategori : "
            )
            Text(
                text = inputViewModel.category,
                color = when (inputViewModel.category) {
                    "Underweight" -> {
                        Color.Yellow
                    }
                    "Normal" -> {
                        Color.Green
                    }
                    else -> {
                        Color.Red
                    }
                }
            )
        }
        Spacer(modifier = Modifier.size(24.dp))
        Button(
            onClick = {
                inputViewModel.calculateBMI()
                inputViewModel.updateCategory()
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = stringResource(id = R.string.calculate),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}