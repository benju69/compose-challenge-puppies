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

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dog = intent.getParcelableExtra<Dog>("dog") ?: return

        setContent {
            MyTheme {
                PuppyDetail(dog) {
                    finish()
                }
            }
        }
    }
}

@Composable
fun PuppyDetail(dog: Dog, onBackPressed: () -> Unit = {}) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            TopAppBar(
                title = { Text(text = dog.name) },
                backgroundColor = MaterialTheme.colors.primary,
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "back"
                        )
                    }
                }
            )

            val image: Painter = painterResource(id = dog.imageId)
            Image(
                painter = image, contentDescription = dog.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = dog.breed,
                style = MaterialTheme.typography.caption
            )
            Text(
                text = dog.gender,
                style = MaterialTheme.typography.caption
            )
            Text(
                text = dog.height,
                style = MaterialTheme.typography.caption
            )
            Text(
                text = dog.color,
                style = MaterialTheme.typography.caption
            )

            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
                AdoptButton(dog.url)
            }
        }
    }
}

@Composable
fun AdoptButton(url: String) {
    val context = LocalContext.current
    Button(
        onClick = {
            val webIntent = Intent(Intent.ACTION_VIEW)
            webIntent.data = Uri.parse(url)
            context.startActivity(webIntent)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "Adopt")
    }
}
