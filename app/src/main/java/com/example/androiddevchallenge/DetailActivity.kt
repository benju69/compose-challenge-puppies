package com.example.androiddevchallenge

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                })

            val image: Painter = painterResource(id = dog.image)
            Image(
                painter = image, contentDescription = dog.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
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
                text = dog.color,
                style = MaterialTheme.typography.caption
            )

            AdoptButton(dog.url)
        }
    }
}

@Composable
fun AdoptButton(url: String) {
    val context = LocalContext.current
    Button(onClick = { 
        val webIntent = Intent(Intent.ACTION_VIEW)
        webIntent.data = Uri.parse(url)
        context.startActivity(webIntent)
    }, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Adopt")
    }
}
