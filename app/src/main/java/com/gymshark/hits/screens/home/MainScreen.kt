package com.gymshark.hits.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.gymshark.hits.R
import com.gymshark.hits.model.Hit
import com.gymshark.hits.navigation.Screens
import com.gymshark.hits.screens.SharedViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController, mainScreenViewModel: SharedViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Today's Hits",
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                Modifier
                    .background(Color.Black)
                    .fillMaxWidth()
            )
        }) {


        MainContent(
            getHits(mainScreenViewModel),
            navController = navController,
            it.calculateTopPadding()
        )
    }
}


fun getHits(vm: SharedViewModel): List<Hit> {
    return vm.data.value.data?.hits!!
}


@Composable
fun MainContent(
    hits: List<Hit>,
    navController: NavController,
    calculateTopPadding: Dp
) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(top = 90.dp, end = 17.dp, start = 17.dp, bottom = 25.dp)
            .padding(16.dp)

    ) {

        Portfolio(hits, onitemClick = {
            navController.navigate(route = Screens.DetailScreen.name + "/${hits.indexOf(it)}")
        })
    }
}

@Composable
fun Portfolio(data: List<Hit>, onitemClick: (Hit) -> Unit) {
    LazyColumn {
        items(data) {
            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .fillParentMaxWidth()
                    .clickable {
                        it.let(onitemClick)
                    },
                shape = RectangleShape,


                ) {
                Row(
                    modifier = Modifier.padding(8.dp),
                ) {
                    CreateProductPic(
                        modifier = Modifier
                            .size(80.dp)
                            .padding(3.dp), it
                    )
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(it.title, fontWeight = FontWeight.Bold)
                        Text(it.type)
                        Text(it.colour)
                        if (it.labels != null) {
                            if (it.labels.isNotEmpty()) {
                                it.labels.forEach {
                                    Text(it, color = Color.Red)
                                }
                            }
                        }
                    }


                }
            }
        }
    }
}

@Composable
fun CreateProductPic(modifier: Modifier, hit: Hit) {
    Surface(
        modifier = modifier,
        shape = RectangleShape,

        border = BorderStroke(0.5.dp, color = Color.White),
        tonalElevation = 4.dp,

        ) {
        AsyncImage(
            model = hit.featuredMedia.src,
            error = painterResource(id = R.drawable.soon),
            contentDescription = null,
            modifier =Modifier.fillMaxWidth()
        )
    }
}



