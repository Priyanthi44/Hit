package com.gymshark.hits.screens.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gymshark.hits.model.Hit
import com.gymshark.hits.navigation.Screens
import com.gymshark.hits.screens.SharedViewModel
import com.gymshark.hits.widgets.ImageSlider
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

@Composable
fun DetailScreen(navController: NavController, hitID: Int, vm: SharedViewModel) {
//    val activity = LocalContext.current as Activity
//    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    val buttonClickedState = remember {
        mutableStateOf(true)
    }
    val scrollState = rememberScrollState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(25.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .width(400.dp)
                    .fillMaxHeight()
                    .padding(16.dp),
                shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                elevation = CardDefaults.cardElevation(4.dp, 4.dp, 4.dp, 4.dp, 4.dp, 4.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
//                    var imageUri by remember {
//                        mutableStateOf<Uri?>(null)
//                    }
//                    val picker = rememberLauncherForActivityResult(
//                        contract = ActivityResultContracts.PickVisualMedia()
//                    ) {
//                        imageUri = it
//
//                    }

                    CreateProfilePic(
                        modifier = Modifier
                            .size(350.dp)
                            .padding(12.dp),  getImageList(hitID, vm)
                    )
                    Divider(
                        thickness = 3.dp
                    )
                    CreateProfileInfo(getItem(hitID, vm))
                    Button(onClick = {
                        buttonClickedState.value = !buttonClickedState.value

                    }) {
                        CreateText(
                            tfontsize = MaterialTheme.typography.labelLarge,
                            tcolor = Color.White,
                            text = "Back"
                        )


                    }
                    if (!buttonClickedState.value) {
                        navController.popBackStack(
                            route = Screens.MainScreen.name,
                            inclusive = false
                        )
                    } else {
                        Box {}
                    }
                }

            }
        }

    }
}

fun getImageList(hitID: Int, vm: SharedViewModel): List<String>? {
 val hit:Hit?=   getItem(hitID, vm)
 val imageList:MutableList<String> = mutableListOf()
    hit?.media?.forEach {
        imageList.add(it.src)
    }
    return imageList


}


fun getItem(hitID: Int, vm: SharedViewModel): Hit? {
    return vm.data.value.data?.hits?.get(hitID) ?: null
}

@Composable
fun CreateText(tfontsize: TextStyle, tcolor: Color, text: String) {
    Text(text = text, color = tcolor, style = tfontsize)
}

@Composable
fun CreateProfilePic(
    modifier: Modifier,

    imageUri: List<String>?
) {

    Surface(

        shape = RectangleShape,

        border = BorderStroke(0.5.dp, color = Color.White),
        tonalElevation = 4.dp,

        ) {
        if (imageUri != null) {
            ImageSlider(imageUri)
        }

    }
}

@Composable
private fun CreateProfileInfo(hit: Hit?) {
    Column(
        modifier = Modifier.padding(0.5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CreateText(
            MaterialTheme.typography.headlineLarge, Color.Blue, hit?.title ?: "Awesome Item"
        )
        if (hit?.availableSizes?.isNotEmpty() == true) {
            var str = StringBuilder()
            hit.availableSizes.forEach {
                str.append(it.size.uppercase()).append(", ")
            }

        CreateText(
            MaterialTheme.typography.bodyLarge,
            Color.Black,
           str.toString().removeSuffix(", ")
        )
    }
        CreateText(
            MaterialTheme.typography.labelLarge,
            Color.Black,
            parseElement(Jsoup.parse(hit?.description ?: "Awesome item").body())
        )
    }
}

fun parseElement(element: Element): String {

    val builder = StringBuilder()
    element.children().forEach { child ->
        if (child.text().startsWith("-")) {
            builder.append("\n")
        }
        when (child.tagName()) {
            "p" -> builder.append(child.text()).append("\n")
            "strong" -> builder.append("**").append(child.text()).append("**").append("\n")
            "br" -> builder.append("\n")
            else -> builder.append(parseElement(child))
        }
    }
    return builder.toString().trim()
}

