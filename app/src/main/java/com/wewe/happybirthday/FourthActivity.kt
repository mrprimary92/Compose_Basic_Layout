package com.wewe.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wewe.happybirthday.ui.theme.HappyBirthdayTheme

class FourthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FourthTask()
                }
            }
        }
    }
}

@Composable
fun FourthTask() {
    Column(modifier = Modifier.fillMaxSize()) {

        Row(modifier = Modifier.weight(1f)) {
            OneQuadrant(
                stringResource(R.string.title1),
                stringResource(R.string.body1),
                Modifier
                    .background(color = Color.Green)
                    .weight(1f)
            )
            OneQuadrant(
                stringResource(R.string.title2),
                stringResource(R.string.body2),
                Modifier
                    .background(color = Color.Yellow)
                    .weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            OneQuadrant(
                stringResource(R.string.title3),
                stringResource(R.string.body3),
                Modifier
                    .background(color = Color.Cyan)
                    .weight(1f)
            )
            OneQuadrant(
                stringResource(R.string.title4),
                stringResource(R.string.body4),
                Modifier
                    .background(color = Color.LightGray)
                    .weight(1f)
            )
        }
    }
}

@Composable
fun OneQuadrant(title: String, body: String, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = body, textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    HappyBirthdayTheme {
        FourthTask()
    }
}