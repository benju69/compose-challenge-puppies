package com.example.androiddevchallenge

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun PuppyItem(name: String = "Dog") {
    Column {
        Card(
            Modifier
                .fillMaxWidth()
                .padding(8.dp), elevation = 8.dp) {
            Text(modifier = Modifier.padding(4.dp), text = name)
        }
    }
}