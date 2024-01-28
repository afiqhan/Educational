package com.afiq.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afiq.artspaceapp.data.DataSource
import com.afiq.artspaceapp.model.Content
import com.afiq.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    MainInterface(
        contentList = DataSource().loadAffirmations(),
    )
}

@Composable
fun MainInterface(contentList: List<Content>, modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf(0) }
    var imageResource = (result)
    if(result >5) result =  0 else if(result <0) result = 5 else imageResource = result

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {
        Box(
            modifier = modifier
//                .border(2.dp, Color.Gray, shape = MaterialTheme.shapes.medium)
                .shadow(50.dp)
                .background(Color(green = 255, red = 255, blue = 255))
                .padding(16.dp)
                .wrapContentSize()
                .size(width = 300.dp, height = 200.dp)



        ) {
            Image(
                painter = painterResource(id = contentList[result].imageResourceId),
                contentDescription = "Image $result",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()

                
            )
        }
        Row(modifier = modifier.padding(top = 30.dp) ) {


                Box(
                    modifier = Modifier.background(Color(236, 235, 244)).padding(20.dp),
                ){
                    Column {
                    Text(
                        text = LocalContext.current.getString(contentList[result].artworkResourceId),
                        modifier = modifier.padding(bottom = 5.dp),
                        fontSize = 25.sp,
                        fontFamily = FontFamily.Cursive ,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    TextWithFormattedAuthorAndYear(
                        authorResourceName = LocalContext.current.getString(contentList[result].authorResourceId),
                        yearText = LocalContext.current.getString(contentList[result].yearResourceId)
                    )
                }

            }

        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /*TODO*/ result--}) {
                Text(text = "Previous")
            }
            Button(onClick = { /*TODO*/  result++}) {
                Text(text = "Next")
            }
        }
    }
}


@Composable
fun TextWithFormattedAuthorAndYear(authorResourceName: String, yearText: String) {
        val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(authorResourceName)
        }
        append(" $yearText")
    }

    Text(text = annotatedString)
}

@Preview(showBackground = true )
@Composable
fun ArtworkAppPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}