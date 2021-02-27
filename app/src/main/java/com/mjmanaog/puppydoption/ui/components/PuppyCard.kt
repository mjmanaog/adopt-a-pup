package com.mjmanaog.puppydoption.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import coil.transform.Transformation
import com.mjmanaog.puppydoption.R
import com.mjmanaog.puppydoption.ui.network.model.PuppyInfo
import com.mjmanaog.puppydoption.ui.network.model.puppyList
import com.mjmanaog.puppydoption.ui.theme.PuppydoptionTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun ItemPuppyCard(puppyInfo: PuppyInfo.Puppy, onClicked: () -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentWidth()
            .height(220.dp)
            .padding(top = 4.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .clickable(onClick = onClicked),
        elevation = 8.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(5)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PuppyImg(
                puppyInfo.imageURL,
                100.dp
            )
            PuppyContent(
                puppyInfo.name,
                puppyInfo.gender,
                puppyInfo.breed,
                puppyInfo.dob,
                Alignment.CenterHorizontally
            )
        }
    }
}

@Composable
fun PuppyImg(imgURL: String, imgSize: Dp) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = Color.White
        ),
        modifier = Modifier
            .padding(8.dp)
            .size(imgSize),
        elevation = 4.dp
    ) {
        CoilImage(
            data = imgURL,
            contentDescription = "Puppy Image",
            requestBuilder = {
                transformations(CircleCropTransformation())
            }
        )
    }
}

@Composable
fun PuppyContent(
    name: String,
    gender: String,
    breed: String,
    dob: String,
    alignment: Alignment.Horizontal
) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = alignment
    ) {
        Row {
            val paintGender: Painter = painterResource(
                id =
                if (gender.toLowerCase() == "female") {
                    R.drawable.ic_girl
                } else {
                    R.drawable.ic_boy
                }
            )
            Image(painter = paintGender, contentDescription = "Gender Icon")
            DefaultH2TextOrange(text = name, TextAlign.Start)
        }
        DefaultBody1TextDark(text = breed, TextAlign.Center)
        DefaultBody1TextDark(text = dob, TextAlign.Center)
    }
}

@Composable
fun PuppyInfoCard(puppyInfo: PuppyInfo.Puppy) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(bottom = 15.dp)
        ) {
            CoilImage(
                data = puppyInfo.imageURL,
                contentDescription = "Puppy Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                loading = {
                    Box(Modifier.matchParentSize()) {
                        CircularProgressIndicator(Modifier.align(Alignment.Center))
                    }
                },
            )
        }
        Row(
            modifier = Modifier.padding(start = 15.dp, end = 15.dp, bottom = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val paintGender: Painter = painterResource(
                id = if (puppyInfo.gender.toLowerCase() == "female") {
                    R.drawable.ic_girl
                } else {
                    R.drawable.ic_boy
                }
            )
            Image(
                modifier = Modifier.padding(end = 5.dp),
                painter = paintGender,
                contentDescription = "Gender Icon"
            )
            DefaultH1TextOrange(text = puppyInfo.name)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp,),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .width(150.dp)
                    .padding(5.dp)
                    .border(1.dp, MaterialTheme.colors.primaryVariant, RoundedCornerShape(20))
            ) {
                IconText(icon = R.drawable.ic_calendar, text = puppyInfo.dob, 5)
            }
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .width(200.dp)
                    .padding(5.dp)
                    .border(1.dp, MaterialTheme.colors.primaryVariant, RoundedCornerShape(20))
            ) {
                IconText(icon = R.drawable.ic_paw, text = puppyInfo.breed, 5)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp,),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .width(150.dp)
                    .padding(5.dp)
                    .border(1.dp, MaterialTheme.colors.primaryVariant, RoundedCornerShape(20))
            ) {
                IconText(icon = R.drawable.ic_weight, text = puppyInfo.weight, 5)
            }
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .width(200.dp)
                    .padding(5.dp)
                    .border(1.dp, MaterialTheme.colors.primaryVariant, RoundedCornerShape(20))
            ) {
                IconText(icon = R.drawable.ic_syringe, text = puppyInfo.vaccines, 5)
            }
        }
        DefaultH1TextOrange(text = " ")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PuppydoptionTheme {
        PuppyInfoCard(puppyInfo = puppyList[0])
    }
}