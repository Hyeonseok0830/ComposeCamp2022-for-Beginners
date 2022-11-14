package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ComposeArticleApp(title = getString(R.string.title_jetpack_compose_tutorial),
                        shortDescription = getString(R.string.compose_short_desc),
                        longDescription = getString(R.string.compose_long_desc),
                        imagePainter = painterResource(id = R.drawable.bg_compose_background),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp)
                    )

                }

            }
        }
    }
}

@Composable
fun ComposeArticleApp(
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
) {
    Box {
        ArticleCard(title, shortDescription, longDescription, imagePainter, modifier)
    }

}

@Composable
private fun ArticleCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
) {
    Column() {
        //Image
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
        )
        //title
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier
                .padding(top = 16.dp, bottom = 16.dp)
        )
        //shortDescription
        Text(
            text = shortDescription,
            modifier = modifier

        )
        //longDescription
        Text(
            text = longDescription,
            modifier =  modifier.padding(top = 16.dp, bottom = 16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        Surface(color = MaterialTheme.colors.background) {
            ComposeArticleApp(title = stringResource(id = R.string.title_jetpack_compose_tutorial),
                shortDescription = stringResource(id = R.string.compose_short_desc),
                longDescription = stringResource(id = R.string.compose_long_desc),
                imagePainter = painterResource(id = R.drawable.bg_compose_background),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            )

        }

    }
}