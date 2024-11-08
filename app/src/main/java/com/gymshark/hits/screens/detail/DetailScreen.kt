package com.gymshark.hits.screens.detail

import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gymshark.hits.navigation.Screens
import coil.compose.AsyncImage

@Composable
fun DetailScreen(navController: NavController, hitName: String?) {
//    val activity = LocalContext.current as Activity
//    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    val buttonClickedState = remember {
        mutableStateOf(true)
    }

    Surface(modifier = Modifier.fillMaxSize()) {
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
                    var imageUri by remember {
                        mutableStateOf<Uri?>(null)
                    }
                    val picker = rememberLauncherForActivityResult(
                        contract = ActivityResultContracts.PickVisualMedia()
                    ) {
                        imageUri = it

                    }
                    CreateProfilePic(
                        modifier = Modifier
                            .size(150.dp)
                            .padding(12.dp), picker, imageUri
                    )
                    Divider(
                        thickness = 3.dp
                    )
                    CreateProfileInfo(hitName)
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
                        navController.popBackStack(route = Screens.MainScreen.name, inclusive = false)
                    } else {
                        Box {}
                    }
                }

            }
        }

    }



}
@Composable
fun CreateProfilePic(
    modifier: Modifier,
    picker: ManagedActivityResultLauncher<PickVisualMediaRequest, Uri?>,
    imageUri: Uri?
) {

    Surface(
        modifier = modifier.clickable {
            picker.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
        },
        shape = RectangleShape,

        border = BorderStroke(0.5.dp, color = Color.White),
        tonalElevation = 4.dp,

        ) {


        AsyncImage(
            model = imageUri, contentDescription = null,
            contentScale = ContentScale.Crop, modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun CreateProfileInfo(hitName: String?) {
    Column(
        modifier = Modifier.padding(0.5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CreateText(
            MaterialTheme.typography.headlineLarge, Color.Blue, hitName?:"Awesome Item"
        )
        CreateText(
            MaterialTheme.typography.bodyLarge,
            Color.Black,
            "Awesome Item"
        )
        CreateText(MaterialTheme.typography.labelLarge, Color.Black, "Awesome tiem")
    }
}
@Composable
fun CreateText(tfontsize: TextStyle, tcolor: Color, text: String) {
    Text(text = text, color = tcolor, style = tfontsize)
}
