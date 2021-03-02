/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.model.dogsList

//@Preview
@Composable
fun PuppyItem(
    dog: Dog = dogsList.first(), // Just for the preview, not the best way
    onClick: () -> Unit
) {
    Column {
        Card(
            Modifier
                .fillMaxWidth()
                .padding(paddingValues = PaddingValues(16.dp, 4.dp)),
            elevation = 8.dp
        ) {
            Row(
                modifier = Modifier
                    .height(80.dp)
                    .clickable(onClick = onClick)
            ) {
                val image: Painter = painterResource(id = dog.image)
                Image(
                    painter = image, contentDescription = dog.name,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(80.dp)
                        .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
                )
                Column {
                    Text(modifier = Modifier.padding(4.dp), text = dog.name)
                }
            }
        }
    }
}

