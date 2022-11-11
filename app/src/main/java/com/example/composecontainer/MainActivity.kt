package com.example.composecontainer

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecontainer.ui.theme.ComposeContainerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeContainerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
private fun ComposableContainer(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
  Column(
      modifier = modifier
          .fillMaxSize()
          .background(backgroundColor)
          .padding(16.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
  ) {
      Text(
          text = title,
          fontWeight = FontWeight.Bold,
          modifier = Modifier.padding(bottom = 16.dp)
      )
      Text(
          text = description,
          textAlign = TextAlign.Justify
      )
  }
}

@Composable
fun Greeting() {
    Column(Modifier.fillMaxWidth()){
        Row(Modifier.weight(1f)) {
            ComposableContainer(
                "Text composable",
                "Displays text and follows Material Design guidelines.",
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1f)
            )
            ComposableContainer(
                "Image composable",
                "Creates a composable that lays out and draws a given Painter class object.",
                backgroundColor = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableContainer(
                "Row composable",
                "A layout composable that places its children in a horizontal sequence.",
                backgroundColor = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            ComposableContainer(
                "Column composable",
                "A layout composable that places its children in a vertical sequence.",
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeContainerTheme {
        Greeting()
    }
}