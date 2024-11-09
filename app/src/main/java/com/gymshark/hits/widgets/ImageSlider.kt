package com.gymshark.hits.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box


@Composable
fun ImageSlider(imageUrls: List<String>) {
    LazyRow {
        items(imageUrls) { imageUrl ->
            ImageCard(imageUrl)
        }
    }
}

@Composable
fun ImageCard(imageUrl: String) {
    Box(modifier = Modifier.background(Color.White)) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),

        ) {
            Image(
                painter = rememberAsyncImagePainter(model = imageUrl),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

