package com.mjmanaog.puppydoption.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.google.accompanist.coil.rememberCoilPainter
import com.mjmanaog.puppydoption.R
import com.mjmanaog.puppydoption.network.model.PuppyModel
import com.mjmanaog.puppydoption.network.model.puppyList
import com.mjmanaog.puppydoption.ui.theme.PuppydoptionTheme

@Composable
fun ItemPuppyCard(puppyModel: PuppyModel.Puppy, onClicked: () -> Unit) {
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
                puppyModel.imageURL,
                100.dp
            )
            PuppyContent(
                puppyModel.name,
                puppyModel.gender,
                puppyModel.breed,
                puppyModel.dob,
                Alignment.CenterHorizontally
            )
        }
    }
}

@Composable
fun PuppyImg(imgURL: String, imgSize: Dp) {
    val painter = rememberCoilPainter(request = imgURL,requestBuilder ={
        transformations(CircleCropTransformation())
    }, previewPlaceholder = R.mipmap.ic_launcher)

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
        Image(
            painter = painter,
            contentDescription = "Puppy Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
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
fun PuppyInfoCard(puppyModel: PuppyModel.Puppy) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(bottom = 15.dp)
        ) {
            val painter = rememberCoilPainter(request = puppyModel.imageURL, previewPlaceholder = R.mipmap.ic_launcher)
            Image(
                painter = painter,
                contentDescription = "Puppy Image",
                modifier = Modifier.fillMaxSize(),
            )
        }
        Row(
            modifier = Modifier.padding(start = 15.dp, end = 15.dp, bottom = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val paintGender: Painter = painterResource(
                id = if (puppyModel.gender.toLowerCase() == "female") {
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
            DefaultH1TextOrange(text = puppyModel.name)
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
                ReusableIconAndText(icon = R.drawable.ic_calendar, text = puppyModel.dob, 5)
            }
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .width(200.dp)
                    .padding(5.dp)
                    .border(1.dp, MaterialTheme.colors.primaryVariant, RoundedCornerShape(20))
            ) {
                ReusableIconAndText(icon = R.drawable.ic_paw, text = puppyModel.breed, 5)
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
                ReusableIconAndText(icon = R.drawable.ic_weight, text = puppyModel.weight, 5)
            }
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .width(200.dp)
                    .padding(5.dp)
                    .border(1.dp, MaterialTheme.colors.primaryVariant, RoundedCornerShape(20))
            ) {
                ReusableIconAndText(icon = R.drawable.ic_syringe, text = puppyModel.vaccines, 5)
            }
        }
        DefaultH1TextOrange(text = " ")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PuppydoptionTheme {
        PuppyInfoCard(puppyModel = puppyList[0])
    }
}